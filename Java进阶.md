

# Java进阶

**目录**

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210731152402728.png" alt="image-20210731152402728" style="zoom:67%;" />



## 第一问：HashMap和TreeMap的区别？如何正确使用？

使用Java构建系统的时候，可能访问其他各种组件，比如数据库、缓存、消息中间件，但是核心还是通过Java代码实现逻辑的运转。

对于数据结构的深入考察，必然是面试中的一个核心点。

### 1. HashMap

- HashMap主要用来存放键值对（K-V），数据是无序的。
- JDK8开始，底层由 **`数组+链表+红黑树`**的数组结构来实现。
- 当发生哈希冲突时，通过拉链法处理，当链表长度大于阈值（默认8）时，将链表转换为红黑树，以减少搜索时间。
  - 链表查询时间复杂度：O(n)
  - 红黑树查询时间复杂度：O(log n)
  - 在数量较少时，没必要进行红黑树转换，因为红黑树的调整是比较麻烦且耗时的，代价较大。
  - 遵从**性价比**。



- Hash查找时间复杂度O(1)
- 如果冲突较多，时间复杂度是O(n)
- 当链表长度大于8时，转换为红黑树，时间复杂度为O(log n)
- 所以查询一个HashMap的时间复杂度是 **O(1)+O(n)** 或 **O(1)+O(log n)**，平均为O(1)



### 2. TreeMap

- 是基于红黑树实现的一个保证有序的Map
- TreeMap中的元素默认按照Key的自然排序，也可以指定comparator
- 由于基于红黑树，所以TreemMap的时间复杂度是O(log n)
- **如果需要排序的数据，可以直接存入TreeMap，TreeMap会自己排序，不需要写排序函数**



### 3. 区别

- HashMap通过hashcode对其内容进行快速查找，而TreeMap中的所有元素都保持着某种固定的顺序，如果你需要得到一个有序的结果，就使用TreeMap
- HashMap比TreeMap效率更高一些，查询速度比TreeMap要快。（因为TreeMap需要不断构建红黑树，而且数组有随机存取的特征）



## 第二问：JDK8对hash算法和寻址算法是如何优化的？

### 1. 寻址算法

在插入和查找数据的时候，会根据一个key得到对应的hash值，根据这个hash值可以得到元素在数组中的下标，这个计算过程就是**寻址算法**。

```java
final Node<K,V> getNode(int hash, Object key){
    Node<K,V>[] tab;
    Node<K,V>[] first, e;
    int n;
    K k;
    if((tab=table)!=null && (n=tab.length)>0 && (first=tab[(n-1)&hash])!=null){
        if(first.hash==hash &&  // always check first node
          ((k=first.key)==key || (key!=null && key.equals(k))))
            return first;
        if((e=first.next)!=null){
            if(first instanceof TreeNode)
                return ((TreeNode<K,V>)first).getTreeNode(hash, key);
            do{
                if(e.hash == hash &&
                  ((k=e.key)==key || (key!=null && key.equals(k))))
                    return e;
            }while ((e=e.next)!=null);
        }
    }
    return null;
}
```

- 我们知道了一个key的hash值，用这个hash值跟数组长度取模，就可以得到下标位置。实际在源码中，采用了与运算（两个都是1则为1，否则为0）代替了取模。
- 公式：(n-1) & hash

- 对于现代计算机的处理器来说，除法和取模是最慢的动作
- **数学公式：a%b = (b-1)&a，当b是2的指数时，等式成立。**



### 2. 哈希算法

- 寻址算法，需要根据hash值计算数组下标。
- 哈希算法就是根据一个key，通过计算得到它对应的hash值。
- 为什么不直接使用**hashCode**？

```java
static final int hash(Object key){
    int h;
    return (key==null) ? 0 : (h=key.hashCode())^(h>>>16);
}
```

- int 有32位，这里h右移16位，相当于高16位和低16位进行了异或运算。

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210731162000095.png" alt="image-20210731162000095" style="zoom:67%;" />

- 如果没有进行位移，上面两个不同的数字最终的结果是一样的，发生冲突了，这里只用到了低16位的特征。
- 寻址算法已经定下来了，无法改变，hashCode()也已经定下来了，唯一可能的变化就是hash()
- 如果右移16位后，高16位和低16位进行异或，就保留了整个的特征，进行优化后，最终会大大降低冲突。

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210731162320344.png" alt="image-20210731162320344" style="zoom:50%;" />

- 这样一个新的hash值得到以后，给到寻址算法后，可以避免一些不必要的冲突。



- 异或运算会保留不同的位置的值为1，就像特征一样，而相同的地方就没必要保留。
- 用哈希算法保留全部32位数字的特征之后，传到寻址算法进行与运算，可以在寻找下标的时候，尽量的避免不必要的冲突。
- **hash-->hash值-->寻址算法getNode-->（n-1）& hash --> n为散列表的容量，必为2的幂次方**



## 第三问：HashMap初始容量为何要是2的指数幂？

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210731162933098.png" alt="image-20210731162933098" style="zoom:50%;" />

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210731163129939.png" alt="image-20210731163129939" style="zoom:50%;" />

- 在例子中，当不是2的指数幂的时候，最后的结果只会有上面8种。

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210731163255218.png" alt="image-20210731163255218" style="zoom:50%;" />

- 在上述例子中，寻址算法的与运算就保留了所有的可能，32种。



## 第四问：HashMap默认加载因子为什么是0.75？转化阈值为什么是8？

### 1. 加载因子

- 代表哈希表在其容量到达一定程度后，需要进行扩容，衡量的是一个散列表的空间使用程度。
- 负载因子越大表示散列表的装填程度越高，反之越小。

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210731165633563.png" alt="image-20210731165633563" style="zoom:50%;" />

### 2. 为什么是0.75？

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210731170141508.png" alt="image-20210731170141508" style="zoom:50%;" />

**由于发生冲突后碰撞位置的次数超过8是几乎不可能的，所以HashMap的查找效率是无限接近与O(1)的。**



## 第五问：String、StringBuffer、StringBuilder有什么区别？

### 1. String

- 在Java中字符串属于对象，Java还提供了String类来创建和操作字符串。
- String是Immutable类的典型实现，被声明为 final class，除了hash这个属性其他属性都声明为 final。
- 因为它的不可变性，所以例如拼接字符串的时候会产生很多无用的中间对象，如果频繁的进行这样的操作，不仅效率低下，而且大量浪费有限的内存空间。
- **Immutable：不可变。**

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803155332520.png" alt="image-20210803155332520" style="zoom:50%;" />



### 2. StringBuilder

- 和String类不同的是，StringBuilder类的对象能够被多次修改，并且不会产生新的未使用的对象。
- 通过append方法，可以将字符串添加到已有序列的末尾或指定位置。
- 它继承了 AbstractStringBuilder，本质是通过一个可变的byte数组进行数据存储。
- 但StringBuilder是线程不安全的。
- **在应用中，两个线程同时对底层数组的同一位置进行修改的时候，其中一个修改可能被覆盖，导致了数据丢失，所以是线程不安全。**



### 3. StringBuffer

- StringBuffer把所有修改数据的方法都加上了synchronized，保证了线程安全。
- 由于StringBuilder相较于StringBuffer有速度优势，所以多数情况下建议使用StringBuilder。然而在应用程序要求线程安全的时候，必须使用StringBuffer。
- 其他的和StringBuilder一样。



### 4. 字符串常量池（JVM知识点）

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803160544359.png" alt="image-20210803160544359" style="zoom:50%;" />



## 第六问：强引用、软引用、弱引用、虚引用有什么区别？

### 1. 引用

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803161324171.png" alt="image-20210803161324171" style="zoom:50%;" />



### 2. 强引用（可达性分析）

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803161816888.png" alt="image-20210803161816888" style="zoom:50%;" />



### 3. 软引用（缓存）

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803161950282.png" alt="image-20210803161950282" style="zoom:50%;" />



### 4. 弱引用（threadLocal）

![image-20210803162025291](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803162025291.png)



### 5. 虚引用（Phantom）

![image-20210803162127818](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803162127818.png)



## 第七问：Object类有哪些方法？作用都是什么？

Object类是一个特殊的类，是所有类的父类，如果一个类没有使用extends明确指出继承于某个类，那么它默认继承Object。



### 1. hashCode()（native —— 本地方法）

![image-20210803162724153](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803162724153.png)



### 2. equals()

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803162953740.png" alt="image-20210803162953740" style="zoom:50%;" />

- 为什么要重写equals()？

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803163108228.png" alt="image-20210803163108228" style="zoom:50%;" />

- 如果不重写equals()方法，上面的比较会一直false，因为不同的对象地址永远不一样，所以我们可以重写equals()来比较对象内部的内容是否一样。



### 3.通信

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803163711752.png" alt="image-20210803163711752" style="zoom:50%;" />

- notify唤醒其他wait状态的线程，notifyAll就是唤醒所有的wait状态的线程。



### 4. 系统相关

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803163754988.png" alt="image-20210803163754988" style="zoom:50%;" />



### 5. toString()

```java
public String toString(Object obj){
    return obj;  // 直接返回地址，一般要重写（如果本身是字符串内容，则会返回字符串）
}
```



## 第八问：Java实现了哪几种IO模型？为什么引入NIO？

### 1. IO

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803164604814.png" alt="image-20210803164604814" style="zoom:50%;" />



### 2. 同步 VS 异步

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803164734346.png" alt="image-20210803164734346" style="zoom:50%;" />



### 3. 阻塞 VS 非阻塞

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803165012044.png" alt="image-20210803165012044" style="zoom:50%;" />



### 4. BIO（同步阻塞）

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803165127334.png" alt="image-20210803165127334" style="zoom:50%;" />

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803170254420.png" alt="image-20210803170254420" style="zoom:50%;" />![image-20210803170609848](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803170609848.png)

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803170625536.png" alt="image-20210803170625536" style="zoom:50%;" />

- **改进**：新建线程来接收Client，防止read()位置阻塞，导致其他Client无限等待。

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803170704247.png" alt="image-20210803170704247" style="zoom:50%;" />![image-20210803171056497](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803171056497.png)

![image-20210803171056497](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803171056497.png)



### 5. NIO

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803171858473.png" alt="image-20210803171858473" style="zoom:50%;" />



### 6. AIO

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803172008753.png" alt="image-20210803172008753" style="zoom:50%;" />



### 7. NIO VS AIO

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803172044606.png" alt="image-20210803172044606" style="zoom:50%;" />



## 第九问：Java NIO 如何实现多路复用？

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803172502631.png" alt="image-20210803172502631" style="zoom:50%;" />



### 1. NIO

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803172800540.png" alt="image-20210803172800540" style="zoom:50%;" />



### 2. 多路复用

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803173154067.png" alt="image-20210803173154067" style="zoom:50%;" />



### 3. selector

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210803173854996.png" alt="image-20210803173854996" style="zoom:50%;" />

- 因为Java代码的for循环底层也是使用的操作系统的系统调用，所以直接交给底层会效率更高。



## 案例实战：如果通过Java高效地拷贝一个文件？

- 文件拷贝涉及到很多操作系统、计算机底层原理方面的内容。
- Java有多种比较典型的文件拷贝实现方法。



### 1. IO类库

为源文件创建一个FileInputStream负责读取，然后再为目标文件创建一个FileOutputStream负责写入。

```java
import java.io.*;

InputStream is = new FileInputStream(source);
OutputStream os = new FileOutputStream(target);
byte[] buffer = new byte[1024];
int length;
while((length = is.read(buffer))>0){
    os.write(buffer, 0, length);
}
```



### 2. NIO类库

通过提供的transferTo或transferFrom方法实现。

```java
import java.io.*;
import java.nio.*;

FileChannel sc = new FileInputStream(source).getChannel();
FileChannel tc = new FileOutputStream(source).getChannel();
long count = sc.size();
while(count>0){
    long transferred = sc.transferTo(sc.position(), count, tc);
    count -= transferred;
}
```

也可以直接调用 **java.nio.file.Files.copy()** 来实现。



### 3. 用户态 VS 内核态

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210807114706617.png" alt="image-20210807114706617" style="zoom:50%;" />



### 4. IO类库（理）

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210807114920354.png" alt="image-20210807114920354" style="zoom:50%;" />



### 5. NIO类库（理）

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210807115320410.png" alt="image-20210807115320410" style="zoom:50%;" />



### 6. 总结

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210807115457818.png" alt="image-20210807115457818" style="zoom:50%;" />

