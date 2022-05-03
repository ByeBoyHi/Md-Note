# SpringMVC



## 一、简介



### 1. 什么是MVC

Model：数据模型

View：视图

Controller：控制器

思想：将所有客户端请求全部交由控制器。由控制器将其分发并将结果相应给客户端。



### 2. 常见MVC框架

使用原生的Servlet实现MVC：

- 配置比较复杂；
- 数据处理麻烦；

实际开发中都会使用MVC框架，如 Struts1(out)、Struts2(out)、SpringMVC等。

对比：

- 效率方面：Strust1 > SpringMVC > Struts2
  - Struts2是多例的，效率低。
  - Struts1和SpringMVC是单例的，两者效率差不多

- 配置方面：SpringMVC > Struts2 > Struts1



### 3. 为什么使用SpringMVC

- 使用注解配置替代xml配置，更简洁
- 效率高，单例实现
- 扩展好，用户自定义
- SpringMVC 和 Spring 可以实现无缝衔接



## 二、SpringMVC的实现原理



### 1. 流程图

![1648960217626](D:\27.md笔记\springmvc\1648960217626.png)





### 2. 执行过程

分为六步：

- DispatcherServlet
  - SpringMVC核心控制器：前端控制器，主要作用是用来分发。
- HandlerMapping
  - 映射处理器：根据请求 url 映射到具体的处理器 handler。
  - Handler 就是 Controller 层的实现类，也成为 Action或者Controller。
- HandlerAdapter
  - 适配器：用来适配不同的处理器Handler
  - 处理器有两种实现方式：实现接口、基于注解。所以执行之前需要先进行适配
- Handler
  - 处理器：执行并且处理具体的业务，并且返回对应的数据模型Model和对应的视图View。
  - Handler会将数据模型和视图封装为一个对象ModelAndView并且返回。
- ViewResolver
  - 视图解析器：根据得到的视图的名称，解析为具体的视图，一般多为jsp页面，然后封装为View的对象进行返回。
- View
  - 视图：使用具体的视图技术进行渲染，结合Model展示数据。
  - 视图有很多种形式：jsp、freemarker、velocity、excel、pdf等。



## 三、第一个SpringMVC程序



### 1. 添加jar包（POM.XML）

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>org.example</groupId>
  <artifactId>springmvc_init</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>

  <name>springmvc_init Maven Webapp</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.13.2</version>
      <scope>test</scope>
    </dependency>

    <!--  ioc  -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>5.3.17</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>5.3.17</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>5.3.17</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-expression</artifactId>
      <version>5.3.17</version>
    </dependency>

    <!--  aop  -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aop</artifactId>
      <version>5.3.17</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aspects</artifactId>
      <version>5.3.17</version>
    </dependency>

    <!--  Web  -->
<!--    <dependency>-->
<!--      <groupId>org.springframework</groupId>-->
<!--      <artifactId>spring-web</artifactId>-->
<!--      <version>5.3.17</version>-->
<!--    </dependency>-->

    <!--  Spring MVC  -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.3.17</version>
    </dependency>

    <!--  JDBC  -->
    <!--    <dependency>-->
    <!--      <groupId>org.springframework</groupId>-->
    <!--      <artifactId>spring-jdbc</artifactId>-->
    <!--      <version>5.3.17</version>-->
    <!--    </dependency>-->
    <!--    <dependency>-->
    <!--      <groupId>com.mysema.spring</groupId>-->
    <!--      <artifactId>spring-tx-annotations</artifactId>-->
    <!--      <version>0.1.0</version>-->
    <!--    </dependency>-->
    <!--    <dependency>-->
    <!--      <groupId>eu.cdevreeze.springtx</groupId>-->
    <!--      <artifactId>spring-tx-scala-utils_2.9.1</artifactId>-->
    <!--      <version>0.3.1</version>-->
    <!--    </dependency>-->

    <!--  MyBatis  -->
    <!--    <dependency>-->
    <!--      <groupId>org.mybatis</groupId>-->
    <!--      <artifactId>mybatis</artifactId>-->
    <!--      <version>3.5.9</version>-->
    <!--    </dependency>-->
    <!--    <dependency>-->
    <!--      <groupId>org.mybatis</groupId>-->
    <!--      <artifactId>mybatis-spring</artifactId>-->
    <!--      <version>2.0.7</version>-->
    <!--    </dependency>-->

    <!--  javaee  -->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>jsp-api</artifactId>
      <version>2.2</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>

  </dependencies>

  <build>
    <finalName>springmvc-init</finalName>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->

      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-war-plugin</artifactId>
          <version>3.2.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>

        <plugin>
          <groupId>org.apache.tomcat.maven</groupId>
          <artifactId>tomcat7-maven-plugin</artifactId>
          <version>2.2</version>
          <configuration>
            <path>/</path>
            <port>8001</port>
          </configuration>
        </plugin>
      </plugins>

    </pluginManagement>
  </build>
</project>
```



### 2. 配置核心控制器（WEB.XML）

```xml
<!-- 1. 配置核心控制器DispatcherServlet -->
  <servlet>
    <servlet-name>springMVC</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!--  在启动的时候就执行  -->
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>springMVC</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
```



### 3. 创建核心配置文件

两种定义方式：

- 使用默认的位置，默认在 `WEB-INF` 目录下，名字为：`核心Servlet名字-servlet.xml`
- 自定义位置和名字，使用之前需要指定名字和位置

根据Controller实现方式的不同，配置方式也有所不同。（HandlerMapping和HandlerAdapter不一样）

- 实现接口
- 基于注解



#### 3.1 实现接口的Controller

分六步：

第一步：新建自己的配置文件

![1648969146382](D:\27.md笔记\springmvc\1648969146382.png)

后面五部，在配置文件中配置对应的信息：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- 2.配置HandlerMapping（基于接口）   -->
    <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>

    <!-- 3.配置HandlerAdapter   -->
    <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>

    <!-- 4.配置handler   -->
    <!-- name是访问这个控制器的url，class就是我的控制器的类   -->
    <bean name="/hello" class="controller.HelloController"/>

    <!-- 5.配置视图解析器ViewResolver   -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <!-- 前缀 -->
        <property name="prefix" value="/WEB-INF/view/" />
        <!-- 后缀 -->
        <property name="suffix" value=".jsp"/>

        <!--  6.配置view，使用jsp视图技术渲染页面  -->
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
    </bean>

</beans>
```

**HelloController.class**

```java
package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 控制器就是handler

public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "hello "+ name);  // 数据
        mav.setViewName("hello");  // 视图名称

        return mav;
    }
}
```



#### 3.2 基于注解的Controller

第一步：新建自定义配置文件。

![1648970803513](D:\27.md笔记\springmvc\1648970803513.png)

后面五步：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
    <!-- 2.指定HandlerMapping -->
    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"/>

    <!-- 3.配置HandlerAdapter -->
    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter"/>

    <!-- 4.配置Handler：根据注解配置的Controller，会加到ioc里面，直接扫包 -->
    <!-- 并且在Controller.class里面配置@RequestMapping注解，指定URL -->
    <context:component-scan base-package="controller"/>

    <!-- 5.配置ViewResolver  -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/view/"/>
        <property name="suffix" value=".jsp"/>
        <!-- 6.配置View -->
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
    </bean>

</beans>
```

**HelloAnnotation.class**

```java
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloAnnotation {

    // 指定访问的URL
    @RequestMapping("/hello2")
    public ModelAndView sayHello(String name){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", name);
        mav.setViewName("hello");
        return mav;
    }
}
```

**在web.xml中指定自定义配置文件**

```xml
<!-- 指定自定义配置文件的信息 -->
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:springmvc.xml</param-value>
    </init-param>
<!-- 要在<load-on-startup>后面 -->
```



#### 3.3 基于注解的简化

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!--  自动配置HandlerAdapter、HandlerMapping -->
    <mvc:annotation-driven/>

    <!-- 4.配置Handler：根据注解配置的Controller，会加到ioc里面，直接扫包 -->
    <!-- 并且在Controller.class里面配置@RequestMapping注解，指定URL -->
    <context:component-scan base-package="controller"/>

    <!-- 5.配置ViewResolver  -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/view/"/>
        <property name="suffix" value=".jsp"/>
        <!-- 6.配置View：如果使用的是JSP视图技术，可以省略不写 -->
    </bean>

</beans>
```

**jsp**

```jsp
<%--
  Created by IntelliJ IDEA.
  User: HeyBoy
  Date: 2022/4/4
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    msg:${msg}
</body>
</html>
```



## 四、案例



### 1. 用户登录



#### 1.1 login.jsp

```jsp
<%--
  Created by IntelliJ IDEA.
  User: HeyBoy
  Date: 2022/4/4
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/js/hello.js"></script>
</head>
<body>
    <h2>用户登录</h2>
    <span style="color:red">${loginErr}</span>
    <%-- 交给login处理 --%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        Account&nbsp;：<input type="text" name="username" /> <br>
        Password：<input type="password" name="password">
        <input type="submit" value="login in">
    </form>

    <%-- ${pageContext.request.contextPath}代表根路径 --%>
    <img src="${pageContext.request.contextPath}/img/springmvc.png" alt="">
</body>
</html>
```



#### 1.2 success.jsp

```jsp
<%--
  Created by IntelliJ IDEA.
  User: HeyBoy
  Date: 2022/4/4
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2 style="color: green">Login Success! Welcome to here, ${username} !</h2>
</body>
</html>
```



#### 1.3 style.css

```css
form{
    border:1px solid red;
}
```



#### 1.4 hello.js

```js
console.log("hello js!");
```





### 2. 静态资源处理

​        静态资源（如：img、css、js）会被web.xml配置的DispatcherServlet拦截，然后DispatcherServlet会调用找对应的handler，而不是去找静态资源，所以在页面里面对应的资源出现**404**。

​        可以把静态资源交给tomcat自带的默认servlet——defaultServlet去处理。由于DispatcherServlet的mapping拦截了所有资源 **'/'**，所以把tomcat的Servlet的 **'/'** 覆盖了。

解决方案：

- 在springmvc.xml中添加配置。

  ```xml
  <!-- 使用tomcat提供的默认Servlet处理静态资源 -->
  <mvc:default-servlet-handler/>
  ```

  缺点：

  1. 如果不是使用的tomcat，则可能不生效，与tomcat耦合
  2. 不能访问WEB-INF下面的静态资源

- 使用SpringMVC处理

  ```xml
  <mvc:resources mapping="/img/**" location="/WEB-INF/img/"/>
  <mvc:resources mapping="/js/**" location="/WEB-INF/js/"/>
  <mvc:resources mapping="/css/**" location="/WEB-INF/css/"/>
  <mvc:resources mapping="/image/**" location="/image/"/>
  ```

  ​        不仅可以访问 `WEB-INF` 里面的静态资源，而且对于其他位置的静态资源，也可以通过映射的方式处理，解决不能处理静态资源的缺陷。



### 3. 直接访问jsp页面

​        默认不能直接访问 `WEB-INF` 目录下的jsp页面，一般都是在 Controller 中做转发映射。

```xml
<!-- 直接访问jsp页面 -->
<mvc:view-controller path="/userLogin" view-name="login"/>
```

​        这里的通过 `/userLogin` 这个路由，直接访问 `login.jsp`，相当于实现了Controller的作用。



## 五、Controller详解



### 1. 方法的返回值

有四种类型：

- ModelAndView：表示返回的data既有数据模型也有视图。

- String：表示返回的是视图的名字

  - 三种写法（形式）：
    - 普通字符串 ——> 视图名称
    - "forward: " + url ——> 转发
    - "redirect: " + url ——> 重定向

- void：将请求的url 作为视图名称，就是把 `RequestMapping` 里面的值当作jsp的名字去找找。

  ```java
  // 他会直接跳转到 success.jsp
  @RequestMapping("/success")
  public void test(){
      System.out.println("test");
  }
  ```

- Object：表示返回的是数据模型。（一般返回的是json数据）



### 2. SpringMVC的注解

| 注解              | 解释                                                         |
| ----------------- | ------------------------------------------------------------ |
| @Controller       | 将类映射为Controller，添加到 IOC 容器中。                    |
| @RequestMapping   | 配置请求映射的url路径                                        |
| @RequestParam     | 表示参数来源于请求参数                                       |
| @PathVariable     | 表示参数来源于请求URL                                        |
| @RequestHeader    | 表示参数来源于请求头                                         |
| @CookieValue      | 表示参数来源于cookie                                         |
| @RequestBody      | 表示参数来源于请求体                                         |
| @ModelAttribute   | 将请求数据转换为对象                                         |
| @Valid            | 后台数据校验                                                 |
| @InitBinder       | 类型转换，注册属性编辑器                                     |
| @ControllerAdvice | 统一异常处理，处理全局异常                                   |
| @ExceptionHandler | 异常处理器，处理特定异常的方法                               |
| @ResponseBody     | 将返回值添加到响应体里面，结合返回值为Object的方法一起使用，返回 JSON 数据 |
| @RestController   | 将类映射到Controller层，默认为所有的方法添加@ResponseBody注解 |



### 3.  @RequestMapping



#### 3.1 基本用法

​        该注解可以放在方法上，也可以定义在类上，在类上的时候，表示层级关系。

​        配置URL时以 / 开头和不以 / 开头的区别：

- 添加时表示从项目的根路径下查找对应的url
- 不添加时表示从当前方法所在层级开始查找



#### 3.2 URL的多种写法

​        请求映射路径有三种写法：

- **Ant风格**
  - 里面可以包含通配符。
  - `*` ：表示单层目录，匹配任意字符，可以没有字符，但是正斜杠必须有
  - `** ` ：表示多层或单层目录，匹配任意字符，可以没有字符，正斜杠也可以么有
  - `?` ：表示单个字符，必须有一个字符
  - 上面的字符当然可以组合一起使用
- **Rest风格**
  - **{变量}：**表示URL中的占位符可以结合@PathVariable来获取值
  - 还可以写正则表达式，进行限制：**{变量：正则}**
- **固定写法**
  - value和path互为别名，值可以传递数组或者单个的字符串，数组的话，里面的每个值都是有效的url



#### 3.3 根据请求方式访问

限定请求方式：GET、POST、PUT、DELETE等

```java
@RequestMapping(method=RequestMapping.GET)   // 只能GET访问
@RequestMapping(method=RequestMapping.POST)  // 只能POST访问
// 等价于
@GetMapping("url")
@PostMapping("url")
```



#### 3.4 其他属性

- params：限定请求参数，必须符合指定条件
- headers：限定请求头，必须符合指定的条件才能访问



#### 3.5 代码

- **`PathController`**

```java
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/path")  // 这个就是指定一个父目录，那样两个Controller里面的方法就可以有一样的url了(层级关系)
public class PathController {

    @RequestMapping("/showLogin")
    public String showLogin() {
        System.out.println("PathController.showLogin");
        return "login";
    }

    @RequestMapping("forwardLogin")
    public String forwardLogin() {
        System.out.println("PathController.forwardLogin");
        return "forward:showLogin";
//        return "forward:/showLogin";
        // 下面和上面是不一样的
        /*
            上面是找的相对路径下的showLogin
            下面找的是根路径下的showLogin
            forward:showLogin === forward:/path/showLogin
         */
    }

    // Ant风格URL
    @RequestMapping("/test1/*")
    public String test1() {
        return "hello";
    }

    @RequestMapping("/test2/**")
    public String test2() {
        return "hello";
    }

    @RequestMapping("/test3/a?")
    public String test3() {
        return "hello";
    }

    /*
        Rest风格
     */
    @RequestMapping("/test4/{id}/{username}")
    // 名字一样，PathVariable可以不用写名字，不一样的话可以在里面备注一下
    // 并且在访问url的时候，参数值必须传
    public String test4(@PathVariable String id, @PathVariable("username") String usr) {
        System.out.println("PathController.test4: id -> " + id);
        System.out.println("PathController.test4: usr -> " + usr);
        return "hello";
    }

    // 正则写错了，导致最开始访问不了
    @RequestMapping("/test5/{id:\\d+}/{username:\\w+}")
    public String test5(@PathVariable String id, @PathVariable("username") String usr) {
        System.out.println("PathController.test5: id -> " + id);
        System.out.println("PathController.test5: usr -> " + usr);
        return "hello";
    }

    // 固定写法
//    @RequestMapping("/test6")
//    @RequestMapping(path = "/test6")
//    @RequestMapping(value = "/test6")
    @RequestMapping(value = {"/test6", "/t6"})
    public String test6() {
        return "hello";
    }

    // 根据请求方式访问

    @RequestMapping(path = "/test7", method = {RequestMethod.POST})
    public String test7() {
        return "hello";
    }

    //    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    @GetMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        System.out.println("PathController.deleteUser, id:" + id);
        return "hello";
    }

    //    @RequestMapping(path = "/user/{id}", method = RequestMethod.POST)
    @PostMapping("/user/{id}")
    public String selectUser(@PathVariable int id) {
        System.out.println("PathController.selectUser, id:" + id);
        return "hello";
    }

    // 其他属性
    // 要求访问必须带 id username password 这三个参数
    // 并且 username==admin 且 password!=123
    @RequestMapping(path = "/test8", params = {"id", "username=admin", "password!=123"})
    public String test8(){
        return "hello";
    }

    // 请求头必须有Cookie，也可以指定别的属性必须等于或者不等于什么
    @RequestMapping(path = "/test9", headers = {"Cookie"})
    public String test9(){
        System.out.println("PathController.test9");
        return "hello";
    }
}
```

- **`PageController`**

```java
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// 用于页面跳转
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/{pageName}")
    public String go(@PathVariable String pageName){
        return pageName;
    }
}
```



## 六. 方法的参数



### 1. JavaEE组件

- HttpServletRequest
- HttpServletResponse
- HttpSession

```java
@RequestMapping("/test1")
public void test1(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
    System.out.println("ParamController.test1 : " + req + ", " + resp + ", " + session);
    String username = req.getParameter("username");
    session.setAttribute("username", username);  // 用户名放到session里面
    Object uername = session.getAttribute("uername");
    System.out.println(username);
    // response响应
    PrintWriter writer = resp.getWriter();
    // 响应到输出页面，文本体
    writer.print("<h1>" + username + "</h1>");
    writer.flush();
    writer.close();
}
```



### 2.  IO流

- InputStream、OutputStream
- Reader、Writer

```java
@RequestMapping("/test2/{usr}")
public void test2(InputStream in, OutputStream out, @PathVariable String usr) throws IOException {
    /*
            相当于：
                request.getInputStream();
                request.getOutputStream();
         */
    System.out.println("ParamController.test2 : \n" + in + "\n" + out);
}

@RequestMapping("/test3")
public void test3(Reader r, Writer w) {
    /*
            相当于：
                request.getReader();
                request.getWriter();
         */
    System.out.println("ParamController.test3: \n" + r + "\n" + w);
}
```



### 3. 向页面传递数据

- Model、Map、ModelMap

将数据存储到Request作用域中的。

```java
@RequestMapping("/test4")
public String test4(Model model, Map map, ModelMap modelMap) {
    // 设置过的值会存储到request里面，然后直接取用
    model.addAttribute("name", "tom");
    map.put("age", 20);
    modelMap.addAttribute("sex", "male");
    modelMap.put("address", "sichuan");
    return "result";
}
```



### 4. String 和 基本类型

@RequestParam，指参数的值来源于请求参数，默认所有参数都加了这个，参数值来源于同名的请求参数。

@PathVariable，表示参数的值来源于URL。

@RequestHeader，参数值来源于请求头。（可以获取请求头里面的一些数据）

@CookieValue，直接从Cookie里面取数据。

@RequestBody，表示参数来源于请求体（POST方式）

```java
@RequestMapping("/test5")
// 这些参数没有加注解，默认来源于请求参数@RequestParam
// 显示的加注解后，那么后面跟着的参数必须有（required=true）
// 不传的时候，可以指定默认值 defaultValue。
public String test5(@RequestParam String username, int age, Double height) {
    System.out.println("ParamController.test5, " + username + " " + age + " " + height);
    return "result";
}

@RequestMapping("/test6/{id}")  // 这个id是来自URL，URL里面的?跟着的参数叫做请求参数
public String test6(@PathVariable("id") int id, String name) {
    System.out.println("ParamController.test6, " + id + " " + name);
    return "result";
}

@RequestMapping("/test7")
// 里面的名字是请求头里面的属性的真实名字，用来映射到我们对应的形参上
public String test7(@RequestHeader("User-Agent") String userAgent, @RequestHeader("Cookie") String cookie) {
    System.out.println("ParamController.test7, " + userAgent + " " + cookie);
    return "result";
}

@RequestMapping("/setCookie")
public String setCookie(HttpServletResponse resp) {
    // 向客户端添加cookie，需要response对象，响应回去
    Cookie cookie = new Cookie("username", "admin");
    cookie.setMaxAge(7 * 24 * 60 * 60); // 7day
    resp.addCookie(cookie);
    return "result";
}

@RequestMapping("/test8")
public String test8(@CookieValue("username") String name, @CookieValue("JSESSIONID") String sessionID) {
    System.out.println("ParamController.test8, " + name + " " + sessionID);
    return "result";
}

@RequestMapping("/test9")
public String test9(@RequestBody String requestBody) {
    System.out.println("ParamController.test9, " + requestBody);
    return "result";
}
```



### 5. 自定义类型

在自己定义的对象前面，会默认有一个注解@ModelAttribute，将请求的数据，封装成自定义的对象。

条件：当自定义对象的属性名和传入数据的名字一样，那么就会实现封装。（顺序也得一样。。）

@ModelAttribute注解右两种用法：

- 在方法参数的前面添加该注解。

  作用：将请求参数转换为对象。

- 在方法上面添加该注解。

  作用：在调用所有目标方法前，都会调用添加了该注解的方法，并向模型中添加这些方法返回值的数据。

**`代码放在错误参数后面一起了。`** 



### 6. 错误参数

​        Errors、BindingResult 接受在业务执行失败的错误信息，实现服务端的数据校验，让我们知道哪儿出了问题。这个出错的业务会继续执行，错误信息会存储到 Errors、BindingResult 对象里面。

​		实际开发中，既要做客户端表单校验，也要做服务端表单校验。（因为客户端表单校验会被绕过去）

```java
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(path = "/regist")
    public String regist(@ModelAttribute UserVo userVo, Errors err){
        if (userVo.getAge()>100 || userVo.getAge()<18){  // 手动校验
            err.reject("年龄只能在18~100之间");
        }
        // 如果有错误，输出错误，返回到注册页面
        if (err.hasErrors()){
            System.out.println(err);
            return "regist";
        }
        System.out.println("UserController.regist");
        System.out.println(userVo);
        return "success";
    }

    @ModelAttribute("types")  // 指定名称（这个名称是随便起的）
    public List<String> getTypes(){
        System.out.println("UserController.getTypes");
        return Arrays.asList("服装", "数码", "食品");
    }

    @RequestMapping("/test")
    public String test(HttpServletRequest req){
        System.out.println("UserController.test");
        return "result";
    }
}
```

```jsp
<%--
  Created by IntelliJ IDEA.
  User: HeyBoy
  Date: 2022/4/7
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <h2>用户注册</h2>
    <form action="${pageContext.request.contextPath}/user/regist" method="post">
        用户名：
            <input type="text" name="username">
        <br>
        密码：
            <input type="password" name="password">
        <br>
        手机号：
            <input type="text" name="phone">
        <br>
        邮箱：
            <input type="email" name="email">
        <br>
        年龄：
            <input type="text" name="age">
        <br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
```



## 七、服务器校验框架



### 1. 简介



#### 1.1 JSR303校验

​		JSRP303是数据验证的标准规范，用于对JavaBean中的属性进行校验，也称为 Bean Validation。提供了常用的注解。



#### 1.2 Hibernate Validator

​		是JSR303的一个参考实现，并提供了扩展的注解。



### 2. 用法



#### 2.1 添加依赖

```java
	<dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-validator</artifactId>
      <version>5.4.1.Final</version>
    </dependency>
    <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-validator-annotation-processor</artifactId>
      <version>5.4.1.Final</version>
    </dependency>
```



#### 2.2 为参数对象添加注解

```java
public String regist(@ModelAttribute @Valid UserVo userVo, Errors err){}
```



#### 2.3 为对象中的属性添加校验注解

```java
@NotEmpty(message = "用户名不能为空")
private String username;

@Length(min = 6, max = 18, message = "密码必须在6~18位之间")
@Pattern(regexp = "[A-Z][\\w|\\d]{5,17}", message = "必须以大写字母开头，且只能包含大写、小写字母、数字或下划线")
@NotEmpty(message = "密码不能为空")
private String password;

@Pattern(regexp = "\\d{13}")
@NotEmpty(message = "手机号不能为空")
private String phone;

@Pattern(regexp = "[\\w|\\d]+@[\\w|\\d]+\\.[\\w|\\d]+")
private String email;

@Range(min = 18, max = 90, message = "年龄必须在18~90之间")  // 为age设置范围校验
private int age;
```



## 八、类型转换

加一个编码校验，解决出现乱码问题，在web.xml中配置filter：

```xml
<!-- 要放在servlet前面 -->
<filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>utf-8</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```



### 1. 简介

​		数据绑定流程：获取值 ---> 查找转换器 ---> 转换 ---> 后台数据校验 ---> 数据绑定

​		两种解决方式：

- 使用 PropertyEditor
- 使用 Converter（推荐）



### 2. PropertyEditor

Step：

- 定义属性编辑器（继承**PropertyEditorSupport**或者实现**PropertyEditor**）
- 注册属性编辑器：`@InitBinder`

缺点：

- 注册的代码嵌套到Controller中了
- 稚嫩刚从字符串进行转换

```java
package editor;

import entity.Address;

import java.beans.PropertyEditorSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// 编辑器
public class AddressEditor extends PropertyEditorSupport {

    // 把Address对象变成字符串
    @Override
    public String getAsText() {
        Address address = (Address) getValue();
        return "[" + address.getCity() + "-" + address.getProvince() + "]";
    }

    // 从字符串中获取数据，生成对应的address对象
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Pattern compile = Pattern.compile("\\[(.*)-(.*)]");
        Matcher matcher = compile.matcher(text);
        if (matcher.matches()){
            String city = matcher.group(2);
            String province = matcher.group(1);
            Address address = new Address();
            address.setCity(city);
            address.setProvince(province);
            setValue(address);
        }
    }
}
```

```java
// 这个里面的address需要转换，那么在这里进行注册
@InitBinder
public void initBinder(DataBinder binder){
    binder.registerCustomEditor(Address.class, new AddressEditor());
}
```





### 3. Converter

Step：

- 定义转换器，实现接口 Converter<srcClass, destClass>

- 管理自定义的多个转换器

  ```xml
  <bean id="conversionService" class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
      <property name="converters">
          <set>
              <bean class="convert.String2AddressConverter"/>
              <bean class="convert.Address2StringConverter"/>
          </set>
      </property>
  </bean>
  ```

- 加载应用自定义的转换器

  ```xml
  <mvc:annotation-driven conversion-service="conversionService" />
  ```



## 九、@SessionAttributes



作用：将模型中指定名称的数据存储到session中，便于共享使用。

```java
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import vo.UserVo;

@Controller
@RequestMapping("/session")
@SessionAttributes("userVo")  // 把request里面的userVo存储到session里面
public class SessionController {

    @RequestMapping("/step1")
    public String step1() {
        System.out.println("SessionController.step1");
        return "step1";
    }

    @RequestMapping("/step2")
    public String step2(UserVo userVo) {
        System.out.println("SessionController.step2, " + userVo);
        return "step2";
    }

    @RequestMapping("/step3")
    public String step3(UserVo userVo) {
        System.out.println("SessionController.step3, " + userVo);
        return "step3";
    }

    @RequestMapping("/regist")
    public String regist(UserVo userVo) {
        System.out.println("SessionController.regist, " + userVo);
        return "success";
    }
}
```



## 十、统一异常处理



### 1. 简介

对异常进行统一处理。

两种方式：

- 使用web技术提供的统一异常处理。
- 使用SpringMVC提供的统一异常处理



### 2. 使用web技术异常处理

```xml
<!-- web.xml -->
<!-- 404异常处理 -->
  <error-page>
    <error-code>404</error-code>
    <location>/WEB-INF/view/error/404.jsp</location>
  </error-page>
  <!-- 500异常处理 -->
  <error-page>
    <error-code>500</error-code>
    <location>/WEB-INF/view/error/500.jsp</location>
  </error-page>
```

```xml
<!-- springmvc.xml -->
<!-- 这里处理完了后，直接输入对应的数字，不用加jsp后缀 -->
<mvc:view-controller path="/404" view-name="/error/404"/>
<mvc:view-controller path="/500" view-name="/error/500"/>
```



### 3. 使用SpringMVC异常处理

Step：

- 定义一个异常处理类（异常通知  **@ControllerAdvice**）
- 定义异常处理的方法，添加注解 **@ExceptionHandler(异常class对象)**

```java
package advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.SessionAttributes;

// 异常通知
@ControllerAdvice
@SessionAttributes("e")
public class ExceptionAdvice {

    @ExceptionHandler(ArithmeticException.class)  // 传入要处理的异常对应的class对象
    public String arithmetic(Exception e){
        System.out.println("警报！程序出现异常："+e.getMessage());
        return "error/arithmetic";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullPoint(Exception e){
        System.out.println("警报！程序出现异常："+e.getMessage());
        return "error/nullPoint";
    }

    @ExceptionHandler(Exception.class)
    public String exce(Exception e){
        return "error/exce";
    }
}
```

```xml
<context:component-scan base-package="advice"/>
```



## 十一、拦截器



### 1. 简介

​        使用拦截器 Interceptor 对请求进行拦截，类似于过滤器 Filter。



### 2. 用法

Step：

- 定义一个类，实现 HandlerInterceptor。

  ```java
  package interceptor;
  
  import org.springframework.web.method.HandlerMethod;
  import org.springframework.web.servlet.HandlerInterceptor;
  import org.springframework.web.servlet.ModelAndView;
  
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  import java.lang.reflect.Method;
  import java.util.Arrays;
  
  public class HelloInterceptor implements HandlerInterceptor {
  
      // 在调用目标处理方法之前执行，可以进行权限、日志等操作
      @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
              throws Exception {
          if (handler instanceof HandlerMethod) {
              HandlerMethod handlerMethod = (HandlerMethod) handler;  // 如果是对应的实例，就转换过来，便于我们使用他的方法
              Object bean = handlerMethod.getBean();
              Method method = handlerMethod.getMethod();
              System.out.println("HelloInterceptor.preHandle \nbean: " + bean.getClass() +
                      "\n" + "method:" + method.getName() + "-->" + Arrays.toString(method.getParameterTypes()));
              // 可以看到拦截的是哪个 bean
          }
          return true;  // true表示继续执行调用下一个拦截器和目标处理方法
      }
  
      // 调用目标处理方法之后执行，渲染视图之前（即请求数据依然可修改——ModelAndView）
      @Override
      public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
              throws Exception {
          System.out.println("HelloInterceptor.postHandle");
      }
  
      // 在视图渲染之后执行，比如释放一些不需要的资源
      @Override
      public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
              throws Exception {
          System.out.println("HelloInterceptor.afterCompletion");
      }
  }
  ```

- 配置拦截器（在springmvc.xml里面）

  ```xml
  <!-- 注册拦截器 -->
  <mvc:interceptors>
      <!-- 默认拦截所有的请求 -->
  	<bean class="interceptor.HelloInterceptor"/>
      <!-- 拦截指定的请求 -->
      <mvc:interceptor>
          <!--
                  这里多个拦截器，各自拦截各自的，互不干扰
                  形成拦截器链，执行顺序根据配置顺序执行，会有true决定是否继续
               -->
          <!-- 可以设置多个拦截文件 -->
          <mvc:mapping path="/user/regist"/>
          <mvc:mapping path="/login"/>
          <mvc:mapping path="/path/*"/>
          <!-- 拦截path下面的所有请求，除了test7 -->
          <mvc:exclude-mapping path="/path/test7"/>
          <bean class="interceptor.TimerInterceptor"/>
      </mvc:interceptor>
  </mvc:interceptors>
  ```



## 十二、处理AJAX



### 1. @ResponseBody

为方法添加该注解后，将返回值写到响应体中。



### 2. 返回JSON

三种方式

- jackson，第三方库，SpringMVC默认支持。
- gson，第三方库，SpringMVC默认支持，google开发。
- fastjson，SpringMVC默认不支持，alibaba开发。



#### 2.1 jackson

Step：

- 添加依赖

  ```xml
  <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.12.3</version>
  </dependency>
  ```

- 配置消息转换器

  ```xml
  <mvc:annotation-driven conversion-service="conversionService" >
      <!-- 配置消息转换器 -->
      <mvc:message-converters>
          <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter"/>
      </mvc:message-converters>
  </mvc:annotation-driven>
  ```

- 对于jackson而言，消息转换器可以不配置，因为SpringMVC提供了支持，在发现了这个依赖后，会默认配置上面的转换器。



#### 2.2 gson

Step：

- 添加依赖

  ```xml
  <dependency>
      <groupId>com.google.code.gson</groupId>
      <artifactId>gson</artifactId>
      <version>2.8.2</version>
  </dependency>
  ```

- 配置消息转换器

  ```xml
  <mvc:annotation-driven conversion-service="conversionService" >
      <!-- 配置消息转换器 -->
      <mvc:message-converters>
          <bean class="org.springframework.http.converter.json.GsonHttpMessageConverter"/>
      </mvc:message-converters>
  </mvc:annotation-driven>
  ```

- 同样可以不配置。



#### 2.3 fastjson

Step：

- 添加依赖

  ```xml
  <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>fastjson</artifactId>
      <version>1.2.46</version>
  </dependency>
  ```

- 配置消息转换器（必须）

  ```xml
  <mvc:annotation-driven conversion-service="conversionService" >
      <!-- 配置消息转换器 -->
      <mvc:message-converters>
          <bean class="com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter"/>
      </mvc:message-converters>
  </mvc:annotation-driven>
  ```

  

## 十三、文件上传和下载



### 1. 文件上传



#### 1.1 简介

​		SpringMVC对文件上传提供了支持，基于 commons-fileupload。



#### 1.2 用法

Step：

- 添加 jar 包

  ```xml
  <dependency>
      <groupId>commons-fileupload</groupId>
      <artifactId>commons-fileupload</artifactId>
      <version>1.4</version>
  </dependency>
  ```

- 编写 jsp 页面

  ```jsp
  <%--
    Created by IntelliJ IDEA.
    User: HeyBoy
    Date: 2022/4/9
    Time: 19:57
    To change this template use File | Settings | File Templates.
  --%>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html>
  <head>
      <title>Title</title>
  </head>
  <body>
      <form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">
          <input type="file" name="file">
          <input type="submit" value="上传">
      </form>
  </body>
  </html>
  ```

  

- 配置文件解析器

  ```xml
  <!-- 配置文件解析器(id名称固定) -->
      <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
          <!-- 上传文件的编码 -->
          <property name="defaultEncoding" value=""/>
          <!-- 也可以设置其他信息，比如上传文件的大小，也可以不配其他限制 -->
      </bean>
  ```

- 通过 CommonsMultipartFile 接受文件

  ```java
  package controller;
  
  import org.springframework.stereotype.Controller;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestParam;
  import org.springframework.web.multipart.commons.CommonsMultipartFile;
  import util.StringUtils;
  
  import javax.servlet.http.HttpSession;
  import java.io.File;
  import java.io.IOException;
  import java.io.InputStream;
  import java.util.Objects;
  
  @Controller
  @RequestMapping("/file")
  public class FileController {
  
      @RequestMapping("/upload")
      // 这个file值是来自请求参数，在文件接收的时候必须添加
      // CommonsMultipartFile是SpringMVC的支持，收到的文件都放在这个对象里面
      public String upload(@RequestParam CommonsMultipartFile file, HttpSession session) throws IOException {
          System.out.println(file);
          System.out.println(file.getName());
          System.out.println(file.getOriginalFilename());
  
          // 获取到文件流
  //        InputStream inputStream = file.getInputStream();
  
          // 获取上传目录的物理路径
          String realPath = session.getServletContext().getRealPath("/WEB-INF/upload");
          System.out.println(realPath);
  
          file.transferTo(new File(realPath, StringUtils.renameFileName(Objects.requireNonNull(file.getOriginalFilename()))));
  
          return "hello";
      }
  
      @RequestMapping("/uploads")
      // 上传多个文件
      public String uploads(@RequestParam CommonsMultipartFile[] files, HttpSession session) throws IOException {
          String realPath = session.getServletContext().getRealPath("/WEB-INF/upload");
          System.out.println(realPath);
  
          for (CommonsMultipartFile file: files){
              file.transferTo(new File(realPath, StringUtils.renameFileName(Objects.requireNonNull(file.getOriginalFilename()))));
          }
          
          return "hello";
      }
  }
  ```

  

### 2. 文件下载

- OutputStream方式
- ResponseEntity方式



#### 2.1 OutputStream

传递文件名的两种方式：

- 使用请求参数传递文件名

  ```jsp
  <a href="${pageContext.request.contextPath}/file/download?filename=springmvc.jpg">请求参数：下载文件</a>
  ```

- 使用rest风格传递文件名

  默认情况下，如果url结尾有后缀，会被自动截取，解决方式：

  - 把名字放在中间就好了

    ```jsp
    <a href="${pageContext.request.contextPath}/file/springmvc.jpg/download">rest:下载文件</a>
    ```

  - 配置不自动截取后缀（使用较少）

    ```xml
    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping">
            <property name="useSuffixPatternMatch" value="false"/>
        </bean>
    ```

**Java代码**

```java
//@RequestMapping("/{filename}/download")
// public String download(@PathVariable String filename, HttpSession session, HttpServletResponse response) throws IOException {

@RequestMapping("/download")
public String download(String filename, HttpSession session, HttpServletResponse response) throws IOException {
    String realPath = session.getServletContext().getRealPath("/WEB-INF/img/");
    File file = new File(realPath, filename);  // 取到这个目录下的这个文件
    FileInputStream fileInputStream = new FileInputStream(file);

    // 汉字默认是iso8859-1，如果有汉字，需要重新编码
    //        filename = new String(filename.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);

    // 这是请求头后，可以把文件下载下来
    response.setHeader("content-disposition","attachment;filename="+filename);
    StreamUtils.copy(fileInputStream, response.getOutputStream());  // 把输入流拷贝到输出流里面
    return "success";
}
```



#### 2.2 ResponseEntity

```jsp
<a href="${pageContext.request.contextPath}/file/download2?filename=springmvc.jpg">ResponseEntity:下载文件</a>
```

```java
@RequestMapping("/download2")
// 文件相应，一般都是字节数组
public ResponseEntity<byte[]> download2(String filename, HttpSession session) throws IOException {
    String realPath = session.getServletContext().getRealPath("/WEB-INF/img/");
    File file = new File(realPath, filename);

    byte[] bytes = FileUtils.readFileToByteArray(file);
    HttpHeaders httpHeaders=  new HttpHeaders();
    httpHeaders.add("content-disposition", "attachment;filename="+filename);

    /*
            响应体里面包含：
            1. 文件数据
            2. 响应头
            3. 状态码
         */
    return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
}
```

