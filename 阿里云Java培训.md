# 阿里云Java培训

- 从Dragonwell上下载OpenJDK，Linux环境下：

  - Dragonwell官网：http://dragonwell-jdk.io/
  - wget https://dragonwell.oss-cn-shanghai.aliyuncs.com/8/8.4.4-GA/Alibaba_Dragonwell_8.4.4-GA_Linux_x64.tar.gz

- 对tar.gz压缩包进行解压：tar xf Alibaba_Dragonwell_8.4.4-GA_Linux_x64.tar.gz

- 执行以下命令将环境变量写入到shell登录配置中

  ```
  cat >> ~/.bashrc << EOF
  export JAVA_HOME=$HOME/jdk8u262-b10
  export PATH=$PATH:$JAVA_HOME/bin
  EOF
  ```

- 执行以下命令重新加载.basbrc文件

  - ```
    source ~/.bashrc
    ```

-  执行以下命令验证环境变量是否生效

  - ```
    java -version
    ```

- 执行以下命令编写Hello World源代码文件

  ```
  cat > Hello.java <<EOF
  public class Hello {
      public static void main(String[] args) {
          System.out.println("Hello World!");
      }
  }
  EOF
  ```

- 执行以下命令编译源程序

  ```
  javac Hello.java
  ```

-  执行以下命令运行程序

  ```
  java Hello
  ```




# 一、 Java基础

## 1. 方法的定义

```java
public static 返回值类型 函数名([参数类型 参数, ...]){
    // code
    [return 返回值;]
}
// 如果不想要返回数据，可以用 void 返回。
```

- 方法名：第一个单词首字母小写，后面单词首字母大写。如：printMessage

- 方法的本质是方便使用者进行重复的调用，并且所有的程序都是从主方法开始执行的。

- **无参数无返回值**

  ```java
  public class Test{
      public static void main(String[] args){
          printMessage();
          printMessage();
      }
      public static void printMessage(){
          System.out.println("*******************");
          System.out.println("**  www.mdsn.cn  **");
          System.out.println("*******************");
      }
  }
  ```

- **带参数带返回值**

  ```java
  public class Test{
      public static void main(String[] args){
          String result = get(20);
          System.out.println(result);
          System.out.println(get(15));
      }
      public static String get(double money){
          if(money > 10){
              return "您的找零："+(money-10.0);
          }else{
              return "对不起，您的余额不足。";
          }
      }
  }
  ```

- **使用 retrun 结束 void 函数执行**

  ```java
  public class Test{
      public static void main(String[] args){
  		sale(3);
          sale(-3);
      }
      public static void sale(double money){
          if(money <= 0){
              return;  // 方法的结束
          }
          for( int i=1; i<=money; i++){
              System.out.println("第"+i+"次");
          }
      }
  }
  ```

- 在Java进行方法的定义的时候，不要定义太长，要注意拆分。



## 2. 方法重载

**定义：**当方法名字相同，参数的类型或个数不同的时候，称为方法的重载。

```java
public class Test{
    public static void main(String[] args){
        int resA = sum(10, 20);
        int resB = sum(10, 20, 30);
        double resC = sum(10.5, 20.3);
        System.out.println(resA);
        System.out.println(resB);
        System.out.println(resC);
    }
    public static int sum(int x, int y){
        return x+y;
    }
    public static int sum(int x, int y, int z){
        return x+y+z;
    }
    public static double sum(double x, double y){
        return x+y;
    }
}
```

记住一点：方法的重载和方法的返回值没有任何关系，它只和参数类型和个数有关。

把握一个开发原则：只要是方法重载强烈建议其返回值类型相同。

**范例：**

```java
public class Test{
    public static void main(String[] args){
        System.out.println(1);
        System.out.println(true);
        System.out.println("Hello world");
        System.out.println(1.1);
        System.out.println('A');
    }
}
```

- System.out.println(); 本身就是一个方法重载的实现。



## 3. 方法的递归调用

自己调用自己，就是递归调用。利用递归调用可以解决一些重复且复杂的问题。

进行递归设计，一般考虑以下问题：

- 设置递归的结束条件。
- 每一次调用一定要修改传递参数值。

**范例：实现1~100的累加。**

```java
public static void main(String[] args){
    System.out.println(sum(100));
}
public static int sum(int num){
    if(num<=0){
        return 0;
    }
    return num + sum(--num);
}
```

**分析：**

- 【第一次调用sum()，主方法调用】 return 100 + sum(99);

- 【第二次调用sum()，sum()递归调用】  return 99 + sum(98);

  ... ... ...

- 【第99次调用sum()，sum()递归调用】  return 2 + sum(1);

- 【第100次调用sum()，sum()递归调用】  return 1 + sum(0);

- 【第101次调用sum()，sum()递归调用】   return 0;

- 所以最终是：return 100 + 99 + ... + 1 + 0;

在实际中，递归很少需要使用，而且不建议使用，因为容易造成栈溢出。



**范例：计算“1! + 2! + 3! + ... + 90!”；**

在进行阶乘计算的时候，必须考虑选择的数据类型，肯定不能使用 int 或 long，只能使用 double。

```java
public class Test{
    int num;
    double[] res;

    public Test(int num){
        this.num = num;
        res = new double[num];
        res[0] = 1;
    }
    
    public double fan(){
        double result = this.res[0];
        for( int i=1; i < this.num; i++){
            res[i] = this.res[i-1]*(i+1);
            result = result + this.res[i];
        }
        return result;
    }
    
    public static void main(String[] args){
	Test t = new Test(90);
        System.out.println(t.fan());
    }
}
```



# 二、Java面向对象

## 一） 深入分析类与对象

### 1. 成员属性封装

在类之中的组成是方法和属性，一般方法是对外提供服务的。

在默认情况下，对于类中的属性是可以通过别的类获取并使用的。（没有进行封装处理，外部可以进行直接调用，不过数据可能是错误的。）

```java
class Person{
    String name;
    int age;
    public void tell(){
        System.out.println("姓名："+name+"，年龄："+age);
    }
}
public class Test{
    public static void main(String[] args){
        Person per = new Person();
        per.name = "张三";
        per.age = -18;  // 错误属性值
        per.tell();
    }
}
```

**进行private封装：**一旦通过private进行了封装，类的外部就不能对该属性进行访问。（对类的外部不可见，内部可见）。如果想要外部访问封装的属性：Java由如下要求：

- 设置 setter 、getter方法来设置属性值和获取属性值。

```java
class Person{
    private String name;
    private int age;
    public void tell(){
        System.out.println("姓名："+name+"，年龄："+age);
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        if(age>=0){
        	this.age = age;
        }
    }
    public String getName(){
        return this.name
    }
    public int getAge(){
        return this.age;
    }
}
public class Test{
    public static void main(String[] args){
        Person per = new Person();
        per.name = "张三";
        per.age = -18;  // 错误属性值
        per.tell();
    }
}
```

- 在以后进行任何类开定义的时候，类中的所有属性都必须使用private封装（适用于98%情况），并且属性要进行访问的时候，必须提供 **setter 、getter** 方法。



### 2. 构造方法

可以通过构造方法实现实例化对象中的属性初始化。

- 构造方法名称必须和类名称保持一致。
- 构造方法不允许设置任何返回值类型，包括void。
- 构造方法是在使用关键字 new 在之后自动调用的。

**范例：定义构造方法**

```java
public class Person{
    private String name;
    private int age;
    // 构造方法
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        if(age>=0){
        	this.age = age;
        }
    }
    public String getName(){
        return this.name
    }
    public int getAge(){
        return this.age;
    }
    public static void main(String[] args){
        Person per = new Person("张三", 18);
    }
}
```

之前的实例化格式：①Person ②per = ③new ④Person();

现在的实例化格式：①Person ②per = ③new ④Person("张三", 18);

- ①Person：主要是定义对象的所属类型，类型决定了你能够调用的方法和属性。
- ②per：实例化对象的名字，所有操作都通过对象来进行访问。
- ③new：开辟一块新的堆内存空间。
- ④Person("张三", 18)：调用有参构造。④Person()：调用无参构造。

在程序没有定义构造方法的时候，代码会在程序编译的时候，自动创建一个无参构造方法。（即任何类之中都至少有一个构造方法）

```txt
疑问：为什么构造方法不允许设置返回值类型？
	既然构造方法是一个方法，那么为什么不让他定义返回值类型？
	既然构造方法不会返回数据，为什么不用void？
分析：程序编译器是根据代码结构来进行编译处理的，执行的时候也是根据代码结构来执行的。
如果构造方法上使用了void，那么此结构就与普通方法结构完全相同了。那么编译器就会认为这是一个普通方法而不是构造方法。
public "void" Person();
public void tell();
```



构造方法也是方法，也可以重载，不够构造方法重载只考虑参数问题。

```java
public class Person{
    private String name;
    private int age;
    // 构造方法
    public Person(){};
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    //重载
    
    public static void main(String[] args){
        Person per = new Person("张三", 18);
    }
}
```

在进行多个方法重载的时候，建议有一定的顺序排放，方便查看和查找。

- setter除了设置内容之外，还可以修改数据。
- getter可以获取private数据。



经过分析之后，发现利用构造方法可以传递属性值。

- **定义对象的名称：**类名称 对象名称 = null;
- **实例化对象：**对象名称 = new 类名称();

如果这时候只是通过实例化对象来进行类的操作也是可以的，而这种形式就叫做**<u>匿名对象</u>**。



### 3. 匿名对象

```java
class Message{
    private String title;
    public Message(String title){
        this.title = title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
}

public class Person(){
    private String name;
    private int age;
    
    // 构造方法
    public Person(){};
    public Person(Message msg, int age){
        this.name = msg;
        this.age = age;
    }
    
    public Message getInfo(){
        return new Message(name + ":" + age);
    }
    public void tell(){
        System.out.println("姓名："+name+"，年龄："+age);
    }
    
    public static void main(String[] args){
        Message msg = new Message("mldn");
        Person per = new Person(msg, 18); // 没有名称，匿名调用
        msg = per.getInfo();
        System.out.println(msg.getTitle());
    }
}
```

匿名对象调用后，因为没有进行名称的定义和初始化，所以在使用过一次之后，就会被视为垃圾，然后被GC回收释放。

​		现在发现程序里面已经有构造方法了，那么下面通过一个程序来利用构造方法进行内存分析。

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210822120211812.png" alt="image-20210822120211812" style="zoom:50%;" />

只要是方法，都可以传递任意数据类型（基本数据类型和引用数据类型都可）。



## 二）this关键字

使用this，可以实现以下三类结构的描述：

- 当前类中的属性：this.属性。
- 当前类中的方法（构造方法、普通方法）：this()、this.方法名称()。
- 描述当前对象。



### 1. 使用this表示当前属性

```java
class Person{
    private String name;
    private int age;
    public Person(String n, int a){
		name = n;
        age = a;
    }
    public void tell(){
        System.out.println("姓名：" + name + "，年龄：" + age);
    }
}
public class JavaDemo{
    public static void main(String[] args){
        Person per = new Person("张三", 18);
        per.tell();
    }
}
```

但是在构造方法上，有一点儿别扭：

```java
public Person(String n, int a){
    name = n;
    age = a;
}
```

这里的参数名称 n 和 a 看着不舒服：

```java
public Person(String name, int age){
    //name = name;
    //age = age;
    // 在Java程序之中"{}"是作为一个程序的边界符，那么在程序里面当进行变量使用的时候，会优先在边界里面找。
    // 所以上面的两次赋值，最终是 Null 和 0
    // 这时候我们需要使用this关键字，来表明下面调用的 name 和 age 是调用的本类的属性值 name 和 age。
    this.name = name;
    this.age = age;
}
```

在以后的代码开发中，所有使用的当前类的属性的时候，最好都在属性前面加一个this关键字，增加可读性。



### 2. 使用this调用方法

除了调用属性之外，this也可以实现方法的调用，但是对于方法的调用要注意区分构造方法和普通方法。

- 构造方法：this() —— 使用关键字new实例化对象的时候，才会调用构造方法。
- 普通方法：this.方法名称() —— 实例化对象之后，就可以调用普通方法。

**范例：调用普通方法**

```java
class Person{
    private String name;
    private int age;
    public Person(String name, int age){
		this.setName(name);
        setAge(age);  // 加或不加都可以调用，但是加上this会让你读起来更清楚
    }
    
    public void tell(){
        System.out.println("姓名：" + name + "，年龄：" + age);
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    
}
public class JavaDemo{
    public static void main(String[] args){
        Person per = new Person("张三", 18);
        per.tell();
    }
}
```



**范例：调用构造方法**

```java
// 调用构造方法，那么肯定是要放在构造方法中执行。
// 要求：类中一共有三个构造方法，但是不管构造哪个构造方法，都要执行一条输出语句。
```

```java
// 传统做法
class Person{
    private String name;
    private int age;
    public Person(){
        System.out.println("*********");
    }
    public Person(String name){
        System.out.println("*********");
        this.name = name;
    }
    public Person(String name, int age){
        System.out.println("*********");
		this.name = name;
        this.age = age;
    }
    public void tell(){
        System.out.println("姓名：" + name + "，年龄：" + age);
    }
}
public class JavaDemo{
    public static void main(String[] args){
        //Person per = new Person();
        //Person per = new Person("张三");
        Person per = new Person("张三", 18);
        per.tell();
    }
}
```

**`评价代码的好坏：`**

-  代码结构可以重用，提供的是一个中间独立的支持；
- 我们的目标是：没有重复。

```java
// this优化
class Person{
    private String name;
    private int age;
    public Person(){
        System.out.println("*********");
    }
    public Person(String name){
        this();
        this.name = name;
    }
    public Person(String name, int age){
        this(name);
        this.age = age;
    }
    public void tell(){
        System.out.println("姓名：" + name + "，年龄：" + age);
    }
}
public class JavaDemo{
    public static void main(String[] args){
        //Person per = new Person();
        //Person per = new Person("张三");
        Person per = new Person("张三", 18);
        per.tell();
    }
}
```

对于本类构造方法的互相调用，需要注意以下几点重要问题：

- 构造方法必须在实例化新对象的时候调用，所以this()只允许放在构造方法的首行。
- 在构造方法中可以调用普通方法，但是在普通方法中不能调用构造方法。
- 构造方法互相调用的时候，请保留程序的出口。（不要互相调用导致死循环）

```java
class Person{
    private String name;
    private int age;
    public Person(){
        System.out.println("*********");
    }
    public Person(String name){
        this("hahaha", 12);  // 问题3：递归调用
        this.name = name;
    }
    public Person(String name, int age){
        this(name);
        this.age = age;
        this(); // 问题1 Error
    }
    public void tell(){
        this(); // 问题2 Error
        System.out.println("姓名：" + name + "，年龄：" + age);
    }
}
public class JavaDemo{
    public static void main(String[] args){
        //Person per = new Person();
        //Person per = new Person("张三");
        Person per = new Person("张三", 18);
        per.tell();
    }
}
```



### 3. 构造方法互相调用案例

现在要求定义一个员工信息的程序类，该类中提供有：编号、姓名、部门、工资。要求如下：

- 【无参构造】：编号定义为1000，姓名定义为“无名氏”。
- 【单参构造】：传递编号，姓名定义为“新员工”，部门定义为“未定”，工资定义为 0 。
- 【三参构造】：传递编号、姓名、部门，工资为2500.00 。
- 【四参构造】：所有属性都全部进行传递。

**范例：进行代码的初期实现。**

```java
class Emp{
    private long empno;  // 员工编号
    private String ename; // 员工姓名
    private String dept; // 部门名称
    private double salary; // 员工工资
    
    // 无参构造
    public Emp(){
        this.empno = 1000;
        this.ename = "无名氏";
    }
    // 单参构造
    public Emp(long empno){
        this.empno = empno;
        this.ename = "新员工";
        this.dept = "未定";
        // 工资 double 默认值 0.0
    }
    // 三参构造
    public Emp(long empno, String ename, String dept){
        this.empno = empno;
        this.ename = ename;
        this.dept = dept;
        this.salary = 2500.00;
    }
    // 四参构造
    public Emp(long empno, String ename, String dept, double salary){
        this.empno = empno;
        this.ename = ename;
        this.dept = dept;
        this.salary = salary;
    }
    
    // setter getter 略。
    public String getInfo(){
        return "雇员编号：" + this.empno +
               "、雇员姓名：" + this.ename +
               "、雇员部门：" + this.dept + 
               "、雇员工资：" + this.salary;
    }
}

public class JavaDemo{
    public static void main(String[] args){
        Emp emp = new Emp(7369L, "Smith", "财务部", 6500.00);
    }
}
```

此时发现代码有重复，现在进行简化定义：

```java
class Emp{
    private long empno;  // 员工编号
    private String ename; // 员工姓名
    private String dept; // 部门名称
    private double salary; // 员工工资
    
    // 全部用四参构造进行优化！！！！
    // 无参构造
    public Emp(){
        this(1000, "无名氏", null, 0.0);
    }
    // 单参构造
    public Emp(long empno){
        this(epmno, "新员工", "未定", 0.0);
    }
    // 三参构造
    public Emp(long empno, String ename, String dept){
        this(empno, ename, dept, 2500.00);
    }
    // 四参构造
    public Emp(long empno, String ename, String dept, double salary){
        this.empno = empno;
        this.ename = ename;
        this.dept = dept;
        this.salary = salary;
    }
    
    // setter getter 略。
    public String getInfo(){
        return "雇员编号：" + this.empno +
               "、雇员姓名：" + this.ename +
               "、雇员部门：" + this.dept + 
               "、雇员工资：" + this.salary;
    }
}

public class JavaDemo{
    public static void main(String[] args){
        Emp emp = new Emp(7369L, "Smith", "财务部", 6500.00);
    }
}
```

**代码的任何位置都可能有重复，所以消除重复是前期学习之中最重要的、最需要考虑的部分。**



### 4. 简单Java类

​		在以后的程序开发与设计之中，简单Java类都将作为一个重要的组成部分存在，慢慢的接触到正规项目设计之后，简单的Java类无处不在，并且有可能产生一系列变化。

​		可以描述某一类信息的程序类。如：描述一类人、描述一本书、描述一个部门、描述一个雇员。

​		并且这种类之中并没有特别复杂的逻辑操作，只作为一种信息存储的媒介存在。

​		对于简单Java类而言，其核心的开发结构如下：

- 类名称一定要有意义，可以明确的描述某一类事物。
- 类之中的所有属性必须是private，封装后要提供 setter getter。
- 类之中可以提供无数多个构造方法，但是**必须要保留有无参构造方法。**
- 类之中不允许出现任何输出语句，所有的内容必须返回。
- 【非必须】：可以提供一个获取对象详细信息的方法，暂时将名字定义为 getInfo()。

**范例：定义一个简单Java类**

```java
class Dept{ // 类名称可以明确描述出某类事物
    private long deptno;
    private String dname;
    private String loc;
    public Dept(){}  // 无参构造
    public Dept(long deptno, String dname, String loc){
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
    public String getInfo(){
        return "【部门信息】部门编号：" + this.deptno +
               "，部门名称：" + this.dname + 
               "，部门地址：" + this.loc;
    }
    public void setDeptno(long deptno){
        this.deptno = deptno;
    }
    public void setDname(String dname){
        this.dname = dname;
    }
    public void setLoc(String loc){
        this.loc = loc;
    }
    public long getDeptno(){
        return this.detpno;
    }
    public String getDname(){
        return this.dname;
    }
    public String getLoc(){
        return this.loc;
    }
}
public class JavaDema{
    public static void main(String[] args){
        Dept dept = new Dept(10, "记事部", "北京");
        System.out.println(dept.getInfo());
    }
}
```

这种简单的Java类就融合了所有现在接触到的概念：

- 数据类型划分
- 类的定义
- private封装
- 构造方法
- 方法定义
- 对象实例化



## 三）代码块

在程序之中，使用“｛｝”定义的结构，称之为代码块。而后根据代码块出现的位置以及定义的关键字的不同，代码块可以分为：普通代码块、构造代码块、静态代码块、同步代码块。（其中同步代码块会在多线程中讲解）



### 1. 普通代码块

主要特点：定义在一个方法之中的。

**范例：观察一个程序**

```java
public class JavaDemo{
    public static void main(String[] args){
        if(true){  //条件一定满足
            int x = 10;  // if内部的局部变量
            System.out.println("x=" + x);
        }
        int x = 100;  // main里面的局部变量
        // 两个x的作用范围是不一样的
        System.out.println("x=" + x);
    }
}
```

按照Java规定，相同名称是不能在同一个方法中存在的，但是由于不同的分界，所以这里的两个 x 是可以共存的。

如果要定义普通代码块，只需要将 if 取消即可。

```java
public class JavaDemo{
    public static void main(String[] args){
        {  // 加一个界限用于区分两个x
            int x = 10;  // if内部的局部变量
            System.out.println("x=" + x);
        }
        int x = 100;  // main里面的局部变量
        // 两个x的作用范围是不一样的
        System.out.println("x=" + x);
    }
}
```

**普通代码块最大的特征在于可以在一个方法之中进行一些结构的拆分，防止相同变量所带来的互相影响。**

### 2. 构造代码块

构造块是定义在一个类之中的。

**范例：观察一个程序**

```java
class Person{
    public Person(){
        System.out.println("【构造方法】Person构造方法执行。");
    }
    {
        System.out.println("【构造块】Person构造块执行。");
    }
}
public class JavaDemo{
    public static void main(String[] args){
        new Person();
        new Person();
        new Person();
    }
}
```

构造块会优先于构造方法执行，并且每次实例化新对象的时候，都会调用构造块中的代码。



### 3. 静态代码块

静态代码块主要指的是使用 `static` 关键字定义的代码块。

- 主类中定义
- 非主类中定义

**范例：非主类中定义**

```java
class Person{
    public Person(){
        System.out.println("【构造方法】Person构造方法执行。");
    }
    {
        System.out.println("【构造块】Person构造块执行。");
    }
    
    static {
        System.out.println("【静态块】Person静态快执行。");
    }
}
public class JavaDemo{
    public static void main(String[] args){
        new Person();
        new Person();
        new Person();
    }
}
```

**此时可以发现静态代码块会优先于构造块执行，并且不管有多少实例化出现，静态块都只会执行一次，静态块的作用主要目的是为了类中的静态属性初始化。**



**范例：观察静态属性初始化**

```java
class Message{
    public static String getCountry(){
        // 该消息的内容可能来自于网络或其他来源
        return "中国";
    }
}
class Person{
    private static String country;
    static {
        // 可能有很多语句需要在开始一起执行，这样可以增加可读性和可操作性
        country = Message.getCountry();  // 编写一部分代码
        System.out.println(country);
    }
}
public class JavaDemo{
    public static void main(String[] args){
        new Person();
        new Person();
        new Person();
    }
}
```

对于静态代码块还需要考虑另一种形式，在主类中的形式。



**范例：在主类中的定义**

```java
public class JavaDemo{
    static{
        System.out.println("*********** 程序初始化 **********");
    }
    public static void main(String[] args){
        System.out.println("www.mldn.cn");
    }
}
```

**静态代码块优先于主方法执行！！！**

（主方法始终为程序起点，不过静态代码块的优先级更高，可以为主方法执行做一些准备工作）



## 四）static关键字

### 1. 声明static属性

在一个类之中，所有的属性一旦定义之后，实际上所有的内容都交由各自的堆内存空间来保存。

**范例：定义一个程序类**

```java
class Person{
    private String name;
    private int age;
    String country = "中华民国";  // 暂时不封装
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    // setter getter略
    public String getInfo(){
        return "姓名：" + this.name + "，年龄：" + this.age + "，国家：" + this.country; 
    }
}
public class JavaDemo{
    public static void main(String[] args){
        Person perA = new Person("张三", 10);
        Person perB = new Person("李四", 10); 
        Person perC = new Person("王五", 11); 
        System.out.println(perA.getInfo());
        System.out.println(perB.getInfo());
        System.out.println(perC.getInfo());
    }
}
```

**对于上述程序作出内存分析：**

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210830161200847.png" alt="image-20210830161200847" style="zoom:67%;" />



​        在正常开发过程之中，每一个对象要保存有各自的属性，所以此时的程序没有任何问题。但是突然有一天 “中华民国” 解放了，变成了 “中华人民共和国” 。并且已经产生了5000W个对象，这时候我们需要修改5000W个对象的属性值！！！因为每一个对象都拥有各自的 "country" 属性。（重复保存数据并且修改不方便）

​		那么这个时候最好的解决方案，就需要将 “country” 设置为公共属性，也就是用 **static** 修饰公共属性。

```java
class Person{
    private String name;
    private int age;
    static String country = "中华民国";  // static 
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    // setter getter略
    public String getInfo(){
        return "姓名：" + this.name + "，年龄：" + this.age + "，国家：" + this.country; 
    }
}
public class JavaDemo{
    public static void main(String[] args){
        Person perA = new Person("张三", 10);
        Person perB = new Person("李四", 10); 
        Person perC = new Person("王五", 11); 
        System.out.println(perA.getInfo());
        System.out.println(perB.getInfo());
        System.out.println(perC.getInfo());
    }
}
```

 		此时会发现所有对象中的 **“country”** 属性值的内容都发生了改变，所以是一个公共属性，**而此时的内存关系图如下：**

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210830161745240.png" alt="image-20210830161745240" style="zoom:67%;" />

​		但是对于 **“static”** 属性的访问需要注意一点：**由于其本身是一个公共的属性，虽然理论上可以通过对象进行访问，但是最好通过所有对象的最高代表（类）进行访问，<u>所以 static 属性可以由类名称直接调用</u>。**

```java
class Person{
    private String name;
    private int age;
    static String country = "中华民国";  // static 
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    // setter getter略
    public String getInfo(){
        return "姓名：" + this.name + "，年龄：" + this.age + "，国家：" + this.country; 
    }
}
public class JavaDemo{
    public static void main(String[] args){
        Person perA = new Person("张三", 10);
        Person perB = new Person("李四", 10); 
        Person perC = new Person("王五", 11); 
        Person.country = "中华人民共和国";
        System.out.println(perA.getInfo());
        System.out.println(perB.getInfo());
        System.out.println(perC.getInfo());
    }
}
```

​		static 属性虽然定义在类之中，但是其不受类实例化对象的控制。static 属性可以在没有实例化对象的时候使用。

**范例：不产生实例化对象调用static属性。**

```java
class Person{
    private String name;
    private int age;
    static String country = "中华民国";  // static 
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    // setter getter略
    public String getInfo(){
        return "姓名：" + this.name + "，年龄：" + this.age + "，国家：" + this.country; 
    }
}
public class JavaDemo{
    public static void main(String[] args){
        System.out.println(Person.country);
        Person.country = "中华人民共和国";
    }
}
```

​		在以后进行类设计的时候，首选的一定是 非static(95%) 属性，考虑到公共信息的时候，才会使用到 static(5%)。非static必须在实例化对象之后使用，但是static对象可以在实例化对象之前就直接产生和使用。



### 2. 声明static方法

​		static关键字也可以进行方法的定义，static方法的主要特点在于：其可以直接由类名称在没有实例化对象之前的情况下进行调用。

**范例：定义static方法。**

```java
class Person{
    private String name;
    private int age;
    private static String country = "中华民国";  // static 
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public static void setCountry(String c){
        country = c;
    }
    // setter getter略
    public String getInfo(){
        return "姓名：" + this.name + "，年龄：" + this.age + "，国家：" + this.country; 
    }
}
public class JavaDemo{
    public static void main(String[] args){
        Person.setCountry("中华人民共和国");  // 没有实例化对象，类名称直接调用
        Person per = new Person("张三", 10);
 		System.out.println(per.getInfo());       
    }
}
```

​		这个时候对于程序而言，方法就有了两种：static方法和非static方法。

​		**这两个方法之间在调用上就有了限制：**

- static方法只允许调用static属性或static方法。
- 非static方法允许调用static属性或static方法。

所有的static定义的属性和方法都可以在没有实例化对象的前提下使用，而所有的非static定义的属性和方法必须有实例化对象才行，所有才有了上述的调用方式。

```java
public class JavaDemo{
    public static void main(String[] args){
        print1();  // 调用static
        new JavaDemo().print2();  // 调用非static
    }
    public static void print1(){
        System.out.println("www.mldn.cn");
    }
    public void print2(){
        System.out.println("www.mldn.cn");
    }
}
```

**<u>只有在回避实例化调用并且描述公共属性的情况下才会考虑使用static定义的方法和属性。</u>**



### 3. static案例

**范例：编写一个程序类。这个类可以实现实例化对象个数的统计，也就是每一次创建新的实例化对象的时候，都可以进行统计操作。**

```java
public class Person{
    private String name;
    private static int number = 0;
    public Person(String name){
        this.name = name;
        number++;
    }
}
```



**范例2：实现属性的自动命名处理。**(如果没有传递title属性)

```java
public class Book{
    private String title;
    private static int number = 0;
    public Book(String title){
        this.title = title;
        number++;
    }
    public Book(){
        this("Book - " + (++count));
    }
}
```

这样处理可以避免没有设置属性值的时候，属性为null的重复问题。



## 五）面向对象案例

初期最简单最可靠的分析就是简单Java类。



### 案例一：Address类

要求：国家、省份、城市、街道、邮编，并返回完整地址信息。

```java
package 面向对象案例;

public class Address {
    private String country;  // 国家
    private String province; // 省份
    private String city;     // 城市
    private String street;   // 街道
    private String zipcode;  // 邮编

    public Address(){}
    public Address(String country, String province, String city, String street, String zipcode){
        this.country = country;
        this.province = province;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getInfo(){
        return "国家：" + country +
                "，省份：" + province +
                "，城市：" + city +
                "，街道：" + street +
                "，邮编：" + zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public static void main(String[] args) {
        System.out.println(new Address("中华人民共和国", "北京", "朝阳路", "天安门街道", "10010").getInfo());
    }
}

```



### 案例二：Employ类

要求：

- 属性：“编号”、“姓名”、“基本薪水”、“薪水增长率”
- 方法：计算薪水增长额以及增长后的工资总额。

已经超过简单Java类，因为简单Java类不涉及普通方法。（但是依然从简单Java类思考出发）

```java
package 面向对象案例;

public class Employee {
    private long empno;
    private String ename;
    private double salary;
    private double rate;

    public Employee(){}

    public Employee(long empno, String ename, double salary, double rate) {
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
        this.rate = rate;
    }
    // getter setter 略过

    // 工资增长额
    public double salaryIncValue(){
        return this.salary * this.rate;
    }

    // 工资总额
    public double salaryIncResult(){
        this.salary = this.salary + this.salaryIncValue();
        return this.salary;
    }

    // 类似于getInfo()
    @Override
    public String toString() {
        return "Employee{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                ", rate=" + rate +
                '}';
    }

    public static void main(String[] args) {
        Employee emp = new Employee(7396L, "Smith", 3000, 0.3);
        System.out.println(emp);
        System.out.println("工资调整额度：" + emp.salaryIncValue());
        System.out.println("工资最后总额：" + emp.salaryIncResult());
        System.out.println(emp);
    }
}
```



### 案例三：Account类

构造一个银行账户类，构成如下：

- 账户名称、账户余额。
- 开户（设置账户名称及余额）。
- 查询余额。

```java
package 面向对象案例;

public class Account {
    private String name;
    private double balance;
    public Account (){}
    public Account (String name){
        this(name, 0.0);
    }
    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    // getter setter略
    public double getBalance(){
        return this.balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public static void main(String[] args) {
        Account a = new Account("啊嘟嘟", 900.00);
        System.out.println(a);
        System.out.println("账户余额：" + a.getBalance());
    }
}
```



### 案例四：Book类

- 书名、编号（静态变量实现自动编号）、书价
- 静态数据成员册数、记录图书的总册数
- 求出总册数

```java
package 面向对象案例;

public class Book {
    private String title;
    private int bid;
    private double price;
    private static int count = 0;
    public Book(){}

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
        this.bid = ++count; // 书的编号
    }

    public static int getCount(){
        return count;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", bid=" + bid +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        Book b1 = new Book("Java", 89.2);
        Book b2 = new Book("Python", 88.6);
        System.out.println("图书总册数：" + Book.getCount());
    }
}
```



## 六）数组

### 1. 数组的初始化

数组的动态声明：

- 声明并初始化数组：
  - 数据类型 数据名称[] = new 数据类型[长度];
  - 数据类型[] 数据名称 = new 数据类型[长度];

数组的静态初始化：在数组定义的时候就为其设置好了里面的内容。

- 简化格式：数据类型 数据名称 = {数据1 ， 数据2， ...}
- 完整格式：数据类型 数据名称 = new 数据类型[]{数据1 ， 数据2， ...}

可以通过角标范围进行每一个元素的访问，角标范围是从 **0 - (n-1)**

在以后的项目中，最常用的方式是进行循环控制和操作。

**范例：数组的初始化**

```java
package 数组;

public class 数组初始化 {
    public static void main(String[] args) {
        // 动态初始化
//        int data[] = new int[3];
//
//        // 依次取值
////        System.out.println(data[0]);
////        System.out.println(data[1]);
////        System.out.println(data[2]);
//        data[0] = 22;
//        data[1] = 53;
//        data[2] = 34;
//
//        for (int i=0; i<data.length; i++){
//            System.out.println(data[i]);
//        }

        // 静态初始化
        int data[] = new int[]{55, 33, 14};
        for( int i = 0; i<data.length; i++){
            System.out.println(data[i]);
        }
    }
}
```

任何数据类型的数组进行动态初始化的之后，里面存放的值都是该数据类型的**默认值**。



### 2. 数组的引用传递

数组的创建过程依然由new的存在，所以依然存在内存匹配的问题。

**以下是一个简单的范例：**

```java
package 数组;

public class 数组的引用传递 {
    public static void main(String[] args) {
        int data[] = new int[3];
        data[0] = 22;
        data[1] = 53;
        data[2] = 34;
        for( int i = 0; i<data.length; i++){
            System.out.println(data[i]);
        }
    }
}
```

**以上面的程序为例，进行数组内存分析：**

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210910161808835.png" alt="image-20210910161808835" style="zoom:67%;" />

但是数组本身就是引用数据类型，那么一定会发生引用传递，按照传统的方式那样：一个堆内存可以被多个栈内存所指向。

**引用传递范例：**

```java
package 数组;

public class 数组的引用传递 {
    public static void main(String[] args){
        int data[] = new int[]{10, 20, 30};
        int temp[] = data; // 引用传递
        int x = data[2];  // 没有受到影响
        temp[2] = 99;
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
        System.out.println(x);
    }
}
```

**输出结果：**

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210910162227267.png" alt="image-20210910162227267" style="zoom:67%;" />

**内存分析：**

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210910162417043.png" alt="image-20210910162417043" style="zoom:67%;" />

由于数组属于引用类型，所以一定要为其开辟堆内存空间之后才可以使用，如果为开辟空间直接使用，会报异常**“NullPointerException”**。

```java
package 数组;

public class 数组的引用传递 {
    public static void main(String[] args){
        int data[] = null;
        int temp[] = data; // 引用传递
        int x = data[2];  // 没有受到影响
        temp[2] = 99;
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
        System.out.println(x);
    }
}
```

**运行结果：**

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210910162736026.png" alt="image-20210910162736026" style="zoom:67%;" />



### 3. foreach迭代

**语法结构：**

```
for( 数据类型 变量 ： 数组|集合){
	// 操作变量
}
```

每一次循环可以直接获取到变量值，而不需要通过下标取值。

```java
package 数组;

public class foreach {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5};
        for (int x:data) { // 自动循环
            System.out.println(x);
        }
    }
}
```

可以避免通过下标取值，出现Null问题。



### 4. 二维数组

以前学的都是一个括号"[]"。

传统数组：

| 下标 | 0    | 1    | 2    | 3    | 4    |
| ---- | ---- | ---- | ---- | ---- | ---- |
| 数据 | 135  | 135  | 12   | 4    | 6    |

二位数组：如果你需要一个多行多列的表格，就是一个二维数组，也就是有两个"[]"。

| 下标  | 0    | 1    | 2    | 3    | 4    | 5    |
| ----- | ---- | ---- | ---- | ---- | ---- | ---- |
| **0** | 135  | 1    | 849  | 46   | 215  | 235  |
| **1** | 89   | 56   | 35   | 44   | 2    | 8    |

数组的动态初始化：

- 数据类型 数据名称[][\] = new 数据类型 [行个数\][列个数\]

数组的静态初始化：

- 数据类型 数据名称[\][\] = new 数据类型 [][\]{{数据1, ...}, {数据2, ...}, {数据3, ...}, ...}

```java
package 数组;

public class 二维数组 {
    public static void main(String[] args) {
        int[][] data = new int[][] {
                {1,2,3,4,5}, {11,22,33,44},{111,222,333}
        };
        for (int i=0; i<data.length; i++){
            for (int j=0; j<data[i].length; j++){
                System.out.println("data["+i+"]["+j+"] = "+data[i][j]);
            }
            System.out.println();
        }
    }
}
```

| 下标索引 | 0    | 1    | 2    | 3    | 4    |
| -------- | ---- | ---- | ---- | ---- | ---- |
| 0        | 1    | 2    | 3    | 4    | 5    |
| 1        | 11   | 22   | 33   | 44   |      |
| 2        | 111  | 222  | 333  |      |      |

**也就是说二维数组可以是不规则的。**

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210910165012510.png" alt="image-20210910165012510" style="zoom:67%;" />

**一般来讲是不提倡不规则的数组的，以下用foreach进行遍历：**

```java
public static void demo(){
    int[][] data = new int[][] {
        {1,2,3,4,5}, {11,22,33,44},{111,222,333}
    };
    for (int[] x : data) {
        for (int y : x) {
            System.out.print(y + " ");
        }
        System.out.println();
    }
}
```

两个中括号以上的都叫多维数组。



### 5. 数组与方法

对于引用数据而言，主要的特点是可以与方法进行引用传递，而数组就是引用类型，所以也可以通过方法实现引用传递。

**范例：实现数组的引用传递。**

```java
package 数组;

public class 数组与方法 {
    public static void main(String[] args) {
        int data[] = new int[]{1, 2, 3, 4, 5};
        printArray(data);
    }
    // 要求接受一个int类型数组
    // 把引用的地址传进来，实现引用传递
    public static void printArray(int[] data){
        for (int x= 0; x<data.length; x++){
            System.out.println(data[x] + ",");
        }
    }
}
```

**内存关系如下：**

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210911163010277.png" alt="image-20210911163010277" style="zoom:67%;" />

既然可以通过方法接收一个数组，就可以通过方法返回数组。

```java
public static int[] initArray() {
    int[] arr = new int[]{1, 2, 3, 4, 5};
    return arr;
    // 在返回匿名数组的时候，不能用简化做法，会报错
}
```

**内存分析：**

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210911163442359.png" alt="image-20210911163442359" style="zoom:67%;" />



**范例：通过引用传递修改数组值**

```java
public static void changeArray(int[] arr){
    for (int i=0; i<arr.length; i++){
        arr[i]*=2;
    }
}
```

传入的是一个地址，所以虽然里面备份了一个temp进行修改，但是都是指向了同一个地址空间，进行修改后，原来的数据也就会被修改。

**内存分析：**

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210911163945842.png" alt="image-20210911163945842" style="zoom:67%;" />



**案例：随意定义一个数组，要求可以计算出这个数组元素的总和，并求出最值和平均值。**

```java
public static void culArray(int[] arr){
    int sum = 0;
    double avg = 0.0;
    int max = arr[0];  // 假设第一个是最大值
    int min = arr[0];  // 假设第一个是最大值
    for(int i=0 ; i<arr.length; i++){
        if (arr[i]>max){  // max低位改变了
            max = arr[i];
        }
        if (arr[i]<min){
            min = arr[i];
        }
        sum += arr[i];
    }
    avg = sum / arr.length;
    System.out.println("最大值："+max);
    System.out.println("最小值："+max);
    System.out.println("总  和："+sum);
    System.out.println("平均值："+avg);
}
```

对于项目开发，主类就相当于一个客户端，应该尽量的简化，不应该包含太多的功能，因此我们可以对这个方法进行封装，**封装成一个工具类**，以此保证主类的安全性以及耦合性。

```java
class ArrayUtil{
    private int sum;
    private int max;
    private int min;
    private double avg;
    private int[] arr;

    public ArrayUtil(){}
    public ArrayUtil(int[] arr) {
        this.arr = arr;
        this.sum = 0;
        this.avg = 0.0;
        this.max = arr[0];  // 假设第一个是最大值
        this.min = arr[0];  // 假设第一个是最大值
        for(int i=0 ; i<arr.length; i++){
            if (arr[i]>this.max){  // max低位改变了
                this.max = arr[i];
            }
            if (arr[i]<this.min){
                this.min = arr[i];
            }
            this.sum += arr[i];
        }
        this.avg = this.sum / arr.length;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
}
```



### 6. 数组排序

数组的排序总是通过一个基础模型完成的。

**范例：升序排序。**

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210911170505081.png" alt="image-20210911170505081" style="zoom:67%;" />

```java
package 数组;

public class 数组排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 56, 89, 1, 9, -10};
        boolean flag = false; // 用来判断是否发生了交换
        for (int i=0; i<arr.length; i++){
            // -1：因为是当前元素和后一个元素比较，所以防止越界
            // -i：每一轮结束都会选出一个最大值，就会少一个元素需要比较
            for (int j=0; j<arr.length-1-i; j++){
                if (arr[j]>arr[j+1]){
                    flag = true; // 说明本轮进行了交换
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (!flag){ // 如果上一轮比较没有发生交换，说明全部排序完毕
                break;
            }
            // 新的一轮重新赋值flag
            flag = false;
        }
    }
    public static void printArray(int[] data) {
        for (int x = 0; x < data.length; x++) {
            System.out.println(data[x] + ",");
        }
    }
}
```

**以上程序都是通过主方法进行设计的，不符合面向对象的思想，所以最好是封装到一个类里面进行实现，当需要用的时候，调用这个类的方法即可。**

```java
// 同一个包下面不能有两个同名的类
class ArrayUtil1{
    // 类中没有属性需要使用，这里可以直接创建静态的方法，然后通过类名直接调用
    // 可以避免生成无用的实例化对象，减少不必要的空间浪费
    public static void sort(int[] arr){
        boolean flag = false;
        for (int i=0; i<arr.length; i++){
            // -1：因为是当前元素和后一个元素比较，所以防止越界
            // -i：每一轮结束都会选出一个最大值，就会少一个元素需要比较
            for (int j=0; j<arr.length-1-i; j++){
                if (arr[j]>arr[j+1]){
                    flag = true; // 说明本轮进行了交换
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (!flag){ // 如果上一轮比较没有发生交换，说明全部排序完毕
                break;
            }
            // 新的一轮重新赋值flag
            flag = false;
        }
    }
}
```



### 7. 数组翻转

指的是数组的前后转置处理，即首位调换位置。

- 数组内容：1 2 3 4 5 6 7 8 9
- 交换后：9 8 7 6 5 4 3 2 1

对于数组的翻转有两种方式：

- 方式一：new 一个新的数组，然后对原数组按逆序的方式进行存储。

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210911185736965.png" alt="image-20210911185736965" style="zoom:50%;" />

```java
public static int[] reverse1(int[] arr){
    int j = arr.length-1;
    int[] temp = new int[j+1];
    for (int i=0; i<arr.length; i++){
        temp[j--] = arr[i];
    }
    // 如果不进行数组返回值
    // 直接 arr=temp
    // 由于temp是临时变量，存放的临时空间，所以在方法结束后会被销毁，所以这里的赋值是不会成立的。
    return temp;
}
```

```java
// 上面的那个方法是我自己写的
// 下面的代码就是教程的代码，也对应下面的内存分析图
public static void main(String[] args){
    int[] arr = {1,2,3,4,5,6,7};
    int[] temp = new int[arr.length];
    int j = temp.length-1;
    for(int i=0; i<arr.length; i++){
        temp[j--] = arr[i];
    }
    arr = temp;
    printArray(arr);
}
```

**内存分析，剖析其中的问题：**

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210911190155680.png" alt="image-20210911190155680" style="zoom:67%;" />

这个逆序过程，虽然简单易懂，但是会产生一个路径内存空间。



- 方式二：在一个数组上进行翻转

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210911190715435.png" alt="image-20210911190715435" style="zoom:50%;" />

实现上面的翻转，需要计算“转换”次数，转换次数是“数组长度 ➗2”，这里其实不需要考虑奇偶数。

```java
public static void reverse2(int[] arr){
    int head = 0;
    int tail = arr.length-1;
    for (int i=0; i<arr.length/2; i++){
        int temp = arr[head];
        arr[head] = arr[tail];
        arr[tail] = temp;
        head++;
        tail--;
    }
}
```



两种方式进行比较，第一种会产生无用的垃圾空间，并且循环次数较多；第二种循环次数较少，并且可以减少无用垃圾的产生，以提升性能。	



可以发现数组由于可以通过脚标进行元素的控制，所以相应的循环逻辑会使用的比较多。



### 8. 数组相关的操作方法

由于数组是一个重要的概念，所以Java语言本身是有提供数组的相关支持的处理。

- **数组排序**：java.util.Arrays.sort(数组名称)

- **数组拷贝（把方法做了变形）**：System.arraycopy(原数组，原数组开始点，目标数组，目标数组开始点，拷贝长度)

  范例：实现数组拷贝

  - 假设有两个数组

    - 数组一：1，2，3，4，5，6，7，8，9
    - 数组二：11，22，33，44，55，66，77，88，99
    - 要求拷贝后的数组二为：11，22，33，**6，7，8**，<u>**77，77，77**</u>

    ```java
    // 拷贝
    int[] dataA = {1,2,3,4,5,6,7,8,9};
    int[] dataB = {11,22,33,44,55,66,77,88,99};
    System.arraycopy(dataA,5,dataB,3,3);
    System.arraycopy(dataB,6,dataB,7,1);
    System.arraycopy(dataB,6,dataB,8,1);
    System.out.println(Arrays.toString(dataB));
    ```

这些操作的支持都是系统本身提供的，即都是在开发中可以使用的操作。

```java
// 拷贝
public static void arraycopy(int[] src, int sindex, int[] des, int dindex, int len){
    for (int x=0; x<len; x++){
        des[dindex++] = src[sindex++];
    }
}
```



### 9. 方法可变参数

案例：实现任意多个整数相加。（早期是用数组实现的）

```java
public static int sum1(int[] data){
    int res = 0;
    int len = data.length();
    for(int i=0; i<len; i++){
        res+=data[i];
    }
    return res;
}
```

案例：实现任意多个参数的相加。

```java
 public static int sum2(int ... data){  // 变种数组
    int res = 0;
    int len = data.length();
    for(int i=0; i<len; i++){
        res+=data[i];
    }
    return res;
}
```

主方法：

```java
public static void main(String[] args){
    System.out.println(sum1(new int[]{1,2,3,4}));
    System.out.println(sum2(1,2,3,4);
}
```

可变参数的最大作用：在进行程序类设计和开发的时候，可以直接传入参数，避免数组的使用。可变参数实质上就是数组，但是使用起来比数组更灵活一点儿。



### 10. 对象数组

在 Java 程序本身各种数据类型都可以成为数组类型，而这样的数组就成为对象数组：`Object[] objs = new Object[长度]`。

范例：定义对象数组。

```java
class Person{
    private String name;
    private int age;
    public Person(String name, int age){
		this.name = name;
        this.age = age;
    }
    public String getInfo(){
        return "姓名：" + this.name + "，年龄：" + this.age;
    }
    //setter getter略
}
public class ArrayDemo{
    public static void main(String[] args){
        Person[] per = new Person[3]{
            new Person("张三", 18),
            new Person("李四", 20),
            new Person("王五", 22)
        }; // 对象数组
        //per[0] = new Person("张三", 18);
        //per[1] = new Person("李四", 20);
        //per[2] = new Person("王五", 22);
        for(Person p:per){
            System.out.println(p.getInfo());
        }
    }
}
```

**内存空间：**

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210928142131578.png" alt="image-20210928142131578" style="zoom:67%;" />

最大缺陷：长度是固定的。

优点：线性保存，索引访问，速度较快，时间复杂度 O(1)。



## 七）引用传递实际应用

引用传递是Java开发设计中最为重要的技术组成，并且也和实际生活密切相关。

### 1. 类关联结构

假设有两类人，一类人有自己的车，另一类人有11路汽车。要求通过面向对象的设计来解决实现以上的这种关系转换。

```java
package 引用传递实际应用;

public class 类关联结构 {
    public static void main(String[] args) {
        // 初始化对象和对象之间的关系
        Person per = new Person("啊哈", 12);
        Car car = new Car("兰博基尼", 2000000);
        per.setCar(car);  // 某个人拥有一辆车
        car.setPerson(per); // 某辆车拥有了某个主人
        
        // 通过对象之间的关系获取彼此的信息
        System.out.println(per.getCar());  // 通过人找车
        System.out.println(car.getPer());  // 通过车找人
    }
}
class Person{
    private String name;
    private int age;
    private Car car;  // 一个人有一辆车

    // 车不是生来就有的，是后面拥有的，所以不能放入构造方法
    public void setCar(Car car){
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Car{
    private String name;
    private double price;
    private Person per;  // 每一辆车属于一个人

    // 和setCar同理
    public void setPerson(Person per){
        this.per = per;
    }

    public Person getPer() {
        return per;
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
```

本次操作的两个类型：Person，Car。但是Person ，Car是根据某个群体设计的，可以描述某一个群体。

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210928151419196.png" alt="image-20210928151419196" style="zoom:67%;" />



### 2. 自身关联

现在已经确定好了人与车的关系，但是现在也可以进一步进行该工作的完善。例如：一个人也会有孩子，孩子也会成年，成年之后也会有车。

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210928151659880.png" alt="image-20210928151659880" style="zoom:67%;" />

```java
package 引用传递实际应用;

public class 类关联结构 {
    public static void main(String[] args) {
        // 第一步：初始化对象和对象之间的关系
        Person per = new Person("啊哈", 32);
        Person childA = new Person("张三", 10);
        Person childB = new Person("李四", 10);
        per.setChildren(new Person[]{childA, childB});
        childA.setCar(new Car("BMW", 150000));  // 匿名对象
        childB.setCar(new Car("法拉利", 1500000));
        Car car = new Car("兰博基尼", 2000000);
        per.setCar(car);  // 某个人拥有一辆车
        car.setPerson(per); // 某辆车拥有了某个主人

        // 第二步：通过对象之间的关系获取彼此的信息
        System.out.println(per.getCar());  // 通过人找车
        System.out.println(car.getPer());  // 通过车找人

        // 根据人找到所有孩子以及孩子所对应的车
        for (int i = 0; i < per.getChildren().length; i++) {
            System.out.println("\t|- "+per.getChildren()[i].toString());
            System.out.println("\t\t|- "+per.getChildren()[i].getCar().toString());
        }
    }
}

class Person {
    private String name;
    private int age;
    private Car car;  // 一个人有一辆车
    private Person children[];  // 自身关联：一个人可能有一个或多个孩子

    public Person[] getChildren() {
        return children;
    }

    public void setChildren(Person[] children) {
        this.children = children;
    }

    // 车不是生来就有的，是后面拥有的，所以不能放入构造方法
    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Car {
    private String name;
    private double price;
    private Person per;  // 每一辆车属于一个人

    // 和setCar同理
    public void setPerson(Person per) {
        this.per = per;
    }

    public Person getPer() {
        return per;
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
```

这些关系的匹配都是通过引用数据类型的关联来匹配的。



### 3. 合成设计模式

假设要求你定义一种可以描述电脑组成的类，那么现在必须进行拆分。电脑分为两部分：显示器、主机。

主机上需要有一系列的硬件。

```java
// 伪代码
class 电脑{
    private 显示器 对象数组;
    private 主机 对象;
}
class 显示器{}
class 主机{
    private 鼠标 对象;
    private 键盘 对象;
}
class 主板{
    private 内存 对象数组;
    private CPU 对象数组;
}
class 内存{}
class CPU{}
class 鼠标{}
class 键盘{}
...
```

任何的人类的科技产品，都是可以进行拆分然后进行重新组合的。这个在 Java 中称为**合成设计模式**。



### 4. 综合实战



#### 4.1 数据表与简单Java类映射转换

在实际应用开发中，简单Java类一般是由数据表的结构来实现的。

例如：在数据库之中，实际上是提供有若干个数据表，那么每一个数据表都可以描绘出一些具体的事物和概念。（部门信息表和部员信息表）

程序类的定义形式和这些实体表的差异并不大。那么在实际开发中，数据表和简单Java类之间的基本映射关系如下：

- 数据表的设计 = 类的定义；
- 表中的字段 = 类的成员属性；
- 表的一行记录 = 类的一个对象；
- 表的多行记录 = 类的数组；
- 表的外键关联 = 引用关联。



部门表和雇员表：

- 一个雇员有一个部门；
- 一个雇员有一个领导；
- 一个部门有多个雇员。

转换为简单Java类：

- 根据部门获得的信息：
  - 一个部门的完整信息
  - 一个部门之中所有雇员的完整信息
- 根据雇员信息获得一下内容：
  - 一个雇员所在的部门信息；
  - 一个雇员对应的领导信息；

对于数据表与简单Java类之间的映射最好的解决步骤：先抛开所有的外键关联字段，写出类的基本内容，然后再引用关联字段。

第一步：定义部门表和雇员表

```java
class Dept{
    private long deptno;
    private String dname;
    private String loc;
    public Dept(long deptno, String dname, String loc){
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
    // 无参构造 setter getter 略
    public String getInfo(){
        return "[部门信息]"+this.deptno+"--"+this.dname+"--"+this.loc;
    }
}

class Emp{
    private long empno;
    private String ename;
    private String job;
    private double sal;
    private double comm;
    public Emp(long empno, String ename, String job; double sal, double comm){
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.sal = sal;
        this.comm = comm;
    }
    // setter getter 无参 略
    public String getInfo(){
        return "[雇员信息]"+this.empno+"--"+this.ename+"--"+this.job+"--"+this.sal+"--"+this.comm;
    }
}
```



第二步：配置关联字段

```java
class Dept{
    private long deptno;
    private String dname;
    private String loc;
    
    private Emp emps[]; // 一个部门多个雇员
    
    public Dept(long deptno, String dname, String loc){
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
    
    public void setEmps(Emp[] emps){
        this.emps = emps;
    }
    public Emp[] getEmps(){
        return this.emps;
    }
    
    // 无参构造 setter getter 略
    public String getInfo(){
        return "[部门信息]"+this.deptno+"--"+this.dname+"--"+this.loc;
    }
}

class Emp{
    private long empno;
    private String ename;
    private String job;
    private double sal;
    private double comm;
    
    private Dept dept; // 部门
    private Emp mgr;   // 领导
    
    public Emp(long empno, String ename, String job; double sal, double comm){
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.sal = sal;
        this.comm = comm;
    }
    
    public void setDept(Dept dept){
        this.dept = dept;
    }
    public void setMgr(Emp mgr){
        this.mgr = mgr;
    }
    
    public Dept getDept(){
        return this.dept;
    }
    public Emp getMgr(){
        return this.mgr;
    }
    
    // setter getter 无参 略
    public String getInfo(){
        return "[雇员信息]"+this.empno+"--"+this.ename+"--"+this.job+"--"+this.sal+"--"+this.comm;
    }
}
```



在以后进行实际项目开发过程之中一定是分两个步骤实现的：

- **第一步：**根据表的结构关系进行对象的配置；
- **第二步：**根据要求通过结构获取数据。

范例：实现项目的开发要求

```java
public class JavaDemo{
    public static void main(String[] args){
        // 第一步
        Dept dept = new Dept(10, "财务部", "上海");
        Emp empA = new Emp(7369L, "SMITH", "CLEAK", 800.00, 0.0);
        Emp empB = new Emp(7366L, "FORD", "MANAGER", 2450.00, 0.0);
        Emp empC = new Emp(7383L, "KING", "PRESIDENT", 5000.00, 0.0);
        // 第二部
        empA.setDept(dept);
        empB.setDept(dept);
        empC.setDept(dept);
        empA.setMgr(empB);
        empB.setMgr(empC);
        dept.setEmps(new Emp[]{empA, empB, empC});
        System.out.println(dept.getInfo);
        for(int i=0; i<dept.getEmps().length; i++){
            System.out.println("\t|- "+deptEmps()[i].getInfo());
            if(deptEmps()[i].getMgr()!=null){
	            System.out.println("\t\t|- "+deptEmps()[i].getMgr().getInfo());
			}
        }
        System.out.println("--------------------------");
        System.out.println(empB.getDept().getInfo());  // 根据雇员获取部门信息
        System.out.println(empB.getMgr().getInfo());  // 根据雇员获取领导信息
    }
}
```

在以后的开发之中，这种转换方式必须熟练。



### 八）继承

对于继承，所有的私有操作都是隐式继承，非私有操作都是显式继承。

隐式继承：可以间接访问，比如get  set。

显式继承：可以直接访问，也可以间接访问。

继承一旦发生，所有的操作都可以被子类使用，子类至少会维持父类的现有功能。



### 九）覆盖



#### 1. 属性覆盖

当子类定义了与父类相同名称的成员的时候，就成为属性覆盖。

```java
class Channel{
    String info = "www.mldn.cn";
}
class DatabaseChannel extends Channel{
    String info = "Hello world";  // 属性覆盖
    public void fun(){
        System.out.println(this.info);  // 自己的
        System.out.println(super.info); // 父类的
    }
}
```

如果对父类的同名属性进行封装。

```java
class Channel{
    private String info = "www.mldn.cn";
    public void getInfo(){
        return this.info;
    }
}
class DatabaseChannel extends Channel{
    String info = "Hello world";  // 属性覆盖
    public void fun(){
        System.out.println(this.info);  // 自己的
        System.out.println(super.getInfo());  // 获取的父类的，父类的this就近取值
    }
}
```

**面试题：** super 与 this 的区别？

- this 表示先从本类查找所需要的属性或方法，如果本类没有，则查找父类。super 则不会查找子类，直接查找父类。
- this 只能调用本类的构造；super 是由子类调用父类构造。同时两个语句都只能放在首行，所有不能同时出现。
- this 可以表示当前对象。



#### 2. 方法覆盖的限制

- 被覆写的方法不能比父类有更为严格的访问权限。

  **public > default(不写) > protected > private。**

  也就是说如果父类的方法使用了 defualt，那么子类只能用 public 或者 default。

  ```java
  class Channel{
      // private void connect(){}
      // 当使用上面这个，权限小于子类，所以不存在覆写，并且private是不可见的，子类也看不到
      void connect(){
          System.out.println("父类");
      }
      public void fun(){
          this.connect();
      }
  }
  class DatabaseChannel extends Chennel{
      public void connect(){  // 父类是defualt，子类是public，覆写
          System.out.println("父类");
      }
  }
  public class JavaDemo{
      DatabaseChannel channel = new DatabaseChannel();
      channel.fun(); // 子类使用的父类继承过来的方法。
  }
  ```

  父类是private方法，对于子类是不可见的，所以在子类定义相同名字参数的方法的时候，不存在覆写，而是新定义的方法。

  在以后的实际开发之中，只要是定义方法，95%都使用Public，便于覆写继承。

  **面试题：** 请解释 Override(覆写) 与 Overloading(重载) 的区别？Overloading 时返回参数是否相同？

- **概念 --** 重载：方法名称相同，参数个数和类型不同。覆写：方法名称、参数个数和类型都相同。
- **权限 --** 重载：没有权限设置。覆写：被覆写的方法不能拥有更严格的权限。
- **范围 --** 重载：发生在一个类中。覆写：发生在继承关系类中。

- 在进行重载的时候，并没有对返回类型做出限制，但是好的习惯应该让返回类型做出一致。



#### 3. final

final 在程序之中描述的是种**终结器**的概念。在 java 中使用 final 关键字可以实现以下功能：

- **定义不能被继承的类。**

**范例：**使用final定义不能被继承的类。

```java
final class Channel{}
class DatabaseChannel extends Channel{}
// 报错：不能继承final修饰的类
```

- **不能被覆写的方法和常量。**

**范例：**当子类继承父类，但是父类中的方法又不希望被覆写，可以使用final。

```java
class Channel{
    public final void connect(){}
}
class DatabaseChannel extends Channel{
    public void connect(){}  // 报错：不能覆写 final 修饰的方法。
}
```

在一些系统中，可以用 0 表示开关关闭；1 表示开关打开。

```java
class Channel{
    // 用final修饰不希望被改变的常量。
    private final int ON = 1;
    private final int OFF = 0;
    public final void connect(){
        ON = 2;  // 报错
    }
}
```

实际上，常量往往是公共的，所以为了实现共享的概念，往往会使用一种全局变量的形式来定义，使用 **public static final** 来定义全局常量。

```java
public static final int ON = 1;
public static final int OFF = 0;
```

在定义全局常量的时候，所以字母必须大写，便于区分。

```java
public class JavaDemo{
    public static void main(String[] args){
        //String info = "mldn"; // false
        String final info = "mldn";  // true:这时候的info被当作了常量，拼接比较后，就是同一个了
        String strA = "www.mldn.cn";
        String strB = "www." + info + ".cn";
        System.out.println(strA == strB);
    }
}
```



### 十）Annotation

是JDK1.5提出的一个新的开发技术结构。利用Annotation可以有效的减少程序配置的代码，并且可以利用Annotation进行结构化定义。

Annotation是以一种注解的形式实现的程序开发。（简化开发，增加代码可读性，实现难度大）

从历史上来讲，程序开发结构的历史分为三个过程：

- **过程一：**在程序定义的时候，将所有可能用到的资源全部定义到程序代码之中。

  - 如果此时的服务器的相关地址发生了改变，那么对于程序而言就需要进行源代码的修改；维护需要由开发人员完成，这显然是不方便的。

  <img src="C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211006211706535.png" alt="image-20211006211706535" style="zoom:67%;" />

- **过程二：**引入配置文件。在配置文件中定义全部的要使用的资源。

  - 在配置项不多的时候，非常方便使用简单。
  - 但是如果所有的项目都采用这种形式开发，可能会出现配置文件**暴多**的情况。
  - 所有的操作都需要通过配置文件来完成，这样的对于开发的难度非常高。

<img src="C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211006211945390.png" alt="image-20211006211945390" style="zoom:67%;" />

- **过程三：**将配置信息重新写回到程序里面，利用一些特殊的标记与代码进行分割，也就是Annotation提出的基本依据。
  - 如果全部都使用注解开发，难度太高了，配置文件有好有坏，所以现在是配置文件加注解结合开发的。



#### 1. 准确覆写：@Override

当子类继承某一个父类后，发现父类的某些方法功能不足的时候，往往会通过覆写的方式进行扩充。

下面首先观察一种覆写操作。

**范例：**观察覆写的问题。

```java
class Channel{
    public void connect(){
        System.out.println("父类");
    }
}
class DatabaseChannel{ // 1
    public void connect(){
        System.out.println("子类");
    }
}

class DatabaseChannel{ 
    public void connection(){ // 2
        System.out.println("子类");
    }
}
```

开发之中经常出现的问题：

- 在对继承的父类的方法进行覆写的时候，忘记写extends，这个时候就不是覆写。
- 覆写的单词写错了，也不会报错，会被系统认为是一个新的方法。

为了避免上面的失误，可以在想要覆写的方法上追加注解@Override。

```java
class Channel{
    public void connect(){
        System.out.println("父类123456");
    }
}
class DatabaseChannel extends Channel{
    @Override  // 当出现上面的问题的时候，这个注解的存在会提示我们没有覆写成功
    public void connect(){
        System.out.println("子类654321");
    }
}
```

这个注解主要是帮助开发者在程序编译的是，可以发现程序关于覆写的时候的错误。



#### 2. 过期操作：@Deprecated

所谓的过期操作指的是一个软件项目在一个开发之中，可能有一个方法或者一个类在设计的时候考虑不周导致新版本有的地方有不适应的地方，老版本不影响，这个时候又不可能删除这个操作，给一个过渡的事件，可以采用过期声明，目的是告诉新的用户不要再用了，老的版本可以接着用。

须使用“@Deprecated”注解声明。

**范例：**声明过期方法。

```java
class Channel{
    // 原方法没返回值不好，希望过期掉
    @Deprecated  // 老系统继续用，新版本最好不要用了
	public void connect(){}
    
    public String connection(){
        return "123";
    }
}
```

在一些开源项目里面特别讨厌的：新版本出现之后，将里面的方法完全变了样。

@Deprecated 可以比较柔和的进行过渡。



#### 3. 压制警告：@SuppressWarnings

在以前的过期程序为例，可以发现在进行程序编译的时候会出现错误警告提示，但是这个警告是在我们预料之内的，我们不希望他不停的警告提示。

如果不希望见到这些提示信息（或者已经知道了错误信息在哪里），可以进行警告压制处理：@SuppressWarnings

```java
class Channel{
    // 原方法没返回值不好，希望过期掉
    @Deprecated  // 老系统继续用，新版本最好不要用了
	public void connect(){}
    
    public String connection(){
        return "123";
    }
}
public class JavaDemo{
    @SuppressWarnings({"xxx"})  // 填写一种警告类型
    public static void main(String[] args){
        new Channel().connect(); // 会进行过期警告提示
    }
}
```

这个注解只是把警告屏蔽了，但是警告的问题依然存在。警告里面的警告类型会有IDE自动对应生成。



### 十一）多态性



#### 1. 多态性的基本概念

在Java之中对于多态性有两种实现的模式：

- 方法的多态性：

  - 方法的重载：方法和返回值名字一样，参数个数、类型不一样。

    ```java
    class Channel{
        public void print(){}
        public void print(String str){}
    }
    ```

  - 方法的覆写：同一个方法可能根据使用子类的不同，有不同的实现。

    ```java
    class Message{
        public void print(){
            System.out.println("www.mldn.cn");
        }
    }
    class DatabaseMessage extends Message{
        public void print(){
            System.out.println("数据库信息打印");
        }
    }
    ```



- 对象的多态性：父子实例之间的转换处理。
  - 对象的向上转型：父类 父类实例 = 子类实例。  			    自动转换成功。  --> 人是动物
  - 对象的向下转型：子类 子类实例 = （子类）父类实例。  强制转换成功。   --> 动物是人？（强转）

从实际的转型处理来讲，大部分情况考虑的是对象的向上转型（90%）。在考虑向下转型的时候，一般是需要使用子类的特殊功能（子类可以对父类进行功能扩充）的时候（3%）；还有一些情况不考虑转型（如String  7%）。



#### 2. 对象向上转型

 **`实现了接收或返回参数的统一性。`**

对象转型的处理属于多态性，而这一特性必须在继承性的基础上实现。

```java
// DatabaseMessage extends Message
// 向上转型：具体实现的对象类型，看后面，调用的方法也是以后面的为主。
Message msg = new DatabaseMessage();
```

**向上转型**有什么主要的用途？？

```java
// DatabaseMessages extends Message
// WebServerMessages extends Message
public static void main(String[] args){
    fun(new DatabaseMessage());
    fun(new WebServerMessage());
}
public static void fun(Message msg){
    msg.print();
}
```

**<u>向上转型的主要特点在于，可以对参数进行统一的设计。（形参是父类，那么多个不同的子类可以作为实参传入）</u>**

这种特点也可以用重载实现：

```java
public static void main(String[] args){
    fun(new DatabaseMessage());
    fun(new WebServerMessage());
}
public static void fun(DatabaseMessage msg){
    msg.print();
}
public static void fun(WebServerMessage msg){
    msg.print();
}
```

重载的确可以实现和之前一样的效果，但是对于程序的开发，进行程序类设计的时候，除了要满足当前的要求之外，还需要做出可维护性的设计。<u>假如随着项目的发展，Message产生了3W个子类，那么每当扩展一个Message子类之后，都需要追加一个fun的重载，但是方法的调用都是一模一样的。</u>这样就对程序的维护性造成了很大的影响。



#### 3. 对象向下转型

主要特点在于需要使用子类的一些特殊功能。

**范例：向下转型**

```java
class Person{
    public void print(){
        System.out.println("我是一个正常人");
    }
}
class SuperMan extends Person{
    public String fly(){
        return "我能飞";
    }
}
public class JavaDemo{
    public static void main(String[] args){
        System.out.println("日常生活时，是个正常人");
        Person per = new SuperMan(); // 向上转型
        per.print();
        System.out.println("怪兽入侵，需要超人！");
        SuperMan man = (SuperMan) per;  // 向下转型
        System.out.println(man.fly());
    }
}
```

向上描述的是一些公共特征，向下是子类自己的特殊环境。

但是在进行向下转型之前，必须先向上转型。下面看一个错误的案例：

```java
	class Person{
    public void print(){
        System.out.println("我是一个正常人");
    }
}
class SuperMan extends Person{
    public String fly(){
        return "我能飞";
    }
}
public class JavaDemo{
    public static void main(String[] args){
        System.out.println("日常生活时，是个正常人");
        Person per = new Person(); // 不转型！！！
        per.print();
        System.out.println("怪兽入侵，需要超人！");
        // 这里转型会报异常：ClassCastException
        SuperMan man = (SuperMan) per;  // 向下转型
        System.out.println(man.fly());
    }
}
```

所以向下转型并不一定是一个安全的行为。（不常用，但还算实用）



#### 4. instanceof 关键字

向下转型是一个比较由风险的事情，所以为了保证转型顺利，需要来判断是否是某个类的对象：**`对象 instanceof 类`**

该判断将会返回一个boolean，如果是这个类型，则返回true。

```java
public class JavaDemo{
    public static void main(String[] args){
        Person per = new Person();
        System.out.println(per instanceof Person);  // true
        System.out.println(per instanceof SuperMan);// false
    }
}
```

所以在日后进行项目开发之中，如果要向下转型，可以先进行判断。

```java
public class JavaDemo{
    public static void main(String[] args){
        Person per = new Person();
        if(per instanceof SuperMan){
            SuperMan man = (SuperMan) per;
        }
    }
}
```



### 十二）Object类



#### 1. Object类的基本概念

Object是用来解决参数统一的问题，使用Object类可以接受所有类型的参数。

- 所有的类默认情况下都是Object类的子类。

  以下两个类的定义是完全相同的：

  ```java
  class Person{}
  class Person extends Object{}
  ```

  在Object类设计的时候，考虑了所有继承的问题，所以该类提供有无参构造方法，这样所有的子类即便不知道Object类的存在，也不会出现构造方法调用失败的问题。

  如果一个程序的方法要求需要接受所有类的对象的时候，就可以用Object当作形参。（所有数据类型，包括数组）

```java
public class JavaDemo{
    public static void main(String[] args){
        Object obj = new int[] {1,2,3};
        if(obj instanceof int[]){
            int[] data = (int[]) obj;
            for(int t: data){
                System.out.println("\t", t );
            }
        }
    }
}
```



#### 2. 获取对象信息：toString()

在Object里面有个toString()方法，可以获取一个对象的所有信息。

对对象进行直接输出的时候，调用的就是toString()方法。所以在以后的开发之中，对象信息的获取可以直接覆写这个方法。

```java
class Person{
    private String name;
    private int age;
    @Override
    public String toString(){
        return "姓名：" + this.name + "，年龄" + this.age;
    }
}
```



#### 3. 对象比较：equals()

所谓的比较，是比较两个对象的内容是否完全相同。假如有两个Person对象，现在需要确认两个对象的内容是否一致。（两个对象的地址是明显不一样的，所以比较的是内容是否一样）

```java
class Person{
    private String name;
    private int age;
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public Person(String name ,int age){
        this.name = name;
        this.age = age;
    }
}
```

equals源码：

```java
public boolean equals(Object obj){
    return this==obj;
}
```

覆写equals()：

```java
@Override
public boolean equals(Object obj){
    if(obj==null) return false;  // 不关心null的比较，否则会NullPointerException
    if(!(obj instanceof Person)) return false;  // 必须检查是否是同一个类型的比较
    if(this == obj) return true;  // 如果是闲得无聊，自己和自己比较，当然还是true
    
    Person per = (Person) obj;  // 目的是获取类中的属性
    return this.name.equals(per.name) && this.age == per.age;
}
```

String类已经覆写了Object的toString()方法。



### 十三）抽象类



类继承的主要作用在于可以扩充已有类的功能，但是对于之前的额继承操作而言会发现，子类可以自愿选择是否要覆写父类的方法。**（父类无法强制性要求子类必须覆写某些方法）** 这种情况下，我们往往不会采用类的继承。而且在实际的开发之中，我们很少继承一个完善的类，（完善的类指的是可以直接俄使用的类）而是必须要继承抽象类。**所以在以后进行父类设计的时候，我们必须优先考虑抽象类。**



#### 1. 抽象类的基本概念

抽象类的主要作用在于对子类中覆写的方法进行约定，在抽象类里面可以定义一些抽象方法，要求子类必须覆写。抽象类方法指的是使用了 abstract 关键字定义并且没有提供方法体的方法，而抽象方法所在的类必须为抽象类，抽象类必须使用 abstract 关键字定义。（在普通类的基础上追加抽象方法，就是抽象类）

```java
abstract class Message{  // 抽象类
	private String type; // 消息类型
    public abstract String getConnectInfo();  // 抽象方法
    // 普通方法
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}
public class JavaDemo{
    public static void main(String[] args){
        Message msg = new Message(); // 抽象类不能直接定义
    }
}
```

当一个抽象类定义完成之后（切记：抽象类不是完整的类），如果想要使用抽象类：

- 抽象类必须提供子类，子类使用extends；
- 抽象类的子类（不是抽象类）一定要覆写抽象类中的全部抽象方法；
- 抽象类的对象实例化可以利用对象多态性通过子类向上转型的方式完成。

**范例：使用抽象类**

```java
abstract class Message{  // 抽象类
	private String type; // 消息类型
    public abstract String getConnectInfo();  // 抽象方法
    // 普通方法
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}
class DatabaseMessage extends Message{  // 想要继承抽象类，必须重写抽象方法，否则异常
    public String getConnectInfo(){
        return "this is Oracle info.";
    }
}
public class JavaDemo{
    public static void main(String[] args){
		Message msg = new DatabaseMessage();  // 向上转型
        System.out.println(msg.getConnectInfo());
        msg.setType("客户信息");  // 使用普通方法（继承而来）
        System.out.println(msg.getType());       
    }
}
```

从整体而言，抽象类只是比普通方法增加了抽象方法以及对子类的强制性覆写要求，其他是完全相同的。

**对于抽象类的使用的几点意见：**

- 抽象类使用很大程度上有一个核心的问题：**抽象类自己无法直接实例化；**
- 抽象类之后主要的目的是进行过渡操作的使用，所以当要使用抽象类进行开发的时候，往往都是在设计中需要解决类继承问题时所带来的代码重复处理。



#### 2. 抽象类的相关说明

抽象类的使用需要注意以下几个问题：

- 不能使用final修饰抽象类。抽象类必须有子类，但是final不能有子类。
- 抽象类是作为一个普通类的加强版出现的。（就是在普通类的基础上扩展来的）那么普通类之中可以定义属性和方法，那么这些属性要求进行内存空间开辟的，所以抽象类一定可以提供构造方法，并且子类一定会按照子类对象的实例化原则进行父类构造的调用。

```java
abstract class Message{  // 抽象类
	private String type; // 消息类型
    
    public Message(String type){
        this.type = type;
    }
    
    public abstract String getConnectInfo();  // 抽象方法
    // 普通方法
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}
class DatabaseMessage extends Message{  // 想要继承抽象类，必须重写抽象方法，否则异常
    
    public DatabaseMessage(String str){  // 父类有对应的构造函数，子类也需要有，并且str会作为父类的type被使用
        super(str)
    }
    
    public String getConnectInfo(){
        return "this is Oracle info.";
    }
}
public class JavaDemo{
    public static void main(String[] args){
		Message msg = new DatabaseMessage("客户信息");  // 向上转型
        System.out.println(msg.getConnectInfo());
        System.out.println(msg.getType());       
    }
}
```

- 抽象类中允许没有抽象方法，但是即便没有抽象方法，也不能直接 new 出实例化对象。（只要是被 abstract 修饰了）必须靠子类完成。

```java
abstract class Message(){}
public class JavaDemo(){
    public static void main(String[] args){
        Message msg = new Message();
    }
}
```

- 抽象类中永远可以提供 static 的方法，并且这个方法不受抽象类的限制，可以直接由类名调用。

```java
abstract class Message(){
    public static DatabaseMessage getInstance()){
        return new DatabaseMessage();
    }
}
class DatabaseMessage extends Message{}
public class JavaDemo(){
    public static void main(String[] args){
		Message msg = Message.getInstance();
    }
}
```



#### 3. 抽象类的应用

抽象类本质上是一个加强版的类，即抽象类是比普通类更高级的类。

假如说限制要描述由三类的事物：

- 机器人：不休息，只知道补充能量和工作。
- 人类：需要休息，需要吃饭以及努力的工作。
- 猪：需要休息，不需要工作，只需要吃饭。
  - 分别有三种行为：eat()、work()、sleep()
  - 准备一个命令（command)：以指令来接受。
  - 每一种命令传一个编码(code)：1 - sleep；5 - eat；10 - work（没有考虑 1 2 3，因为 1+2=3）
- **范例：实现代码**

```java
abstract class Action{
    // 给每种行为定义一个编码
    public static final int EAT = 1;
    public static final int SLEEP = 5;
    public static final int WORK = 10;
    
    // 根据指令指定行为
    public oid command(int code){
        switch(code){
            case EAT:{
                this.eat();
                break;
            }
            case SLEEP:{
                this.sleep();
                break;
            }
            case WORK:{
                this.work();
                break;
            }
            case EAT+WORK+SLEEP:{
                this.eat();
                this.sleep();
                this.work();
                break;
            }
        }
    }
    
    // 行为是抽象的，根据不同的类，有不同的行为
    public abstract void eat();
    public abstract void sleep();
    public abstract void work();
}

class Robot extends Action{
    public void eat(){
        System.out.println("机器人需要充电。。。");
    }
    public void sleep(){}  // 没有行为，空着就好
    public void work(){
        System.out.println("机器人按照固定套路工作。。。");
    }
}

class Person extends Action{
    public void eat(){
        System.out.println("饿的时候吃饭。。。");
    }
    public void sleep(){
        System.out.println("困的时候就睡觉。。。");
    }
    public void work(){
        System.out.println("人类进行有想法的工作。。。");
    }
}

class Pig extends Action{
    public void eat(){
        System.out.println("猪狼吞虎咽的吃。。。");
    }
    public void sleep(){
        System.out.println("猪想怎么睡怎么睡。。。");        
    }
    public void work(){}  // 猪不工作
}

public class JavaDemo{
    public static void main(String[] args){
        Action robotAction = new Robot();
        Action personAction = new Person();
        Action pigAction = new Pig();
        System.out.println("---------机器人行为---------");
        robotAction.command(Action.SLEEP);
        robotAction.command(Action.WORK);
        System.out.println("---------人的行为---------");
        personAction.command(Action.WORK + Action.SLEEP + Action.EAT);
        System.out.println("---------猪的行为---------");
        pigAction.command(Action.EAT);
        pigAction.command(Action.WORK);       
    }
}
```

现在定义的Action的父类，主要目的是为了：抽象所有行为，对所有行为规范进行统一处理。

如果在 Robot 自己定义一个 add 方法，父类识别不到，即能量补充不上。

```java
public void add(){}
```

抽象类最大的好处：

- 对子类方法的统一管理。
- 可以自身提供有一些普通方法，并且这些普通方法可以调用抽象方法。这些抽象方法必须在有子类提供实现的时候生效。

抽象类就像给子类一个编写模板，便于代码识别和统一运行。



### 十四）接口



#### 1. 接口的基本定义

抽象类与普通类相比最大的好处在于：可以实现对子类覆写的控制。但是仍然会对外部开发一部分信息（普通方法、属性等），要是相对外部隐藏所有的袭击的时候，可以用接口来描述。

接口可以理解为 **“纯粹的抽象类”**（里面只有抽象方法和全局常量）。在JDK1.8由于引入了 **Lambda** 表达式，接口也得到了加强，接口除了抽象方法和全局常量，**还可以定义静态方法和普通方法**。

从设计本身的角度而言，接口之中的组成还是应该以抽象方法和全局变量为主。

在Java中，接口主要使用 **interface** 关键字定义。

```java
// 由于类名称和接口名称的定义要求相同，往往会在类名前面加一个 'I'
interface IMessage{
    public static final String INFO = "www.mldn.cn";
    public abstract String getInfo();
}
```

此时有一个明显的问题：此时的接口无法直接实例化对象，所以对于接口的使用原则如下：

- 接口需要被子类实现（implements），一个子类可以实现多个接口；
- 子类如果不是抽象类，那么一定要覆写接口中的全部抽象方法；
- 接口对象可以利用子类对象的向上转型进行实例化。

**范例：定义接口。**

```java
// 由于类名称和接口名称的定义要求相同，往往会在类名前面加一个 'I'
interface IMessage{
    public static final String INFO = "www.mldn.cn";
    public abstract String getInfo();
}

class MessageImpl implements IMessage{
    public String getInfo(){  // 必须覆写接口抽象方法
        return "123";
    }
}

public class JavaDemo{
    public static void main(String[] args){
        IMessage msg = new MessageImpl();  // 向上转型
        System.out.println(msg.getInfo());
        System.out.println(msg.INFO);  // 直接使用全局常量
    }
}
```

**在java中实现接口主要是因为实现多接口继承。**

```java
interface IChannel {
	public abstract boolean connect();
}
interface IMessage{
    public static final String INFO = "www.mldn.cn";
    public abstract String getInfo();
}

class MessageImpl implements IMessage, IChannel{
    public String getInfo(){  // 必须覆写接口抽象方法
		if(this.connect){
            return "这是你要的信息";
        }
        return "你是哪儿来的黑客";
    }
    public boolean connect(){
        System.out.println("数据库连接成功");
        return true;
    }
}

public class JavaDemo{
    public static void main(String[] args){
        IMessage msg = new MessageIpml();  // 向上转型
        System.out.println(msg.getInfo());
    }
}
```

但是这个时候需要考虑：**关于对象的转型问题。** 

```
此时的 msg 是 IMessage、IChannel、Object的子类。
也就是说 msg 是 IMessage、IChannel 的实例，所以可以在这两个实例之间互相转换
IMessage msg = new MessageImpl();
IChannel channel = (IChannel) msg;
```

接口是不允许取继承父类的，所以接口绝对不会是Object的子类，但是根据之前的分析，**IMessageImpl是Object的子类，所以接口可以用Object接受。**

```java
IMessage msg = new MessageImpl();
Object obj = msg;
IChannel chan = (IChannel) obj;
```

**在进行转型的时候，主要是看他们的实例化子类是否是同一个。**

Object可以接收所有的数据类型，包括数组、接口、引用类型。

由于接口描述的是一个公共的定义标准，所以在接口之中所有的抽象方法的访问权限都是public，所以public可以省略。

方法不写abstract的时候，没有方法体，那么就是抽象方法。

```java
public static final String INFO = "info";
public abstract void print();
// 上下等价
void print();
String INFO = "info";
```

需要注意：在实际开发之中，实现接口的可能是抽象类，一个抽象类可以实现多个接口，一个普通类只能继承一个抽象类和多个接口，要求先继承后实现。**（先写 extends 后写 implements）**

**`接口的抽象方法可以省略 abstract，抽象类不可以。`** 

**虽然接口无法继承一个父类**，但是一个接口却可以通过 **extends** 继承若干个父接口，此时成为接口的多继承。

```java
interface IChannel {
	public abstract boolean connect();
}
interface IMessage{
    public abstract String getInfo();
}
// extends 在类继承上只能继承一个父类
interface IService extends IMessage, IChannel{  // 接口多继承
    public String service();
}

class MessageService implements IService{
    public boolean connect(){
        return true;
    }
    pubic String getInfo(){
        return "info";
    }
    public String service(){
        return "service";
    }
}
```

在实际的开发之中，接口的使用往往有三种形式：

- 进行标准设置；
- 表示一种操作的能力；
- 暴露远程方法的试图，这个一般在RPC分布式开发中使用。



#### 2. 接口定义加强

接口最早是由全局常量和抽象方法组成。但是如果项目设计不当，会出现以下问题：

- 一个接口由1080个子类，同样的方法实现了1080次？？？

  - 该操作属于结构设计不当的结果。在早期的时候，设计接口都不敢说是绝对的完善。
  - 所以我们可以在中间加一个过渡的抽象类，而不是直接的实现接口。
  - 抽象类可以定义普通方法，所以抽象类对通用方法进行实现后，子类就不需要实现了。

- 从 JDK1.8 之后开始，为了解决接口设计的缺陷，所以在接口之中允许开发者定义普通方法。

  ```java
  interface IMessage{
      public String message();
  }
  class MessageImpl implements IMessage{
      public String message(){
          return "www.mldn.cn";
      }
  }
  ```


- **接口的普通方法必须加 `defualt` 关键字。**





#### 3. 工厂设计模式（Factory）

对于接口，必须有子类可以通过对象向上转型来获得实例化；但是在这个实例化过程也存在设计问题。

范例：观察以下程序。

```java
package 接口;

public class 工厂模式 {
    public static void main(String[] args) {
        IFood food = new Bread();
        food.eat();
    }
}

interface IFood{  // 定义食物标准
    public void eat();  // 吃
}
class Bread implements IFood{

    @Override
    public void eat() {
        System.out.println("吃面包。");
    }
}		
```

在本程序之中借用子类进行了实例化处理，而此时程序的结构如下：

```
主类（客户端） --> IFood(interface) <-- Bread
	|
	↓
客户端需要明确的直到具体是哪一个子类：IFood food = new Bread();
```

 如果面包吃腻了，需要牛奶，那么客户端就需要对应的修改。（但是客户端不关注食物从哪儿来）

**范例：**再添加一个食物。

```java
package 接口;

public class 工厂模式 {
    public static void main(String[] args) {
//        IFood food = new Bread();
        IFood food = new Milk();
        food.eat();
    }
}

interface IFood{  // 定义食物标准
    public void eat();  // 吃
}
class Bread implements IFood{

    @Override
    public void eat() {
        System.out.println("吃面包。");
    }
}
class Milk implements IFood{
    @Override
    public void eat() {
        System.out.println("喝牛奶。");
    }
}
```

所以此时的程序就表示出现有耦合的问题，而造成耦合的元凶：” 关键字 new “。

以JVM的设计为例，Java实现可移植性的关键在于JVM，而JVM的核心原理：利用一个虚拟机来运行Java程序，所有的程序并不与具体的操作系统有任何的关联，而是由JVM进行匹配，所以得出的结论：良好的设计应该**避免耦合**。

```java
package 接口;

import java.util.Locale;

public class 工厂模式 {
    public static void main(String[] args) {
//        IFood food = new Bread();
//        IFood food = new Milk();
        IFood food = Factory.getInstance(args[0]);
        food.eat();
    }
}

interface IFood{  // 定义食物标准
    public void eat();  // 吃
}
class Bread implements IFood{

    @Override
    public void eat() {
        System.out.println("吃面包。");
    }
}
class Milk implements IFood{
    @Override
    public void eat() {
        System.out.println("喝牛奶。");
    }
}

class Factory{
    public static IFood getInstance(String className){
        if ("bread".equals(className.toLowerCase())){
            return new Bread();
        }else if ("milk".equals(className.toLowerCase())){
            return new Milk();
        }else {
            return null;
        }
    }
}
```

再本程序中，主程序类和IFood接口之间没有任何关联，所有的关联都是由Factory完成的，我们只需要在使用的时候通过初始化参数进行子类的传递定义。

- java 工厂模式 Bread
- java 工厂模式 milk

**关系如下：**

```
主类（客户端） --> IFood(interface) <-- Bread
	|					↑
	↓					|
 Factory --> Milk	   Milk
 		 --> Bread
```

在以后进行子类扩充的时候，只需要修改Factory程序类即可。



#### 4. 代理模式（Proxy）

代理模式设计的主要功能可以帮助客户把所有开发的注意只集中在核心业务功能的处理上。例如：肚子饿了，思考如何可以吃到东西。

**代理设计：想吃东西。**

```
 主类 --关注--> IEat(interface) <-- EatProxy(制造吃的地方)(1.准备食材；2.加工食材；3.送饭(*)；4.收拾碗筷)
                     ↑
                     |
                EatReal(“吃”业务)
```

**范例：**实现的代理设计。

```java
package 接口;

public class 代理模式 {
    public static void main(String[] args) {
        IEat eat = new EatProxy(new EatReal());
        eat.get();
    }
}

interface IEat{
    public void get();
}

class EatReal implements IEat{
    public void get(){
        System.out.println("[真实主题]得到一份食物，而后开始品尝美味。");
    }
}

class EatProxy implements IEat{
    private IEat eat;  // 为吃而服务

    public EatProxy(IEat eat){  // 代理
        this.eat = eat;
    }

    public void prepare(){
        System.out.println("[代理主题]1.精心购买食材");
        System.out.println("[代理主题]2.处理食材");
    }

    @Override
    public void get() {
        this.prepare();
        this.eat.get();
        this.clear();
    }

    public void clear(){
        System.out.println("[代理主题]4.收拾碗筷");
    }
}
```

代理设计模式由两个子类，一个子类是真实操作类，另一个是代理操作类。

- 一个负责制作和呈上来。
- 另一个负责其他不需要面向用户的工作。
- 节约自己主要工作的时间。



#### 5. 抽象类和接口的区别

在实际的开发之中，抽象类和接口的定义形式非常相似，尤其是JDK1.8之后就更加明显了，在抽象类有了 default 和 static 方法后。

|  NO  |   区别   |                   接口                   |                   抽象类                    |
| :--: | :------: | :--------------------------------------: | :-----------------------------------------: |
|  1   |   定义   |       abstract class 抽象类名称{}        |            interface 接口名称{}             |
|  2   |   组成   | 构造、普通方法、静态方法、全局常量、成员 | 抽象方法、全局常量、default方法、static方法 |
|  3   |   权限   |           可以使用各种权限定义           |               只能使用 public               |
|  4   | 子类使用 |   子类通过 extends 可以继承一个抽象类    |    子类通过implements可以实现多个接口(★)    |
|  5   |   关系   |         抽象类可以实现若干个接口         |  接口不允许继承抽象类，可以实现多个父接口   |
|  6   |   使用   |       1. 抽象类或接口必须定义子类|2. 子类必须覆写抽象类或接口的全部抽象方法|
|||3. 通过子类向上转型实现抽象类或接口的对象实例化||
当抽象类和接口都可以使用的情况下，优先考虑接口，因为接口可以避免子类的单继承缺点。

我们也需要从接口进行项目的整体设计。

接口和抽象类是最初的设计，类和底层原理是最后的设计。



### 十五）UML设计图

​		UML是统一建模的语言，本质就是利用图形化的形式来实现程序类关系的描述。在之前已经画出了大量的图形，这些图形都是根据UML的标准来进行的，并且最早且使用广泛的是：Rational Rose，而后还有：PowerDesigner也可以实现类图的定义。

（现在更多的人是写完代码，转换成类图，用于报告或者给他人看）



#### 1. 类图描述

一般情况要用类图来表示，往往可以使用三层的结构来表示：

- 第一层：类名称
- 第二次：属性
- 第三次：方法

如果是一个普通类的名称，往往直接编写，而如果是抽象类，往往是斜体+abstract表示。

对于类中的额属性，可以用 “访问权限 属性名称：属性类型“ 的格式来定义。访问权限一般由：public(+)、private(-)、protected(#)。

类中的方法采用的格式 “访问权 方法名称()：返回值“ 的结构来描述，一般的方法都是用 public 修饰的。

实际的开发花费大量人力去作图是没有意义的，一般是使用一个图形引擎转换为图形显示，即自己写出代码，然后用UML软件把代码转换成UML图即可。



### 十六）函数式编程



#### 1. Lambda表达式

函数式编程：利用这个方法可以避免掉面向对象方法之中的一些繁琐的问题。

[lambda简介](https://www.haskell.com)

面向对象长期发展自终一直有一部分反对者，这些反对者认为这个编程有一些繁琐。

**范例：**以一个简单程序为例。

```java
package 函数式编程;

public class Lambda {
    public static void main(String[] args) {
        IMessage msg = new IMessage() {
            @Override
            public void send(String str) {
                System.out.println("消息发生："+str);
            }
        };
        msg.send("www.mldn.cn");
    }
}

interface IMessage {
    public void send(String str);
}
```

在这样一个程序里面，核心的功能只有一句：System.out.println("消息发生："+str);

为了这一行语句，我们依然需要面向对象的方式，写了很多行。于是这些问题随着技术的发展越来越突出。然后Java就不得不提供了Lambda表达式。

**范例：**使用Lambda表达式实现上面一样的功能。

```java
package 函数式编程;

public class Lambda {
    public static void main(String[] args) {
        IMessage msg = (str) ->{
            System.out.println("消息发生："+str);
        };
        msg.send("www.mldn.cn");
    }
}

interface IMessage {
    public void send(String str);
}
```

现在整个程序代码里面真的只有这一行语句，于是利用这种形式就避免了复杂的面向对象结构化的要求。

**Lambda的一个重要是实现要求：SAM (Single Abstract Method) --> 只有一个抽象方法。**

这样一个接口中只有一个抽象方法，这样的接口被称为函数式接口，也只有这样的接口可以被Lambda表达式所使用。

如果在一个函数式接口里面增加了多余的方法，那么在使用Lambda的时候就会报异常。

为了保证一个接口是函数式接口，我们会在接口上面加：**@FunctionalInterface**

```java
package 函数式编程;

public class Lambda {
    public static void main(String[] args) {
        IMessage msg = (str) ->{
            System.out.println("消息发生："+str);
        };
        msg.send("www.mldn.cn");
    }
}

@FunctionalInterface
interface IMessage {
    public void send(String str);
}
```

函数式接口里面的**抽象方法**永远只能有一个，多于一个报异常。但是普通方法和抽象方法可以加上不会有问题。

```java
package 函数式编程;

public class Lambda {
    public static void main(String[] args) {
        IMessage msg = (str) ->{
            System.out.println("消息发生："+str);
        };
        msg.send("www.mldn.cn");
        msg.print();
        IMessage.print2();
    }
}

@FunctionalInterface
interface IMessage {
    public void send(String str);
    public default void print(){
        System.out.println("123456");
    }
    public static void print2(){
        System.out.println("654321");
    }
}
```

这些普通方法的更新是为了保护函数式接口实现的保障。当我们想要在接口里面添加新的行为的时候，普通方法和静态方法是不受影响的。

Lambda表达式而言，提供有以下几种格式：

- 方法没有参数：() -> {};

- 方法由参数：(参数, 参数...) -> {};

- 如果只有一行语句返回：(参数, 参数) --> 返回; 

  ```java
  @FunctionalInterface
  interface IMessage{
      public int add(int x, int y);
  }
  public class JavaDemo{
      public static void main(String[] args){
          IMessage msg = (x,y) -> x+y;
          System.out.println(msg.add(5,6));
      }
  }
  ```

利用Lambda表达式的确可以摆脱结构的限制，但是有一个问题：只能替换掉函数式接口。



#### 2. 方法引用

引用数据类型最大的特点是可以进行内存的指向处理，在传统的开发之中一直使用的对象的引用操作，在JDK1.8之后还提供了方法的引用。即：不同的方法名称可以描述同一个方法。如果要进行方法的引用，在Java里面有如下四种形式：

- 引用静态方法：类名称 :: static 方法名称;
- 引用某个实例对象的方法：实例化对象 :: 普通方法;
- 引用特定类型的方法：特定类 :: 普通方法;
- 引用构造方法：类名称 :: new。

**范例：引用静态方法。**

- 在String类里面提供有 String.valueOf() 方法，这个方法就属于静态方法。
  - 方法定义：public static String valueOf(int i)

```java
package 函数式编程;

public class 方法引用 {
    public static void main(String[] args) {
        IFunction<Integer, String> fun = String :: valueOf;
        System.out.println(fun.transfer(100).length());
    }
}

@FunctionalInterface
interface IFunction<P,R> {
    public R transfer(P p);
}
```

利用方法引用这一概念可以为一个方法定义多个名字，但是要求必须是**函数式接口**。

**范例：引用实例化对象中的方法。**

- 在String里面有一个转大写的方法：public String toUpperCase()

```java
package 函数式编程;

public class 方法引用 {
    public static void main(String[] args) {
        IFunction<String> fun = "www.mldn.cn":: toUpperCase;
        System.out.println(fun.Upper());
    }
}

@FunctionalInterface
interface IFunction<R> {
    public R Upper();
}
```

**范例：引用特定类中的操作方法。**

- 在String里面提供了比较字符串关系大小的方法：public int compareTo(String other)；
- 这只是一个普通方法，需要引用实例化对象使用，但是如果不想使用实例化对象就想使用，就可以使用特定类进行引用处理。

```java
package 函数式编程;

public class 方法引用 {
    public static void main(String[] args) {
        IFunction<String> fun = String :: compareTo;
        System.out.println(fun.compare("A", "a"));
    }
}

// 3
@FunctionalInterface
interface IFunction<R> {
    public int compare(R r1, R r2);
}
```

**范例：构造方法的引用。**

```java
package 函数式编程;

public class 方法引用 {
    public static void main(String[] args) {
        IFunction<Person> fun = Person :: new;
        System.out.println(fun.create("张三", 15));
    }
}

// 4
@FunctionalInterface
interface IFunction<R> {
    public R create(String s, int a);
}
class Person{
    private String name;
    private int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

提供方法引用的概念更多情况下弥补了对于引用的支持功能。



#### 3. 内建函数式接口

在JDK1.8之中，提供有Lambda表达式，也有会方法引用。但是如果让开发者设计函数式接口，需要使用 ”@FunctionalInterface“ 来进行大量的声明，也是很多情况为了方便直接使用系统提供的函数式接口。

在系统之中有一个 java.util.function 的开发包，里面可以直接使用函数式接口。



##### 3.1 功能型函数式接口

后缀 **-function**

- 在 String 类中有一个方法判断是否以某个字符串开头。

```java
// 接口定义
public interface Function<T, R>{
    public R apply(T t); 
}

// 接口使用
package 函数式编程;

import java.util.function.Function;

public class 内建函数式接口 {
    public static void main(String[] args) {
        // 前面参数是传入
        // 后面参数是返回
        Function<String, Boolean> fun = "**hello" :: startsWith;
        System.out.println(fun.apply("**"));  // true
    }
}
```



##### 3.2 消费型函数式接口

只能进行数据处理，而不能返回。

- 在进行系统数据输出的时候，使用的是：System.out.println();  这个就只能进行数据的输出消费，不能返回。

```java
// 接口定义
@FunctionalInterface
public interface Consumer<T>{
    void accept(T t);
}

// 接口使用
package 函数式编程;

import java.util.function.Consumer;
import java.util.function.Function;

public class 内建函数式接口 {
    public static void main(String[] args) {
        // 2
        Consumer<String> con = System.out::println;
        con.accept("www.mldn.cn");  // 相当于println输出了，调用
    }
}
```



##### 3.3 供给型函数式接口

- 在 String 类中提供有转小写的方法，这个方法没有接受参数，但是有返回值。public String toLowerCase();

```java
// 接口定义
@FunctionalInterface
public interface Supplier<T>{
    T get();
}

// 接口使用
package 函数式编程;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class 内建函数式接口 {
    public static void main(String[] args) {
        // 3
        Supplier<String> sup = "WWW.MLDN.CN" :: toLowerCase;
        System.out.println(sup.get());  // www.mldn.cn
    }
}
```



##### 3.4 断言型函数式接口

进行判断处理。

- 在 String 内有一个方法 equalsIgnoreCase() 方法。

```java
// 接口定义
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
// 接口使用
package 函数式编程;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class 内建函数式接口 {
    public static void main(String[] args) {
        // 4
        Predicate<String> pre = "mldn" :: equalsIgnoreCase;
        System.out.println(pre.test("MLDN"));  // true
        // equalsIgnoreCase:比较上下两个字符串的大小，忽略大小写
    }
}

```



### 十七）内部类

在一个类的内部定义的类，称之为内部类。



#### 1. 内部类的基本定义

内部类肯定是一个独立且完善的类结构，在一个类的内部除了属性和方法之外，还可以使用class定义类。

**范例：**内部类的基本定义

```java
package 内部类;

public class demo2_内部类 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.fun();
    }
}

class Outer{  // 外部类
    private String msg = "www.mldn.cn";
    public void fun(){
        Inner inner = new Inner();
        inner.print();
    }

    class Inner{  // 内部类
        public void print(){
            // 这里调用外部类的属性，相当于调用同级的成员
            // 不能直接使用this，会被认为Inner的成员
            System.out.println(Outer.this.msg);
        }
    }
}
```

从整个代码而言，内部类的结构不难理解，整体结构和普通类一样清晰明了。那么为什么会提供有内部类这样的结构？

因为整体从代码结构来讲，内部类的结构并不合理。（类的里面还有其他结构，并且可能不断的嵌套）所以内部类最大的缺陷是破坏了类

的结构，但是他也有一定的优势，我们将内部类拿到外面观察。

**范例：**将以上的程序分为了两个类。

```java
package 内部类;

public class demo2_内部类 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.fun();
    }
}

class Outer{  // 外部类
    private String msg = "www.mldn.cn";
    public void fun(){
        // 思考五：需要把当前对象Outer传入Inner中
        Inner inner = new Inner(this);
        inner.print();
    }
    // 思考一：msg如果想被外部访问必须有getter方法
    public String getMsg(){
        return this.msg;
    }
}
class Inner{  // 内部类放出去
    // 思考三：Inner实例化的时候，需要Outer类的引用，所以我们应该想办法接受Outer类的引用
    private Outer out;
    // 思考四：我们应该通过Inner类的构造方法获取Outer类对象
    public Inner(Outer out){
        this.out = out;
    }
    public void print(){
        // 思考二：如果想要调用外部类的getter方法，需要有Outer对象 
        System.out.println(this.out.getMsg());
    }
}
```

可以发现整体操作之中的目的是为了让Inner内部类可以访问Outer类的私有属性。如果不用内部类的话，整体操作非常麻烦。

所以可以得出内部类的最大优势：**可以轻松访问外部类的私有属性。**



#### 2. 内部类的相关说明

需要注意的是，内部类可以轻松访问外部类的私有属性和方法，外部类也可以访问内部类的私有属性和方法。

```java
package 内部类;

public class demo2_内部类 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.fun();
    }
}

class Outer{  // 外部类
    private String msg = "www.mldn.cn";
    public void fun(){
        Inner inner = new Inner();
        inner.print();
        System.out.println(inner.info);
    }

    class Inner{  // 内部类
        private String info = "今天天气还行";
        public void print(){
            System.out.println(Outer.this.msg);
        }
    }
}
```

使用了内部类之后，内部类和外部类之间的私有访问可以直接进行，不需要setter和getter了。

但是需要注意的是，内部类也属于一个类，虽然在大部分的情况下往往是被外部类包裹的，但是外部类依然可以产生内部类的实例化对象，而此时内部类实例化对象的格式如下：`外部类.内部类  内部类对象 = new 外部类().new 内部类();` (如果还有孙子，继续往下new)

在内部类编译完成之后会自动形成一个 ”Outer&Inner.class“ 类文件，其中 ”$“ 这个符号换到程序之中就变成了 “.”。所以内部类的全称是 ”外部类.内部类“。内外可以互相访问，在内部类实例化之前，必须保证外部类已经实例化了。

```java
package 内部类;

public class demo2_内部类 {
    public static void main(String[] args) {
        // 这就是连续实例化
        Outer.Inner inner = new Outer().new Inner();
        inner.print();
    }
}

class Outer{  // 外部类
    private String msg = "www.mldn.cn";
    class Inner{  // 内部类
        public void print(){
            System.out.println(Outer.this.msg);
        }
    }
}
```

如果此时Inner类只允许Outer类使用，那么在这样的情况下就可以使用private进行私有定义，这时候外部将不能产生实例化对象。

抽象类和接口也可以定义内部结构。

**范例：定义内部接口**

```java
package 内部类;

public class Demo2_定义内部接口 {
    public static void main(String[] args) {
        IChannel channel = new ChannelImpl();
        // channel 是 ICannel 的，这里初始化内部类需要使用 ChannelImpl。
        channel.send(((ChannelImpl)channel).new MessageImpl());
    }
}
interface IChannel{
    public void send(IMessage msg);  // 发送消息
    interface IMessage{
        public String getContent();  // 获取消息内容
    }
}

class ChannelImpl implements IChannel{

    @Override
    public void send(IMessage msg) {
        System.out.println("发送消息："+msg.getContent());
    }

    class MessageImpl implements IMessage{
        @Override
        public String getContent() {
            return "www.mldn.cn";
        }
    }
}
```

下面观察一个内部的抽象类，内部抽象类可以定义在普通类、抽象类、接口内部。

**范例：观察内部抽象类**

```java
package 内部类;

public class Demo3_内部抽象类 {

    public static void main(String[] args) {
        IChannel1 channel = new ChannelImpl1();
        channel.send();
    }
}

interface IChannel1 {
    public void send();  // 发送消息
    abstract class MessageAbstract{
        public abstract String getContent();
    }
}

class ChannelImpl1 implements IChannel1 {
    @Override
    public void send() {
        MessageAbstract msg = new MessageImpl();
        System.out.println(msg.getContent());
    }
    class  MessageImpl extends MessageAbstract{
        @Override
        public String getContent() {
            return "www.mldn.cn";
        }
    }
}
```

内部类还有一些更为有意思的结构，**即：如果现在定义了一个接口，那么可以在内部利用类实现接口。**在JDK1.8之后接口中追加了static方法，可以不受实例化对象的控制，现在就可以利用这个特性来完成功能。

**范例：接口内部进行实现。**

```java
package 内部类;

public class Demo4_内部实现接口 {
    public static void main(String[] args) {
        IC.getInstance().send();
    }
}

interface IC{
    public void send();
    // 内部实现
    class ICImpl implements IC{
        @Override
        public void send() {
            System.out.println("www.mldn.cn");
        }
    }
    public static IC getInstance(){
        return new ICImpl();
    }
}
```

内部类是一种非常灵活的定义结构，只要语法满足了，都可以帮你实现。



#### 3. static定义内部类

如果一个内部类被 static 修饰，那么这个内部类就变成了 ”外部类“ ，static 定义的都是独立于类的结构，所以该类就相当于独立于程序类了。

```java
package 内部类;

public class Demo5_static内部类 {
}

class Outer1{
    private static final String MSG = "www.mldn.cn";
    // static只能互相访问，不能访问别的
    static class Inner{
        public void print(){
            System.out.println(Outer1.MSG);
        }
    }
}
```

实例化内部静态类：**`外部类.内部类  内部类对象 = new 外部类.内部类();`**

```java
package 内部类;

public class Demo5_static内部类 {
    public static void main(String[] args) {
        Outer1.Inner inner = new Outer1.Inner();
        inner.print();
    }
}

class Outer1{
    private static final String MSG = "www.mldn.cn";
    // static只能互相访问，不能访问别的
    static class Inner{
        public void print(){
            System.out.println(Outer1.MSG);
        }
    }
}
```

static定义内部接口比较常用。

**范例如下：**

```java
package 内部类;

public class Demo6_static内部接口 {
    public static void main(String[] args) {
        IMessageWarp.send(new DefaultMessage(), new NetChannel());
    }
}

interface IMessageWarp{  // 消息包装
    static interface IMessage{  // 消息内容
        public String getContent();
    }
    static interface IChannel{  // 消息通道
        public boolean connect();
    }
    public static void send(IMessage msg, IChannel channel) {  // 消息发生
        if (channel.connect()){
            System.out.println(msg.getContent());
        }else {
            System.out.println("消息通道建立失败，消息发送失败。");
        }
    }
}
class DefaultMessage implements IMessageWarp.IMessage{
    @Override
    public String getContent() {
        return "www.mldn.cn";
    }
}
class NetChannel implements IMessageWarp.IChannel{
    @Override
    public boolean connect() {
        return true;
    }
}
```

使用static定义的内部接口相当于是一类的接口，属于一组相关的定义，有了外部接口，可以更加明确的描述出这些接口的主要功能。

比如上面的IMessageWrap.IMessage就是获取被消息包装的数据。



#### 4. 在方法中定义内部类

内部类可以在任意结构中定义，这就包括了：类中、方法中、代码块中，方法中定义内部类的形式较多。

**范例：**方法中的内部类。

```java
package 内部类;

public class Demo7_方法中的内部类 {
    public static void main(String[] args) {
        new Outer2().fun(13513545);
    }
}

class Outer2{
    private String msg = "www.mldn.cn";
    public void fun(long time){
        class Inner{  // 内部类
            public void print(){
                System.out.println(Outer2.this.msg);
                System.out.println(time);
            }
        }
        new Inner().print();
    }
}
```

此时在fun()的方法内部提供有Inner内部类的定义，并且内部类可以直接访问外部类中的私有属性和方法中的参数，但是对于方法中的参数直接访问是从JDK1.8开始支持的（因为Lambda）。在JDK1.8之前的程序中，必须在要访问的参数前面加上final，才能进行访问。

之所以取消这样的限制，是为了配合函数式编程。



#### 5. 匿名内部类

是一种简化的内部类处理形式，其主要是在抽象类和接口的子类上使用的。

**范例：观察一个程序。**

```java
package 内部类;

public class Demo8_匿名内部类 {
    public static void main(String[] args) {
        IMessage msg = new MessageImpl();
        msg.send("www.mldn.cn");
    }
}

interface IMessage{
    public void send(String str);
}
class MessageImpl implements IMessage{
    @Override
    public void send(String str) {
        System.out.println(str);
    }
}
```

如果说现在IMessage子类只使用唯一的一次，那么是否有必要将其定义为单独的类？在这样的需求下，就发现定义的子类有些多余，就可以利用匿名内部类的形式解决此问题。

**范例：使用匿名内部类**

```java
package 内部类;

public class Demo8_匿名内部类 {
    public static void main(String[] args) {
        IMessage msg = new IMessage() {
            @Override
            public void send(String str) {
                System.out.println(str);
            }
        };
        msg.send("www.mldn.cn");
    }
}

interface IMessage{
    public void send(String str);
}
```

匿名内部类不一定实在抽象类和接口上使用，匿名内部类也可以用在其他合适的场合。

有些时候也可以利用静态方法做一个内部的匿名内部类。

**范例：在接口中直接定义匿名内部类。**

```java
package 内部类;

public class Demo9_static中的匿名内部类 {
    public static void main(String[] args) {
        IMessage1.getInstance().send("www.mldn.cn");
    }
}

interface IMessage1{
    public void send(String str);
    public static IMessage getInstance(){
        return new IMessage() {  //*****
            @Override
            public void send(String str) {
                System.out.println(str);
            }
        };
    }
}

// 上面的匿名内部类IDEA建议换成Lambda，如下：
interface IMessage1{
    public void send(String str);
    public static IMessage getInstance(){
        return str -> System.out.println(str);  //*****
    }
}

// 上面的Lambda又建议换成方法引用
interface IMessage1{
    public void send(String str);
    public static IMessage getInstance(){
        return System.out::println;  //*****
    }
}
```

匿名内部类就是一个只能使用一次的，有着固定结构的类。





## 三、Java高级编程特性



### 一）Java多线程编程



#### 1. 进程和线程



**单进程：**同一个时间段上只允许一个程序执行。

**多进程(单核)：**同一个时间段会有多个程序依次执行，但是一个时间点只会有一个程序在执行，实现了并发。

**多进程(多核)：**同一个时间点也会有多个程序在执行，实现了并行。

**线程：**是在进程的基础之上划分的更小的程序单元，线程是在进程基础上创建的，即依赖于进程，但是线程的启动速度要比进程快得多，那么在并发处理的时候，线程要比进程效率高的多。

**Java**是多线程的编程语言，所以Java在并发访问处理的时候，性能更好。



#### 2. Thread实现多线程

一个类只要继承了java.lang.Thread类，就表明这个类是线程的主体类。但是并不是说这个线程就可以实现多线程处理，还需要覆写Thread类中的run（public void run()）方法。

**范例：以下就实现了一个多线程的定义。**

```java
package 多线程编程;

public class ThreadDemo {

}

class MyThread extends Thread{  // 线程的主体类
    private String title;

    public MyThread(String title) {
        this.title = title;
    }

    @Override
    public void run() {  // 主题方法
        for (int i=0; i<10; i++){
            System.out.println(this.title + "，运行："+i+" 次");
        }
    }
}
```

run()方法不能被直接调用，因为这里面牵扯到操作系统的系统调用的问题。直接调用run方法会顺序执行，而不会交叉执行。

```java
package 多线程编程;

public class ThreadDemo {
    public static void main(String[] args) {
//        new MyThread("线程A").run();
        new MyThread("线程A").start();
        new MyThread("线程B").start();
        new MyThread("线程C").start();
    }
}

class MyThread extends Thread{  // 线程的主体类
    private String title;

    public MyThread(String title) {
        this.title = title;
    }

    @Override
    public void run() {  // 主题方法
        for (int i=1; i<10; i++){
            System.out.println(this.title + "，运行："+i+" 次");
        }
    }
}
```

虽然调用的start方法，但是执行的是run方法。

疑问？为什么不直接使用run，而是要用start方法调用。

如果要想清楚这个问题，最好查看start的源代码看一下。

```java
public synchronized void start() {
    /**
         * This method is not invoked for the main method thread or "system"
         * group threads created/set up by the VM. Any new functionality added
         * to this method in the future may have to also be added to the VM.
         *
         * A zero status value corresponds to state "NEW".
         */
    if (threadStatus != 0)
        throw new IllegalThreadStateException();

    /* Notify the group that this thread is about to be started
         * so that it can be added to the group's list of threads
         * and the group's unstarted count can be decremented. */
    group.add(this);

    boolean started = false;
    try {
        start0();  // 在start里面调用了start0
        started = true;
    } finally {
        try {
            if (!started) {
                group.threadStartFailed(this);
            }
        } catch (Throwable ignore) {
            /* do nothing. If start0 threw a Throwable then
                  it will be passed up the call stack */
        }
    }
}

private native void start0();
```

我们会发现源码会抛出异常 ”IllegalThreadStateException“ 异常，但是程序并没有进行相应的try ... catch 处理，说明该异常一定是 RuntimeException 的子类，每一个线程类的对象只允许启动一次，如果出现重复启动，就会抛出这个异常。

```java
MyThread mt = new MyThread();
mt.start();
mt.start(); // 这就是重复启动
// 所以每一个线程对象只允许启动一次
```

**关键字 "native" ：**在java程序考虑到不同层次的开发者需求，所以支持本地的操作系统函数调用，这种技术被称之为 JNI 技术，但是在Java开发之中并不推荐使用。（JNI --> Java Native Interface）这个关键字就表示需要将这个方法依赖于不同的操作系统实现。

<img src="C:\Users\18343\Desktop\Screenshot_20211013_221737_com.huawei.browser.jpg" alt="Screenshot_20211013_221737_com.huawei.browser" style="zoom:67%;" />

任何情况下，只要定义了多线程，多线程的启动永远都只有一种方法：Thread类中的start()方法。



#### 3. Runnable实现多线程

为避免单继承的缺陷，所以提供了接口Runnable。

```java
@FunctionalInterface
interface Runnable{
    public void run();
}
```

Runnable没有start方法，只有run方法，Thread有一个构造方法传入Runnable：pubilc Thread(Runnable runnable); ，把Runnable放入Thread里面进行启动

**范例：通过Runnable实现主体类。**

```java
package 多线程编程;

public class RunnableDemo {
    public static void main(String[] args) {
        Thread myThreadA = new Thread(new MyT("线程A"));
        Thread myThreadB = new Thread(new MyT("线程B"));
        Thread myThreadC = new Thread(new MyT("线程C"));
        myThreadA.start();
        myThreadB.start();
        myThreadC.start();
    }
}

class MyT implements Runnable{
    private String name;
    public MyT(String name){
        this.name = name;
    }
    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println(this.name + ":运行 - "+i+"次");
        }
    }
}
```

这个时候的多线程实现里面由于只是实现了Runnable接口对象是，所以此时线程主体类上就不再有单继承的局限，这样的设计才OK的。

从JDK1.8开始，Runnable接口变成了函数式接口定义，所以可以直接用Lambda实现。

**范例：使用Lambda实现多线程定义。**

```java
package 多线程编程;

public class RunnableDemo {
    public static void main(String[] args) {
        Thread myThreadA = new Thread(new MyT("线程A"));
        Thread myThreadB = new Thread(new MyT("线程B"));
        Thread myThreadC = new Thread(() -> {
            String title = "线程C";
            for (int i=0; i<10; i++){
                System.out.println(title + ":运行 - "+i+"次");
            }
        });
        myThreadA.start();
        myThreadB.start();
        myThreadC.start();
    }
}

class MyT implements Runnable{
    private String name;
    public MyT(String name){
        this.name = name;
    }
    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println(this.name + ":运行 - "+i+"次");
        }
    }
}
```

在以后的开发之中，对于多线程的实现，优先考虑Runnable接口实现，并且永远都是通过Thread类启动多线程。



#### 4. Thread和Runnable的关系

从结构上，Thread和Runnable的联系：

```java
public class Thread extends Object implements Runnable{}
```

继承Thread类覆写的还是Runnable的run方法。

<img src="C:\Users\18343\Desktop\图片\1.jpg" alt="1" style="zoom:67%;" />

多线程开发的本质实质上是在于多个线程可以进行同一资源的抢占，Thread主要是描述线程，资源的描述主要是Runnable。

<img src="C:\Users\18343\Desktop\图片\2.jpg" alt="2" style="zoom:67%;" />

**范例：利用一个卖票程序来实现多个线程的资源并发访问。**

```java
package 多线程编程;

public class Demo_多线程并发卖票 {
    public static void main(String[] args) {
        MThread m = new MThread();
        new Thread(m).start();
        new Thread(m).start();
        new Thread(m).start();
    }
}

class MThread implements Runnable{
    private int ticket = 5;

    @Override
    public void run() {
        for (int x=0; x<100; x++){
            if (this.ticket>0) {
                System.out.println("卖票，ticket = " + this.ticket--);
            }else {
                break;
            }
        }
    }
}
```

<img src="C:\Users\18343\Desktop\图片\3.jpg" alt="3" style="zoom:67%;" />



#### 5. Callable实现多线程

进行多线程实现肯定依靠Runnable，但是Runnable有一个缺陷，就是执行完之后没有返回值。所以在JDK1.5之后提出了新的线程实现接口：java.util.concurrent.Callable 接口，首先来观察这个接口的定义：

```java
@FunctionalInterface
public interface Callable<V> {
    public V call() throws Exception;
}
```

返回值使用的泛型，可以避免向下转型的安全隐患。

<img src="C:\Users\18343\Desktop\图片\4.jpg" alt="4" style="zoom:67%;" />

**范例：使用Callable实现多线程处理。**

```java
package 多线程编程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyThreaD());
        new Thread(task).start();
        System.out.println("线程返回数据："+task.get());
    }
}

class MyThreaD implements Callable<String>{
    @Override
    public String call() throws Exception {
        for (int x=0; x<10; x++){
            System.out.println("------- 线程执行\t" + x);
        }
        return "线程执行完毕";
    }
}
```

**面试题：请解释Runnable和Callable的区别？**

- Runnable实在JDK1.0提出的多线程接口，而Callable实在JDK1.5之后提出的。
- java.lang.Runnable接口之中国只提供了一个run()方法，并且没有返回值。
- java.util.concurrent.Callable接口提供有call()方法且存储有返回值，并且可以通过FutureTask的get获得返回值。



#### 6. 线程运行状态

1. 任何一个线程的对象都应该使用Thread进行封装，所以线程的启动使用的是start的，但是启动是进入一个就绪状态，并没有执行；
2. 这些就绪状态的线程会等待资源调度，当某一个线程调度成功之后则进入到运行状态（run)。
3. 但是所有线程都不会一直执行，中间会出现暂停的状态，这个让出的状态叫做阻塞状态。
4. 随后会被CPU重新唤醒进入就绪状态。
5. 当重新资源分配，并且run执行完毕后，线程就结束了，进入停止状态。

<img src="C:\Users\18343\Desktop\图片\5.jpg" alt="5" style="zoom:67%;" />



### 二）线程的常用操作方法

多线程的主要操作方法都是在Thread类中定义的。



#### 1. 线程的命名和取得

多线程的运行状态是不确定的，所以为了获取一些需要使用的线程，就需要线程的名字来操作。所以线程的名字是一个至关重要的概念，在Thread类中就有提供线程名称：

- 构造方法：public Thread(Runnable r, String name);
- 设置名字：public final void setName(String name);
- 取得名字：public final String getName();

对于线程对象的获得，不可能只是依靠一个his来完成的，但是有一点是明确的，所有的线程对象一定要执行run方法，那么这个时候我们可以**考虑获取当前线程**，Thread类里面有提供获取当前线程。

**范例：观察线程的命名操作。**

```java
package 线程的常用操作;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt,"线程A");
        new Thread(mt);
        new Thread(mt,"线程B");
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {

    }
}


```

```java
/*
当有设置名字的时候，会显示设置的名字，否则会自动生成不重复的名字。
Thread-0
线程A
线程B
*/
private static int threadInitNumber;
private static synchronized int nextThreadNum(){
    return threadInitNumber++;  // 自动编号
}

package 线程的常用操作;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt,"线程A").start();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt,"线程B").start();
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
```

可以发现在主方法之中使用线程对象的 run() 方法 "mt.run()" ，会显示 "main" 名字，所以可以得出一个结论，主方法也是一个线程。

```java
package 线程的常用操作;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt,"线程A").start();
        mt.run();
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

/*
main
线程A
*/
```

每当使用Java命令执行程序的时候，就表示启动了一个JVM的进程，可以用下面的代码实验。

```java
public class Demo{
    public static void main(String[] args){
        for (int x=0; x<Integer.MAX_VALUE; x++){
            System.out.println(x);
        } 
    }
}
```

一台电脑上可以启动若干个JVM的进程，每个JVM进程都有各自的线程。

在任何开发之中，主线程可以创建若干个子线程，创建子线程可以将一些复杂逻辑交给子线程处理。

**范例：子线程的处理。**

```java
package 线程的常用操作;

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("1.执行操作任务一");
//        for (int i=0; i<Integer.MAX_VALUE; i++){
//            System.out.println(temp+=i);
//        }
        new Thread(() -> {  // 子线程负责统计
            int temp = 0;
            for (int i=0; i<Integer.MAX_VALUE; i++){
                temp+=i;
            }
        }).start();
        System.out.println("2.执行操作任务二");
        System.out.println("3.执行操作任务三");
    }
}
```

主线程负责整体流程，子线程负责处理耗时操作。



#### 2. 线程的休眠

如果希望某一个线程可以暂缓处理，在Thread类之中可以进行休眠处理。

```java
public static void sleep(long millis) throws InterruptedException{}
public static void sleep(long millis, int nanos) throws InterruptedException{}
```

 在进行休眠的时候会产生中断异常 "InterruptedException"。

**范例：观察休眠处理。**

```java
package 线程的常用操作;

public class 线程的休眠处理 {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int x=0; x<10; x++){
                System.out.println(Thread.currentThread().getName()+".x = " + x);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程对象").start();
    }
}
```

休眠的主要特点是可以自动实现线程的唤醒，以继续进行后续的处理，但是需要注意的是，如果现在有多个线程对象，那么休眠也是有先后顺序的。

**范例：产生多个线程对象进行线程处理。**

```java
package 线程的常用操作;

public class 线程的休眠处理 {
    public static void main(String[] args) {
        for (int y = 0; y<5; y++) {
            new Thread(() -> {
                for (int x = 0; x < 10; x++) {
                    System.out.println(Thread.currentThread().getName() + ".x = " + x);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "线程对象").start();
        }
    }
}
```

此时将产生五个线程对象，并且这五个线程对象执行的方法体是相同的。此时从程序执行的感觉来讲，好像是若干个程序一起进行休眠，一起执行，不过实际上是有差别的。



#### 3. 线程的中断

在之前发现线程的休眠里面有一个中断异常，实际上就证明线程的休眠时可以被打断的，而这个是由其他线程完成的。在Thread类里面提供有中断处理的方法。

- 判断线程是否被中断：`public boolean isInterrupted();`
- 中断线程执行：`public void interrupt();`

**范例：观察线程的中断处理操作。**

```java
package 线程的常用操作;

public class 线程的中断处理 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("*** 72个小时。。？？我需要睡觉。。！！");
            try {
                Thread.sleep(10000);  // 预计休息10秒
                System.out.println("*** 我醒了。。？？我来了。。！！");
            } catch (InterruptedException e) {
                System.out.println("*** 到点了。。？？没有。。！！");
            }
        });
        thread.start(); // 开始睡觉
        Thread.sleep(3000);
        if (!thread.isInterrupted()){
            System.out.println("*** 我悄悄地来了。。！！");
            thread.interrupt();
        }
    }
}
```

所有正在执行的线程都是可以被中断的，中断线程必须进行异常的处理。



#### 4. 线程的强制执行

所谓的线程的强制执行指的是当满足某些条件之后，某一个现场对象可以一直独占资源，一直到该线程的程序执行结束。

**范例：观察一个没有强制执行的程序。**

```java
package 线程的常用操作;

public class 线程的强制执行 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
           for (int x=0; x<100; x++){
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName() + "执行、x=" + x);
           }
        });
        thread.start();
        for (int x=0; x<100; x++){
            Thread.sleep(100);
            System.out.println("【霸道的main线程】number = " + x);
        }
    }
}
```

上面的主线程和子线程一直在交替执行，但是如果你现象希望主线程独占执行，那么就可以利用Thread里面的方法强制执行。

- 强制执行：`public final void join() throws InterruptedException{}`

```java
package 线程的常用操作;

public class 线程的强制执行 {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();  // 获得主线程
        Thread thread = new Thread(()->{
           for (int x=0; x<100; x++){
               if (x==3){  // 霸道线程来了
                   try {
                       mainThread.join();  // 霸道线程强行加入，先执行
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName() + "执行、x=" + x);
           }
        });
        thread.start();
        for (int x=0; x<100; x++){
            Thread.sleep(100);
            System.out.println("【霸道的main线程】number = " + x);
        }
    }
}
```

在进行线程强制执行的时候，一定要获取强制执行线程对象之后才可以执行join()。

```java
Thread mainThread = Thread.currentThread();  // 获得主线程
mainThread.join();
```



#### 5. 线程的礼让

指的是将资源让出去，让别的线程先执行。线程的礼让可以使用Thread中的yield方法。

- 礼让：`public static void yield();`

**范例：礼让操作。**

```java
package 线程的常用操作;

public class 线程的礼让 {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();  // 获得主线程
        Thread thread = new Thread(()->{
            for (int x=0; x<100; x++){
                if (x%3==0){
                    Thread.yield();  // 线程礼让
                    System.out.println("***  玩耍的线程礼让执行  ***");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行、x=" + x);
            }
        });
        thread.start();
        for (int x=0; x<100; x++){
            Thread.sleep(100);
            System.out.println("【霸道的main线程】number = " + x);
        }
    }
}
```

礼让yield执行的时候只会礼让一次。



#### 6. 线程的优先级

从理论上来讲，线程的优先级越高，越有可能先执行，也就是越有可能抢占到资源。在Thread类里面针对于优先级的操作，提供了两个处理方法。

- 设置优先级：`public final void setPriority(int newPriority);`
- 获取优先级：`public final int getPriority();`

- 最高优先级：`public static final int MAX_PRIORITY;`   //10
- 中等优先级：`public static final int NORM_PRIORITY`   // 5
- 最低优先级：`public static final int MIN_PRIORITY; `   // 1

```JAVA
package 线程的常用操作;

import 多线程编程.ThreadDemo;

public class 线程的优先级 {
    public static void main(String[] args) {
        Runnable run = () -> {
            for (int x=0; x<10; x++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行。");
            }
        };
        Thread threadA = new Thread(run, "线程对象A");
        Thread threadB = new Thread(run, "线程对象B");
        Thread threadC = new Thread(run, "线程对象C");
        threadA.setPriority(Thread.MIN_PRIORITY);
        threadB.setPriority(Thread.MIN_PRIORITY);
        threadC.setPriority(Thread.MAX_PRIORITY);
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
```

设置优先级后，这个线程会被影响，优先级高可能先执行，但不一定每次都先执行，只是可能性高一点儿。

```java
public class JavaDemo{
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getPriority());
        // 主线程优先级是5
        System.out.println(new Thread().currentThread().getPriority());
    }
}
```

主线程的优先级是5，默认线程的优先级也是5。



### 三）线程的同步和死锁

在多线程处理之中，可以利用Runnable描述多个线程操作的资源，而Thread描述每一个线程对象，当多个线程访问同一资源的时候，如果处理不当，就会产生数据错误的操作。

<img src="C:\Users\18343\Desktop\图片\6.jpg" alt="6" style="zoom:67%;" />

#### 1. 同步问题的引出

下面编写一个卖票的程序，创建若干程序进行卖票。

**范例如下：**

```java
package 线程的同步和死锁;

public class 卖票程序 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt, "票贩子A").start();
        new Thread(mt, "票贩子B").start();
        new Thread(mt, "票贩子C").start();
    }
}

class MyThread implements Runnable{
    private int ticket = 10; // 总票数10张
    @Override
    public void run() {
        while (true){
            if (this.ticket>0){
                System.out.println(Thread.currentThread().getName() + " 卖票 ticket = " + this.ticket--);
            }else {
                System.out.println("票卖光了。");
                break;
            }
        }
    }
}
```

上面是三个线程共同使用同一个资源，这个资源有10份。整个过程看着好像没问题，但是追加个延迟，问题就出来了。

```java
package 线程的同步和死锁;

public class 卖票程序 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt, "票贩子A").start();
        new Thread(mt, "票贩子B").start();
        new Thread(mt, "票贩子C").start();
    }
}

class MyThread implements Runnable{
    private int ticket = 10; // 总票数10张
    @Override
    public void run() {
        while (true){
            if (this.ticket>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 卖票 ticket = " + this.ticket--);
            }else {
                System.out.println("票卖光了。");
                break;
            }
        }
    }
}
```

这个时候，追加了延迟，问题就暴露出来了，而实际上这个问题一直都在。

<img src="C:\Users\18343\Desktop\图片\7.jpg" alt="7" style="zoom:67%;" />



#### 2. 线程同步

同步问题的已经找到，下面进行同步问题的解决，而同步的解决指的是锁，也就是当某一个线程执行操作的时候，其他线程外面等待：

<img src="C:\Users\18343\Desktop\图片\8.jpg" alt="8" style="zoom:67%;" />

如果想在程序之间实现锁的功能，就可以使用 synchronized关键字实现，利用这个关键字可以定义同步方法和同步代码块。

在同步代码块之中只允许一个线程执行。

1. **利用同步代码块进行处理。**

```java
synchronized(同步对象){
    同步代码操作;
}
```

一般进行同步的对象处理的时候可以采用当前对象this进行同步。

**范例：同步代码块。**

```java
package 线程的同步和死锁;

public class 线程同步的解决 {
    public static void main(String[] args) {
        MyThread1 mt = new MyThread1();
        new Thread(mt, "票贩子A").start();
        new Thread(mt, "票贩子B").start();
        new Thread(mt, "票贩子C").start();
    }
}

class MyThread1 implements Runnable{
    private int ticket = 100000; // 总票数10张
    @Override
    public void run() {
        while (true){
            synchronized (this) {  // 每一次只允许一个线程访问
                if (this.ticket > 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 卖票 ticket = " + this.ticket--);
                } else {
                    System.out.println("票卖光了。");
                    break;
                }
            }
        }
    }
}
```

加入同步处理之后，程序的整体性能下降了，实际上同步会让性能降低。



2. **利用同步方法解决：只需要在方法上使用synchronized关键字即可。**

```java
package 线程的同步和死锁;

public class 线程同步的解决 {
    public static void main(String[] args) {
        MyThread1 mt = new MyThread1();
        new Thread(mt, "票贩子A").start();
        new Thread(mt, "票贩子B").start();
        new Thread(mt, "票贩子C").start();
    }
}

class MyThread1 implements Runnable{
    private int ticket = 10; // 总票数10张
    public synchronized boolean sale(){
        if (this.ticket > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 卖票 ticket = " + this.ticket--);
            return true;
        } else {
            System.out.println("票卖光了。");
            return false;
        }
    }
    @Override
    public void run() {
        while (this.sale()){
        }
    }
}
```

在学习java类库的时候，系统中许多的类上使用的同步的处理，采用的都是同步的方法。



#### 3. 线程死锁

死锁是在进行多线程处理之中有可能产生的问题。所谓的死锁，指的是若干个线程彼此互相等待的状态。下面通过一个简单的代码来观察一下死锁的表现形式。

```java
package 线程的同步和死锁;

public class DeadLock implements Runnable{
    private PERSON PER = new PERSON();
    private person per = new person();
    public DeadLock(){
        new Thread(this).start();
        per.say(PER);
    }
    @Override
    public void run() {
        PER.say(per);
    }

    public static void main(String[] args) {
        new DeadLock();
    }
}

class PERSON {
    public synchronized void say(person p){
        System.out.println("A说：这都是我的，先给过路费。");
    }
    public synchronized void get(){
        System.out.println("A说：得到了钱可以吃饭了。");
    }
}
class person{
    public synchronized void say(PERSON p){
        System.out.println("B说：先让我过，才给你钱");
    }
    public synchronized void get(){
        System.out.println("B说：逃过了一劫，真好");
    }
}
```

这个死锁造成的主要原因是：**互相等待。**

有的时候代码如果处理不当则会不定期出现死锁，这是属于正常开发中的调试问题。

若干个线程访问同一资源时一定要进行同步处理，而过多的同步处理会造成死锁（同步会持有资源，而如果互相持有对方的资源，就会死锁）。



### 四）生产者和消费者



#### 1. 代码

<img src="C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211016170910498.png" alt="image-20211016170910498" style="zoom:67%;" />

```java
package 生产者和消费者;

public class ThreadDemo {
    public static void main(String[] args) {
        Message msg = new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }
}

class Producer implements Runnable{
    private Message msg;

    public Producer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++){
            if (i%2==0){  // 设置资源
                this.msg.setTitle("王建");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.msg.setContent("宇宙大帅哥");
            }else {
                this.msg.setTitle("小高");
                this.msg.setContent("猥琐第一人");
            }
        }
    }
}

class Consumer implements Runnable{
    private Message msg;

    public Consumer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++){
            // 获取资源
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.msg.getTitle() + ":" + this.msg.getContent());
        }
    }
}

class Message{
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
```

- 问题一：数据不同步了。
- 问题二：生产一个取走一个，但是发现有重复生产和重复取出。



#### 2. 解决数据同步

添加设置同步代码块或者同步方法。

```java
package 生产者和消费者;

public class ThreadDemo {
    public static void main(String[] args) {
        Message msg = new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }
}

class Producer implements Runnable{
    private Message msg;

    public Producer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++){
            if (i%2==0){  // 设置资源
                this.msg.set("王建", "宇宙大帅哥");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                this.msg.set("小高", "猥琐第一人");
            }
        }
    }
}

class Consumer implements Runnable{
    private Message msg;

    public Consumer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++){
            // 获取资源
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.msg.get());
        }
    }
}

class Message{
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public synchronized void set(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public synchronized String get() {
        return this.title + " : " + this.content;
    }
}
```

同步之后，数据保持一致了，但是对于重复操作依然存在。



#### 3. 线程的等待和唤醒

也就是消费者等待产品生产，唤醒生产者去生产产品；生产者等待产品被消费，消费后重新放入产品唤醒消费者去消费。

``` java
public final void wait() throws InterruptedException;  // 死等
public final void wait(long timeout [,long nanos]) throws InterruptedException;  // 设置等待时间毫秒纳秒
```

```java
public final void notify();  // 唤醒第一个等待线程（等待队列的第一个）
public final void notifyAll();  // 唤醒全部等待线程（优先级高的可能先执行）
```

```java
package 生产者和消费者;

public class ThreadDemo {
    public static void main(String[] args) {
        Message msg = new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }
}

class Producer implements Runnable{
    private Message msg;

    public Producer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++){
            if (i%2==0){  // 设置资源
                this.msg.set("王建", "宇宙大帅哥");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                this.msg.set("小高", "猥琐第一人");
            }
        }
    }
}

class Consumer implements Runnable{
    private Message msg;

    public Consumer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++){
            // 获取资源
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.msg.get());
        }
    }
}

class Message{
    private String title;
    private String content;
    private boolean flag = true; // 表示生产或者消费的模式
    // flag = true 允许生产
    // flag = false 允许消费

    public String getTitle() {
        return title;
    }

    public synchronized void set(String title, String content) {
        if (!this.flag){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = content;
        flag = false;    // 可以消费了
        super.notify();  // 唤醒消费线程
    }

    public synchronized String get() {
        if (this.flag){  // 等待生产
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = true;    // 可以生产了
        super.notify(); // 唤醒生产线程
        return this.title + " : " + this.content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
```

这种处理形式就是进行多线程开发之中最原始的解决方案，整个等待、同步都是通过最原始的代码控制。



### 五）多线程深入话题



#### 1. 优雅的停止线程

Thread类有提供stop()方法，但是已经被移除并且禁用了。（从JDK1.2开始）还有其他几个也被废除了。

- 销毁多线程：public void destroy() ;  
- 挂起线程、暂停执行：public final void suspend() ;
- 恢复挂起的线程执行：public final void resume() ;

之所以废除这些方法，是因为有可能导致死锁的诞生。

**范例：柔和的停止线程。**

```java
package 多线程的深入话题;

import java.util.concurrent.atomic.AtomicInteger;

public class 柔和的停止线程 {
    public static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            AtomicInteger num = new AtomicInteger();
            while (flag){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在执行；num = "+ num.getAndIncrement());
            }
        },"执行线程").start();
        Thread.sleep(200);
        flag = false;
    }
}
```

万一有其他的线程控制flag的内容，那么对于线程的停止也无法说停就停，而是会在执行中判断flag的内容来完成。

强制性立刻停止会造成死锁，而这样缓缓的停是最好用最方便的形式。

```java
Thread.sleep(200);
flag = false;
flag = true;  // 本来设置false已经停止了，但是由于线程没有结束，子线程还在运行态，这里重新设置后，又重新挂起执行了。
```

接下来我又试验了多次修改flag的值。

```java
Thread.sleep(200);
flag = false;
Thread.sleep(200);
flag = true;  // 本来设置false已经停止了，但是由于线程没有结束，子线程还在运行态，这里重新设置后，又重新挂起执行了。
Thread.sleep(200);
flag = false;
```

线程只执行了最开始的200ms，后面就没有执行了，因为flag变回true后，线程被沉睡了，没有回到while循环里面去，刚醒过来又被false掉了，所以就结束了。



#### 2. 后台守护线程

一个人有一个保镖，那么这个保镖一定是在这个人活着的时候有用，人死了就保镖没用了。

只要主线程存在，守护线程就一直存在。

Thread类里面提供有守护线程操作方法：

- 设置为守护线程：`public final void setDaemon(boolean on) ;`
- 判断是否为守护线程：`public final boolean isDaemon() ;`

**范例：使用守护线程。**

```java
package 多线程的深入话题;

public class 守护线程 {
    public static void main(String[] args) throws InterruptedException {
        Thread userThread = new Thread(()->{
            for (int x=0; x<10; x++){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在运行、x = " + x);
            }
        }, "用户线程");  // 完成核心代码
        Thread daemonThread = new Thread(()->{
            for (int x=0; x<Integer.MAX_VALUE; x++){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在运行、x = " + x);
            }
        }, "守护线程");
        daemonThread.setDaemon(true);  // 设置为守护线程
        userThread.start();
        daemonThread.start();
    }
}
```

守护线程会在用户线程执行结束后，一起结束。尽管用户线程只执行10次，守护线程执行MAX_VALUE次。

程序中最大的守护线程是GC线程，程序执行完毕GC才会结束。



#### 3. volatile关键字

volatile关键字主要用于属性定义上的，**表示此属性为直接数据操作，不进行副本的拷贝处理。**

在一些书上就将其错误的理解为同步属性了。

<img src="C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211016180614936.png" alt="image-20211016180614936" style="zoom:67%;" />

在**正常进行变量处理的时候**，往往经历如下几个步骤：

- 获取变量原有数据内容的副本。
- 利用副本为变量进行数学计算。
- 将计算后的变量保存到原始空间之中。

而如果给属性加上volatile关键字，就是**表示不使用副本**，直接操作原始变量，节省了拷贝副本、重新保存的步骤。

面试题：请解释 volatile 和 synchronized 的区别？

- volatile 主要是在属性上使用，synchronized 是在方法和代码块上使用。
- volatile 无法描述同步的处理，synchronized 可以进行同步的处理。



### 六）多线程综合案例



#### 1. 数字加减

```java
package 多线程综合案例;

public class AddOrSubtractNumber {
    public static void main(String[] args) {
        Resource resource = new Resource();
        AddThread at = new AddThread(resource);
        SubThread st = new SubThread(resource);
        new Thread(at, "addition thread - A").start();
        new Thread(at, "addition thread - B").start();
        new Thread(st, "subtraction thread - A").start();
        new Thread(st, "subtraction thread - B").start();
    }
}

class Resource{
    private int num = 0;  // 进行加减操作的数据
    private boolean flag = true;  // 加减切换
    // flag=true -> Add
    // flag=false-> subtract

    public synchronized void add() throws InterruptedException {
        while (!this.flag){
            super.wait();
        }
        Thread.sleep(100);
        this.num++;
        System.out.println("[add operation : " + Thread.currentThread().getName() + "] num=" + this.num);
        this.flag = false;
        super.notifyAll();
    }

    public synchronized void subtract() throws InterruptedException {
        while (this.flag){
            super.wait();
        }
        Thread.sleep(200);
        this.num--;
        System.out.println("[subtract operation : " + Thread.currentThread().getName() + "] num=" + this.num);
        this.flag = true;
        super.notifyAll();
    }
}

class AddThread implements Runnable{
    private Resource resource;

    public AddThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int x=0; x<50; x++){
            try {
                this.resource.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class SubThread implements Runnable{
    private Resource resource;

    public SubThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int x=0; x<50; x++){
            try {
                this.resource.subtract();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

整个结果应该在0、1、-1之间来回跳动，才是合理的做法。



#### 2. 生产电脑

如果没有电脑，要生成；如果还有电脑，要等搬走了再生成。并且要统计共生成了多少台电脑。

```java
package 多线程综合案例;

public class GenerateComputer {
    public static void main(String[] args) {
        CResource resource = new CResource();
        new Thread(new Producer(resource)).start();
        new Thread(new Consumer(resource)).start();
    }
}

class Computer{
    private static int count = 0;  // 表示生产的个数
    private String name;
    private double price;

    public Computer(String name, double price) {
        this.name = name;
        this.price = price;
        count++;
    }

    @Override
    public String toString() {
        return "[The " +count+"th]: "+
                "name='" + this.name + '\'' +
                ", price=" + this.price +
                '}';
    }
}

class CResource{
    private boolean flag = true;
    private Computer computer;

     public synchronized void make() throws InterruptedException {
        while (this.computer!=null){
            super.wait();
        }
        Thread.sleep(100);
        System.out.println("A computer was produced.");
        this.computer = new Computer("MLDN电脑", 1.1);
        super.notifyAll();
    }

    public synchronized void get() throws InterruptedException {
        while (this.computer==null){
            super.wait();
        }
        Thread.sleep(100);
        System.out.println("A computer was taken away："+this.computer);
        this.computer = null;
        super.notifyAll();
    }
}

class Producer implements Runnable{
    private CResource cResource;

    public Producer(CResource cResource) {
        this.cResource = cResource;
    }

    @Override
    public void run() {
        for (int x=0; x<50; x++){
            try {
                this.cResource.make();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements Runnable{
    private CResource cResource;

    public Consumer(CResource cResource) {
        this.cResource = cResource;
    }

    @Override
    public void run() {
        for (int x=0; x<50; x++){
            try {
                this.cResource.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```



#### 3. 竞拍抢答案例

设置三个抢答者，而后给出抢答指令，抢答成功给出成功提示，抢答失败给出失败提示。

对于一个多线程的操作由于涉及到数据的返回问题，那么最好使用Callable是比较方便的一种处理形式。

```java
package 多线程综合案例;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ContestToAnswer {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread mt = new MyThread();
        FutureTask<String> taskA = new FutureTask<>(mt);
        FutureTask<String> taskB = new FutureTask<>(mt);
        FutureTask<String> taskC = new FutureTask<>(mt);
        new Thread(taskA, "竞赛者A").start();
        new Thread(taskB, "竞赛者B").start();
        new Thread(taskC, "竞赛者C").start();
        System.out.println(taskA.get());
        System.out.println(taskB.get());
        System.out.println(taskC.get());
    }
}

class MyThread implements Callable<String>{
    private boolean flag = false; // 抢答处理
    @Override
    public String call() throws Exception {
        synchronized(this){
            if (!this.flag){
                this.flag = true;
                return Thread.currentThread().getName() + "抢答成功。";
            }else {
                return Thread.currentThread().getName() + "抢答失败。";
            }
        }
    }
}
```

上面是定义了三个FutureTask对象，但是他们公用的同一个mt资源，所以在抢占资源你的时候是同一个。

也可以定义一个FutureTask对象，然后有三个线程公用一个task对象资源，这时候也有返回值，不过我们这里只能知道谁成功了。上面定义三个 task对象给三个线程，可以知道三个对象的成功与否的情况。



### 七）Java基础类



#### 1. System类

System类是一直陪我们学习的类，之前采用的系统输出就是这样的一个方法。里面也有定义一些其他的处理方法：

- 数组拷贝：`System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length) ;`
- 获取当前日期时间数值： `public static long currentTimeMillis() ;`
- 进行垃圾回收： `public static void gc() ;`

**范例：操作耗时的统计。**

```java
package Java基础类库;

public class System类 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String x = "";
        for (int i=0; i<3000; i++){
            x+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }
}
```

在System里面也有一个gc方法。

```java
public static void gc(){
    Runtime.getRuntime().gc();
}
```

调用的也是系统里面的gc操作。



#### 2. CharSequence接口

CharSequence接口是一个描述字符串结构的接口，在这个接口里面一般发现有三种常见的子类。

- String类。

  ```java
  public final class String extends Object implements Serializable, Comparable<String>, CharSequence {}
  ```

- StringBuffer类。

  ```java
  public final class StringBuffer extends Object implements Serializable,  CharSequence {}
  ```

- StringBuilder类。

  ```java
  public final class StringBuilder extends Object implements Serializable, CharSequence {}
  ```

<img src="C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211017173702775.png" alt="image-20211017173702775" style="zoom:67%;" />

现在只要有字符串就可以为CharSequence实例化。看到CharSequence，其实就是字符串。

```java
package Java基础类库;

public class CharSequence类 {
    public static void main(String[] args) {
        CharSequence str = "www.mldn.cn";  // 子类向父接口转型
    }
}
```

CharSequence本身是一个接口，在该接口也定义了如下操作。

-  `public char charAt(int index) ;`
-  `public int length() ;`

-  `public CharSequence SubSequence(int start, int end) ;`

**范例：字符串的截取。**

```java
package Java基础类库;

public class CharSequence类 {
    public static void main(String[] args) {
        CharSequence str = "www.mldn.cn";  // 子类向父接口转型
        CharSequence sub = str.subSequence(4, 8);
        System.out.println(sub);
    }
}
```

以后看到了CharSequence，描述的就是一个字符串。



#### 3. 对象克隆

所谓的对象克隆，指的是对象的复制，全新的复制，即：使用已有对象创建一个新的对象。如果要进行对象的克隆的话，需要Object里面的 clone() 方法。

```java
protected Object clone() throws CloneNotSupportedException{}
```

所有的类都会继承Object父类，所以所有的类都一定clone()方法，但是并不是所有的类都希望被克隆。如果想要实现对象的克隆，那么对象所在的类需要实现一个接口：Cloneable。此接口并没有任何方法提供，因为他描述的是一种能力。

接口有了两大基础作用：标准和能力。

```java
package Java基础类库;

public class Clone方法 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Member memberA = new Member("李强", 18);
        Member memberB = (Member) memberA.clone();  // 浅克隆，只是复制了内容，没有复制地址。
        Member memberC = memberA;  // 直接指向了同一个地址引用
        System.out.println(memberA);
        System.out.println(memberB);
        System.out.println(memberC);
    }
}
class Member implements Cloneable{
    private  String name;
    private int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        // 本节实验克隆，这里取地址观察
        return "[" + super.toString() + "] name="+this.name + "、age=" + this.age;
    }
}
```

clone()方法想要使用，首先这个类必须实现Cloneable接口，然后再覆写clone()方法。（直接调用super.clone()）

这里的clone()只是浅克隆，复制了内容，地址不一样。



#### 4. Cleaner类

是在JDK1.9之后提供的一个对象清理操作，其主要功能是进行finalize()的替代。

在C++中有两种特殊函数：构造函数、析构函数（进行对象的手工回收）。在Java里面所有的垃圾空间都是通过GC自动回收，所以很多情况都不需要使用析构函数，所以Java并没有提供这方面的支持。

但是Java本身依然提供了给用户收尾的操作。每一个实例化对象在回收之前至少给他一个喘息的机会，最初实现对象收尾处理的方法是Object类中提供的finalize()方法。这个方法的定义如下：

```java
protected void finalize() throws Throwable {}
```

这个方法最大的特点是抛出了Throwable异常类型，这个异常类型分为两个子类型：Error 和 Exception。

**范例：观察传统回收。**

```java
package Java基础类库;

public class Cleaner类 {
    public static void main(String[] args) {
        M m = new M();  // 诞生
        m = null;  // 回收
        System.gc();
        System.out.println("太阳照常升起。");
    }
}
class M {
    public M(){
        System.out.println("[构造]林强诞生了！");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("[回收]人，终有一死");
        throw new Exception("我还要再活500年！");
    }
}
```

从JDK1.9开始，finalize()不建议使用了，而对于对象回收，建议使用 AutoCloseable 或者使用 java.lang.ref.Cleaner 类进行回收处理（Cleaner 也支持 AutoCloseable 处理）。

```java
package Java基础类库;

import java.lang.ref.Cleaner;

public class Cleaner类 {
    public static void main(String[] args) {
        try(MemberClean mc = new MemberClean()) {
            // 执行相关代码
        }catch (Exception e){
        }
    }
}
class M implements Runnable{
    public M(){
        System.out.println("[构造]林强诞生了！");
    }

    @Override
    public void run() {  // 执行清除
        System.out.println("[回收]人，终有一死");
    }
}

class MemberClean implements AutoCloseable{  // 实现清除操作
    private static final Cleaner cleaner = Cleaner.create();  // 创建一个清楚处理。
    private M m;
    private Cleaner.Cleanable cleanable;

    public MemberClean() {
        this.m = new M();  // 创建新对象
        this.cleanable = this.cleaner.register(this, this.m);  // 注册要使用的对象
    }

    @Override
    public void close() throws Exception {
        this.cleanable.clean();  // 启动多线程进行清除
    }
}
```

在新一代的回收处理过程之中，更多的是考虑多线程的使用。即：为了访问有可能造成的延迟处理，所以许多对象的处理，都是单独通过一个线程完成的，这样可以保证整体性能的提高。



#### 5. AutoCloseable类

AutoCloseable类主要用于日后进行资源开发处理上，以实现资源的自动关闭（释放资源）。在以后进行文件、网络以及数据库的开发之中，由于服务器的资源有限，所以使用之后一定要关闭资源，才能被更多的使用者使用。

下面将通过一个消息的发送处理来完成。

**范例：手工模拟实现资源处理。**

```java
package Java基础类库;

public class AutoCloseable类 {
    public static void main(String[] args) {
        Message m = new Message("www.mldn.cn");  // 定义要发送的消息
        if (m.open()){ // 是否打开了链接通道
            m.send();
            m.close();
        }
    }
}
interface IMessage{
    public void send();  // 消息发送
}
class Message implements IMessage{
    private String msg;

    public Message(String msg) {
        this.msg = msg;
    }

    public boolean open(){ // 获取资源链接
        System.out.println("【OPEN】获取消息资源的链接。");
        return true;
    }
    public void close(){
        System.out.println("【CLOSE】关闭消息发送通道。");
    }

    @Override
    public void send() {
        System.out.println("【*** SEND ***】"+ this.msg);
    }
}
```

此时有位设计师说了：既然所有的资源完成处理之后都必须完成关闭操作，那么能否实现自动关闭的功能。在这样的要求下推出了AutoCloseable接口，这个接口实在JDK1.7之后提供的，并且这个接口只提供有一个方法。

- 关闭方法：`public void close() throws Exception {}`

要想实现自动关闭处理，除了要使用AutoCloseable之外，还需要结合异常处理语句完成。

<img src="C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211017185047881.png" alt="image-20211017185047881" style="zoom:67%;" />



**范例：实现自动关闭处理。**

```java
package Java基础类库;

public class AutoCloseable类 {
    public static void main(String[] args) {
        try(IMessage m = new Message("www.mldn.cn")){  // 放到这里面自动调用close方法。
            m.send();
        }catch (Exception e){}

    }
}
interface IMessage extends AutoCloseable{
    public void send();  // 消息发送
}
class Message implements IMessage{  // 这里也相当于实现了AutoCloseable
    private String msg;

    public Message(String msg) {
        this.msg = msg;
    }

    public boolean open(){ // 获取资源链接
        System.out.println("【OPEN】获取消息资源的链接。");
        return true;
    }

    @Override
    public void send() {
        if (this.open()) {
            System.out.println("【*** SEND ***】" + this.msg);
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("【CLOSE】关闭资源链接通道。");
        super.close();
    }
}
```

在以后的接触到资源关闭的时候，都会见到AutoCloseable接口的使用。（记得要和异常捆绑到一起使用才能完成）

之前学的和数据库有关的几个类，都需要手动close关闭，也可以放进try里面自动关闭，因为他们都实现了Closeable接口。



#### 6. Runtime类

Runtime描述的是运行时的状态，也就是说在整个JVM之中，Runtime是唯一一个和运行状态有关的类，并且会默认提供一个该类的实例化对象。

由于在每一个JVM进程里面只允许提供一个Runtime类的对象，所以这个类的构造方法被默认私有化了，所以这个类使用的单例设计模式，并且一定有提供static方法获取实例。

<img src="C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211018153628509.png" alt="image-20211018153628509" style="zoom:67%;" />

由于Runtime类属于单例设计模式，如果想要获取实例化对象，可以依靠getRuntime()方法完成。

- 获取实例化对象：`public static Runtime getRuntime() ;`

**范例：获取Runtime类对象。**

```java
package Java基础类库;

public class Runtime类 {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();
        System.out.println(run.availableProcessors());
    }
}
```

通过这个类中的 availableProcessors() 方法，可以获取系统的内核数，也就是并发的最佳访问量。

但是除了以上的方法之外，在我们Runtime里面还提供了以下四个重要的操作方法：

- 获取最大可用内存空间：`public long maxMemory() ;` 默认的配置是本机系统内存的 `1/4`。
- 获取可用内存空间：`public long totalMemory() ;` 默认的配置是本机系统内存的 `1/64`。
- 获取空闲内存空间：`public long freeMemory() ;` 
- 手工进行GC处理：`public void gc() ;`
- 返回值是long，是因为内存是由字节的形式返回的。

**范例：观察内存状态。**

```java
package Java基础类库;

public class Runtime类 {
    public static void main(String[] args) throws InterruptedException {
        Runtime run = Runtime.getRuntime();
        System.out.println("[1]MaxMemory: " + run.maxMemory());
        System.out.println("[1]totalMemory: " + run.totalMemory());
        System.out.println("[1]freeMemory: " + run.freeMemory());
        String str = "";
        for (int x=0; x<30000; x++){
            str+=x;  // 产生大量的垃圾
        }
        System.out.println("-------");
        System.out.println("[2]MaxMemory: " + run.maxMemory());
        System.out.println("[2]totalMemory: " + run.totalMemory());
        System.out.println("[2]freeMemory: " + run.freeMemory());
        System.out.println("-------");
        Thread.sleep(2000);
        run.gc();   // 清理垃圾
        System.out.println("[3]MaxMemory: " + run.maxMemory());
        System.out.println("[3]totalMemory: " + run.totalMemory());
        System.out.println("[3]freeMemory: " + run.freeMemory());
    }
}

/*
	[1]MaxMemory: 2095054848
    [1]totalMemory: 132120576
    [1]freeMemory: 128974848
    -------
    [2]MaxMemory: 2095054848
    [2]totalMemory: 397410304
    [2]freeMemory: 327285792
    -------
    [3]MaxMemory: 2095054848
    [3]totalMemory: 17825792
    [3]freeMemory: 15995824
*/
```

面试题：请问什么是GC？如何处理垃圾的？

- GC（Garbage Collector）——垃圾收集器。是由JVM虚拟机自动调用的，或者由Runtime手动调用对垃圾进行清除。
- 上面的free和total的变化是因为JVM底层原理问题：<u>Eden区、S0区、S1区(新生代)</u>、老年代区。



#### 7. StringBuffer类

String类是在所有开发之中一定会使用到的一个功能类。并且这个类拥有如下特点：

- 每一个字符串常量都属于一个String类的匿名对象，并且不可更改。
- String类有两个常量池：静态常量池和运行时常量池。
- String类对象实例化建议使用直接赋值的形式完成，这样可以将对象保存在对象池之中，方便下次重用。

虽然String类很好使用，但也有最大的弊端：内容不可修改。虽然大部分的情况都不会设计到字符串内容频繁修改，但是依然可能会有这样的情况。所以为此提供了StringBuffer类，可以进行内容的频繁修改处理。

StringBuffer并不像String那样有两种实例化表示，而是想普通类那样实例化方式。StringBuffer类有如下方法：

- 无参构造：`public StringBuffer() ;`
- 数据追加：`public StringBuffer append(各种数据类型 obj) ;`



**范例：观察String和StringBuffer的对比。**

```java
package Java基础类库;

//String
public class StringBuffer类 {
    public static void main(String[] args) {
        String str = "hello";
        change(str);
        System.out.println(str);
    }
    public static void change(String temp){
        temp+="world";
    }
}
// 内容没有改变

---------------------------------------

package Java基础类库;

// StringBuffer
public class StringBuffer类 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("hello");
        change(str);
        System.out.println(str);
    }
    public static void change(StringBuffer temp){
        temp.append(" world");
    }
}
// 内容改变了
```

实际上很少会出现字符串内容的改变，这种改变指的并不是针对于静态常量池的改变。

**范例：分析已有问题。**

```java
package Java基础类库;

public class StringBuffer类 {
    public static void main(String[] args) {
        String strA = "www.mldn.cn";
        String strB = "www." + "mldn" + ".cn";
        System.out.println(strA==strB);
    }
}
```

这个时候的strB并不算改变，或者更加严格的意义上来讲，对于strB，当程序编译之后，会变成如下的形式：

```java
StringBuilder buf = new StringBuilder();
buf.append("www.").append("mldn").append(".cn");
//上下相同
String str = "www."+"mldn"+".cn";
```

所有的 ”+“ 在编译之后都变成了StringBuffer 中的 append() 方法，并且在程序之中，StringBuffer和String类之间本来就可以互相转换。

- String类转换成StringBuffer类：可以利用StringBuffer类的构造方法或者append()方法。
- StringBuffer类转换成String类：可以使用toString()转换。

在StringBuffer里面，除了可以支持字符串内容修改之外，还有几个String类所不具备的几个方法：

- 插入数据：`public StringBuffer insert(int offset, object obj) ;`

```java
package Java基础类库;

public class StringBuffer类 {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(".cn").insert(0,"www.").insert(4,"mldn");
        System.out.println(buffer);
    }
}
```

- 删除部分范围数据：`public StringBuffer delete(int start, int end);`

```java
package Java基础类库;

public class StringBuffer类 {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("hello world!");
        buffer.delete(6,12).insert(6,"MLDN !");
        System.out.println(buffer);
    }
}
```

- 字符串内容反转：`public StringBuffer reverse() ;`

```java
package Java基础类库;

public class StringBuffer类 {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("hello world!");
        buffer.reverse();
        System.out.println(buffer);
    }
}
```

和StringBuffer类有一个类似的类StringBuilder类，这个类是在JDK1.5之后提出的，该类中提供的方法和StringBuffer提供的方法功能相同，最大的区别在于StringBuffer里面的方法属于线程安全的，全部使用 `synchronized` 关键字修饰，StringBuilder属于非线程安全的。

**面试题：请解释String、StringBuffer和StringBuilder的区别？**

- String类是字符串的首选类型，其最大特点是内容不允许修改。

- StringBuffer与StringBuilder 类的内容是可以修改的。
- StringBuffer是在JDK1.0提供的，且线程安全的；StringBuilder是在JDK1.5提供的，属于非线程安全的操作。



### 八）数字操作类



#### 1. Math数学计算类

主要功能是进行数学计算的操作的类。这个类的构造方法被私有化了，并且不是单例。该类提供的所有方法都是 static 类型的方法。即：这些方法都可以通过类名称直接使用。

虽然在Math的类里面提供有四舍五入的处理方法，但是这个四舍五入在进行处理的时候，是直接将小数点后面的所有位进行进位处理了，这样肯定不方法，那么最方便的做法是实现指定位数的保留。

**范例：自定义四舍五入功能。**

```java
package 数字操作类;

public class Math类 {
    public static void main(String[] args) {
        System.out.println(MathUtil.round(13578.1351354, 5));
    }
}

class MathUtil{
    private MathUtil(){}

    /**
     * 实现四舍五入的操作
     * @param num  要进行四舍五入的数字
     * @param scale  四舍五入要保留的位数
     * @return  四舍五入处理后的结果
     */
    public static double round(double num, int scale){
        return Math.round(num*Math.pow(10, scale))/Math.pow(10, scale);
    }
}
```

Math提供的都是基础的数学公式，需要的时候需要自己重新整合。



#### 2. Random类

java.util.Random类的主要功能是产生随机数的，这个类主要是依靠内部提供过的方法来完成。

- 产生一个不大于边界的随机正整数：`public int nextInt(int bound) ;`

```java
package 数字操作类;

import java.util.Random;

public class Random类 {
    public static void main(String[] args) {
        Random random = new Random();
        for (int x=0; x<10; x++){
            System.out.print(random.nextInt(100) + "、");
        }
    }
}
// 包括 0 
```

在国内有一款36选7的彩票，现在用Random随机生成彩票。

**范例：随机生成彩票。**

- 不能有 0 
- 不能重复

```java
package 数字操作类;

import java.util.Arrays;
import java.util.Random;

public class Random类 {
    public static void main(String[] args) {
        int[] data = new int[7];  // 开辟7个空间
        int foot = 0;  // 操作data的脚标
        Random rand = new Random();
        while (foot < 7){
            int num = rand.nextInt(37);
            if (isUse(num, data)){
                data[foot++] = num;
            }
        }
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));
    }

    /**
     * 判断传入的数字是否为0或者在数组中存在
     * @param num 需要判断的数字
     * @param arr 已经存在的数据
     * @return  如果该数字不是0且不在arr里面，则返回true
     */
    public static boolean isUse(int num, int[] arr){
        if (num==0) return false;
        for (int x=0; x<arr.length; x++){
            if (arr[x]==num){
                return false;
            }
        }
        return true;
    }
}
```

以后这种随机的操作，都可以使用Random来处理。



#### 3. 大数字操作类

可以实现海量数字的计算（能提供的也只是基础数字的计算）。

假设一个数字很大，超过了double的范围。那么这个时候并没有任何一种数据类型可以保存下此类的内容，最开始只能用String保存。

```java
String strA = "120";
String strB = "220";
```

如果想要进行计算，那么就需要进行拆分，每一位自己计算，而后自己独立控制进位处理，开发难度很高。为了解决这样的问题，提供有两个大数字操作类：BigInteger、BigDecimal。

<img src="C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211018165033797.png" alt="image-20211018165033797" style="zoom:67%;" />

当数字很大的时候，只能用字符串描述操作。所以这一点可以观察两个大数字类的构造方法。

- `public BigInteger(String str) ;`

- `public BigDecimal(String str) ;`

**范例：使用BigInteger实现四则运算。**

```java
package 数字操作类;

import java.math.BigInteger;

public class BigInteger类 {
    public static void main(String[] args) {
        BigInteger bigA = new BigInteger("13543873135448");
        BigInteger bigB = new BigInteger("1354354");
        System.out.println("加法："+bigA.add(bigB));
        System.out.println("减法："+bigA.subtract(bigB));
        System.out.println("乘法："+bigA.multiply(bigB));
        System.out.println("除法："+bigA.divide(bigB));
    }
}
```

虽然有提供大数字类，提升了大数字计算的能力，但是还是要考虑性能问题，计算结果还是很慢的，任何所谓的电脑都是有极限的。

既然在进行数学除法的时候有可能无法进行整除的处理，那么我们可以简化使用其他的除法运算，来求出余数。

- 求余数：`public BigInteger[] divideAndRemainder(BigInteger val) ;`  返回值第一个为商，第二个为余数。

**范例：求余除法。**

```java
package 数字操作类;

import java.math.BigInteger;

public class BigInteger类 {
    public static void main(String[] args) {
        BigInteger bigA = new BigInteger("13543873135448");
        BigInteger bigB = new BigInteger("1354354");
        BigInteger[] res = bigA.divideAndRemainder(bigB);
        System.out.println("商："+res[0] + ",余数："+res[1]);
    }
}
```

如果在开发中真进行计算的时候，该计算没有超过基本数据类型的时候，强烈不建议使用大数字类型进行计算，这种运算速度是很差的。

BigDecimal的操作模式和BigInteger是非常类似的。

```java
package 数字操作类;

import java.math.BigDecimal;

public class BigDecimal类 {
    public static void main(String[] args) {
        BigDecimal bigA = new BigDecimal("1354837313131");
        BigDecimal bigB = new BigDecimal("135431321");
        System.out.println("加法："+bigA.add(bigB));
        BigDecimal[] res = bigA.divideAndRemainder(bigB);
        System.out.println("除法："+res[0]);
    }
}
```

但是在使用BigDecimal的时候，有一个数据进位的问题，在这个类里面定义有如下的除法计算：

```java
public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode) {}  //9之后被废除
public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode) {}  // 这是新的，1.5开始
```

**范例：使用BigDecimal实现四舍五入处理。**

```java
package 数字操作类;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimal类 {
    public static void main(String[] args) {
        System.out.println(BigDecimalUtil.round(19.3548, 2));
    }
}

class BigDecimalUtil{
    public static double round(double num, int scale){
        return new BigDecimal(num).divide(new BigDecimal(1.0), scale, RoundingMode.HALF_UP).doubleValue();
    }
}
```

和Math相比，BigDecimal速度要慢得多。（Math都是基本数据类型）



### 九）日期处理类



#### 1. Date类

在Java里面提供了一个 java.util.Date 类，如果直接实例化，就可以直接获得当前的日期时间。

**范例：观察 java.util.Date 类。**

```java
package 日期操作类;

import java.util.Date;

public class Date日期处理类 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
    }
}
```

这个类确实获取了当前时间，但是结构并不完善。

这个时候需要进一步观察Date类中的构造方法：

```java
public Date(){
    this(System.currentTimeMillis()) ;
}
public Date(long date){
    fastTime = date;
}
```

通过以上源代码可以得出一个结论：Date类至少对long的一种包装，所以Date类中一定提供有long和日期之间的相互转化。

- 将long转为日期：`public Date(long date){}`
- 将Date转为long：`public long getTime(){}`

**范例：观察long和Date之间的转换。**

```java
package 日期操作类;

import java.util.Date;

public class Date日期处理类 {
    public static void main(String[] args) {
        Date date = new Date();
        long current = date.getTime();
        current+=864000000;  //10天的秒数
        System.out.println(new Date(current));
    }
}
```

long之中可以保存毫秒的数据级，这样方便程序的处理。



#### 2. 日期的格式化

虽然Date可以获取当前时间，但是时间格式不太习惯，那么可以对日期格式进行处理。

为了格式化处理日期，在 java.text.SimpleDateFormat类中，该类是DateFormat的子类，该父类提供了如下方法：

- 【DateFormat】将日期格式化：`public final String format(Date date);`
- 【DateFormat】将字符串转为日期：`public Date parse(String source) throws ParseException`
- 【SimpleDateFormat】构造方法：`public SimpleDateFormat(String pattern);`
  - 日期描述：年（yyyy）、月（MM）、日（dd）、时（hh\HH）、分（mm）、秒（ss）、毫秒（SSS）

**范例：格式化日期显示**

```java
package 日期操作类;

import java.text.SimpleDateFormat;
import java.util.Date;

public class 日期格式化 {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String str = sdf.format(date);
        System.out.println(str);
    }
}
// 2021-10-18 18:18:49:029
```

除了可以将日期格式化为字符串之后，也可以实现字符串与日期之间的格式化显示。

**范例：将日期转为Date。**

```java
package 日期操作类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 日期格式化 {
    public static void main(String[] args) throws ParseException {
        String birthday = "1999-10-1 8:8:8:888";  // 字符串日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Date date = sdf.parse(birthday);
        System.out.println(date);
    }
}
```

当日期的时间超出了合理时间，会自动进行进位处理。

**范例：进行数字的货币格式化。**

```java
package 日期操作类;

import java.text.NumberFormat;

public class 日期格式化 {
    public static void main(String[] args){
        double money = 1354843.24764;
        System.out.println(NumberFormat.getInstance().format(money));
    }
}
//1,354,843.248
```

这就是货币的格式化。**在此我们发现字符串可以和所有的类型进行相互的转换。**



### 十）正则表达式



#### 1. 认识正则



**范例：验证是否是数字**

```java
public static boolean isNumber(String str){
    for(int i=0; i<str.length(); i++){
        if (str.charAt(i)>'9' || str.charAt(i)<'0'){
            return false;
        }
    }
    return true;
}
```

一个简单的功能写了过多的代码。

**范例：使用正则表达式验证。**

```java
public static void main(String[] args) {
    String str = "123";
    if (str.matches("\\d+")){
        int num = Integer.parseInt(str);
        System.out.println(num);
    }
}
```

这里的正则表达式只用了一句话，就验证了是否是数字。

在JDK1.4之前，想要使用正则需要引入第三方包 *.jar，在JDK1.4之后，就可以直接使用了，并且提供了 java.util.regex，并且给String类提供了相应的支持——matches(regex)。

使用正则最大的特点在于方便进行验证处理，以及方便进行复杂字符串的修改处理。



#### 2. 使用正则标记（常背常用）

从JDK1.4开始提供有 java.util.regex 开发包，里面有一个 Pattern 匹配类。

- 字符匹配：数量单个。

  - 任意字符：表示由任意字符组成。

    ```java
    public static void main(String[] args) {
        String str = "a";  // 要判断的依据
        String regex = "a";// 正则规则
        String regex1 = "b";
        System.out.println(str.matches(regex));  // true
        System.out.println(str.matches(regex1));  // false
    }
    ```

  - \\\：匹配 “ \ "

  - \n：匹配换行

  - \t：匹配制表符

- 字符集：数量单个。

  - [abc]：可能是字母abc中的任意一个。

    ```java
    String str = "a";  // 要判断的依据
    String regex = "[abc]";// 正则规则
    System.out.println(str.matches(regex));  // true
    ```

  - [^abc]：除了abc的其他字符。

    ```java
    String str = "a";  // 要判断的依据
    String regex = "[^abc]";// 正则规则
    System.out.println(str.matches(regex));  // false
    ```

  - [a-zA-Z]：表示所有字母中的任意一个。

    ```java
    String str = "1";  // 要判断的依据
    String regex = "[a-zA-Z]";// 正则规则
    System.out.println(str.matches(regex));  // false
    ```

  - [0-9]：表示由一个数字组成。

    ```java
    String str = "1";  // 要判断的依据
    String regex = "[0-9]";// 正则规则
    System.out.println(str.matches(regex)); // true
    ```

- 简化的字符集：数量单个。

  - ' . ' ：表示任意的一个字符。

    ```java
    String str = "1";  // 要判断的依据
    String str1 = "a";  // 要判断的依据
    String regex = ".";// 正则规则
    System.out.println(str.matches(regex)); // true
    System.out.println(str1.matches(regex)); // true
    ```

  - ' \d '：等价于 [0-9]。

    ```java
    String str = "1";  // 要判断的依据
    String regex = "\\d";// 正则规则
    System.out.println(str.matches(regex)); // true
    ```

  - ' \D '：等价于 [\^0-9]。

  - ' \s '：匹配任一空白字符。（空格、换行、制表符）

    ```java
    String str = "a\t";  // 要判断的依据
    String regex = "\\D\s";// 正则规则
    System.out.println(str.matches(regex)); // true
    ```

  - ' \S ' ：匹配任意非空白字符。

  - ' \w '：匹配字母、数字、下划线，等价于[a-zA-Z_0-9]。

  - ' \W '：等价于 [\^a-zA-Z_0-9]



- 边界匹配：
  - ^：匹配边界开始。
  - $：匹配边界结束。



- 数量表达：默认情况下只有添加了数量单位才可以匹配多位字符。

  - 表达式 ?：该正则可以出现 0次 或 1次。
  - 表达式 *：该正则可以出现 0-n 次。
  - 表达式 +：该正则可以出现 1-n 次。

  ```java
  String str = "asd";
  String regex = "\\w*";
  System.out.println(str.matches(regex)); // true
  ```

  - 表达式 {n}：表达式必须出现 n 次 。
  - 表达式 {n,}：表达式出现 n 次以上。
  - 表达式 {n,m}：表达式出现 n-m 次。



- 逻辑表达式：可以连接多个正则。

  - 表达式X表达式Y：X表达式之后紧跟着Y表达式。

    ```java
    String str = "a15";
    String regex = "[a-z][0-9]*";
    System.out.println(str.matches(regex)); // true
    ```

  - 表达式X|表达式Y：表达式X或者表达式Y一个成立即可。

  - （表达式）：为表达式设置一个整体描述，可以为整体描述设置数量单位。

    ```java
    package 正则表达式;
    
    public class 正则标记 {
        public static void main(String[] args) {
            String str = "a15";
            String regex = "([a-z][0-9])*";
            System.out.println(str.matches(regex)); // false：因为regex是字母数字配对出现，但是str多了一个数字没有配对字母
        }
    }
    ```



#### 3. Regex包

在 java.util.regex 包里面有两个类：Pattern（正则表达式编译）和Matcher（匹配）。



- Pattern类：提供有正则表达式的编译处理。`public static Pattern compile(String regex);`

  同时也提供有字符串的拆分功能： `public String[] split(CharSequence input) ;`

```java
package 正则表达式;

import java.util.regex.Pattern;

public class Regex包 {
    public static void main(String[] args) {
        String str = "as1D35w43d13S5Dw31d351DSD";
        String regex = "[^a-zA-Z]+";  // +：有多位非字母算一位
        Pattern pattern = Pattern.compile(regex);  // 编译正则
        String[] split = pattern.split(str);  // 拆分
        for (int x=0; x<split.length; x++){
            System.out.println(split[x]);
        }
    }
}
```



- Matcher类：实现了正则匹配的处理类，这个类的对象实例化依靠Pattern类完成。
  - Pattern类提供过的方法：`public Matcher matcher(CharSequence input) ;`
  - 获取了Matcher类之后，可以进行如下操作：
    - 匹配： `public boolean matches() ;`
    - 替换：`public String replaceAll(String replacement) ;`

**范例：字符串的匹配。**

```java
package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex包 {
    public static void main(String[] args) {
        String str = "101";
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.matches());  // true
    }
}
```

```java
package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex包 {
    public static void main(String[] args) {
        String str = "10AD1S3AD13AW5D1C1";
        String regex = "\\D+";  // 匹配所有非数字然后换成空串
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.replaceAll(""));  // true
    }
}
```



如果以拆分、替换、匹配三种方式，用不到 java.util.regex 开发包，只用 String 类就能实现。

但是Matcher类里面提供有分组的功能，这个功能是String做不到的。

```java
package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex包 {
    public static void main(String[] args) {
        String str = "insert into dept(deptno, dname, loc) values (#{deptno}, #{dname}, #{loc})";
        String regex = "#\\{\\w+\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            System.out.println(matcher.group(0).replaceAll("#|\\{|\\}",""));
        }
    }
}
```



### 十一）国际化程序实现

指的是同一个程序代码可以根据不同的国家实现不同的语言描述，但是程序处理的核心逻辑是相同的。

**国际化问题简介：**

​		现在假设有一款知名的世界管理平台，现在老板决定将这个产品推广到各个上市公司（来自不同的国家）。

![image-20211101191218163](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211101191218163.png)

代码的底层逻辑 **B** 是不变的，有变化的是根据不同的国家区域编码，获取不同的资源文字文件，进行不同国家语言的文字信息加载。

通过分析之后发现，如果要想实现国际化的程序设计，那么需要解决以下两点问题：

- 如何可以定义保存文字的文件信息？（对应文字资源）
- 如何根据不同的区域语言编码读取指定的文件信息？



#### 1. Locale类

Locale-->译为 "语言环境"。属于 java.util.Locale。

Locale专门描述区域和语言编码的类。

```java
// 构造方法
public Locale(String language);
public Locale(String language, String country);
// 中国的代码：zh_CN
// 美国的代码：en_US
```

对于一个国家的代码，可以通过IE浏览器获得：

<img src="C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211101191947427.png" alt="image-20211101191947427" style="zoom:67%;" />

**范例：实例化Locale类对象。**

```java
package 国际化程序实现;

import java.util.Locale;

public class 实例化Locale {
    public static void main(String[] args) {
        Locale localeChina = new Locale("zh", "CN");  // 中文环境
        System.out.println(localeChina);
    }
}
```

这种描述的是手工选择语言文字。

如果现在想要自动获得当前运行的环境，可以利用Locale类本身默认的方式进行实例化。

```java
public static Locale getDefault();
```

```java
package 国际化程序实现;

import java.util.Locale;

public class 实例化Locale {
    public static void main(String[] args) {
//        Locale localeChina = new Locale("zh", "CN");  // 中文环境
        Locale localeChina = Locale.getDefault();
        System.out.println(localeChina);
    }
}
```

在实际的开发过程之中，我们并不关心国家和语言的编码，所以为了简化开发，Locale类也将世界上一些著名的国家**设置为常量。**

```java
package 国际化程序实现;

import java.util.Locale;

public class 实例化Locale {
    public static void main(String[] args) {
//        Locale localeChina = new Locale("zh", "CN");  // 中文环境
//        Locale localeChina = Locale.getDefault();
        Locale localeChina = Locale.CHINA; 
        System.out.println(localeChina);
    }
}
```

**使用常量的好处是避免了区域信息的繁琐。**



#### 2. 读取资源文件ResourceBundle

属于：java.util.ResourceBundle类。

此类定义如下：

```java
public abstract class ResourceBundle extends Object; 
```

可以利用该类提供的静态方法获取类实例，或者子类。

```java
public static final ResourceBundle getBundle(String baseName);
```

- baseName：描述的是资源文件的名称，但是没有后缀（**国际化程序实现**）。
- 根据 key 读取资源内容：`public final String getString(String key) ;`

**范例：使用ResourceBundle类读取内容。**

```java
package 国际化程序实现;

import java.util.ResourceBundle;

public class ResourceBundle类 {
    public static void main(String[] args) {
        // 文件名称必须为后缀，是因为读取的时候不需要加入文件后缀
        ResourceBundle resource = ResourceBundle.getBundle("国际化程序实现.messages");
        String info = resource.getString("name");
        System.out.println(info);
    }
}
// 在“国际化程序实现”包下有一个“messages”的“properties”文件。
```

如果资源没有在包里面，我们直接编写资源名称即可。

```java
package 国际化程序实现;

import java.util.ResourceBundle;

public class ResourceBundle类 {
    public static void main(String[] args) {
        // 文件路径必须为参数，可以在读取的时候不需要加入文件后缀
        ResourceBundle resource = ResourceBundle.getBundle("messages2");
        String info = resource.getString("name");
        System.out.println(info);
    }
}
// messages2在根包目录下
```

资源文件没有找到的时候：

```java
Exception in thread "main" java.util.MissingResourceException: Can't find bundle for base name messages3, locale zh_CN
	at java.base/java.util.ResourceBundle.throwMissingResourceException(ResourceBundle.java:2045)
	at java.base/java.util.ResourceBundle.getBundleImpl(ResourceBundle.java:1683)
	at java.base/java.util.ResourceBundle.getBundleImpl(ResourceBundle.java:1586)
	at java.base/java.util.ResourceBundle.getBundleImpl(ResourceBundle.java:1549)
	at java.base/java.util.ResourceBundle.getBundle(ResourceBundle.java:858)
	at 国际化程序实现.ResourceBundle类.main(ResourceBundle类.java:8)
```

**在进行资源读取的时候，如果key不存在，资源找对了，那么会出现以下异常信息：**

```java
Exception in thread "main" java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key key
	at java.base/java.util.ResourceBundle.getObject(ResourceBundle.java:564)
	at java.base/java.util.ResourceBundle.getString(ResourceBundle.java:521)
	at 国际化程序实现.ResourceBundle类.main(ResourceBundle类.java:9)
```



#### 3. 实现国际化程序

前期准备已经就绪：依靠资源文件、依靠Locale、ResourceBundle类。那么实现国际化程序设计。（关键：读取资源信息）

1. 在CLASSPATH下建立：`国际化程序实现.properties.Messages_zh_CN.properties`（中文资源）

```properties
info = 欢迎您的访问！
```

2. 在CLASSPATH下建立：`国际化程序实现.properties.Messages_en_US.properties`（英文资源）

```properties
info = welcome!
```

现在加上没有默认的区域文件，一共定义了三个资源文件：

![image-20211101200741750](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211101200741750.png)

3. 通过程序进行指定区域的资源信息加载。

```java
package 国际化程序实现;

import java.util.ResourceBundle;

public class JavaLocaleDemo {
    public static void main(String[] args) {
        ResourceBundle resource = ResourceBundle.getBundle("国际化程序实现.properties.Messages");
        String info = resource.getString("info");
        System.out.println(info);
    }
}
// input:欢迎您的到来！我的公主殿下！
```

这里我们没有指定明确的Locale对象，但是这里默认读取了"Messages_zh_CN"文件资源。

```java
@CallerSensitive
public static final ResourceBundle getBundle(String baseName){
    Class<?> caller = Reflection.getCallerClass();
    return getBundleImpl(baseName, Locale.getDefault(),
                         caller, getDefaultControl(caller, baseName));
}
```

这个*baseName*其实是我们文件资源的一个基本前缀。**源码中也是获取的当前的语言环境。**

4. 如果有需要，也可以修改当前的Locale环境，可以使用ResourceBundle类中的如下方法：

- 获取ResourceBundle对象：`public static final ResourceBundle getBundle(String baseName, Locale locale) ;`

```java
package 国际化程序实现;

import java.util.Locale;
import java.util.ResourceBundle;

public class JavaLocaleDemo {
    public static void main(String[] args) {
        Locale locale = Locale.US;  // 可以根据不同的语言环境，指定语言资源访问和接收
        ResourceBundle resource = ResourceBundle.getBundle("国际化程序实现.properties.Messages", locale);
        String info = resource.getString("info");
        System.out.println(info);
    }
}
```

当指定的语言环境没有对应的资源文件，会读取本地的语言环境的资源文件，如果本地的语言资源都没有的话，就会读取公共资源，也就是没有区域设置的资源：**指定语言文件资源 > 本地语言资源文件 > 没有区域设置的资源文件**。



#### 4. 消息格式化

如果某一位用户登录成功，会显示这样的信息：“XXX，欢迎您的光临！”，也就是说这个时候会显示用户名，这个内容如果保存在资源文件里面，则需要占位符进行描述，同时对于读取出来的数据进行消息格式化处理。

**范例：修改资源文件。**

| 【中文资源】：'国际化程序实现.properties.Messages_zh_CN.properties' | info = 欢迎{0}的到来！我的公主殿下！日期：{1}。 |
| :----------------------------------------------------------- | :---------------------------------------------- |
| **【英文资源】：'国际化程序实现.properties.Messages_en_US.properties'** | **info = welcome：{0}！date：{1}**              |

如果有需要则可以继续添加占位符“{1}，{2}，...”之类的内容。

如果进行资源信息的读取，会将占位符一起读取出来，所以需要MessageFormat类进行格式化处理。

<img src="C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211101202621903.png" alt="image-20211101202621903" style="zoom:67%;" />

MessageFormat的方法：`public static String format(String pattern, Object... arguments) ;`

```java
package 国际化程序实现;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class 消息格式化 {
    public static void main(String[] args) {
        Locale locale = Locale.CHINA;
        ResourceBundle resource = ResourceBundle.getBundle("国际化程序实现.properties.Messages", locale);
        String info = resource.getString("info");
        // 前面传入需要格式化处理的字符串
        // 后面传入对应{0}，{1}等占位符的数值
        System.out.println(MessageFormat.format(info, "mldn", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
    }
}
```

如果在日后的资源中看到 "{0}、{1}"之类的，一定都是格式化处理的占位符处理。



### 十二）开发支持类库



#### 1. UUID类

UUID是一种生成无重复字符串的程序类，是根据时间戳自动生成无重复的字符串。

一般在获取UUID的时候，往往都是随机生成的内容。

- `public static UUID randomUUID() ;`
- `public static UUID fromString(String str) ;`

**范例：生成使用UUID。**

```java
package 开发支持类库;

import java.util.UUID;

public class UUID类 {
    public static void main(String[] args) {
        UUID uid = UUID.randomUUID();
        System.out.println(uid.toString());
    }
}
```

在对文件进行自动命名处理的情况下，UUID非常好用。



#### 2. Optional类

Optional类的主要功能是进行null的相关处理，在以前的程序开发的时候，为了防止程序出现空指向异常，往往会追加空的验证。

**范例：有可能出现空指向。**

```java
package 开发支持类库;


public class Optional类 {
    public static void main(String[] args) {
//        MessageUtil.useMessage(null);  // NullPointerException
        MessageUtil.useMessage(MessageUtil.getMessage());
    }
}

class MessageUtil{
    private MessageUtil(){}
    public static IMessage getMessage(){
        return new MessageImpl();
    }
    public static void useMessage(IMessage msg){
        if (msg!=null) {
            System.out.println(msg.getContent());  // 有可能因为空导致空指向
        }
    }
}

interface IMessage{
    public String getContent();
}
class MessageImpl implements IMessage{

    @Override
    public String getContent() {
        return "mldn.cn";
    }
}
```

在引用传递的一方，我们往往都是被动的进行判断。所以为了解决这种被动的处理操作，Java类中提供Optional（JDK1.8之后），可以实现null的处理操作。在这个类中有如下常用操作：

- 返回空数据：`public static <T> Optional<T> empty() ;`
- 获取数据：`public T get() ;`
- 保存数据，但是不允许出现null：`public static <T> Opitonal<T> of(T value) ;`  --> 否则会抛出空指针异常。
- 保存数据，允许为空：`public static <T> Opitonal<T> ofNullable(T value) ;`
- 空的时候，返回其他数据：`public T orElse(T other) ;`

<img src="C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211102105055843.png" alt="image-20211102105055843" style="zoom:67%;" />

**范例：修改程序，按照正规结构完成。**

```java
package 开发支持类库;


import java.util.Optional;

public class Optional类 {
    public static void main(String[] args) {
//        MessageUtil.useMessage(null);  // NullPointerException
        IMessage temp = MessageUtil.getMessage().get();
        MessageUtil.useMessage(temp);
    }
}

class MessageUtil{
    private MessageUtil(){}

    public static Optional<IMessage> getMessage(){
        return Optional.of(new MessageImpl());
    }
    public static void useMessage(IMessage msg){
        if (msg!=null) {
            System.out.println(msg.getContent());  // 有可能因为空导致空指向
        }
    }
}

interface IMessage{
    public String getContent();
}
class MessageImpl implements IMessage{

    @Override
    public String getContent() {
        return "mldn.cn";
    }
}
```

如果现在保存的数据是空，就会在保存处出现异常。

![image-20211102105400751](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211102105400751.png)

```java
Exception in thread "main" java.lang.NullPointerException
	at java.base/java.util.Objects.requireNonNull(Objects.java:208)
	at java.base/java.util.Optional.of(Optional.java:113)
	at 开发支持类库.MessageUtil.getMessage(Optional类.java:18)  // 异常位置
	at 开发支持类库.Optional类.main(Optional类.java:9)
```

有Optional可以明确的表示我们的对象不为null。

由于Optional中允许有null的内容，所以在获取数据的时候也可以进行null的处理。

**范例：处理 null。**

```java
package 开发支持类库;


import java.util.Optional;

public class Optional类 {
    public static void main(String[] args) {
//        MessageUtil.useMessage(null);  // NullPointerException
        IMessage temp = MessageUtil.getMessage().get();
        MessageUtil.useMessage(temp);
    }
}

class MessageUtil{
    private MessageUtil(){}

    public static Optional<IMessage> getMessage(){
        return Optional.ofNullable(null);
    }
    public static void useMessage(IMessage msg){
        if (msg!=null) {
            System.out.println(msg.getContent());  // 有可能因为空导致空指向
        }
    }
}

interface IMessage{
    public String getContent();
}
class MessageImpl implements IMessage{

    @Override
    public String getContent() {
        return "mldn.cn";
    }
}
```

如果用 ofNullable 处理 null 的时候，在 get 会出现异常信息：NoSuchElementException。所以此时可以更换 orElse 方法。

```java
package 开发支持类库;


import java.util.Optional;

public class Optional类 {
    public static void main(String[] args) {
//        MessageUtil.useMessage(null);  // NullPointerException
        IMessage temp = MessageUtil.getMessage().orElse(new MessageImpl());
        MessageUtil.useMessage(temp);
    }
}

class MessageUtil{
    private MessageUtil(){}

    public static Optional<IMessage> getMessage(){
        return Optional.ofNullable(null);
    }
    public static void useMessage(IMessage msg){
        if (msg!=null) {
            System.out.println(msg.getContent());  // 有可能因为空导致空指向
        }
    }
}

interface IMessage{
    public String getContent();
}
class MessageImpl implements IMessage{

    @Override
    public String getContent() {
        return "mldn.cn";
    }
}
```

在所有引用数据类型的操作处理之中，null是一个重要的技术问题，所以JDK1.8提供的Optional类是一个非常重要且使用频繁的类。



#### 3. ThreadLocal类

**范例：编写一个简单的程序。定义下面这样的结构。**

```java
package 开发支持类库;

public class ThreadLocal类 {
    public static void main(String[] args) {
        Message msg = new Message();
        msg.setInfo("www.mldn.cn");
        Channel.setMessage(msg);
        Channel.send();
    }
}

class Channel{  // 消息发送的通道
    private static Message message;
    private Channel(){}
    public static void setMessage(Message m){
        message = m;
    }
    public static void send(){
        System.out.println("【消息发送】：" + message.getInfo());
    }
}

class Message{  // 要发生的消息体
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
```

对于当前的程序，实际上采用的单线程的模式处理的。

![image-20211102114637843](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211102114637843.png)

如果在多线程的状态下，能否实现完全一致的操作效果？

**范例：多线程的影响。**

```java
package 开发支持类库;

public class ThreadLocal类 {
    public static void main(String[] args) {
        int x=0;
        for (; x<3; x++) {
            new Thread(()->{
                Message msg = new Message();
                msg.setInfo("第"+Thread.currentThread().getId()+"发送消息");
                Channel.setMessage(msg);
                Channel.send();
            }, "消息发送者："+(char)(x+'A')).start();
        }
    }
}

class Channel{  // 消息发送的通道
    private static Message message;
    private Channel(){}
    public static void setMessage(Message m){
        message = m;
    }
    public static void send(){
        System.out.println("【"+Thread.currentThread().getName()+" 消息发送】：" + message.getInfo());
    }
}

class Message{  // 要发生的消息体
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
/**
【消息发送者：A 消息发送】：第16发送消息
【消息发送者：B 消息发送】：第17发送消息
【消息发送者：C 消息发送】：第16发送消息
*/
```

当有多个线程同时发送消息的时候，消息的处理产生了影响。由于Message是Channel里面的静态对象，那么在一个线程取了使用的时候，还没赋值，另一个线程来了，出现了不同步问题。

<img src="C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211102115715575.png" alt="image-20211102115715575" style="zoom:67%;" />

在保持Channel（所有发送的通道）核心结构不变的情况下，需要考虑到每个线程的独立操作问题。那么在这样的情况下，Channel除了需要保留有发送的消息之外，还应该存有每一个线程的标记。那么这个时候，就可以通过ThreadLocal类来存放数据。

在ThreadLocal类里面提供有如下方法：

- 构造方法：`public ThreadLocal() ;`
- 设置数据：`public void set(T value) ;`
- 取出数据：`public T get() ;`
- 删除数据：`public void remove() ;`

<img src="C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211102121033157.png" alt="image-20211102121033157" style="zoom:67%;" />

范例：解决线程同步问题。

```java
package 开发支持类库;

public class ThreadLocal类 {
    public static void main(String[] args) {
        int x=0;
        for (; x<3; x++) {
            new Thread(()->{
                Message msg = new Message();
                msg.setInfo("第"+Thread.currentThread().getId()+"发送消息");
                Channel.setMessage(msg);
                Channel.send();
            }, "消息发送者："+(char)(x+'A')).start();
        }
    }
}

class Channel{  // 消息发送的通道
    private static final ThreadLocal<Message> THREADLOCAL = new ThreadLocal<>();
    private Channel(){}
    public static void setMessage(Message m){
        THREADLOCAL.set(m);  // 向ThreadLocal中保留数据
    }
    public static void send(){
        System.out.println("【"+Thread.currentThread().getName()+" 消息发送】：" + THREADLOCAL.get().getInfo());
    }
}

class Message{  // 要发生的消息体
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
/**
【消息发送者：B 消息发送】：第17发送消息
【消息发送者：A 消息发送】：第16发送消息
【消息发送者：C 消息发送】：第18发送消息
*/
```

**ThreadLocal会对每一个到来的线程进行对象和数据保存，在多个线程访问的时候，相当于各自进入各自的隔间互不干扰，避免了线程不同步引起问题。**



#### 4. 定时调度——定时器

定时器的主要操作是进行定时任务的处理，就好比每天早上的闹钟。在Java中提供有定时任务处理，但是这种处理只是间隔触发的操作，比如上了十二个小时的闹钟，每几分钟叫一次。不能做定时的处理，比如每年的某年某月要执行某件事。

如果想实现定时处理，需要有定时操作的主体类，以及一个定时任务的控制，需要两个类：都是JDK1.3

- java.util.TimerTask类：定时任务处理。abstract，implements Runnable。
- java.util.Timer类：进行任务的启动。
  - 任务启动：`public void schedule (TimerTask task, long delay) ;` 延迟单位为ms，大部分都是ms，也可以指定Date。
  - 间隔触发：`public void scheduleAtFixedRate(TimerTask task, long delay, long period)`

**范例：实现定时任务处理。**

```java
package 开发支持类库;

import java.util.Timer;
import java.util.TimerTask;

public class 定时任务处理 {
    public static void main(String[] args) {
        Timer timer = new Timer();  // 初始化定时任务实例
//        timer.schedule(new MyTask(), 0);  // 不延迟
        timer.scheduleAtFixedRate(new MyTask(), 100, 1000); // 间隔触发
    }
}

class MyTask extends TimerTask{
    // 继承自Runnable
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "定时任务执行、当前时间：" + System.currentTimeMillis());
    }
}
```

![image-20211102122932737](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211102122932737.png)

这种定时是由JDK最原始的方式提供的支持，但是开发之中使用此类方式进行处理会非常复杂。（计算机成为第一大飞跃技术就是时钟器）



#### 5. Base64加密与解密

正常上加密基本上伴随着解密，所谓的加密和解密往往都需要一些规则。从JDK1.8开始，由Base64处理。有两个内部类：

- Base64.Encoder：加密处理类。
  - 加密处理：`public byte[] encode(byte[] src) ;`
- Base64.Decoder：解密处理类。
  - 解密处理：`public byte[] decode(String src) ;`

**范例：实现加密与解密操作**

```java
package 开发支持类库;

import java.util.Base64;

public class Base64类 {
    public static void main(String[] args) {
        String msg = "www.mldn.cn";
        String encode = new String(Base64.getEncoder().encode(msg.getBytes()));  // 加密
        System.out.println(encode);
        String decode = new String(Base64.getDecoder().decode(encode));
        System.out.println(decode);
    }
}
```

虽然Base64可以进行加密和解密，但是由于是一个公版的算法，所以并不安全，最好的做法是使用盐值操作。

```java
package 开发支持类库;

import java.util.Base64;

public class Base64类 {
    public static void main(String[] args) {
        String salt = "java";
        String msg = "www.mldn.cn" + "{" + salt + "}";
        String encode = new String(Base64.getEncoder().encode(msg.getBytes()));  // 加密
        System.out.println(encode);
        String decode = new String(Base64.getDecoder().decode(encode));
        System.out.println(decode);
    }
}
```

盐值毕竟是明文规定的，也不太安全。最好的做法是多次加密。

```java
package 开发支持类库;

import java.util.Base64;

public class Base64类 {
    public static void main(String[] args) {
        String salt = "java";
        String msg = "www.mldn.cn" + "{" + salt + "}";
        String encode = new String(Base64.getEncoder().encode(msg.getBytes()));  // 加密
        System.out.println(encode);
        String decode = new String(Base64.getDecoder().decode(encode));
        System.out.println(decode);
        String str = StringUtil.encode("www.mldn.cn");
        System.out.println(str);
        System.out.println(StringUtil.decode(str));
    }
}

class StringUtil{
    private static String salt = "java";  // 公共的盐值：不能修改！
    private static final int REPEAT = 5;  // 加密次数
    /**
     * 加密处理
     * @param str    要加密的字符串
     * @return       加密后的数据
     */
    public static String encode(String str){  // 加密处理
        String temp = str + "{" + salt + "}";
        byte[] data = temp.getBytes();
        for (int x=0; x<REPEAT; x++){
            data = Base64.getEncoder().encode(data);  // 重复加密
        }
        return new String(data);
    }

    /**
     * 解密处理
     * @param str  要解密的内容
     * @return     解密后的原始数据
     */
    public static String decode(String str){
        byte[] data = str.getBytes();
        for (int x=0; x<REPEAT; x++){
            data = Base64.getDecoder().decode(data);
        }
        return new String(data).replaceAll("\\{\\w+\\}", "");
    }
}
/*
d3d3Lm1sZG4uY257amF2YX0=   //1
www.mldn.cn{java}		   //2

// 3加密
VjJ0U1QyRXdNSGRsU0ZKT1YwVTFhRlZ1Y0ZOTlZtUlZVMVJHVDAxcldqQlZiWEJMVjJ4a1JWRlVhejA9
// 4解密
www.mldn.cn
*/
```

**范例：复杂加密操作——对盐值也进行加密。**

```java
private static String salt = new String(Base64.getEncoder().encode("java".getBytes()));  // 公共的盐值：不能修改！
```

最好的做法是使用2-3种加密程序，同时找到一些完全不可解的加密算法。





## 三、Servlet

![image-20211126084521168](C:\Users\18343\AppData\Roaming\Typora\typora-user-images\image-20211126084521168.png)

异步、线程不安全、速度快。



### 1. 什么是Servlet

Servlet是JavaWeb三大组件之一。属于动态资源，作用是处理请求，在Servlet中通常需要：

- 接收请求数据
- 处理请求
- 完成响应

Servlet需要我们自己编写，每个Servlet必须实现 javax.servlet.Servlet 接口，每个Servlet 都实现不一样的功能。



### 2. 实现Servlet的方式

实现Servlet的三种方式：

- 实现  javax.servlet.Servlet 接口。
- 继承 javax.servlet.GenericServlet 类。
- 继承 javax.servlet.http.HttpServlet 类。

通常我们会继承 HttpServlet 类来完成我们的 Servlet，比较方便。但是学习要从 javax.servlet.Servlet 接口开始学习。

```java
public interface Servlet{
    public void init(ServletConfig config) throws ServletException;
    public ServletConfig getServletConfig();
    public void service(ServletRequest req, ServletResponse res)
        throws ServletException, IOException;
    public String getServletInfo();
    public void destroy();
}
```

Servlet中的方法大多数不由我们来调用，而是由Tomcat(服务器)调用，并且Servlet的对象也不由我们创建，由Tomcat创建。

在web.xml中配置servlet，用于网络访问：

```xml
<servlet>
	<servlet-name>XXX</servlet-name>
    <servlet-class>类路径全名.AServlet</servlet-class>
</servlet>
<servlet-mapping>
	<servlet-name>XXX</servlet-name>
    <url-pattern>/xxx/xxx..(随便一个路径即可，和Servlet绑定在一起了)</url-pattern>
</servlet-mapping>
```



### 3. Servlet实现



**生命周期：**

- void init(ServletConfig)：出生之后，会后续做准备的方法	
- void service(ServletRequest req, ServletResponse res)：每次调用的时候
- void destroy()：关闭服务器之前，释放资源的方法



**特性：**

- 单例，一个类只有一个对象，当然可以存在多个Servlet类
- 线程不安全的，所以效率极高的



**Servlet类由我们写，但是对象由服务器创建，由服务器调用相应的方法。也就是我们负责设计过程，执行由服务器来做。**

**范例：**一个Servlet的实现类。

```java
package web;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 查看Servlet接口中的方法
 */
public class AServlet implements Servlet {
	// http://localhost:8080/web/AServlet
	
	/*
	 * 生命周期方法
	 * 它会在Servlet销毁之前调用，并且只会被执行一次。（临终之前）
	 * 服务器关闭的时候
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy...");
	}

	/*
	 * 获取Servlet的配置信息
	 */
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfig...");
		return null;
	}

	/*
	 * 获取Servlet的信息
	 */
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("getServletInfo...");
		return null;
	}
	
	/*
	 * 生命周期方法
	 * 会在Servlet对象创建之后，马上执行，并且只执行一次（出生之后）
	 * 第一次接收请求的时候
	 * 只有一个init，也就是Servlet是单例的。
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init...");
	}

	/*
	 * 生命周期方法
	 * 会被调用多次，每次处理请求都是在调用这个方法
	 * 每次访问这个Servlet的时候
	 */
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service...");
	}
}
```



### 4. 什么是 ServletConfig



一个ServletConfig对象，对应一段web.xml中Servlet的配置信息。

![image-20211126123821852](C:\Users\18343\Desktop\学习\md所需图片\9.jpg)

**API：**

- `String getServletName();  获取的是<servlet-name>里面的内容`
- `ServletContext getServletContext();  获取Servlet上下文对象`
- `String getInitParameter(String name);  通过名称获取指定参数的值`
- `Enumeration getInitParameterNames();  获取所有初始化参数的名称`



**ServletRequst：请求。**

获得请求数据、处理请求，对客户端进行响应。

<u>如何获取数据：</u>

所有数据都被 Config 分装到 ServletRequst 中，调用它的方法就能获得请求信息。

**ServletResponse：响应**。

调用它的方法才能设置响应头和状态码，甚至可以用它发送 html 代码，这时请求被发送到浏览器，浏览器才能打开。



### 5. GenericServlet

```Java
package web;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 模拟GenericServlet
 * @author 18343
 */
public class BServlet implements Servlet {
	
	private ServletConfig config;
	
	/*
	 * 需要就写，不需要就不写
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("我要是死了。。。");
	}

	/*
	 * 这个方法一定会在init方法之后被调用
	 */
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.config;
	}

	// 用处不大
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "我是一个快乐的Servlet";
	}
	
	/*
	 * 由Tomcat调用，并且只调用一次，是这些方法中第一个被调用的，会在构造器在之后马上被调用
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 初始化config
		this.config = config;
		init();
	}

	/*
	 * 这个方法是本类中自己定义的，不是Servlet的
	 */
	public void init() {
		
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("每次处理的请求都会被调用");
	}
	
	
	public ServletContext getServletContext() {
		return this.config.getServletContext();
	}
	
	public String getServletName() {
		return this.config.getServletName();
	}
	
	public String getInitParameter(String name) {
		return this.config.getInitParameter(name);
	}

}
```



### 6. HttpServlet

与Http协议相关。

主要用以下方法：

```java
protect void service(HttpServletRequest req, HttpServletResponse resp)
    	throws ServletException, IOException{}
```

上面这个方法也是和Http协议相关的。它不是生命周期，但是我们在使用生命周期的service的时候，这个service的参数会直接强转为上面这种，然后调用上面这个方法。看下图：

![image-20211130200706368](C:\Users\18343\Desktop\学习\md所需图片\10.png)



**时序图如下：**

![image-20211130201216522](C:\Users\18343\Desktop\学习\md所需图片\11.png)

405表示不支持该方式访问，因为我们服务器没有重写doGet或者doPost，那么客户端就无法通过这两种方式访问我们，尽管资源找到了

下面的Servlet，直接访问是GET方式，通过html的action访问，可以设置POST方式。

```java
package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost...");
	}
	
}
```

```html
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		This is my HTML page.<br>
		<!--
			action：相对路径
			访问这个html的时候，也是web/login.html
		-->
		<form action="/web/EServlet" method="POST">
			<input type="submit" value="提交">
		</form>
	</body>
</html>
```



### 7. Servlet细节

- 不要在Servlet中创建成员！创建局部变量即可！

  - 成员和变量的区别是位置不一样，成员是类的属性，局部变量是在方法里面定义的。

- 因为Servlet只有一个对象，且线程不安全，那么有多个线程来操作同一个对象的时候，容易出现数据错误。

- 可以创建无状态成员。

  ```
  无状态成员指的是这个成员内部没有别的属性。
  只能执行一些功能。
  ```

- 可以创建有状态的成员，但是成员的状态必须只能是只读(final、private)的。

  ```java
  public class Demo{
      private User user = new User();
      public User getUser(){
          return this.user;
      }
  }
  // final对于引用类型，只能保证不修改地址指向，但是地址里面的内容管不了
  // final可以限制普通类型
  ```



- Servlet可以在两个时间点被创建：

  - 在Servlet首次收到请求的时候被创建

  - 配置web.xml，让Servlet在服务器启动的时候就自动创建

    ```xml
    <servlet>
    	<load-on-startup>非负整数</load-on-startup>
        数字小的，优先级越高，不在mapping里面配置
    </servlet>
    ```



- url-pattern可以给出多个。

  ```xml
  <servlet-mapping>
  	<servlet-name>AServlet</servlet-name>
      <url-pattern>/AServlet</url-pattern>
      <url-pattern>/BServlet</url-pattern>
      可以让一个Servlet有多个路径访问到这个Servlet，涉及过滤器
  </servlet-mapping>
  ```

  - 还可以正在url-pattern里面用通配符 "*"。
  -  \* 在前面：扩展名匹配。/abc/de/g.do  == /a/v.do == *.do
  -  \* 在后面：路径匹配。/servlet/a  ==  /servlet/b  ==  /servlet/*
  - /* 匹配所有的url。
  - 当有多个匹配路径的时候，会优先匹配最清晰直白的路径，才会去匹配模糊路径
  - \* 只能放最前面或者最后面，不能放中间



### 8. web.xml 的了解

在JavaEE\conf\web.xml中的内容，相当于写到了每个项目的web.xml中。

```
在这个配置文件里面，有个servlet-name = default，他的优先级最低，在没有servlet执行的时候，他会显示执行404。
他的servlet-mapping的url-pattern是<url-pattern>\</url-pattern>，表示所有路径的根路径，优先级最低
```

session的过期时间：30分钟

```xml
<session-config>
	<session-timeout>30</session-timeout>
</session-config>
```

设置扩展名对应的类型：

```xml
<mime-mapping>
	<extension>txt</extension>
    <mime-type>text/plain</mime-type>
    这个指的是txt文本文件，对应的类型是text/plain
</mime-mapping>
```

这个web.xml里面还有配置jsp的映射和servlet，用于将jsp文件从动态文件转为静态文件。



### 9. Servlet和反射

服务端发送请求的时候，服务器收到请求过来的文件路径，然后去servlet-mapping通过路径拿到名字，然后用名字去servlet拿到类的路径的字符串，然后通过反射，使用字符串创建对应的Servlet的对象，然后执行。（但是反射的实现必须对应的类有无参构造方法）



### 10. ServletContext（重要）



#### 10.1 ServletContext概述

**一个项目只有一个ServletContext对象**！常戏称Application。

我们可以在N多个Servlet中来获取这个唯一的对象，使用它可以给多个Servlet传递数据！

所以称它为上下文对象，可以通过它给上下文传递共享数据，如果让Servlet互相调用，那么耦合过高。

- ServletContext对象是在服务器启动的时候创建，在服务器关闭的时候销毁。（与天地(tomcat)同寿！）



#### 10.2 获取ServletContext

HttpServlet是ServletConfig的子类的子类。

```java
this.getServletContext()
    == 
this.getServletConfig().getServletContext;
// 这两个是同一个ServletContext
```

不管怎样获得，都是通过ServletConfig类的getServletContext()获得的。

其他可以获得的类：HttpSession、ServletContextEvent。

- ServletConfig#getServletContext();
- GenericServlet#getServletContext();
- HttpSession#getServletContext();
- ServletContextEvent#getServletContext();



#### 10.3 演示ServletContext

域对象的作用：

- 必须要有存数据的功能；
- 必须要有取数据的功能；

```java
void setAttribute(String name, Object value);  // 用来存储一个对象，也可以称之为域属性，如果已经存在了name，会出现覆盖，性质和Map类似。

Object getAttribute(String name);  // 取数据，根据key取value

void removeAttribute(String name);  // 用来移除指定name的值，如果name不存在，则什么也不做

Enumeration getAttributeNames(); // 获取所有域属性的名称
```



```JAVA
package web2;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 演示从ServletContext中取数据
 */
@WebServlet("/BServlet")
public class BServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 获取ServletContext对象
		 * 2. 调用getAttribute()方法
		 */
		ServletContext application = this.getServletContext();
		String name = (String) application.getAttribute("name");
		System.out.println(name);
	}

}
```

```JAVA
package web2;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 演示向ServletContext中保存数据
 */
@WebServlet("/AServlet")
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 	1. 获取ServletContext对象
		 *  2. 调用其setAttribute()方法保存数据
		 */
		ServletContext application = this.getServletContext();
		application.setAttribute("name", "张三");
	}

}
```



#### 10.4 获取应用初始化参数

- Servlet也可以获取初始化参数，但他是局部的参数；也就是说，一个Servlet只能获取自己的初始化参数，不能获取别人的初始化参数，即每个初始化参数都是当前Servlet独有的。
- 可以配置公共的初始化参数，让所有的Servlet都可以使用，这需要使用ServletContext才能获取。

```xml
<context-param>
	<param-name>context-name</param-name>
    <param-value>context-value</param-value>
    <!--这个是直接放在根标签下，不是在哪个Servlet里面-->
</context-param>
```

```java
package web2;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取公共的初始化参数
 */
@WebServlet("/CServlet")  // 我没有配置web.xml，这个注解直接自动帮我配置了
public class CServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext app = this.getServletContext();
		String value = app.getInitParameter("context-name");
		System.out.println(value);
	}

}
```



#### 10.5 获取资源相关信息

- 获取资源的绝对路径，包括盘符

```java
package web2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用ServletContext获取资源路径
 */
@WebServlet("/DServlet")
public class DServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 它会得到一个有盘符的路径
		 */
		String path = this.getServletContext().getRealPath("/index.jsp");
		System.out.println(path);
	}

}
```



- 获取指定路径下的流数据对象。

```java
package web2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用ServletContext获取资源路径
 */
@WebServlet("/DServlet")
public class DServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 它会得到一个有盘符的路径
		 */
		String path = this.getServletContext().getRealPath("/index.jsp");
		System.out.println(path);
		
		/*
		 * 获取资源的路径后，再创建流数据对象
		 */
//		InputStream in = new FileInputStream(path);
		// 一句话做了两名两句话的事儿
		InputStream in = this.getServletContext().getResourceAsStream("/index.jsp");
		System.out.println(in);
	}

}
```



- 获取一个路径下的所有文件路径

```java
package web2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用ServletContext获取资源路径
 */
@WebServlet("/DServlet")
public class DServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 它会得到一个有盘符的路径
		 */
		String path = this.getServletContext().getRealPath("/index.jsp");
		System.out.println(path);
		
		/*
		 * 获取资源的路径后，再创建流数据对象
		 */
//		InputStream in = new FileInputStream(path);
		// 一句话做了两名两句话的事儿
		InputStream in = this.getServletContext().getResourceAsStream("/index.jsp");
		System.out.println(in);
		
		/*
		 * 获取当前路径下的所有资源的路径，不会递归获取文件夹里面的东西
		 */
		Set<String> paths = this.getServletContext().getResourcePaths("/WEB-INFO");
		System.out.println(paths);
	}

}
```



### 11.  网站访问量统计小案例

**一个项目所有的资源被访问的时候都要对访问量进行累加。**

那么我们可以把这个放在一个所有Servlet都可以访问到的域里面——创建一个int类型来记录访问量，然后把它保存到ServletContext的域中，可以保证所有的Servlet都能访问到，并且生命周期也足够长，与天地同寿啊不是！

- 最初时，ServletContext中没有保存访问量相关的属性；
- 当本站第一次被访问的时候，创建一个变量，初始化值为1，保存到ServletContext里面，以后的访问都对这个变量进行++。

```java
package web2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 记录访问量
 */
@WebServlet("/EServlet")
public class EServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 获取ServletContext对象
		 * 2. 从ServletContext对象里面获取count属性
		 * 3. 如果是第一次访问，count肯定没有，赋值为1
		 * 4. 否则count++
		 */
		ServletContext app = this.getServletContext();
		Integer count = (Integer) app.getAttribute("count");
		if(count==null) {
			app.setAttribute("count", 1);
			count = (Integer) app.getAttribute("count");
		}else {
			app.setAttribute("count", count+1);
		}
		/*
		 * 向浏览器输出：需要使用响应对象！
		 */
		PrintWriter pw = response.getWriter();
		pw.print("<h1>"+count+"</h1>");
	}

}
```



### 12. 获取类路径下的资源

获取类路径资源，类路径对一个JavaWeb项目而言，就是 /WEB-INF/classes 和 /WEB-INF/lib 的每个 jar 包。

代码如下：不过一直获取失败！！！

```java
package web2;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * 演示获取类路径下的资源
 */
@WebServlet("/FServlet")
public class FServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 得到ClassLoader
		 * 	> 先得到class，再得到ClassLoader
		 * 2. 调用其getResourceAsStream()，得到一个InputStream
		 */
		// 类加载器的相对路径是src
//		ClassLoader cl = this.getClass().getClassLoader();
//		InputStream is = cl.getResourceAsStream("a.txt");
		// 也可以写src路径下的相对路径
		
		// 也可以用class取，相对路径是相对于.class的路径
		// 找不到文件：500响应码
		Class c = this.getClass();
		InputStream is = c.getResourceAsStream("a2.txt");
		
		// 相对classes下
//		InputStream is = c.getResourceAsStream("/a.txt");
		
		//  /../../..  可以通过两个点不断往回走
		// 这个toString已经被过期了
		String s = IOUtils.toString(is);
		System.out.println(s);
	}
}
```



### 13. BaseServlet

1. 希望在一个Servlet中可以有多个请求处理方法。如：

   ```java
   class UserServlet{
       public void addUser();
       public void updateUser();
       public void deleteUser();
   }
   
   /*
   	domain:User
   	dao:UserDao
   	service:UserService
   	servlet:UserServlet
   */
   ```

2. 客户端发送给请求的时候，必须多给出一个参数，说明要调用的方法

   ```java
   void service(ServletRequest, ServletResponse)
   	throws IOException, ServletException {
       在这里让它去调用其他方法;
       要求：用户在发出请求时，必须给出一个参数，来说明要调用哪一个方法;
       获取参数，通过参数名字来确定要调用的方法;
       // http://localhost:8080/xxx/AServlet?m=addUser
   }
   ```

**请求处理方法的签名必须与service相同，即返回值、参数以及声明的异常都必须相同。**

3. 客户端必须传名为method的参数。（**参数名随意，但是必须是双方规定的一个规范**）

其他的Servlet在调用方法的时候，直接继承BaseServlet类，就可以通过反射，直接调用类。

**==GServlet==**

```java
package web2;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 在这里给出多个请求处理方式
 * 请求处理方式：除了名称以外，都与service方法相同
 */
public class GServlet extends BaseServlet {

	public void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("addUser...");
		throw new RuntimeException("测试一下");
	}
	
	public void editUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("editUser...");
	}
	
	public void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("deleteUser...");
	}
	
	public void loadUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("loadUser...");
	}
}
```

**==HServlet==**：添加了消息转发和重定向功能，并在BaseServlet里面进行了封装

```java
package web2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public String fun1(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("fun1()...");
		// 消息转发
//		req.getRequestDispatcher("/XXX").forward(req, resp);
		// 重定向
//		resp.sendRedirect(req.getContextPath() + "/xxx.jsp");
		// 上面着两个如果每个方法都要执行，会比较麻烦且冗长
//		return "forward:/index.jsp";  // 表示我要转发的消息
		// 在没有前缀f或者r的时候,就决定一个默认值--转发(假设转发多)
		return "f:/index.jsp";
	}
	
	public String fun2(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("fun2()...");
//		return "redirect:/index.jsp";  // 重定向的消息
		return "r:/index.jsp";
	}
	
	public String fun3(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("fun3()...");
//		return "download:/WEB-INF/files/a.jpg";  // 需要下载对应文件
		return null;  // null表示啥也不干
	}
	
	public String fun4(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("fun4()...");
		return "d:/WEB-INF/files/a.jpg";  // 需要下载对应文件
	}
}
```

**==BaseServlet==**：基础类，封装了反射调用方法，和重定向、消息转发，增强了复用性，减少了代码冗余。

```java
package web2;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1. 获取参数，用来识别用户想请求的方法
		 */
		String methodName = req.getParameter("method");
		
		if(methodName == null || methodName.trim().equals("")) {
			throw new RuntimeException("您没有传递参数！无法确定您想要的方法！");
		}
		
		// 每多一个方法，都要加一个，比较麻烦，而且这个代码不能重用，如果换了别的类，就需要全部修改
//		if(methodName.equals("addUser")) {
//			addUser(req, resp);
//		}else if(methodName.equals("editUser")) {
//			editUser(req, resp);
//		}else if(methodName.equals("deleteUser")) {
//			deleteUser(req, resp);
//		}
		
		// 通过反射的方式，用字符串得到方法
		/*
		 * 1. 得到方法名，得到Method对象
		 * 	 * 得到当前类的class对象，通过class对象得到Method方法
		 */
		Class<? extends BaseServlet> c = this.getClass();
		Method method = null;
		try {
			 method = c.getMethod(methodName,   // 前面穿参数名字，后面传参数类型的class
					HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("您要调用的方法："+methodName+" 不存在！");
		}
		/*
		 * 调用Method表示的方法
		 */
		try {
			// 正常调用：this.addUser(req, resp)
			// 反射调用：method(addUser, req, resp)
			String result = (String)method.invoke(this, req, resp);  // 执行调用的方法！！！！！！
			
            /*
			 * 获取请求处理方法执行后返回的字符串,它表示转发或重定向的路径
			 * 并且帮他完成转发或者重定向
			 * 分割字符串,得到前缀和后缀,前缀如果是f表示转发,如果是r表示重定向
			 * 后缀表示转发或重定向的路径
			 */
			if(result!=null) {
				if(result.contains(":")) {
					String[] strings = result.split(":");
					if(strings[0].equals("f")) {
						req.getRequestDispatcher(strings[1]).forward(req, resp);
					}else if(strings[0].equals("r")) {
						resp.sendRedirect(strings[1]);
					}else {
						throw new RuntimeException("你指定的操作:"+strings[0]+",暂不支持!");
					}
				}else {  // 默认转发
					req.getRequestDispatcher(result).forward(req, resp);
				}
			}
            
		} catch (Exception e) {
			System.out.println("您调用的方法："+methodName+" 内部抛出了异常！");
			System.out.println("------------------------------------");
			throw new RuntimeException(e);
		}
	}
}
```

**消息转发**

![image-20211205161821137](C:\Users\18343\Desktop\学习\md所需图片\12.png)

**重定向**

![image-20211205161916021](C:\Users\18343\Desktop\学习\md所需图片\13.png)



## 四、XML



### 1. XML简介

**eXtensible Markup Language**：可扩展标记型语言

- 用标签来操作。（和html一样）
- 可扩展的：
  - html的标签是固定的，每个都有固定的含义
  - 标签可以自己定义，也可以是中文的。\<person>\</person> 、<猫></猫>
- XML用途：
  - html是用于显示数据，xml也可以显示数据（不是主要功能）
  - xml主要功能是为了存储数据，可以理解为小型的数据库，模拟数据库的效果
- XML是W3C发布的技术，目前有两个版本：1.0   1.1
  - 目前使用的都是1.0的版本
  - 因为1.1的版本不能向下兼容



### 2. XML的应用

- 不同的系统之间进行数据传输

  - 比如QQ之间的数据传输，以图来显示：

    ![image-20211205163710164](C:\Users\18343\Desktop\学习\md所需图片\xml的QQ应用.png)

- 用于表示生活中有关系的数据

  ![image-20211205164027489](C:\Users\18343\Desktop\学习\md所需图片\XML的生活中的应用.png)

  ![image-20211205164124787](C:\Users\18343\Desktop\学习\md所需图片\XML的生活中的应用2.png)

- 经常用于配置文件

  - 比如现在链接数据库，需要知道数据库的用户名、密码、数据库名称等信息。
  - 如果我们需要修改数据库的信息，不需要修改源代码，只需要修改配置文件即可。



### 3. XML的语法

1. *****XML的文档声明

   - 创建一个文件，后缀名是 `.xml`。

   - 如果写 `xml`，第一步必须有一个文档声明（写了文档声明之后，表示写xml文件的内容）

     ```xml
     <?xml version="1.0" encoding="utf-8"?>
     <person>
     	<name>张三</name>
         <age>20</age>
     </person>
     ```

   - 文档声明必须写在第一行第一列——不能空行空格！！

   - 属性

     - version：xml的版本  1.0(使用)   1.1
     - encoding：xml的编码   gbk   utf-8    iso8859-1(不包含中文)
     - standalone：表示是否依赖于其他文件  yes/no

   - **中文乱码问题的解决：**

     - 文件保存到电脑的时候，默认使用的GBK

     - 打开文件的时候，使用的是我们设置的编码UTF-8编码

     - 由于编码格式不一样，所以导致了中文乱码问题

     - 只要让保存和设置的编码格式统一即可

       ![image-20211205170209866](C:\Users\18343\Desktop\学习\md所需图片\中文乱码问题.png)



2. *****XML中如何定义元素（标签）

   - 标签的定义，必须要有开始，也要有结束；\<person>\</person>

   - 标签没有内容，可以在标签内结束；\<person  />

   - 标签可以嵌套，但必须合理嵌套；

     - 合理嵌套：`<a><b></b></a>`
     - 不合理嵌套：`<a><b></a></b>`

   - 一个xml中，只能有一个根标签，其他标签都是这个标签下面的子标签

   - 在xml中，空格和换行都当作内容来解析，也就是下面两端代码的含义是不一样的：

     ```xml
     <网址>www.itcast.cn</网址>
     
     <网址>
     	www.itcast.cn    
     </网址>
     ```

   - xml中标签的名称规则：

     - xml是区分大小写的：\<a>、\<A>
     - 标签名称不能以数字和下划线(_)开头：\<1a>、\<\_a>  ❌
     - 不能以xml(XML、Xml等)开头：\<XMLa>、\<XmlB>、\<xmlC>  ❌
     - 不能包含空格和冒号：\<a b>、\<b:c>  ❌

   

3. *****XML中如何定义属性
   - html是标记型文档，有属性；xml是标记型文档，也有属性。
   - `<person id="aaa"></person>`
   - 属性定义的要求：
     - 一个标签上可以有多个属性：`<person id1="aaa" id2="bbb"></person>`
     - 属性名称必须唯一：`<person id="aaa" id="bbb"></person>`   ❌
     - 属性值可以用单引号或者双引号引起来，属性和属性值之间用等号。
     - **xml的属性命名规范和元素的规范是一致的。**



4. *****注释
   - 和HTML一样的注释：`<!-- 这是注释 -->`
   - 注意：
     - 注释是不能嵌套的！ `<!-- <!-- --> -->`   ❌  它会识别最接近的注释语句，而忽略的更外层的注释语句。
     - 注释也不能放在第一行！！



5. *****特殊字符

   - 如果在xml中使用 a<b，不能正常显示，因为把 < 当作了标签

     ```tex
     &lt; == <
     &gt; == >
     &ampl == &
     &quot; == "
     &apos; == '
     &nbsp; == 空格
     ```

     

6. CDATA区**（了解）**

   - CDATA区用于解决不断转义多个字符的情况，可以将这些放在一个区里面，就不用转义了

   - `if (a<b && b<c && d<e) {}`

   - 写法：

     ​	`<![CDATA[ 内容 ]]>`

     ​	`<![CDATA[<b>if (a<b && b<c && d<e) {}</b>]]>`

     相当于里面的内容当作普通文本进行解释了，没有当作标签解析。



7. 处理指令（PI指令）**（了解）**

   - 可以在xml中设置样式

   - 写法：`<?xml-stylesheet type="text/css" href="2.css"?>`

   - 引入我们写的css文件即可

     ```xml
     <?xml version="1.0" encoding="utf-8"?>
     <?xml-stylesheet type="text/css" href="2.css"?>
     <person>
     	<name>张三</name>
     	<age>20</age>
     	<![CDATA[<b>if (a<b && b<c && d<e) {}</b>]]>
     </person>
     ```

     ```css
     name{
     	background-color: red;
     }
     age{
     	background-color: green;
     }
     ```

   - PI设置样式只对英文标签名称起作用，对中文无效。

   - 我们一半也不用它显示数据，所以比较鸡肋。



**XML的语法总结**

- 所有XML元素都须有关闭标签
- XML标签对大小写敏感
- XML必须正确嵌套
- XML必须有且只能有一个根标签
- XML的属性值须加引号
- 特殊字符必须转义——或者用CDATA
- XML中的空格换行在解析的是会被保留



### 4. XML的约束

- 为什么需要约束？
  - 比如我们有个xml文件是放指定类型的信息，如果有别的类型的信息放进去，正常情况是可以放进去的。但是我们希望对这个文件进行约束，保证我们放进去的信息是我们想要的类型。这个时候我们就需要约束。
- xml的约束技术：DTD约束、Schema约束



### 5. DTD的快速入门

- 创建一个文件，后缀名是 `.dtd`。
- 步骤：
  - 看xml中有多少个元素，有几个标签元素在DTD元素，就写几个 `<!ELEMENT>`
  - 判断元素是简单元素还是复杂元素
    - 简单元素：没有子元素的 —— `<!ELEMENT 标签名称 (#PCDATA)>`
    - 复杂元素：有子元素的 —— `<!ELEMENT 标签名称 (子元素名称)>`

- 通过上面的步骤初始化为完毕DTD文件，现在在XML中引入DTD约束文件：`<!DOCTYPE 根元素名称 SYSTEM "DTD文件的路径">`

```dtd
<!ELEMENT Person (name, age)>
    <!ELEMENT name (#CDATA)>
    <!ELEMENT age (#CDATA)>
<!--1.dtd 文件——注意！！里面的名字也是区分大小写的-->
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE Person SYSTEM "/1.dtd">
<Person>
	<name>张三</name>
    <age>18</age>
</Person>
```

![image-20211206164831611](C:\Users\18343\Desktop\学习\md所需图片\DTD快速入门.png)

- 现在打开xml文件是使用浏览器打开的，但是浏览器不会去负责校验DTD约束，只是负责打卡并校验语法。
- 如果想要校验xml约束，需要使用工具（myeclipse工具）
  - 右键new一个xml文件
  - 第一次会进入 `design`模式，选择`source`模式就可以编写源代码了
  - 右键xml文件，点击 `open with` ，选择 `browser`，即可用浏览器打开
  - 加注释的快捷键：`ctrl+shift+/`
  - 校验方式：在xml文件里面如果出现了不符合dtd规则的标签，会出现错误提示。



### 6. DTD的三种引入方式

区分大小写且有空格。

- 引入外部DTD文件：`<!DOCTYPE 根元素名称 SYSTEM "DTD文件路径">`

- 引入内部DTD文件：

  - 直接在xml里面写dtd约束

    ```xml
    <?xml version="1.0" encoding=utf-8 ?>
    <!DOCTYPE person[
    	<!ELEMENT person(name, age)>
    	<!ELEMENT name (#PCDATA)>
    	<!ELEMENT age (#PCDATA)>
    ]>
    <person>
    	<name></name>
        <age></age>
        <!--<a>这里会报错</a>-->
    </person>
    ```

- 使用网络的DTD文件：`<!DOCTYPE 根元素 PUBLIC "DTD名称" "DTD文档的url">`

  - 后面学到的框架 `struts2` 使用配置文件，会用到网络的DTD文件。



### 7. 使用DTD定义元素

- 语法：`<!ELEMENT 元素名称 约束>`
- 简单元素：没有子元素的元素
  - `<!ELEMENT name (#PCDATA)>`
  - PCDATA：约束name是字符串类型
  - EMPTY：表示元素为空（没有内容）`<!ELEMENT name EMPTY>`
  - ANY：表示任意类型。`<!ELEMENT name ANY>`
- 复杂元素：有子元素的元素
  - `<!ELEMENT 元素名称 (子元素1,...)>`
  - 这些指定了名字的子元素只能出现一次。
  - 可以给子元素后面添加符号，表示子元素出现的次数：
    - `+`：至少出现一次。
    - `?`：只能出现一次或者零次。
    - `*`：出现零次或者多次。
    - `<!ELEMENT person (name+, age*, sex?)>`
  - 子元素之间用逗号隔开，**表示元素之间出现的顺序**
  - 元素之间如果用竖线`|`隔开的话，**表示这几个元素只能出现其中任意一个 **`<!ELEMENT person (name|age|sex)>`  就像枚举。

![image-20211206182009883](C:\Users\18343\Desktop\学习\md所需图片\DTD元素定义.png)



### 8. 使用DTD定义属性

- 语法：

  ```dtd
  <!ATTLIST 元素名称
  	属性名称 属性类型 属性的约束
  >
  ```

- 例子

  ```xml
  <?xml version="1.0" encoding=utf-8 ?>
  <!DOCTYPE person[
  	<!ELEMENT person(name, sex, age, birthday)>
  	<!ELEMENT name (#PCDATA)>
  	<!ATTLIST name
  		ID3 ID #REQUIRED
  	>	
  	
  	<!ELEMENT sex (#PCDATA)>
  	<!ATTLIST sex
  		ID5 CDATA "male"
  	>
  
  	<!ELEMENT age (#PCDATA)>
  	<!ATTLIST age
  		ID2 CDATA #FIXED "ABC"
  	>
  
  	<!ELEMENT birthday (#PCDATA)>
  	<!ATTLIST birthday
  		ID1 CDATA #IMPLIED
  	>
  ]>
  <person>
  	<name></name>
      <age></age>
      <!--<a>这里会报错</a>-->
  </person>
  ```

- 属性类型：

  - CDATA：表示一个字符串
  - 枚举：`(aa|bb|cc...) `  表示只能在一定的范围内出现值，但是只能每次出现其中的一个
  - ID：只能由字母或者下划线开头，并且唯一。

- 属性的约束：

  - #REQUIRED：表示这个属性必须有
  - #IMPLIED：表示这个属性可有可无
  - #FIXED：表示这个属性是一个固定值  
    - `#FIXED "AAA"`：表示这个属性值必须是"AAA"
  - 直接值：表示这个属性的默认值，没有设置的时候，会使用这个值，设置后，会使用你设置的值



### 9. 定义实体

- 语法：`<!ENTITY 实体名称 实体值>`
- `<!ENTITY TEST "HAHAHAHA">`
- 引入实体：`&TEST;`  == `&实体名称;`
- 注意：
  - 定义的实体要写在内部的DTD里面。
  - 如果写在外部的DTD里面，有些浏览器下，内容取不到。



### 10. W3C的案例

- DTD文件：由 David Moisan 创造。拷贝自：http://www.davidmoisan.org/

```dtd
<!-- 定义标签之间的关系 -->
<!ELEMENT TVSCHEDULE (CHANNEL+)>
<!ELEMENT CHANNEL (BANNER,DAY+)>
<!ELEMENT BANNER (#PCDATA)>
<!ELEMENT DAY (DATE,(HOLIDAY|PROGRAMSLOT+)+)>
<!ELEMENT HOLIDAY (#PCDATA)>
<!ELEMENT DATE (#PCDATA)>
<!ELEMENT PROGRAMSLOT (TIME,TITLE,DESCRIPTION?)>
<!ELEMENT TIME (#PCDATA)>
<!ELEMENT TITLE (#PCDATA)> 
<!ELEMENT DESCRIPTION (#PCDATA)>

<!-- 定义标签的属性和类型 -->
<!ATTLIST TVSCHEDULE NAME CDATA #REQUIRED>
<!ATTLIST CHANNEL CHAN CDATA #REQUIRED>
<!ATTLIST PROGRAMSLOT VTR CDATA #IMPLIED>
<!ATTLIST TITLE RATING CDATA #IMPLIED>
<!ATTLIST TITLE LANGUAGE CDATA #IMPLIED>

<!-- 电视节目表 TV.dtd -->
```

- 写一个对应的XML文件：

```xml
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE TVSCHEDULE SYSTEM "TV.dtd">

<TVSCHEDULE NAME="CCTV">
	<CHANNEL CHAN="CCTV1">
    	<BANNER></BANNER>
        <DAY>
        	<DATE></DATE>
            <HOLIDAY></HOLIDAY>
        </DAY>
        <DAY>
        	<DATE></DATE>
            <PROGRAMSLOT>
            	<TIME></TIME>
                <TITLE RATING="T1"></TITLE>
            </PROGRAMSLOT>
            <PROGRAMSLOT VTR="B">
            	<TIME></TIME>
                <TITLE></TITLE>
            </PROGRAMSLOT>
        </DAY>
    </CHANNEL>
    
    <CHANNEL CHEN="CCTV2">
    	<BANNER></BANNER>
        <DAY>
        	<DATE></DATE>
            <HOLIDAY></HOLIDAY>
            <PROGRAMSLOT>
            	<TIME></TIME>
                <TITLE LANGUAGE="ZN-CN"></TITLE>
                <DESCRIPTION></DESCRIPTION>
            </PROGRAMSLOT>
        </DAY>
    </CHANNEL>
</TVSCHEDULE>
```



### 11. XML的解析简介（写到java代码***）

**今天最重要的内容！**

- xml是标记型文档

- js使用dom来解析标记型文档html

  - 根据html的层级结构，在内存中分配一个树型结构，把html的标签、属性和文本都封装成对象
  - document对象、element对象、属性对象、文本对象、Node节点对象

- xml的解析技术：`dom` 和 `sax`

  - 画图分析：DOM

    ![image-20211207095930826](C:\Users\18343\Desktop\学习\md所需图片\DOM解析XML.png)

  - SAX解析XML：

    - 采用事件驱动，边读边解析（从上到下一行一行的解析）
    - 解析到某一个对象的时候，把对象名称进行返回
    - 不会造成内存溢出，实现查询
    - 不能做增删改操作

    ![image-20211207100209898](C:\Users\18343\Desktop\学习\md所需图片\SAX解析XML.png)



- 想要解析xml，首先需要**解析器**
- 不同的公司和组织提供了针对dom和sax方式的解析器，通过api方式提高
  - sun公司：jaxp （**sun公司最开始提供的标准**）
  - dom4j组织：**dom4j** （**实际开发用的最多的**）
  - jdom组织：jdom （**最开始和dom4j是一个公司的**）



### 12. JAXP API的查看

- jaxp是JavaSE的一部分，也就是说可以在JDK里面查到。

- jaxp解析器在jdk的javax.xml.parsers里面，里面有四个类，分别是针对DOM和SAX解析使用的类和类工厂。

  - DOM：

    - `DocumentBuilder`：解析器的类

      - 它是一个抽象类，不能new，但是可以通过工厂获取到实例：`DocumentBuilderFactory.newDocumentBuilder()`

      - 解析xml文件：`parse("xml文件路径")` ，返回一个 `Document` 对象——整个文档。

      - 返回的 `Document` 是一个接口，父接口是 `Node`，如果找不到我们想要的方法，可以去 `Node` 里面找。

      - 在 `Document` 里面的方法：

        - `getElementsByTagName(String tagname)`
          - 在这个方法可以得到标签
          - 返回集合：`NodeList`
        - `createTextNode()`
          - 创建文本
        - `createElement`
          - 创建标签
        - `appandChild(Node newChild)`
          - 把文本添加到标签里面
          - 返回：`Node`
        - `removeChild(Node oldChild)`
          - 删除子节点
          - 返回子节点
        - `getParentNode()`
          - 获取父节点

      - 在 `NodeList` 的方法：

        - ` int getLength();` ：获取NodeList的长度

        - `Node item(int index);`：根据index获取对应位置的节点

          ```java
          // 遍历NodeList集合的所有节点
          for(int i=0; i<NodeList.getLength; i++){
          	Node cur = NodeList.item(i);
          }
          ```

        - `node.getTextContent()`： 得到节点里面的值

    - `DocumentBuilderFactory`：解析器的工厂

      - 也是一个抽象类，不能new，通过：`newInstance() `得到工厂实例。

  - SAX：

    - `SAXParser`：解析器的类
    - `SAXParserFactory`：解析器的工厂



### 13. 使用JAXP实现操作

**xml文件**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<person>
	<p1>
		<name>zhangsan</name>
		<age>20</age>
	</p1>
	<p1>
		<name>lisi</name>
		<age>30</age>
	</p1>
</person>
```



**需求一：** 查询xml中所有的name元素的值。

```java
package xmlStudy.cn.itcast.jaxptest;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 实现JAXP操作xml
 * @author 18343
 */

/**
* 查询xml中所有name元素的值
* @param name  要查询的标签的名称
* @throws Exception  异常
* 把一段代码导出为一个方法的快捷键：alt+shift+M
*/
public static void selectAll(String name) throws Exception {
    /*
	* 1. 创建解析器工厂
	* 2. 根据解析器工厂创建解析器
	* 3. 解析xml，返回document 
	* 4. 得到所有的name元素
	* 5. 遍历集合
	* 6. 得到节点里面的值
	*/
    // 1     代码提示快捷键  alt+/
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    // 2     异常原则：能处理尽量处理，否则抛出去
    DocumentBuilder builder = builderFactory.newDocumentBuilder();
    // 3   w3c的包
    Document dom = builder.parse("src/main/java/first.xml");
    // 4
    NodeList list = dom.getElementsByTagName(name);
    // 5
    for(int i=0; i<list.getLength(); i++) {
        Node node = list.item(i);
        // 6
        System.out.println(node.getTextContent());
    }
}
```

![image-20211207104854877](C:\Users\18343\Desktop\学习\md所需图片\dom查询结果.png)



**需求二： **使用JAXP查询某一个节点

```java
/**
 * 查询xml中任意一个name的值
 * @param name   指定标签的名称
 * @param index	 第index个标签
 * @throws Exception  异常
 */
public static void selectAny(String name, int index) throws Exception {
    /*
	 * 1. 创建解析器工厂
	 * 2. 根据解析器工厂创建解析器
	 * 3. 解析xml得到dom
	 * 4. 得到集合
	 * 5. 使用item下标取对应的值
	 */
    // 1
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    // 2
    DocumentBuilder builder = builderFactory.newDocumentBuilder();
    // 3
    Document dom = builder.parse("src/main/java/first.xml");
    // 4
    NodeList list = dom.getElementsByTagName(name);
    if(index>=list.getLength()) {
        System.out.println("输入的索引值越界了");
        return;
    }
    System.out.println(list.item(index).getTextContent());
}
```



**需求三：**使用JAXP添加节点。

```java
/**
 * 在指定节点后面添加一个新的节点
 * @param parentType  指定的父节点类型
 * @param index       第index个子节点
 * @param child		  子节点名称
 * @param str		  子节点内容
 * @throws Exception  异常
 */
public static void addAny(String parentType, int index, String child, String str)
    throws Exception {
    /*
	* 1. 创建解析器工厂
	* 2. 根据解析器工厂创建解析器
	* 3. 解析xml得到dom
	* 
	* 4. 得到parentType的节点
	* 5. 使用item下标得到第index个parent节点
	* 6. 创建child标签  createElement
	* 7. 创建文本  createTextNode
	* 8. 把文本添加到 child 下边  appendChild
	* 9. 把child添加到parent下边
	* 
	* 10. 回写到xml文件里面去(因为上面操作的是内存里面的文档)
	*/

    // 1
    DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
    // 2
    DocumentBuilder builder = db.newDocumentBuilder();
    // 3
    Document dom = builder.parse("src/main/java/first.xml");
    // 4
    NodeList list = dom.getElementsByTagName(parentType);
    // 5
    if(list.getLength()<=index || index<0) {
        throw new RuntimeException("输入的索引值越界");
    }
    Node first = list.item(index);
    // 6
    Element e = dom.createElement(child);
    // 7
    Text text = dom.createTextNode(str);
    // 8
    e.appendChild(text);
    // 9
    first.appendChild(e);
    // 10 回写
    /*
		 * 需要一个转换类作为中介，把内存里面的DOM写到源文件的XML里面
		 * 利用transform操作，前面传内存的DOM放到DOMSource里面（起点站）
		 * 后面放xml源文件的路径，放到结果流里面（终点站）
		 */
    TransformerFactory factory = TransformerFactory.newInstance();
    Transformer former = factory.newTransformer();
    former.transform(new DOMSource(dom), new StreamResult("src/main/java/first.xml"));
}
```



**需求三：** 修改指定节点的子节点的内容

```java
/**
* 修改指定节点的内容
* @param name    节点名称
* @param index   第index个节点
* @param value   修改为对应值
* @throws Exception  异常
*/
public static void modifyAny(String name, int index, String value) throws Exception {
    /*
	* 1. 创建解析器工厂
	* 2. 根据解析器工厂创建解析器
	* 3. 解析xml得到dom
	* 
	* 4. 得到child  item
	* 5. 修改child的内容  setTextContext
	* 
	* 6. 回写xml
	*/
    // 1
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    // 2
    DocumentBuilder builder = factory.newDocumentBuilder();
    // 3
    Document dom = builder.parse("src/main/java/first.xml");
    // 4
    Node node = dom.getElementsByTagName(name).item(index);
    // 5
    node.setTextContent(value);

    // 6
    TransformerFactory f = TransformerFactory.newInstance();
    Transformer trans = f.newTransformer();
    trans.transform(new DOMSource(dom), new StreamResult("src/main/java/first.xml"));

}
```



**需求四：**删除指定节点。

```java
/**
* 删除指定节点
* @param name   节点名称
* @param index  第index个这类节点
* @throws Exception  异常
*/
public static void delAny(String name, int index) throws Exception{
    /*
	* 1. 创建解析器工厂
	* 2. 根据解析器工厂创建解析器
	* 3. 解析xml得到dom
	* 
	* 4. 获取name元素的标签  getElementsByTagName
	* 5. 获取name的父节点  getParentNode
	* 6. 使用父节点删除当前节点  removeChild
	* 
	* 7. 回写
	*/
    // 1
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    // 2
    DocumentBuilder builder = factory.newDocumentBuilder();
    // 3
    Document dom = builder.parse("src/main/java/first.xml");
    // 4
    Node node = dom.getElementsByTagName(name).item(index);
    // 5
    Node parent = node.getParentNode();
    // 6
    parent.removeChild(node);

    // 7
    TransformerFactory f = TransformerFactory.newInstance();
    Transformer t = f.newTransformer();
    t.transform(new DOMSource(dom), new StreamResult("src/main/java/first.xml"));
}
```



**需求五：** 遍历所有子节点

```java
/**
* 打印所有的节点名称，只打印标签元素
* @throws Exception  异常
*/
public static void printElements() throws Exception{
    /*
	* 1. 创建解析器工厂
	* 2. 根据解析器工厂创建解析器
	* 3. 解析xml得到dom
	* 
	* 4. 得到根节点，输出当前节点
	* 5. 递归得到子节点
	*/
    // 1
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    // 2
    DocumentBuilder builder = factory.newDocumentBuilder();
    // 3
    Document dom = builder.parse("src/main/java/first.xml");

    // 编写一个方法来实现递归
    process(dom);
}

private static void process(Node node) {
    // 标签类型才处理
    if(node.getNodeType()!=Node.ELEMENT_NODE) {
        return;
    }
    System.out.println(node.getNodeName());

    NodeList list = node.getChildNodes();
    for(int i=0; i<list.getLength(); i++) {
        // 得到每一个子节点
        process(list.item(i));
    }
}
```



**主方法：**

```java
public static void main(String[] args) throws Exception {
//		selectAll("name");
//		selectAny("name",1);
//		addAny("p1", 0, "sex", "nv");
//		modifyAny("sex",0,"nan");
//		delAny("sex", 0);
	printElements();
}
```



### 14. Schema约束

- DTD语法：`<!ELEMENT 元素名称 约束>`
- Schema是符合XML的语法规范的，里面写的就是xml的语句
- 一个xml中只能有一个DTD，但是可以有多个Schema，多个Schema用名称空间区分（类似于Java包名）
- DTD里面有PCDATA类型，但是在Schema里面可以支持更多的数据类型
  - 比如：年龄，在Schema可以定义整数
- Schema的语法更加复杂，所以目前还无法替代DTD



### 15. Schema快速入门

- 创建一个schema文件。步骤：

  - 看xml中有多少个元素：`element`

  - 根节点：`schema`

    - `xmlns` ：约束文档url，表示当前XML是一个约束文件
    - `targetNamespace` ：引入schema的路径（一般写一个url，保证不会和别的约束同名）
    - `elementFormDefault` ："qualified"

  - 看是简单元素还是复杂元素

    - 简单元素：要写在复杂复杂元素里面

    - 复杂元素：复杂元素要嵌套简单元素

      ```xml
      <?xml version="1.0" encoding="UTF-8"?>
      <schema xmlns="http://www.w3.org/2001/XMLSchema" 
      targetNamespace="http://www.example.org/1" 
      xmlns:tns="http://www.example.org/1" 
      elementFormDefault="qualified">
      	<element name="person">
      		<complexType>
      			<sequence>
      					<element name="name" type="string"></element>
      					<element name="age" type="int"></element>
      			</sequence>
      		</complexType>
      	</element>
      </schema>
      ```

  - 在被约束文件里面引入约束文件：

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <person xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xmlns="http://www.example.org/1"
    	xsi:schemaLocation="http://www.example.org/1 1.xsd"
    >
    <!-- xmlns:xsi  表示给这个xmlns起了一个别名xsi，就不会和下面的xmlns冲突了
    	xsd文件是一个文件下的，所以直接写的名称 
    -->
    	<name>zhangsan</name>
    	<age>20</age>
    </person>
    ```

    - `xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"` ：表示xml是一个被约束文件，后面多了一个 `instance`
    - `xmlns="http://www.example.org/1"` ：约束文档的 `targetNamespace `。
    - `xsi:schemaLocation="http://www.example.org/1 1.xsd"` ：指定约束文档。`targetNamespace 空格 约束文档的路径`

![image-20211208143719241](C:\Users\18343\Desktop\学习\md所需图片\schema开发过程.png)

- `<sequence>`：表示顺序，xml的顺序和这里面加的顺序要一致

- `<all>`：表示里面的元素只能出现一次

- `<choice>`：表示里面的所有元素，只能出现其中一个

- `maxOccurs="unbounded"`：表示这个标签里面的元素出现的次数不限制，可以出现零次或多次

- `<any>`：表示任意元素

  ```xml
  <sequence>
  	<any>表示可以写任意一个非指定元素进来</any>
  </sequence>
  ```

  

- 定义属性：这个属性只能放在复杂元素`complexType `里面。

  - `<attribute name="id" type="int" use="required">`

    ```xml
    <complexType>
    	<attribute name="id" type="int" use="required">
    </complexType>
    ```

    - `name`：属性的名称
    - `type`：属性的类型
    - `use`：属性是否要求必须写

- 一个xml文件引入多个schema的时候，地址空间用空格隔开：`targetNamesapce1 loc1 targetNamespace2 loc2 ...`

  ![image-20211208150013816](C:\Users\18343\Desktop\学习\md所需图片\引入多个schema的使用.png)

- 引入多个schema的时候，可以给每个schema起一个别名，里面使用这个约束的标签的时候，前面要加上别名。



### 16. SAX解析原理

- 事件驱动的方式，边读边解析。

- 在 `javax.xml.parsers` 里面有两个关于 SAX 的类：

  - `SAXParser` ：通过 `SAXParserFactory.newSAXParser()` 得到。
    - `parse(File f, DefualtHandler dh)`
      - 第一个参数：xml文件路径
      - 第二个参数：事件处理器
      - 当把事件处理器传进来后，就相当于绑定了一个事件。
  - `SAXParserFactory` ：`newInstance()` 得到。

- 画图分析SAX解析过程：

  ![image-20211208152045427](C:\Users\18343\Desktop\学习\md所需图片\SAX解析过程.png)



### 17. 使用JAXP的SAX解析XML

不能做增删改的操作，只能查询。

- **打印出整个文档：**

```java
package xmlStudy.cn.itcast.jaxptest;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestSAX {

	public static void main(String[] args) throws Exception, SAXException {
		/*
		 * 1. 创建解析器工厂
		 * 2. 得到解析器
		 * 3. 执行parse
		 * 
		 * 4. 自己创建一个类，继承DefaultHandler
		 * 5. 重写类里面的三个方法
		 */
		// 1
		SAXParserFactory f = SAXParserFactory.newInstance();
		// 2
		SAXParser parser = f.newSAXParser();
		// 3：DefaultHandler需要我们自己写，然后去继承这个类
		parser.parse(new File("src/main/java/P1.xml"), new MyHandler());
	}
	
	static class MyHandler extends DefaultHandler{
		// 不用ln换行，因为会把换行和空格都正常解析出来
        // 下面这三个方法都是自动执行的
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			System.out.print("<"+qName+">");
		}
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			System.out.print(new String(ch, start, length));
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			System.out.print("<"+qName+">");
		}

	}
}
```

![image-20211208153400266](C:\Users\18343\Desktop\学习\md所需图片\SAX打印整个文档.png)



- **获取到所有指定标签名的值：**

```java
static class MyHandler2 extends DefaultHandler{
    boolean flag = false;
    String name = "name";
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
        throws SAXException {
        // 判断是否是name元素
        if(qName.equals(name)) {
            flag = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(flag) {
            System.out.println(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals(name)) {
            flag = false;  // name元素结束
        }
    }

}
```

![image-20211208154040427](C:\Users\18343\Desktop\学习\md所需图片\SAX查询.png)

- **获取第一个元素的值：**

```java
static class MyHandler3 extends DefaultHandler{
    int index = 0;
    String name = "name";
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
        throws SAXException {
        // 判断是否是name元素
        if(qName.equals(name)) {
            index++;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(index==1) {
            System.out.println(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals(name)) {
            index++;
        }
    }

}
```



### 18. 使用dom4j解析xml

- dom4j不是javase的一部分：

  - 导入dom4j的jar包
  - 把jar复制到lib里面，然后Build path --> add to build path。

- 得到document

  ```java
  SAXReader reader = new SAXReader();
  Document document = reader.read(url);
  ```

- Document的父接口是Node：Document找不到的方法，去Node里面找

- Document的 `getRootElement()` 获取根节点，返回值是 `Element`
- Element也是接口，父接口是Node：
  - `getParent()`：获取父节点
  - `addElement()`：添加标签



### 19. 使用dom4j查询xml

- **查询所有name元素里面的值**

  ```java
  /**
   * 查询path的xml中所有name元素的值
   * @param path    xml路径
   * @param parent  指定父节点
   * @param name    父节点下的指定节点
   * @throws Exception 异常
   */
  public static void selectName(String path, String parent, String name) throws Exception {
  	/*
  	 	1. 创建解析器
  		2. 获取DOM
  		3. 得到根节点  getRootElement()
  		
  		4. 得到所有的p1的标签
  			element(QName);  表示获取标签下的第一个子标签（QName表示子标签的名字）
  			elements(QName); 表示获取标签下面的所有子标签（一层）（QName表示子标签的名称）
  			elements();  获取标签下面的所有子标签（一层）
  		5. 得到name
  		6. 得到name里面的值
  	 */
  	// 1 
  	SAXReader reader = new SAXReader();
  	// 2
  	Document dom = reader.read(path);
  	// 3
  	Element e = dom.getRootElement();
  	
  	// 4
  	List<Element> list = e.elements(parent);
  
  	for(Element cur:list) {
  		// 5
  		Element n = cur.element(name);
  		// 6
  		System.out.println(n.getData());
  	}
  	
  }
  ```
  
  
  
- **查询指定位置的父元素下面的指定位置的子元素的值**

  ```java
  /**
   * 查询指定位置的父元素下面的指定位置的子元素的值
   * @param path	  	xml的路径
   * @param parent	父元素的名称
   * @param pIndex	第pIndex个父元素
   * @param child		子元素的名称
   * @param cIndex		第几个子元素
   * @throws Exception	异常
   */
  public static void selectIndex(String path, String parent, int pIndex, String child, int cIndex) throws Exception{
  	/*
  	 * 	1. 创建解析器
  	 *  2. 得到DOM
  	 *  3. 得到根节点
  	 *  
  	 *  4. 得到parent
  	 *  5. 得到parent下面的第index个name
  	 *  6. 得到name值
  	 */
  	// 1
  	SAXReader reader = new SAXReader();
  	// 2
  	Document dom = reader.read(path);
  	// 3
  	Element root = dom.getRootElement();
  	// 4
  	List<Element> pList = root.elements(parent);
  	Element p = pList.get(pIndex-1);
  	// 5
  	Element n = null;
  	int num = 0;
  	for(Element e: p.elements(child)) {
  		if(num+1==cIndex) {
  			n = e;
  			break;
  		}
  		num++;
  	}
  	
  	// 6
  	System.out.println(n.getData());
  }
  ```

  ###### 

### 20. 使用dom4j实现添加操作

**需求一 ：** 在第index个p1的末尾添加子元素sex。

```java
/**
 * 在第index个parent里面添加子元素child，内容为str
 * @param path		xml路径
 * @param parent	父元素名称
 * @param index		父元素的索引
 * @param child		子元素名称
 * @param str		子元素内容
 * @throws Exception	异常
 */
public static void addIndex(String path, String parent, int index, String child, String str) throws Exception{
	/*
	 * 1. 创建解析器
	 * 2. 得到DOM
	 * 3. 得到根节点
	 * 
	 * 4. 获取第index个parent
	 * 5. 在p1下面添加child
	 * 6. 给child添加文本str
	 * 
	 * 7. 回写
	 */
	
	// 1
	SAXReader reader = new SAXReader();
	// 2
	Document dom = reader.read(path);
	// 3
	Element root = dom.getRootElement();
	
	// 4
	Element p = root.elements(parent).get(index-1);
	// 5
	Element c = p.addElement(child);
	// 6
	c.setText(str);
	
	// 7 
	// createPrettyPrint() 有缩进
	// createCompactFormat() 压缩文件
	XMLWriter writer = new XMLWriter(new FileOutputStream(path), OutputFormat.createPrettyPrint());
	writer.write(dom);
	writer.close();
}
```



**需求二：** 在特定元素之前添加元素

```java
/**
 * 在指定的元素下面的子元素之前添加指定元素
 * @param path		xml路径
 * @param parent	父元素的名称
 * @param pIndex	第几个父元素
 * @param child		子元素的名称
 * @param cIndex	第几个子元素
 * @param addE		我们指定添加的元素
 * @param str		添加的元素的内容
 * @throws Exception	异常
 */
public static void addBefore(String path,
		String parent, int pIndex,
		String child, int cIndex,
		String addE, String str) throws Exception 
{
	/*
	 * 1. 创建解析器
	 * 2. 得到DOM
	 * 3. 得到根节点
	 * 
	 * 4. 获取第pIndex的parent下面的所有子元素
	 * 		得到第cIndex的child元素
	 * 		elements(name);
	 * 5. 在特定位置添加元素：add(int index, E element)
	 * 
	 * 6. 回写
	 */
	// 1
	SAXReader reader = new SAXReader();
	// 2
	Document dom = reader.read(path);
	// 3
	Element root = dom.getRootElement();
	
	// 4
	Element p = root.elements(parent).get(pIndex-1);
	int index = 0;
	int temp = 0;
	for(Element cur:p.elements()) {
		index++;
		if(cur.getName().equals(child)) {
			temp++;
			if(temp==cIndex) {
				break;
			}
		}
	}
	
	Element e = DocumentHelper.createElement(addE);
	e.setText(str);
	
	// 5
	p.elements().add(index-1, e);
	
	// 6
	XMLWriter writer = new XMLWriter(new FileOutputStream(path), OutputFormat.createPrettyPrint());
	writer.write(dom);
	writer.close();
}
```



### 21. 对方法进行封装

```java
package xmlStudy.cn.itcast.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jUtils {
	// 路径封装
	public static final String PATH = "src/main/java/person.xml";
	
	// 返回Document
	public static Document getDocument(String path){
		try {
			return new SAXReader().read(path);
		} catch (DocumentException e) {
			System.out.println(Dom4jUtils.class+" : "+e);
		}
		return null;
	}
	
	// 回写
	public static void xmlWriterBack(String path, Document dom) {
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(path), OutputFormat.createPrettyPrint());
			writer.write(dom);
			writer.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
```



### 22. 使用Dom4j修改元素

**需求一：** 修改指定p1下面的指定age元素的值

```java
public static void modify(String parent, int pIndex,
		String child, int cIndex, String newStr) throws Exception 
{
	/*
	 * 1. 得到DOM
	 * 2. 得到第pIndex个parent
	 * 3. 得到第cIndex个child
	 * 4. 修改内容
	 * 5. 回写
	 */
	// 1
	Document dom = Dom4jUtils.getDocument(Dom4jUtils.PATH);
	// 2
	Element p = dom.getRootElement().elements(parent).get(pIndex-1);
	// 3
	Element c = p.elements(child).get(cIndex-1);
	// 4
	c.setText(newStr);
	// 5
	Dom4jUtils.xmlWriterBack(Dom4jUtils.PATH, dom);
}
```

- `setText(String) 是修改内容。`
- `addText(String) 是追加内容。`



### 23. 使用dom4j实现删除节点

**需求一：** ：删除指定元素的下面的指定的子元素

```java
public static void delete(String parent, int pIndex,
		String child, int cIndex) throws Exception 
{
	/*
	 * 1. 得到DOM
	 * 2. 得到根节点
	 * 3. 得到第pIndex个parent
	 * 4. 得到第cIndex个child
	 * 5. 删除
	 * 6. 回写
	 */
	// 1
	Document dom = Dom4jUtils.getDocument(Dom4jUtils.PATH);
	// 2
	Element root = dom.getRootElement();
	// 3
	Element p = root.elements(parent).get(pIndex-1);
	if(p==null) {
		return;
	}
	// 4
	Element c = p.elements(child).get(cIndex-1);
	if(c==null) {
		return;
	}
	// 5
	p.remove(c);
	// 6
	Dom4jUtils.xmlWriterBack(Dom4jUtils.PATH, dom);
	
}
```



### 24. 使用dom4j获取元素的属性值

**需求一：** 获取指定元素的属性值

```java
public static void getValue(String factor, int index, String value) {
	/*
	 * 1. 得到DOM
	 * 2. 得到根节点
	 * 3. 得到指定元素
	 * 4. 得到属性值
	 */
	// 1
	Document dom = Dom4jUtils.getDocument(Dom4jUtils.PATH);
	// 2
	Element root = dom.getRootElement();
	// 3
	Element f = root.elements(factor).get(index-1);
	if(f==null) {
		return;
	}
	// 4
	String v = f.attributeValue(value);
	System.out.println(v);
}
```



### 25. XPATH简介

使用XPATH可以直接获取某个元素。

- 第一种形式：`/AAA/BBB/DDD`  表示一层一层的。
- 第二种形式：`//BBB` 表示匹配所有名称是BBB的元素。
- 第三种形式：`/*` 表示里面的所有元素。
- 第四种形式：`/AAA/BBB[1]   或者  /AAA/BBB[last()]` 表示第一个BBB或者最后一个BBB元素。
- 第五种形式：`/BBB[@id]` 表示取有id属性的所有BBB元素。  `/@id` 取所有有id属性的元素。
- 第六种形式：`/BBB[@id="p1"]` 取所有id属性值为p1的BBB元素。



### 26. 使用dom4j支持xpath

- 默认情况下，dom4j是不支持xpath的。
- 需要引入对应的jar包才能支持xpath。
- 有两个方法支持xpath：
  - `selectNodes("xpath表达式")` ：获取多个节点
  - `selectSingleNode("xpath表达式")` ：获取一个节点

```java
// 查询xml中所有name元素的值
public static void test1(String name) throws Exception {
    /*
		 * 1. 得到DOM
		 * 2. 直接使用selectNodes得到所有name元素
		 * 3. 得到值
		 */
    // 1
    Document dom = Dom4jUtils.getDocument(Dom4jUtils.PATH);
    // 2
    List<Node> nodes = dom.selectNodes(name);
    System.out.println(nodes);
    // 3
    for(Node node: nodes) {
        System.out.println(node.getText());
    }
}
```



**使用XPATH实现** ：获取第一p1下面的name的值。

```java
// 获取第一p1下面的name的值。
// //p1[@id="aaa"]/name
public static void test2() throws Exception{
    Document dom = Dom4jUtils.getDocument("./src/main/java/person.xml");
    Node node = dom.selectSingleNode("//p1[@id='heiBoy']/name");		
    System.out.println(node.getText());
}
```



### 27. 学生管理系统

- 使用xml当作小型数据库

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <student>
  	<stu>
  		<id>1001</id>
  		<name>zhangsan</name>
  		<age>20</age>
  	</stu>
  	<stu>
  		<id>1002</id>
  		<name>lisi</name>
  		<age>19</age>
  	</stu>
  	<stu>
  		<id>1003</id>
  		<name>wangwu</name>
  		<age>21</age>
  	</stu>
  </student>
  ```

  

- 添加操作

```java
// 增加
public static void addStu(Student student) throws Exception{
    /*
		 * 1. 创建DOM
		 * 2. 获取根节点
		 * 3. 创建stu标签
		 * 4. 在stu标签里面依此创建子标签
		 * 5. 在新的标签上依次添加值
		 * 
		 * 6. 回写
		 */
    // 1
    Document dom = Dom4jUtils.getDocument(Dom4jUtils.PATH);
    // 2
    Element root = dom.getRootElement();
    // 3
    Element stu = root.addElement("stu");
    // 4
    Element id = stu.addElement("id");
    Element name = stu.addElement("name");
    Element age = stu.addElement("age");
    // 5
    id.setText(student.getId());
    name.setText(student.getName());
    age.setText(student.getAge());
    // 6
    Dom4jUtils.xmlWriterBack(Dom4jUtils.PATH, dom);

}
```



- 删除操作

```java
// 删除
public static void deleteStu(String id) throws Exception {
	/*
	 * 1. 获取DOM
	 * 2. 遍历所有id xpath //id
	 * 3. 删除对应id的父节点stu  getParent()
	 * 4. 回写
	 */
	// 1
	Document dom = Dom4jUtils.getDocument(Dom4jUtils.PATH);
	
	// 3
	List<Node> nodes = dom.selectNodes("//id");
	// 4
	for(Node node: nodes) {
		if(node.getText().equals(id)) {
			Element p = node.getParent();
			p.getParent().remove(p);
			break;
		}
	}
	Dom4jUtils.xmlWriterBack(Dom4jUtils.PATH, dom);
	
}
```



- 查询操作

```java
// 查询
public static void selectStu(String id) throws Exception{
	/*
	 * 1. 获取DOM
	 * 2. 获取所有的id  //id
	 * 3. 发送对应的值
	 */
	// 1
	Document dom = Dom4jUtils.getDocument(Dom4jUtils.PATH);
	// 2
	List<Node> nodes = dom.selectNodes("//id");
	// 3
	for(Node node: nodes) {
		if(node.getText().equals(id)) {
			Element e = node.getParent();
			List<Node> content = e.content();
			for(Node n: content) {
				if(n.getNodeType()==1) {
					System.out.println(n.getName() + ": "+n.getText());
				}
			}
			break;
		}
	}
	
}
```



- 主方法

```java
public static void main(String[] args) throws Exception{
//		Student student = new Student("1004", "wangmazi", "20");
//		addStu(student);
//		deleteStu("1002");
		selectStu("1003");
}
```



- 实体类

```java
package vo;

public class Student {
	private String id;
	private String name;
	private String age;
	
    public Student() {}
    
	public Student(String id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
    
    @Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
```



- 整体

```java
package service;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import Util.Dom4jUtils;
import vo.Student;

public class StuService {
	public static void main(String[] args) throws Exception{
//		Student student = new Student("1004", "wangmazi", "20");
//		addStu(student);
//		deleteStu("1002");
		selectStu("1003");
	}
	
	// 增加
	public static void addStu(Student student) throws Exception{
		/*
		 * 1. 创建DOM
		 * 2. 获取根节点
		 * 3. 创建stu标签
		 * 4. 在stu标签里面依此创建子标签
		 * 5. 在新的标签上依次添加值
		 * 
		 * 6. 回写
		 */
		// 1
		Document dom = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		// 2
		Element root = dom.getRootElement();
		// 3
		Element stu = root.addElement("stu");
		// 4
		Element id = stu.addElement("id");
		Element name = stu.addElement("name");
		Element age = stu.addElement("age");
		// 5
		id.setText(student.getId());
		name.setText(student.getName());
		age.setText(student.getAge());
		// 6
		Dom4jUtils.xmlWriterBack(Dom4jUtils.PATH, dom);
		
	}
	
	// 删除
	public static void deleteStu(String id) throws Exception {
		/*
		 * 1. 获取DOM
		 * 2. 遍历所有id xpath //id
		 * 3. 删除对应id的父节点stu  getParent()
		 * 4. 回写
		 */
		// 1
		Document dom = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		
		// 3
		List<Node> nodes = dom.selectNodes("//id");
		// 4
		for(Node node: nodes) {
			if(node.getText().equals(id)) {
				Element p = node.getParent();
				p.getParent().remove(p);
				break;
			}
		}
		Dom4jUtils.xmlWriterBack(Dom4jUtils.PATH, dom);
		
	}
	
	// 查询
	public static void selectStu(String id) throws Exception{
		/*
		 * 1. 获取DOM
		 * 2. 获取所有的id  //id
		 * 3. 发送对应的值
		 */
		// 1
		Document dom = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		// 2
		List<Node> nodes = dom.selectNodes("//id");
		// 3
		for(Node node: nodes) {
			if(node.getText().equals(id)) {
				Element e = node.getParent();
				List<Node> content = e.content();
				for(Node n: content) {
					if(n.getNodeType()==1) {
						System.out.println(n.getName() + ": "+n.getText());
					}
				}
				break;
			}
		}
		
	}
}
```



- 工具类

```java
package Util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jUtils {
	// 璺緞灏佽
	public static final String PATH = "student.xml";
	
	// 杩斿洖Document
	public static Document getDocument(String path) throws Exception{
		return new SAXReader().read(path);
	}
	
	// 鍥炲啓
	public static void xmlWriterBack(String path, Document dom) {
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(path), OutputFormat.createPrettyPrint());
			writer.write(dom);
			writer.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
```



## 五、过滤器Filter



### 1. Filter特征

过滤器会在一组资源（jsp、servlet、css、html等待）的前面执行！

他可以让请求得到目标资源，也可以不让请求得到资源。

- 即过滤器有拦截请求的能力。

  - 比如有些Servlet只有在登录之后才能访问，那么我们可以用过滤器对访问的用户进行过滤，而不需要对每个Servlet添加if语句判断。

- 生命周期

  - void init(FilterConfig)：创建之后，马上执行 —— 服务器启动的时候就执行
  - void destroy()：销毁之前执行 —— 服务器关闭的时候销毁
  - void doFilter(ServletRequest, ServletResponse, FilterChain)：每次过滤都会执行

- Filter 是单例的！

- 配置文件

  ```xml
  <filter>
  	<filter-name>XXX</filter-name>
      <filter-class>Filter.AFilter</filter-class>
  </filter>
  <filter-mapping>
  	<filter-name>XXX</filter-name>
      <!-- 指定的url-pattern是指的你要拦截的Serlvet的范围，你也可以指定某一个 -->
      <url-pattern>/*</url-pattern>
  </filter-mapping>
  ```

- FilterConfig --> 与ServletConfig相似

  - 获取初始化参数：getInitParameter()
  - 获取过滤器名称：getFilterName()
  - 获取application：getServletContext() —— 获取上下文

- FilterChain

  - doFilter(ServletRequest, ServletResponse)：放行！

  - 放行，相当于调用了 `servlet.service `方法，然后回来接着执行

    **Filter**

    ```java
    package Filter;
    
    import java.io.IOException;
    
    import javax.servlet.Filter;
    import javax.servlet.FilterChain;
    import javax.servlet.FilterConfig;
    import javax.servlet.ServletException;
    import javax.servlet.ServletRequest;
    import javax.servlet.ServletResponse;
    
    
    public class AFilter implements Filter{
    
    	/**
    	 * 创建之后马上执行，用来进行初始化
    	 */
    	@Override
    	public void init(FilterConfig filterConfig) throws ServletException {
    		System.out.println("过滤器诞生了");
    	}
    	
    	/**
    	 * 销毁之前调用，用来做对非内存进行释放
    	 */
    	@Override
    	public void destroy() {
    		System.out.println("过滤器去世了");
    	}
    	
    	/**
    	 * 每次过滤时都会执行
    	 */
    	@Override
    	public void doFilter(ServletRequest arg0, ServletResponse arg1,
    			FilterChain arg2)
    			throws IOException, ServletException {
    		System.out.println("我要拦截你！");
    		arg2.doFilter(arg0, arg1);  // 拦截之后，放行！
    		System.out.println("你回来了？");
    	}
    
    }
    ```

    **Servlet**

    ```java
    package Servlet;
    
    
    import java.io.IOException;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    
    @WebServlet("/AServlet")
    public class AServlet extends HttpServlet {
    	private static final long serialVersionUID = 1L;
           
        
        public AServlet() {
            
        }
    
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		System.out.println("AServlet....");
    	}
    
    	
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    	}
    
    }
    ```

    **web.xml**

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app xmlns="http://www.w3.org/2001/XMLSchema-instance" version="5.0">
      	<servlet>
      		<servlet-name>AServlet</servlet-name>
      		<servlet-class>Servlet.AServlet</servlet-class>
      	</servlet>
      	<servlet-mapping>
      		<servlet-name>AServlet</servlet-name>
      		<url-pattern>/AServlet</url-pattern>
      	</servlet-mapping>
      	
      	
      	<filter>
    		<filter-name>AFilter</filter-name>
        	<filter-class>Filter.AFilter</filter-class>
    	</filter>
    	<filter-mapping>
    		<filter-name>AFilter</filter-name>
        	<!-- 指定的url-pattern是指的你要拦截的Serlvet的范围，你也可以指定某一个 -->
        	<url-pattern>/*</url-pattern>
    	</filter-mapping>
    </web-app>
    ```

    **异常** ：

    ```java
    严重: 无法部署应用目录 [D:\Workspaces\.metadata\.me_tcat9046\webapps\FilterStudy]
    java.lang.IllegalStateException: 启动子级时出错
    	at org.apache.catalina.core.ContainerBase.addChildInternal(ContainerBase.java:720)
    	at org.apache.catalina.core.ContainerBase.addChild(ContainerBase.java:690)
    	at org.apache.catalina.core.StandardHost.addChild(StandardHost.java:692)
    	at org.apache.catalina.startup.HostConfig.deployDirectory(HostConfig.java:1184)
    	at org.apache.catalina.startup.HostConfig$DeployDirectory.run(HostConfig.java:1925)
    	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
    	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
    	at org.apache.tomcat.util.threads.InlineExecutorService.execute(InlineExecutorService.java:75)
    	at java.base/java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:118)
    	at org.apache.catalina.startup.HostConfig.deployDirectories(HostConfig.java:1094)
    	at org.apache.catalina.startup.HostConfig.deployApps(HostConfig.java:476)
    	at org.apache.catalina.startup.HostConfig.start(HostConfig.java:1611)
    	at org.apache.catalina.startup.HostConfig.lifecycleEvent(HostConfig.java:319)
    	at org.apache.catalina.util.LifecycleBase.fireLifecycleEvent(LifecycleBase.java:123)
    	at org.apache.catalina.util.LifecycleBase.setStateInternal(LifecycleBase.java:423)
    	at org.apache.catalina.util.LifecycleBase.setState(LifecycleBase.java:366)
    	at org.apache.catalina.core.ContainerBase.startInternal(ContainerBase.java:936)
    	at org.apache.catalina.core.StandardHost.startInternal(StandardHost.java:829)
    	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:183)
    	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1384)
    	at org.apache.catalina.core.ContainerBase$StartChild.call(ContainerBase.java:1374)
    	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
    	at org.apache.tomcat.util.threads.InlineExecutorService.execute(InlineExecutorService.java:75)
    	at java.base/java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:140)
    	at org.apache.catalina.core.ContainerBase.startInternal(ContainerBase.java:909)
    	at org.apache.catalina.core.StandardEngine.startInternal(StandardEngine.java:262)
    	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:183)
    	at org.apache.catalina.core.StandardService.startInternal(StandardService.java:433)
    	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:183)
    	at org.apache.catalina.core.StandardServer.startInternal(StandardServer.java:930)
    	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:183)
    	at org.apache.catalina.startup.Catalina.start(Catalina.java:772)
    	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
    	at org.apache.catalina.startup.Bootstrap.start(Bootstrap.java:342)
    	at org.apache.catalina.startup.Bootstrap.main(Bootstrap.java:473)
    Caused by: org.apache.catalina.LifecycleException: 无法启动组件[StandardEngine[Catalina].StandardHost[localhost].StandardContext[/FilterStudy]]
    	at org.apache.catalina.util.LifecycleBase.handleSubClassException(LifecycleBase.java:440)
    	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:198)
    	at org.apache.catalina.core.ContainerBase.addChildInternal(ContainerBase.java:717)
    	... 37 more
    Caused by: java.lang.IllegalArgumentException: 名为 [AServlet]和 [Servlet.AServlet] 的servlet不能映射为一个url模式(url-pattern) [/AServlet]
    	at org.apache.tomcat.util.descriptor.web.WebXml.addServletMappingDecoded(WebXml.java:343)
    	at org.apache.tomcat.util.descriptor.web.WebXml.addServletMapping(WebXml.java:336)
    	at org.apache.catalina.startup.ContextConfig.processAnnotationWebServlet(ContextConfig.java:2679)
    	at org.apache.catalina.startup.ContextConfig.processClass(ContextConfig.java:2358)
    	at org.apache.catalina.startup.ContextConfig.processAnnotationsStream(ContextConfig.java:2347)
    	at org.apache.catalina.startup.ContextConfig.processAnnotationsWebResource(ContextConfig.java:2248)
    	at org.apache.catalina.startup.ContextConfig.processAnnotationsWebResource(ContextConfig.java:2242)
    	at org.apache.catalina.startup.ContextConfig.processClasses(ContextConfig.java:1398)
    	at org.apache.catalina.startup.ContextConfig.webConfig(ContextConfig.java:1303)
    	at org.apache.catalina.startup.ContextConfig.configureStart(ContextConfig.java:986)
    	at org.apache.catalina.startup.ContextConfig.lifecycleEvent(ContextConfig.java:303)
    	at org.apache.catalina.util.LifecycleBase.fireLifecycleEvent(LifecycleBase.java:123)
    	at org.apache.catalina.core.StandardContext.startInternal(StandardContext.java:5077)
    	at org.apache.catalina.util.LifecycleBase.start(LifecycleBase.java:183)
    	... 38 more
    ```

    - **已解决**

    ```
    对于Tomcat的D:\apache-tomcat-9.0.55\conf\catallina.properties文件进行了配置修改。
    改为：tomcat.util.scan.StandardJarScanFilter.jarsToSkip=*.jar
    然后重启Tomcat，自己重新写一个配置文件，不要从别的地方复制。
    web.xml放在 src\main\webapp\WEB-INF\ 里面
    ```

    - **新问题**

    ```
    挂不了多过滤器。
    ```

    

在**多过滤器**中，FilterChain#doFilter()方法，执行目标资源或者下一个过滤器，优先执行下一个过滤器。

```
filter1...
filter2...
something
```



### 2. 四种拦截方式

- 拦截请求（Dispatcher）
- 拦截转发（Forward）
- 拦截包含（Include）
- 拦截错误（Error）

在`<filter-mapping>`里面进行配置。

```xml
<filter-mapping>
	<dispatcher>REQUEST</dispatcher>
	<dispatcher>FORWARD</dispatcher>
	<dispatcher>INCLUDE</dispatcher>
	<dispatcher>ERROR</dispatcher>
</filter-mapping>
```

- `REQUEST` 是默认的。在写了别的后，默认的就没了。
- 在错误的时候，会进入我们写的错误的页面。

```xml
<error-page>
	<error-code>500</error-code>
    <location>/500.jsp</location>
</error-page>
```



### 3. 控制多个过滤器的执行顺序

在 `<filter-mapping>` 的配置顺序，决定了过滤器的执行顺序



### 4. 小结

- 几乎是所有的`Servlet`都需要写`request.setCharacterEncoding()` ，可以把它写入到一个`Filter`中，做预处理工作。

- 通过条件判断是否放行。
- 在目标资源执行后，做一些后续特殊工作的处理——回程拦截。



## 六、监听器Listener



### 1. 什么是监听器

- 初次见面：AWT
- 二次见面：SAX
- 三次见面：今天



监听器的特点：

- 它是一个接口，内容由我们实现
- 它需要注册，例如注册到按钮上
- 监听器中的方法，会在特殊事件发生时被调用



观察者模式：

- 事件源：引发事件的源头。
  - 小偷
- 事件。
  - 偷东西
- 监听器：对事件进行监听和处理。
  - 警察——抓捕

**AWT实例：**

```java
package AWT_Test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300,200);
		frame.setLocation(200, 200);
		frame.setLayout(new FlowLayout());  // 流式布局管理器管家
		// 默认管家是BorderLayout，东南西北中
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn = new JButton("确定");
		frame.add(btn);
		
		// 监听器：在点击的时候，触发事件
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello");
			}
		});
		
		
		frame.setVisible(true);
	}
}

/*
	actionPerformed：事件
	click：事件源
	ActionListener：监听者
*/
```



### 2. 概述以及生命周期

JavaWeb中的监听器：

- 事件源：三大域！
  - **ServletContext**：随服务器出生和死亡
    - 生命周期监听：ServletContextListener，两个方法，分别在出生和死亡的时候调用。
    - 属性监听：ServletContextAttributeListener，三个方法，分别在添加属性、替换属性、移除属性的时候调用。
  - **HttpSession**：有人访问，且调用request.getSession()或者访问JSP，就有session
    - 生命周期监听：HttpSessionListener，两个方法，分别在出生和死亡的时候调用。
    - 属性监听：HttpSessionAttributeListener，三个方法，分别在添加属性、替换属性、移除属性的时候调用。
  - **ServletRequest**：请求发出时候会创建，访问静态资源不会创建。
    - 生命周期监听：ServletRequestListener，两个方法，分别在出生和死亡的时候调用。
    - 属性监听：ServletRequestAttributeListener，三个方法，分别在添加属性、替换属性、移除属性的时候调用。

- JavaWeb中完成编写监听器：
  - 写一个监听器类：要求必须去实现某个监听器接口。
  - 注册：在web.xml中配置完成注册。
- 事件对象：
  - ServletContextEvent：ServletContext getServletContext();
  - HttpSessionEvent：HttpSession getSession();
  - ServletRequestEvent：
    - ServletContext getServletContext();
    - ServletRequest getServletRequest();

```java
package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * ServletContext生死监听
 */
public class AListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("出生之前调用：");
		System.out.println("我出生了吗？");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("我死之前干的事儿：");
		System.out.println("我死了吗？");
	}
	
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="https://jakarta.ee/xml/ns/jakartaee" xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd" version="5.0">
  <listener>
  	<listener-class>listener.AListener</listener-class>
  </listener>
</web-app>
```



### 3. 属性监听

```java
package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener("/BListener")
public class BListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("1 您向application添加了一个属性，名为：" +
					event.getName() + ",值为：" +
					event.getValue() + "的属性");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("2 "+
				event.getName() + ",老值为：" +
				event.getValue() + ",新值为：" +
				event.getServletContext().getAttribute(event.getName()));
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("3 " +
				event.getName() + ",值为：" +
				event.getValue() + ". 告辞！");
	}

}

```

```jsp
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
<%
application.setAttribute("xxx", "xxx");
application.setAttribute("xxx", "YYY");
application.removeAttribute("xxx");
%>
  </body>
</html>
```

- ServletContextEvent：ServletContext	getServletContext();
- HttpSessionEvent：HttpSession getSession();
- ServletRequest：
  - ServletContext  getServletContext();
  - ServletRequest  getServletRequest();
- ServletContextAttributeEvent：
  - ServletContext  getServletContext();
  - String getName();  获取属性名
  - String getValue();  获取属性值
- HttpSessionBindingEvent: 略
- ServletRequestAttributeEvent: 略



### 4. 其他监听器

- 感知监听（都与HttpSession相关）
  - 它用来添加到 JavaBean 上，而不是添加到三大域上。
  - 这两个监听器都不需要在 web.xml 中注册。

**User 类**

```java
package listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener{
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	public User() {}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	// session绑定了我
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("啊？？？？");
	}
	// session解绑了我
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("啊！！！！");
	}
		
}
```

**add.jsp**

```jsp
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  	<h1>add</h1>
  	<br>
  	<jsp:useBean id="user" class="listener.User" scope="page" />
<%
session.setAttribute("user", user);
%>
</body>
</html>
```

**remove.jsp**

```jsp
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
<%
session.removeAttribute("user");
%>
  </body>
</html>
```

**异常：** 这是由于jsp无法解析类的实例化的问题。

```
org.apache.jasper.JasperException: /add.jsp (行.: [12], 列: [3]) useBean类属性[listener.User]的值无效。
	org.apache.jasper.compiler.DefaultErrorHandler.jspError(DefaultErrorHandler.java:42)
	org.apache.jasper.compiler.ErrorDispatcher.dispatch(ErrorDispatcher.java:292)
	org.apache.jasper.compiler.ErrorDispatcher.jspError(ErrorDispatcher.java:115)
	org.apache.jasper.compiler.Generator$GenerateVisitor.visit(Generator.java:1381)
	org.apache.jasper.compiler.Node$UseBean.accept(Node.java:1186)
	org.apache.jasper.compiler.Node$Nodes.visit(Node.java:2389)
	org.apache.jasper.compiler.Node$Visitor.visitBody(Node.java:2441)
	org.apache.jasper.compiler.Node$Visitor.visit(Node.java:2447)
	org.apache.jasper.compiler.Node$Root.accept(Node.java:470)
	org.apache.jasper.compiler.Node$Nodes.visit(Node.java:2389)
	org.apache.jasper.compiler.Generator.generate(Generator.java:3609)
	org.apache.jasper.compiler.Compiler.generateJava(Compiler.java:258)
	org.apache.jasper.compiler.Compiler.compile(Compiler.java:392)
	org.apache.jasper.compiler.Compiler.compile(Compiler.java:368)
	org.apache.jasper.compiler.Compiler.compile(Compiler.java:352)
	org.apache.jasper.JspCompilationContext.compile(JspCompilationContext.java:605)
	org.apache.jasper.servlet.JspServletWrapper.service(JspServletWrapper.java:400)
	org.apache.jasper.servlet.JspServlet.serviceJspFile(JspServlet.java:378)
	org.apache.jasper.servlet.JspServlet.service(JspServlet.java:326)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)
```

```
例外情况

org.apache.jasper.JasperException: org.apache.jasper.JasperException: java.lang.ClassNotFoundException: org.apache.jsp.add_jsp
	org.apache.jasper.servlet.JspServletWrapper.handleJspException(JspServletWrapper.java:590)
	org.apache.jasper.servlet.JspServletWrapper.service(JspServletWrapper.java:426)
	org.apache.jasper.servlet.JspServlet.serviceJspFile(JspServlet.java:378)
	org.apache.jasper.servlet.JspServlet.service(JspServlet.java:326)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)
根本原因。

org.apache.jasper.JasperException: java.lang.ClassNotFoundException: org.apache.jsp.add_jsp
	org.apache.jasper.servlet.JspServletWrapper.getServlet(JspServletWrapper.java:198)
	org.apache.jasper.servlet.JspServletWrapper.service(JspServletWrapper.java:414)
	org.apache.jasper.servlet.JspServlet.serviceJspFile(JspServlet.java:378)
	org.apache.jasper.servlet.JspServlet.service(JspServlet.java:326)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)
根本原因。

java.lang.ClassNotFoundException: org.apache.jsp.add_jsp
	java.base/java.net.URLClassLoader.findClass(URLClassLoader.java:435)
	org.apache.jasper.servlet.JasperLoader.loadClass(JasperLoader.java:128)
	org.apache.jasper.servlet.JasperLoader.loadClass(JasperLoader.java:59)
	org.apache.jasper.servlet.JspServletWrapper.getServlet(JspServletWrapper.java:193)
	org.apache.jasper.servlet.JspServletWrapper.service(JspServletWrapper.java:414)
	org.apache.jasper.servlet.JspServlet.serviceJspFile(JspServlet.java:378)
	org.apache.jasper.servlet.JspServlet.service(JspServlet.java:326)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)
```



### 5. session序列化

session是因浏览器而异的，保存的数据只是在当前浏览器的session里面。

session是具有记忆化的，你重启服务器后，进入同样的浏览器依然会有记录，可以在配置文件 `/tomcat/conf/context.xml `的 `<Context>` 标签里面添加 `<Manager pathname="" />` 。

**a.jsp**

```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
我添加了session数据啊
<%
session.setAttribute("xxx", "我是快乐的小session");
%>
</body>
</html>
```

**b.jsp**

```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
我是存放session的啊
<br>
<%
out.print(session.getAttribute("xxx"));
%>
</body>
</html>
```



### 6. session的钝化和活化

**钝化和活化：**在某一瞬间，可能网站访问过多，然后session保存过多，这时候有个别的session会有很长时间没有活动，然后服务器会把很长时间没有人使用的session扔到硬盘上**（钝化）**。当访问的时候，又会从硬盘中抓回来**（活化）**。

可以在 `context.xml` 中添加下面的配置，然后会对所有的web项目生效。

```xml
<Manager className="org.apache.catalina.session.PersistentManager" maxIdleSwap="1">
	<Store className="org.apache.catalina.session.FileStore" directory="mysession"/>
</Manager>
```

钝化：就是1分钟后把session信息保存到mysession文件夹里面。

活化：就是使用的时候，再从这个文件夹里面读取自己的session信息，但是这个文件夹里面的session信息还在，不会删除。

```java
package listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

// 无论是钝化还是活化，都是序列化和反序列化的实现
// 所以需要实现序列化接口，才能完美的跟着session一起序列化
public class newUser implements HttpSessionActivationListener, Serializable{
	
	// 钝化
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("啊！我走了，火星更安全！");
	}
	
	// 活化
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("啊！我来了，地球还是好啊！");
	}
	
}
```





## 七、三大组件案例



### 案例1：分IP统计访问次数

说明：网站统计每个IP地址访问本网站的次数。

分析：

- 统计工作都需要在所有资源之前执行，那么就需要放在Filter里面。也就是我们这个过滤器不做拦截操作，而是做统计。
- 使用**Map<String, Integer> ===> Map<ip, count>** 来记录每个ip访问本网站的次数。（只需要一个Map就够了——根据实际情况决定要多少内存保存数据）
  - 使用ServletContextListener，在服务器开启的时候，创建Map。
  - Map保存到ServletContext中。
  - Map需要在Filter中保存数据。
  - Map需要在页面中显示数据。

**Filter**

```java
package Filter;

import java.io.IOException; 
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 从application中获取Map
 * 从request中得到当前客户端的IP，然后进行Map统计
 * @author 18343
 *
 */
@WebFilter("/AFilter")
public class AFilter implements Filter{
	ServletContext context;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		context = filterConfig.getServletContext();
	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * 1. 得到app里面的Map
		 * 2. 从request里面获取当前客户端的ip地址
		 * 3. 查看map中是否存在这个ip对应访问次数，如果存在，把次数+1再保存回去
		 * 4. 如果不存在，则存入，次数赋值为1
		 * 5. 把Map再放回app里面，表示更新
		 */
		// 1
		Map<String, Integer> map = (Map)context.getAttribute("map");
		// 2
		String ip = request.getRemoteAddr();
		// 3 4
		map.put(ip, map.getOrDefault(ip, 0)+1);
		// 5
		context.setAttribute("map", map);
		
		// 放行
		chain.doFilter(request, response);
	}

}
```

**Listener**

```java
package Listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("/AListener")
public class AListener implements ServletContextListener{
	// 在服务器启动的时候，创建Map，然后保存到ServletContext里面
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Map<String ,Integer> map = new HashMap<>();
		ServletContext application = sce.getServletContext();
		application.setAttribute("map", map);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
```

**show.jsp**

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">显示结果</h1>
	<table align="center" width="60%" border="1">
		<tr>
			<th>IP</th>
			<th>次数</th>
		</tr>
		<c:foreach items="${applicationScope.map}" var="entry">
			<tr>
				<td>${entry.key}</td>
				<td>${entry.value}</td>
			</tr>
		</c:foreach>
	</table>
</body>
</html>	
```

**遇到的问题**

```
c:foreach 没有激活，网上方案，没有导报的问题。
```

**解决方案：**

```
导入两个包：jstl.jar 和 standard.jar
在jsp头部加入这一行：
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```





### 案例2：粗粒度权限管理

- user：用户可以访问的文件夹
- admin：管理员可以访问的文件夹
- 其他：都可以访问的范围



**a.jsp**

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>欢迎光临！Admin！</h1>
	<a href="<c:url value='/index.jsp'/>">游客入口</a> <br>
    <a href="<c:url value='/users/u.jsp'/>">会员入口</a><br>
    <a href="<c:url value='/admin/a.jsp'/>">管理员入口</a><br>
</body>
</html>
```



**u.jsp**

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>欢迎光临！User！</h1>
	<a href="<c:url value='/index.jsp'/>">游客入口</a> <br>
    <a href="<c:url value='/users/u.jsp'/>">会员入口</a><br>
    <a href="<c:url value='/admin/a.jsp'/>">管理员入口</a><br>
</body>
</html>
```



**index.jsp**

```jsp
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <h1>到此一游！</h1>
	<a href="<c:url value='/index.jsp'/>">游客入口</a> <br>
    <a href="<c:url value='/users/u.jsp'/>">会员入口</a><br>
    <a href="<c:url value='/admin/a.jsp'/>">管理员入口</a><br>
  </body>
</html>
```



**login.jsp**

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>登录</h1>
${msg}
<form action="<c:url value='/LoginServlet'/>" method="post">
	用户名：<input type="text" name="username"/>
	<input type="submit" value="登录" />
</form>
</body>
</html>
```



**UserFilter**

```java
package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UserFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * 1. 得到Session
		 * 2. 判断Session中是否存在admin，如果存在则放行
		 * 3. 判断Session中是否存在username，如果存在则放行，否则打回login.jsp
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		String name = (String)req.getSession().getAttribute("admin");
		if(name!=null) {
			chain.doFilter(request, response);
			return;
		}
		name = (String)req.getSession().getAttribute("username");
		if(name!=null) {
			chain.doFilter(request, response);
		}else {
			request.setAttribute("msg", "您啥也不是，回去吧");
			request.getRequestDispatcher("/login.jsp")
			.forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
}
```



**AdminFilter**

```java
package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AdminFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * 1. 得到Session
		 * 2. 判断Session中是否存在admin，如果存在则放行
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		String name = (String)req.getSession().getAttribute("admin");
		if(name!=null) {
			chain.doFilter(request, response);
		}else {
			request.setAttribute("msg", "您不是管理员，回去吧");
			request.getRequestDispatcher("/login.jsp")
			.forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

}
```



**LoginServlet**

```java
package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 1. 获取用户名
		 * 2. 判断用户名是否包含itcast
		 * 3. 如果包含就是管理员，否则是普通会员
		 * 4. 要把登录的名称保存到session里面
		 * 5. 转发到index.jsp 
		 */
		String username = req.getParameter("username");
		if(username.contains("itcast")) {
			req.getSession().setAttribute("admin", username);
		}else {
			req.getSession().setAttribute("username", username);
		}
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
```



**web.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" id="WebApp_ID" version="4.0">
  <display-name>案例2_粗粒度权限管理</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  
  <servlet>
  	<servlet-name>Login</servlet-name>
  	<servlet-class>Servlet.LoginServlet</servlet-class>
  </servlet>
  
  <filter>
  	<filter-name>UserFilter</filter-name>
  	<filter-class>Filter.UserFilter</filter-class>
  </filter>
  <filter>
  	<filter-name>AdminFilter</filter-name>
  	<filter-class>Filter.AdminFilter</filter-class>
  </filter>
  
  <servlet-mapping>
    <servlet-name>Login</servlet-name>
    <url-pattern>/LoginServlet</url-pattern>
  </servlet-mapping>
  
  <filter-mapping>
		<filter-name>AdminFilter</filter-name>
		<url-pattern>/admin/*</url-pattern>
  </filter-mapping>
  <filter-mapping>
		<filter-name>UserFilter</filter-name>
		<url-pattern>/users/*</url-pattern>
  </filter-mapping>
  
</web-app>
```



**问题**

```
servlet访问失败
```



### 案例3：解决全站字符编码问题

- servlet
  - POST：`request.setCharacterEncoding("utf-8"); `
  - GET：分两步走
    - `String username = request.getParameter("uername");`
    - `username = new String(username.getBytes("ISO-8859-1"), "utf-8");`

**AServlet**

```java
package anli3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().print(request.getParameter("username"));
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().print(request.getParameter("username"));
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}
}
```



**EncodingRequest**

```java
package request;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


/**
 * 装饰request
 * 装饰者模式
 * HttpServletRequestWrapper就是实现了HttpServletRequest，把里面300行代码都重写了
 */
public class EncodingRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	
	public EncodingRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	public String getParameter(String name) {
		String value = request.getParameter(name);
		// 处理编码
		try {
			value = new String(value.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}
	
}
```



**EncodingFilter**

```java
package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import request.EncodingRequest;

public class EncodingFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 只处理编码问题，肯定放行
		// 处理post请求编码问题
		request.setCharacterEncoding("utf-8");
		// 处理get请求编码问题
		/*
		 * 调包request
		 * 1. 写一个request装饰类
		 * 2. 在放行时，使用我们自己的request
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		if(req.getMethod().equals("GET")) {
			EncodingRequest er = new EncodingRequest(req);
			chain.doFilter(er, response);
		}else {
			chain.doFilter(request, response);
		}
	}
	@Override
	public void destroy() {
		
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
}
```



### 案例4：页面静态化

#### 1. 准备工作——图书管理

- **页面**

- jsp：链接页面（link.jsp）。四个超链接：
  - 查看所有
  - 查看SE分类
  - 查看EE分类
  - 查看框架分类
- show.jsp：显示查询结果



- **Servlet**
- BookServlet
  - findAll：查看所有图书
  - findByCategory：按分类查询

- BookService：略。
- BookDao：
  - findAll() --> List<Book\>
  - findByCategory() --> List<Book\>

- domain：Book类

```sql
create table t_book{
	bid CHAR(32) PRIMARY KEY,
	bname VARCHAR(200),
	price NUMERIC(10,2),
	category INT
};

INSERT INTO t_book VALUES('b1', 'JavaSE_1', 10, 1);
INSERT INTO t_book VALUES('b2', 'JavaSE_2', 30, 1);
INSERT INTO t_book VALUES('b3', 'JavaSE_3', 22, 1);
INSERT INTO t_book VALUES('b4', 'JavaSE_4', 15, 1);

INSERT INTO t_book VALUES('b5', 'JavaEE_1', 50, 2);
INSERT INTO t_book VALUES('b6', 'JavaEE_2', 80, 2);
INSERT INTO t_book VALUES('b7', 'JavaEE_3', 60, 2);

INSERT INTO t_book VALUES('b8', 'JavaFramework_1', 50, 3);
INSERT INTO t_book VALUES('b9', 'JavaFramework_2', 40, 3);
```



**BookServlet**

```java
package anli4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDao;

public class BookServlet extends BaseServlet {
	private BookDao bookDao = new BookDao();
	
	public String findAll(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setAttribute("bookList", bookDao.findAll());
		return "/show.jsp";
		
	}
	
	public String findByCategory(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String value = req.getParameter("category");
		int category = Integer.parseInt(value);
		req.setAttribute("bookList", bookDao.findByCategory(category));
		return "/show.jsp";
	}
}
```



**BookDao**

```java
package Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Book;


public class BookDao {
	private QueryRunner qr = new TxQueryRunner();
	
	public List<Book> findAll(){
		try {
			String sql = "select * from t_book";
			return qr.query(sql,new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public List<Book> findByCategory(int category){
		try {
			String sql = "select * from t_book where category=?";
			return qr.query(sql, new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

} 
```



**Book**

```java
package domain;

public class Book {
	private String bid;
	private String bname;
	private double price;
	private int category;
	
	public Book() {}
	
	public Book(String bid, String bname, double price, int category) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.price = price;
		this.category = category;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", price=" + price + ", category=" + category + "]";
	}
	
}
```



**link.jsp**

```jsp
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
	<h1>链接页面</h1>
	<a href="<c:url value='/BookSevlet?method=findAll'/>">查询所有</a> <br>
	<a href="<c:url value='/BookSevlet?method=findByCategory&category=1'/>">查询SE</a> <br>
	<a href="<c:url value='/BookSevlet?method=findByCategory&category=2'/>">查询EE</a> <br>
	<a href="<c:url value='/BookSevlet?method=findByCategory&category=3'/>">查询Framework</a> <br>
  </body>
</html>
```



**show.jsp**

```jsp
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
	<h1 align="center">图书列表</h1>
	<table align="center" border="1" width="50%">
		<tr>
			<th>图名</th>
			<th>单价</th>
			<th>分类</th>
		</tr>
		<c:forEach items="${bookList} }" var="book">
			<tr>
				<td>${book.bname }</td>
				<td>${book.price }</td>
				<c:choose>
					<c:when test="${book.category eq 1 }"><td style="color:red">JavaSE</td></c:when>
					<c:when test="${book.category eq 2 }"><td style="color:blue">JavaEE</td></c:when>
					<c:when test="${book.category eq 3 }"><td style="color:green">JavaFramework</td></c:when>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
  </body>
</html
```



#### 2. 什么是页面静态化？

首次访问，去数据库获取数据，然后把数据保存到一个html页面中。

二次访问，不再访问数据库，而是直接显示html。



1. **目标**

给出一个过滤器，把Servlet请求的资源做输出保存到html中，重定向到html中。

二次访问的时候，这个html已经存在，那么直接重定向，不用再次访问Servlet。



**BaseServlet**

```java
package anli4;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String methodName = req.getParameter("method");
		
		if(methodName == null || methodName.trim().equals("")) {
			throw new RuntimeException("您没有传递参数！无法确定您想要的方法！");
		}
		
		Class<? extends BaseServlet> c = this.getClass();
		Method method = null;
		try {
			 method = c.getMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("您要调用的方法："+methodName+" 不存在！");
		}

		try {
			
			String result = (String)method.invoke(this, req, resp);
			/*
			 * 获取请求处理方法执行后返回的字符串,它表示转发或重定向的路径
			 * 并且帮他完成转发或者重定向
			 * 分割字符串,得到前缀和后缀,前缀如果是f表示转发,如果是r表示重定向
			 * 后缀表示转发或重定向的路径
			 */
			if(result!=null) {
				if(result.contains(":")) {
					String[] strings = result.split(":");
					if(strings[0].equals("f")) {
						req.getRequestDispatcher(strings[1]).forward(req, resp);
					}else if(strings[0].equals("r")) {
						resp.sendRedirect(strings[1]);
					}else {
						throw new RuntimeException("你指定的操作:"+strings[0]+",暂不支持!");
					}
				}else {  // 默认转发
					req.getRequestDispatcher(result).forward(req, resp);
				}
			}
			
		} catch (Exception e) {
			System.out.println("您调用的方法："+methodName+" 内部抛出了异常！");
			System.out.println("------------------------------------");
			throw new RuntimeException(e);
		}
	}
}
```



**BookServlet**

```java
package anli4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDao;

public class BookServlet extends BaseServlet {
	private BookDao bookDao = new BookDao();
	
	public String findAll(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setAttribute("bookList", bookDao.findAll());
		return "/show.jsp";
		
	}
	
	public String findByCategory(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String value = req.getParameter("category");
		int category = Integer.parseInt(value);
		req.setAttribute("bookList", bookDao.findByCategory(category));
		return "/show.jsp";
	}
}
```



**Book**

```java
package domain;

public class Book {
	private String bid;
	private String bname;
	private double price;
	private int category;
	
	public Book() {}
	
	public Book(String bid, String bname, double price, int category) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.price = price;
		this.category = category;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", price=" + price + ", category=" + category + "]";
	}
	
}
```



**BookDao**

```java
package Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Book;


public class BookDao {
	private QueryRunner qr = new TxQueryRunner();
	
	public List<Book> findAll(){
		try {
			String sql = "select * from t_book";
			return qr.query(sql,new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public List<Book> findByCategory(int category){
		try {
			String sql = "select * from t_book where category=?";
			return qr.query(sql, new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

} 
// TxQueryRunner：这个是课程里面他们自己实现的一个类
```



**StaticFilter**

```java
package Filter;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StaticFilter implements Filter{
	FilterConfig config;
	public StaticFilter() {
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		ServletContext servletContext = config.getServletContext();
		/*
		 * 1. 第一次访问时，要查找请求对应的html是否存在，如果存在，则重定向
		 * 2. 如果不存在则放行。把Servlet访问数据库后输出给客户端的数据放进html中，再重定向。
		 */
		/*
		 * 一、获取category参数
		 * 		category有四种可能：
		 * 		1. -->null.html
		 * 		2. -->1.html
		 * 		3. -->2.html
		 * 		4. -->3.html
		 * html都保存在htmls文件夹里面
		 * 
		 * 判断对应的html文件是否存在，如果存在，直接重定向。
		 */
		String category = request.getParameter("category");
		String htmlName = category + ".html";
		String htmlPath = servletContext.getRealPath("/htmls");
		File destFile = new File(htmlPath, htmlName);
		if(destFile.exists()) {
			// 重定向到这个文件
			// 病毒攻击：手动创建文件，假装有这个文件，但是里面的信息是错误的
			resp.sendRedirect(req.getContextPath() + "/htmls/" + htmlName);
			return;
		}
			
		/*
		 * 二、如果html不存在，我们就生成html
		 * 1. 放行。show.jsp会做出很多输出，我们让输出到指定的html中，而不是客户端。
		 * 2. 调包response，让他的getWriter和一个html文件绑定，可以让数据输出到html里面。
		 */
		StaticResponse res = new StaticResponse(resp, destFile.getAbsolutePath());
		// 这里因为是调包，所以不是给客户端做出响应，下面的重定向才能执行
		// 如果这里没有调包直接做出响应了，那么下面的再次重定向就是异常，因为二次响应了
		chain.doFilter(request, res); // 放行，生成了对应的html
		// 再次重定向到html中，显示数据给客户端
		resp.sendRedirect(req.getContextPath() + "/htmls/" + htmlName);
	}
	@Override
	public void destroy() {}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
	}
}
```



**StaticResponse**

```java
package Filter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class StaticResponse extends HttpServletResponseWrapper {
	
	private HttpServletResponse response;
	private PrintWriter pw;
	
	// 这个路径的文件如果不存在，则会自动创建
	public StaticResponse(HttpServletResponse response, String path) 
			throws FileNotFoundException, UnsupportedEncodingException {
		super(response);
		this.response = response;
		// 创建一个与html文件绑定到一起的流对象
		pw = new PrintWriter(new File(path), "utf-8");
	}
	
	/*
	 * 返回一个和html绑定的printWriter对象
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		// 这样数据都输出到html文件中
		return pw;
	}

}
```



**show.jsp**

```jsp
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">

        <title>My JSP 'index.jsp' starting page</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">    
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <meta http-equiv="Context-Type" content="text/html;charset=utf-8">
        <!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
    </head>

    <body>
        <h1 align="center">图书列表</h1>
        <table align="center" border="1" width="50%">
            <tr>
                <th>图名</th>
                <th>单价</th>
                <th>分类</th>
            </tr>
            <c:forEach items="${bookList} }" var="book">
                <tr>
                    <td>${book.bname }</td>
                    <td>${book.price }</td>
                    <c:choose>
                        <c:when test="${book.category eq 1 }"><td style="color:red">JavaSE</td></c:when>
                        <c:when test="${book.category eq 2 }"><td style="color:blue">JavaEE</td></c:when>
                        <c:when test="${book.category eq 3 }"><td style="color:green">JavaFramework</td></c:when>
                    </c:choose>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
```



**link.jsp**

```jsp
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
	<h1>链接页面</h1>
	<a href="<c:url value='/BookSevlet?method=findAll'/>">查询所有</a> <br>
	<a href="<c:url value='/BookSevlet?method=findByCategory&category=1'/>">查询SE</a> <br>
	<a href="<c:url value='/BookSevlet?method=findByCategory&category=2'/>">查询EE</a> <br>
	<a href="<c:url value='/BookSevlet?method=findByCategory&category=3'/>">查询Framework</a> <br>
  </body>
</html>
```



**乱码问题：**

```
所有输出到html的数据，都是经由show.jsp做到的，那么只需要在show.jsp里面添加下面这一行，就相当于给每个html都添加了这一行，以此解决了字符集的问题：
<meta http-equiv="Context-Type" content="text/html;charset=utf-8">
```













