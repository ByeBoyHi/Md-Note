# SpringBoot

## 一、SpringBoot简介

### 1. SpringBoot是什么？

​		**产生背景：**

​		Spring开发变得越来越笨重，大量的XML文件，繁琐的配置，复杂的部署流程，整合第三方技术、第三方框架难度大，导致开发效率低下。

​		SpringBoot是一个用来简化Spring应用的创建和开发过程的框架，简化配置，实现快速开发。		

​		整合了整个的Spring技术栈，JavaEE开发的一站式解决方案。



### 2. 为什么使用SpringBoot？

​		优点：

- 可以快速创建独立运行的Spring项目并与主流框架集成。
- 内置了Servlet容器，应用无需打成war包。
- 提供了starter(启动器)管理依赖并进行版本控制。
- 有大量的自动配置，可以自动配置第三方库，简化开发。
- 提供了准生产环境的运行时监控，如指标、健康检查、外部配置等。
- 无需配置XML，没有冗余的代码，开箱即用。



## 二、第一个SpringBoot程序

### 1. 简介

环境：

- SpringBoot 2.5.3 (基于Spring5.0)
- JDK1.8以上
- Maven 3.5以上
- Gradle **6.8.x  6.9.x or 7.x**
- 并且向上兼容 JDK16
- IDEA使用较新的版本

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210731171518331.png" alt="image-20210731171518331" style="zoom:80%;" />



### 2. 创建步骤

- 创建Maven的Java工程。

  - 传统的web应用需要创建web工程，后期需要打成war包，然后放在Tomcat中。

  - SpringBoot应用只需要创建一个Java工程，后期直接打成Jar包，这是可执行的Jar包，内置了Tomcat。

  - **先创建了一个普通的Java工程。**

  - 在Java工程中，先指定自己的maven，并且配置文件设置为自己的maven带的settings.xml。

  - 设置好JDK版本需求。

  - **然后在Java工程中创建一个Maven的Module工程**

  - maven工程中指定groupId和artifactId。

  - 在pom.xml中指定打包方式

    ```xml
    <packaging>jar</packaging>
    ```

- 导入SpringBoot的相关依赖

  <img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210731172746202.png" alt="image-20210731172746202" style="zoom: 67%;" /><img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210731173636840.png" alt="image-20210731173636840" style="zoom:67%;" />



- 运行程序

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class MyApplication {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```

**注：SpringBoot会默认扫主程序所在的包及其子包，所以主程序最好放在最外层。**

- 自己指定要扫描的包：

  ```java
  @ComponentScan("com.itany.Controller -- 包的路径")
  ```

  

### 3. 部署打包

添加插件，将应用打包成可执行的jar，执行  **`java -jar xxx.jar文件`**。

```xml
<!-- Creating an Executable Jar -->
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```



### 4. 分析HelloWorld

#### 4.1 POM文件

- 指定了父工程 spring-boot-starter-parent

  ```xml
  <parent>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-parent</artifactId>
      <version>2.5.3</version>
  </parent>
  ```

- 父工程的父工程是 spring-boot-dependencies，用来管理SpringBoot应用中的依赖的版本，进行版本控制。

- 通过starter指定web工程依赖

  ```xml
  <!-- Since we are developing a web application, we add a spring-boot-starter-web dependency.  -->
  <dependencies>
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-web</artifactId>
      </dependency>
  </dependencies>
  <!-- 这个依赖会把web开发的相关依赖加进去，简化开发。 -->
  ```

- SpringBoot提供了很多Starter(启动器)，分别对应不同的功能场景，当在项目中引入这些starter时相应场景的依赖就会导入进来。



#### 4.2 主程序类注解

- @SpringBootApplication
  - 标注在类上，表示这个是SpringBoot的主配置类，通过运行该类的main方法来启动SpringBoot应用。
  - 组合注解：
    - @SpringBootConfiguration
      - 标注在类上，表示这个类是SpringBoot的配置类。
      - 层级关系：@SpringBootConfiguration —> @Configuration —> @Component
      - @Configuration：标注在类上，表示这个类是Spring的配置类，相当于一个xml文件。
      - @Component：表示是Spring容器的一个组件。
    - @EnableAutoConfiguration
      - 开起 **<u>自动配置</u>** 功能，SpringBoot会自动完成许多配置，简化了繁琐的配置。
      - SpringBoot在启动的时候，会在类路径下 /META-INF/spring.factories 中获取EnableAutoConfiguration指定的值，将这些值作为自动配置类添加到容器中，这些 **<u>自动配置类</u>** 会帮我们完成许多 **<u>配置工作</u>** 。
- @ComponentScan("xxx包路径")：标注在类上，指定要扫描的包，会扫描对应路径的包及其子包。



## 三、快速创建SpringBoot项目

### 1. 简介

使用IDEA提供的Spring Initializr（Spring初始化器），

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210801154125598.png" alt="image-20210801154125598" style="zoom:50%;" />![image-20210801154154351](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210801154154351.png)

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210801154207160.png" alt="image-20210801154207160" style="zoom:50%;" />

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210801154244534.png" alt="image-20210801154244534" style="zoom:50%;" />![image-20210801154302513](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210801154302513.png)

![image-20210801154302513](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210801154302513.png)

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210801154412617.png" alt="image-20210801154412617" style="zoom:50%;" />



### 2. 基本操作

- POM文件和主程序已经生成完毕，直接写业务逻辑即可。

- 生成完毕后可以调整一下resource和source root

- resources文件夹的目录结构

  - static：用来存放静态资源，如css、js、img等。

  - templates：存放模版页面，可以使用模版引擎，如freemarker、thymeleaf等。

  - application.properties：SpringBoot应用的配置文件，可以修改一些默认设置。

    ```properties
    # 修改默认端口号为8888
    server.port = 8888
    ```

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210801155243296.png" alt="image-20210801155243296" style="zoom:50%;" />



​	<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210801155959573.png" alt="image-20210801155959573" style="zoom:50%;" />

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210801155933617.png" alt="image-20210801155933617" style="zoom:50%;" />



!(C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210801155811327.png)

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210801155640725.png" alt="image-20210801155640725" style="zoom:50%;" />

<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210801155742253.png" alt="image-20210801155742253" style="zoom:50%;" />