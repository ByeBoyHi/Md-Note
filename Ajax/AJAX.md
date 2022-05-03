# AJAX

## 一、Ajax基本用法

### 1. 为什么使用Ajax

- 无刷新：不刷新整个页面，只刷新局部
- 无刷新的好处：
  - 只更新部分页面，有效利用宽带：例如页面登录时，只有登录位置刷新
  - 提供连续的用户体验：例如留言点赞，只有那一个区域变化
  - 提供类似C/S的交互效果，操作更方便：例如百度搜索，根据关键字显示提示



### 2. 传统Web和Ajax的差异

![](F:\桌面\Ajax\传统Web和Ajax的差异.png)



### 3. 什么是Ajax

只刷新局部页面的技术。

Ajax --> Asynchronous JavaScript And Xml

- JavaScript：Ajax技术主要开发语言
- HTML/XML/JSON：用于封装请求数据和响应数据
- DOM：通过DOM修改页面元素，实现页面局部刷新
- CSS：改变样式，梅花页面，提升用户体验
- **Ajax引擎**：即XMLHttpRequest对象，以异步方式在客户端和服务器之间传递数据。



### 4. Ajax的工作流程

![](F:\桌面\Ajax\Ajax的工作流程.png)



### 5. XMLHttpRequest

- JavaScript对象XMLHttpRequest是整个Ajax技术的核心，它提供了异步发送请求的能力。

- **常用方法：**
  
  - open(method, URL, async)：建立与服务器的链接
    - method参数：请求方式，可选值GET(默认)或POST。
    - URL参数：请求地址。
    - async参数：是否使用异步请求，可选值true(默认)或false。
  - send(content)：发送请求
    - content;请求参数，只有post能通过send()发送参数
  - setRequestHeader(header, value)：设置请求头信息
  
- **常用事件：**

  - onreadystatechange：事件属性，指定回调函数，当readyState属性改变时触发执行

- **常用属性：**

  - readyState：表示XMLHttpRequest对象的状态

  ![](F:\桌面\Ajax\readyState.png)
  
  - status：表示HTTP请求响应的状态
    - 200：响应正常
    - 400：无法找到请求的资源
    - 403：没有访问权限
    - 404：访问资源不存在
    - 500：服务器内部错误
  - responseText：获得相应的文本内容
  - responseXML：获得相应的XML文档对象Document

为了兼容老版本的IE浏览器，有如下方式建立XMLHttpRequest对象：

![](F:\桌面\Ajax\建立XMLHttpRequest对象.png)

```js
// 定义工厂函数，用于创建XMLHttpRequest对象
// 用于兼容不用浏览器
function createXHR(){
    if(window.XMLHttpRequest){
        return new XMLHttpRequest();
    }else{ //IE老版本浏览器
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}
```



### 6. 使用AJAX验证用户名

- 实现无刷新用户名验证
  - 当用户名文本框失去焦点时，发送请求到服务器判断用户名是否存在
  - 如果存在则提示“该用户名已被使用”
  - 如果不存在则提示“该用户名可以使用”
- 实现无刷新用户登录
  - 输入用户名和密码，单击“登录”，异步提交表单
  - 如果正确，显示欢迎信息
  - 如果错误，显示提示信息



## 二、jQuery实现Ajax

### 1. 使用jQuery发送Ajax请求

- 传统方式实现Ajax的不足

  - 方法、属性、常用值较多不好记忆
  - 步骤繁琐
  - 浏览器兼容问题

- jQuery常用Ajax方法

  - **$.ajax()发送HTTP请求加载远程数据，最底层是Ajax实现**

  <img src="F:\桌面\Ajax\$.ajax().png" style="zoom:55%;" />

  <img src="F:\桌面\Ajax\$.ajax()2.png" style="zoom:55%;" />

  - **$.get()发送HTTP GET请求从服务器加载数据**

  <img src="F:\桌面\Ajax\$.get().png" style="zoom:55%;" />

  - **$.post()发送HTTP POST请求从服务器加载数据**

  <img src="F:\桌面\Ajax\$.post().png" style="zoom:55%;" />

  - **$.getJSON()发送HTTP请求从服务器加载JSON数据**

  <img src="F:\桌面\Ajax\$.getJSON().png" style="zoom:55%;" />

  - **load()发送Ajax请求从服务器加载数据，并把返回的数据放置到指定的元素中**

  <img src="F:\桌面\Ajax\$.load().png" style="zoom:55%;" />

- 序列化表单元素值

<img src="F:\桌面\Ajax\序列化表单元素值.png" style="zoom:55%;" />



### 2. 数据格式

- 在服务器端AJAX是一门与语言无关的技术。在业务逻辑层使用何种服务器端语言都可以。
- 从服务器端接收数据的时候，那些数据必须以浏览器能够理解的格式来发送。服务器端的编程语言只能以如下3种格式返回数据：
  - 纯文本
  - XML
  - JSON



#### 2.1 纯文本实现步骤

<img src="F:\桌面\Ajax\纯文本实现步骤.png" style="zoom:55%;" />



#### 2.2 JSON实现步骤

<img src="F:\桌面\Ajax\JSON实现步骤.png" style="zoom:55%;" />

<img src="F:\桌面\Ajax\JSON小结.png" style="zoom:55%;" />



### 3. AJAX跨域

#### 3.1 跨域问题

<img src="F:\桌面\Ajax\AJAX的跨域请求.png" style="zoom:55%;" />

- auth：身份校验
- anchor：锚点



**API数据供应平台：**

- 聚合数据：`https://www.juhe.cn/`
- 百度API Store：`http://apistore.baidu.com/`
- HaoService：`http://www.haoservice.com/`



#### 3.2 JSONP解决跨域

JSONP就是把JSON对象作为参数传入一个函数中，然后调用使用的一个方式。



<img src="F:\桌面\Ajax\JSONP基础.png" style="zoom:65%;" />

<img src="F:\桌面\Ajax\JSONP原理.png" style="zoom:65%;" />



#### 3.3 使用jQuery发送跨域请求

<img src="F:\桌面\Ajax\Ajax实现jQuery.png" style="zoom:60%;" />



#### 3.4 CORS跨域

<img src="F:\桌面\Ajax\CORS跨域请求.png" style="zoom:60%;" />

	### 4. API数据平台

#### 4.1 前端模板引擎

<img src="F:\桌面\Ajax\前端模版引擎.png" style="zoom:60%;" />