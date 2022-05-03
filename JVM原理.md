# JVM原理



## 一、JNI



### 1. 什么是JNI

**Java Native Interface。**

<img src="C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105193002605.png" alt="image-20211105193002605" style="zoom:67%;" />

Java调用Native：Tensorflow。

Native调用Java：java launcher



#### 1.1 为什么要学习JNI？

- 掌握和native的互相调用，大大丰富java的使用场景。
- 了解原理，对于学习**JVM/故障定位**更加得心应手。

- 一个经典谬误，NIO的BUG？

  ![image-20211105193305610](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105193305610.png)

  ```java
  public static void main(String[] args) throw Exception{
      java.nio.channels.Selector.open().select();
  }
  ```



#### 1.2 JNT实战：从native调用java

![image-20211105193445668](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105193445668.png)



#### 1.3 JNI实战：从java调用C

![image-20211105193736581](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105193736581.png)



#### 1.4 思考：java和native的数据是怎么传递的？

![image-20211105193914175](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105193914175.png)



#### 1.5 思考：回到问题，为什么select()的线程状态是RUNNABLE？

![image-20211105193952886](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105193952886.png)

- JNI提供了一种机制让java进入native状态，但是jvm是无法对这个native进行管理的。
- 这个native可以看作做一个复杂的运算，所以是RUNNABLE状态，会出现阻塞，但是这个阻塞Runnable对于JVM是不支持的。



### 2.  JNI与Safepoint

先问自己两个问题：

- JNI是否会影响GC进行。
- GC时，JNI修改java Heap怎么保证一致。



![image-20211105194419966](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105194419966.png)

- JNI执行时发生SafePoint。
- JNI返回Java时正在SafePoint。
- native和GC是并行的。
- VM状态和GC是不会同时进行的。
- native返回java的时候，会阻塞然后检查状态，因为返回java的时候不会让safePoint执行，保持同步。



#### 2.1 JNI和GC

![image-20211105194805873](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105194805873.png)

二级指针。在oop改变的时候，handle会感知到然后指向新的位置，jobject依然指向handle，依然指向正确的数据。



#### 2.2 高级主题：intrinsic

![](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105195235826.png)

![image-20211105195213278](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105195213278.png)



#### 2.3 RocketMQ Intrinsic 导致应用卡顿

```java
public void warmMappedFile(FlushDiskType type, int pages){
	long beginTime = System.currentTimeMillis();
    ByteBuffer bytebuffer = this.mappedByteBuffer.slice();
    int flush = 0;
    long time = System.currentTimeMillis();
    for (int i=0, j=0; i<this.fileSize; i+=MappedFile.OS_PAGE_SIZE; j++){
        byteBuffer.put(i, (byte)0);  // 这里相当于对内存进行预热分配内存页，到时候在读入数据的时候，就不会需要再分配，节省大量的读取内存的时间（put最底层是intrinsic，被inline了，返回的时候没有方法调用，JVM在方法返回和循环末尾会去检查是否有safepoint，是否要进入GC，这个驯悍被JVM认定为是一个有限次循环，也不会去检查safepoint，不会进入GC）
        
        // 每1000次调用Thread.sleep()是一个JNI
        /*
        	因为byteBuffer.put不会进入GC，JVM也就不会进入GC。
        	因为上面的this.fileSize被JVM认定为是有限次，在有限次下，不会去检查SafePoint。
        	以至于后面在运行的时候会有几秒钟的卡顿。
        	然后这里的Thread.sleep()调用返回的时候，会去检查SafePoint，然后那个代码就不会影响JVM进入GC。
        */
        if(j%1000==0){
			log.info("j={}, costTime = {}", j, System.currentTimeMillis()-time);
            time = System.currentTimeMillis();
            try{
                Thread.sleep(0);
            }catch(InterruptedException e){
                log.error("Interrupted:", e);
            }
        }
    }
}
// 也可以使用机制：+XX:UseCountedLoopSafepoints
// 会在每次 countedloop 末尾检查 safepoint，保证GC，但是也影响了整体的性能，因为每次都会去检查。
```



# 二、safepoint机制



### 1. 什么是safepoint

![image-20211105201902467](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105201902467.png)

safepoint相当于对VM级别的操作进行保护，建立一个护盾，等执行完毕VM操作后，其他Java线程再继续执行。



### 2. safepoint还能做什么？

![image-20211105202104630](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105202104630.png)



### 3. 对于Safepoint需要关注的指标

safepoint会占用整个JVM的线程空间，去执行VM级别的操作。

- 及时相应 vm_operation 的 safepoint 请求。
- 快速完成 vm_operation。
- 快速退出 safepoint。
- Safepoint的频率。



### 4. SafePoint的内部实现

- 协作式。（非强制性：java线程会在自己安全的时候进行相应）
- VM thread 负责发起 safepoint 请求。
- 各个 java 线程自己检测 safepoint 请求并暂停运行。
- **问题：怎样确保能及时进入safepoint？**



<img src="C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105203202457.png" alt="image-20211105203202457" style="zoom:67%;" />



#### 4.1 Thread in VM

- 执行 hotspot 内部的代码
  - arraycopy
  - 反射
  - resolve
  - ...

以上操作的线程，就会把自己状态设置为 Thread in VM，表示不可被打断。比如arraycopy，在拷贝的时候如果打断导致指针位置错误，就会拷贝到错误的信息。



#### 4.2 Thread in native

- 通过 JNI 执行 native code。
- 这种状态认为是进入了 safepoint。
- 当 native code 调用 JNI 接口会检测 safepoint 请求。

在 native code 的时候， JVM是不知道你的状态的，但是会被默认为 safepoint。

native code 执行的时候不会访问到JVM的东西（heap等），当想访问java内部结构的时候，会调用JNI接口，然后JVM就会来检查，如果是safepoint，JVM就会把调用阻塞住，线程就会停下来，等VM_operation结束后再继续进行下去。

所以JNI即使native和java之间隔离保护的屏障。



#### 4.3 Thread in java - interpreter

- 切换 dispatch_table
- 在 safept_table 中为每个 bytecode 检测 safepoint

![image-20211105204326197](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105204326197.png)





#### 4.4 Thread in java - jit

![image-20211105204717969](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105204717969.png)



#### 4.5 Global polling vs ThreadLocal handshake

- JDK10引入thread local 的 handshake：`http://openjdk.java.net/jeps/312`
- 可以对特定的 thread来触发 safepoint。
- 控制开关：UseThreadLocalHandshakes，默认打开



#### 4.6 Polling in counted loop

![image-20211105210308740](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105210308740.png)



#### 4.7 监控 Safepoint

- JDK8：PrintSafePointStatistics
- JDK11：-Xlog:safepoint=debug



## 三、类加载器原理



### 1. TraceClassLoader

- JDK8：-XX:+TraceClassLoading
- JDK11：-Xlog:class+load=info

![image-20211105211003887](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105211003887.png)



### 2. 类的加载、链接和初始化

- 类加载
  - .class 文件  -->  虚拟机的元数据
    - Kclass *
    - Method *
    - ConstantPool * 等



#### 2.1 ClassFile

![image-20211105211127966](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105211127966.png)

​																**图片一**

![image-20211105211232742](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211105211232742.png)

​																	**图片二**

