# HTML5+CSS3



# 	第一章





## 一、块元素和内联元素(div/a)

- 块元素：
  - 容器。可以容纳其他的块元素和内敛元素。
  - 块元素，网页排版的时候，排斥和其他元素排在同一行。
  - 块元素，width height 都起作用。

- 内敛元素：
  - 容器。只能容纳文本后者其他的内敛元素。
  - 内敛元素，网页排版的时候，可以与其他的内敛元素排在同一行。
  - 内敛元素，width height 不起作用

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <style type="text/css">
            body,div{
                margin: 0;
                padding: 0;
            }
            
            /* 这两个块元素是放在两行的。 */
            #div2{
                width: 100px;
                height: 100px;
                background-color: #900000;
            }
            
            #div3{
                width: 100px;
                height: 100px;
                background-color: #000090;
                color: #000000;
            }
            
            /* 这两个内敛元素由于宽度允许，在网页中会放在同一行 */
            #aid{
                
                /*display: block; 这个可以把内敛元素改成块元素，然后宽高也可以设置了。block就是改成块元素。*/
                /* 这里的宽度高度其实不起作用 */
                width: 50px;
                height: 50px;
                background-color: #000000;
                color: #FFFFFF;
            }
            
            #aid2{
                /* 这里的宽度高度其实不起作用 */
                width: 50px;
                height: 50px;
                background-color: #000FFF;
                color: #FFF000;
            }
        </style>
    </head>
    <body>
        <!-- 块元素：
				1. 容器。可以容纳其他的块元素和内敛元素。
				2. 块元素，网页排版的时候，排斥和其他元素排在同一行。
				3. 块元素，width height 都起作用。
			内敛元素：
				1. 容器。只能容纳文本或者	其他的内敛元素。
				2. 内敛元素，网页排版的时候，可以与其他的内敛元素排在同一行。
				3. 内敛元素，width height 不起作用。
		-->
        <div id="div1">
            <div id="div2">块元素</div>
            <div id="div3">块元素2</div>
            <a id="aid" href="#">内联元素</a>
            <a id="aid2" href="#">内敛元素2</a>
        </div>
    </body>
</html>
```



## 二、浮动和定位(float--浮动状态)

浮动：就是让原本在一个图层的各个元素，跑到了多个图层。

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <style type="text/css">
            body, div{
                margin: 0;
                padding: 0;
            }
            
            #div1 {
                float: left;
                margin-left: 10px;
                margin-top: 10px;
                width: 100px;
                height: 1500px;
                background-color: #900;
                /*display: inline; 把一个块元素变成内联元素，原来的高度宽度还有。  -- Only for IE */
            }	
            
            #div2 {
                float: left;
                margin-left: 10px;
                margin-top: 10px;
                width: 150px;
                height: 100px;
                background-color: #090;
            }
            
            #div3 {
                width: 100px;
                height: 100px;
                background-color: #009;
                margin-left: 10px;
                margin-top: 10px;
            }
            
            .class{
                clear: both; /* 在Chrome中，让后续的块元素重启一行 */
            }
        </style>
    </head>
    <body>
        <div id="div1"></div>
        <div id="div2"></div>
        <!-- IE 在浮动中的一个Bug:
				1. 块元素；
				2. float: left;
				3. margin-left: 不为0;
			解决方案：加一个display，把块元素改为内联元素。
		-->
        <div class="clear"></div>
    </body>
</html>
```



## 三、制作一个导航栏

### 01 案例

```html
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title></title>
        <style type="text/css">
            body, div, ul, li{ /* 这里是为了各个浏览器的兼容性而设置的。 */
				margin: 0;
                padding: 0;
            }
            
            #nav {
                width: 960px;
                height: 35px;
                background-color: #CCC;
                margin: 0 auto;
                margin-top: 30px;
            }
            
            #nav ul{ 
                width: 960px;
                height: 35px;
            }
            
            #nav ul li{
				float: left;
                list-style: none; /*去掉名字前的原点*/
                /*width: 100px;*/
                /*background-color: #F00;*/
                height: 35px; /*和外面的大容器弄成等高*/
                text-align: center:
                line-height: 35px;
                padding: 0 10px;
            }
            
            #nav ul li a {
				font-size: 14px; /*设置字体大小*/
                color: #EEE; /*字体颜色*/
                text-decoration: none; /*去掉字体的下划线*/
            }
        </style>
    </head>
    <body>
        <div id="nav">
            <ul>
                
                <!-- href是放一个网址，加#是不跳到任何地方。 在不对这个标签设置宽高的时候，里面的字体多大，他们多大。 
				-->
                <li><a href="#">阿里巴巴</a></li>
                <li><a href="#">腾讯</a></li>
                <li><a href="#">百度</a></li>
                <li><a href="#">小米</a></li>
                <li><a href="#">今日头条</a></li>
                <li><a href="#">微软</a></li>
            </ul>
        </div>
    </body>
</html>
```



### 02 案例

```html
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title></title>
        <style type="text/css">
            body, div, ul, li{ /* 这里是为了各个浏览器的兼容性而设置的。 */
				margin: 0;
                padding: 0;
            }
            
            #nav {
                width: 960px;
                height: 35px;
                background-color: #E7E7E7;
                margin: 0 auto;
                margin-top: 30px;
            }
            
            #nav ul{ 
                width: 960px;
                height: 35px;
            }
            
            #nav ul li{
				float: left;
                list-style: none; /*去掉名字前的原点*/
                /*width: 100px;*/
                background-color: #E7E7E7;
                height: 35px; /*和外面的大容器弄成等高*/
                text-align: center:
                line-height: 35px;
                /*padding: 0 10px;*/
            }
            
            #nav ul li a {
				font-size: 14px; /*设置字体大小*/
                color: #8790A1; /*字体颜色*/
                text-decoration: none; /*去掉字体的下划线*/
                display: block; /*在IE中，变成块元素后，他们跳行。*/
				height: 35px;
                float: left; /*加一个浮动，IE就变成一行了。*/
                padding: 0 10px;/*此时，除了IE外，其他浏览器左右又多出了一块儿*/
            }
            
            /*这些标签嵌套的里面的a，当鼠标放上去(hover)，会变成什么样*/
            #nav ul li a: hover {
                /*background-color: #85CE02*/
				background-color: #000;/*背景色*/
                color: #FFF;/*字体色*/
                font-size: 15px;/*比原来的字体大一丢丢，放上去会变大*/
            }
        </style>
    </head>
    <body>
        <div id="nav">
            <ul>
                
                <!-- href是放一个网址，加#是不跳到任何地方。 在不对这个标签设置宽高的时候，里面的字体多大，他们多大。 
				-->
                <li><a href="#">阿里巴巴</a></li>
                <li><a href="#">腾讯</a></li>
                <li><a href="#">百度</a></li>
                <li><a href="#">小米</a></li>
                <li><a href="#">今日头条</a></li>
                <li><a href="#">微软</a></li>
            </ul>
        </div>
    </body>
</html>
```





## 四、导航栏的举一反三

 <!-- href是放一个网址，加#是不跳到任何地方。 在不对这个标签设置宽高的时候，里面的字体多大，他们多大。-->

### 01 案例

```html
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title></title>
        <style type="text/css">
            body, div, ul, li{ /* 这里是为了各个浏览器的兼容性而设置的。 */
				margin: 0;
                padding: 0;
            }
            
            #nav {
                width: 960px;
                height: 35px;
                background-color: #E7E7E7;
                margin: 0 auto;
                margin-top: 30px;
            }
            
            #nav ul{ 
                width: 960px;
                height: 35px;
            }
            
            #nav ul li{
				float: left;
                list-style: none; /*去掉名字前的原点*/
                /*background-color: #E7E7E7;*/
                background-image: url(图片路径)
                height: 35px; /*和外面的大容器弄成等高*/
                text-align: center:
                line-height: 35px;
            }
            
            #nav ul li a {
				font-size: 14px; /*设置字体大小*/
                color: #8790A1; /*字体颜色*/
                text-decoration: none; /*去掉字体的下划线*/
                display: block; /*在IE中，变成块元素后，他们跳行。*/
				height: 35px;
                float: left; /*加一个浮动，IE就变成一行了。*/
                padding: 0 10px;/*此时，除了IE外，其他浏览器左右又多出了一块儿*/
            }
            
            /*这些标签嵌套的里面的a，当鼠标放上去(hover)，会变成什么样*/
            #nav ul li a: hover {
                /*background-color: #85CE02*/
				background-color: #646464;/*背景色*/
                color: #FFF;/*字体色*/
                font-size: 15px;/*比原来的字体大一丢丢，放上去会变大*/
            }
        </style>
    </head>
    <body>
        <div id="nav">
            <ul>
                <!-- href是放一个网址，加#是不跳到任何地方。 在不对这个标签设置宽高的时候，里面的字体多大，他们多大。 
				-->
                <li><a href="#">阿里巴巴</a></li>
                <li><a href="#">腾讯</a></li>
                <li><a href="#">百度</a></li>
                <li><a href="#">小米</a></li>
                <li><a href="#">今日头条</a></li>
                <li><a href="#">微软</a></li>
            </ul>
        </div>
    </body>
</html>
```



### 02 案例

```html
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title></title>
        <style type="text/css">
            body, div, ul, li{ /* 这里是为了各个浏览器的兼容性而设置的。 */
				margin: 0;
                padding: 0;
            }
            
            #nav {
                width: 960px;
                height: 35px;
                background-color: #E7E7E7;
                margin: 0 auto;
                margin-top: 30px;
            }
            
            #nav ul{ 
                width: 960px;
                height: 35px;
            }
            
            #nav ul li{
				float: left;
                list-style: none; /*去掉名字前的原点*/
                background-color: #646464;
                height: 35px; /*和外面的大容器弄成等高*/
                text-align: center:
                line-height: 35px;
                margin-right: 1px;
            }
            
            #nav ul li a {
				font-size: 14px; /*设置字体大小*/
                color: #FFF; /*字体颜色*/
                text-decoration: none; /*去掉字体的下划线*/
                display: block; /*在IE中，变成块元素后，他们跳行。*/
				height: 35px;
                float: left; /*加一个浮动，IE就变成一行了。*/
                padding: 0 10px;/*此时，除了IE外，其他浏览器左右又多出了一块儿*/
            }
            
            /*这些标签嵌套的里面的a，当鼠标放上去(hover)，会变成什么样*/
            #nav ul li a: hover {
                /*background-color: #85CE02*/
				background-color: #E7E7E7;/*背景色*/
                color: #8790A1;/*字体色*/
                font-size: 15px;/*比原来的字体大一丢丢，放上去会变大*/
            }
        </style>
    </head>
    <body>
        <div id="nav">
            <ul>
                <!-- href是放一个网址，加#是不跳到任何地方。 在不对这个标签设置宽高的时候，里面的字体多大，他们多大。 
				-->
                <li><a href="#">阿里巴巴</a></li>
                <li><a href="#">腾讯</a></li>
                <li><a href="#">百度</a></li>
                <li><a href="#">小米</a></li>
                <li><a href="#">今日头条</a></li>
                <li><a href="#">微软</a></li>
            </ul>
        </div>
    </body>
</html>
```



### 03 案例

```html
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title></title>
        <style type="text/css">
            body, div, ul, li{ /* 这里是为了各个浏览器的兼容性而设置的。 */
				margin: 0;
                padding: 0;
            }
            
            #nav {
                width: 960px;
                height: 35px;
                background-color: #E7E7E7;
                margin: 0 auto;
                margin-top: 30px;
                border-radius: 5px;
            }
            
            #nav ul{ 
                width: 960px;
                height: 35px;
            }
            
            #nav ul li{
				float: left;
                list-style: none; /*去掉名字前的原点*/
                background-color: #E7E7E7;
                height: 35px; /*和外面的大容器弄成等高*/
                text-align: center:
                line-height: 35px;
            }
            
            #nav ul li a {
				font-size: 14px; /*设置字体大小*/
                color: #8790A1; /*字体颜色*/
                text-decoration: none; /*去掉字体的下划线*/
                display: block; /*在IE中，变成块元素后，他们跳行。*/
				height: 35px;
                float: left; /*加一个浮动，IE就变成一行了。*/
                padding: 0 10px;/*此时，除了IE外，其他浏览器左右又多出了一块儿*/
            }
            
            /*这些标签嵌套的里面的a，当鼠标放上去(hover)，会变成什么样*/
            #nav ul li a: hover {
                /*background-color: #85CE02*/
				background-color: #646464;/*背景色*/
                color: #FFF;/*字体色*/
                font-size: 15px;/*比原来的字体大一丢丢，放上去会变大*/
                border-radius: 5px; /*给外边一个圆角*/
            }
        </style>
    </head>
    <body>
        <div id="nav">
            <ul>
                <!-- href是放一个网址，加#是不跳到任何地方。 在不对这个标签设置宽高的时候，里面的字体多大，他们多大。 
				-->
                <li><a href="#">阿里巴巴</a></li>
                <li><a href="#">腾讯</a></li>
                <li><a href="#">百度</a></li>
                <li><a href="#">小米</a></li>
                <li><a href="#">今日头条</a></li>
                <li><a href="#">微软</a></li>
            </ul>
        </div>
    </body>
</html>
```



## 五、主页的需求分析和设计

header的一部分：logo、navigator（横向排列）

网页的四部分(div)：header、banner、content、footer（从上往下）



## 六、HTML搭建

<!-- 图片就在当前路径的话，用 ./图片名字.后缀 -->

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <style text="text/css"></style>
    </head>
    <body>
        <div id="header">
        	<div id="logo">
                <a href="#(网址)">
                    <!-- 图片就在当前路径的话，用 ./图片名字.后缀 -->
                	<img src="logo路径"> 
                </a>
            </div>
        	<div id="nav">
            	<ul>
                    <!-- 需要7个菜单 -->
                    <li><a href="#">菜单1</a></li>
                    <li><a href="#">菜单2</a></li>
                    <li><a href="#">菜单3</a></li>
                    <li><a href="#">菜单4</a></li>
                    <li><a href="#">菜单5</a></li>
                    <li><a href="#">菜单6</a></li>
                    <li><a href="#">菜单7</a></li>
                </ul>
            </div>
        </div>
        <div id="banner">
            <a href="#"><img src="图片路径"/></a>
        </div>
        <div id="content">
        	<div id="leftArtical">
                <a href="#"><img src="./img/article.jpg" alt="" /></a>
                <h1>===========文章标题==========</h1>
                <p>DEFAEFASDVSDVAWE</p>
                <p>FDFAWWAEFDVVVVAS</p>
                <p>ADVCXVZXCVADFAWE</p>
            </div>
            <div id="rightInfo">
                <dl>
                    <dt>标题1：XXXX</dt>
                    <dd>XXXXXXXXXXXXXXX</dd>
                    <dd>XXXXXXXXXXXXXXX</dd>
                    <dd>XXXXXXXXXXXXXXX</dd>
                </dl>
            </div>
        </div>
        <div id="footer">
        	<p>
                <a href="#">关于某某</a>
                <a href="#">广告服务</a>
                <a href="#">联系我们</a>
                <a href="#">版权声明</a>
                <a href="#">合作对象</a>
            </p>
            <p>
                <a>京ICP备 123132123号</a>
                All rights(C) 2020-2030 Reserved.
            </p>
        </div>
    </body>
</html>
```



# 	第二章

##  零、源码主要部分

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <style text="text/css">
            /*1. 为什么要写这个？*/
            /*不同浏览器缺省的margin和padding，都设成0，避免兼容性问题*/
            /*2. 不要 * ，因为 * 会把整个网页走一遍，会增加网页的负担，效率低下。*/
            /* * {
                margin: 0;
                padding: 0;
            } */
            
            /* 上面的 * 修改为以下。 */
            /*网页出现哪些元素，这里写哪些元素*/
            /*优点：加载速度比前面的 * 快。*/
            /*缺点：如果有新的标签，这里还需要手动添加。*/
            body,div,p,ul,li,dl,dt,dd,h1,a{
                margin: 0;
                padding: 0;
            }
            
            body {
                /*给字体多种选择样式*/
                font-family: 微软雅黑, verdana, geneva,sans-serif;
            }
            
            /*设置整个网页的背景颜色*/
            html,body{
                background: #2E2E2E;
            }
            
            /*对四个div进行统一设计一部分*/
            #header,#banner,#content,#footer{
                background: #900; /*深红色*/
                width: 1176px;
                margin: 0 auto; /*水平居中*/
            }
            
            /*对整个网页整体进行设计*/
            body{
                padding-top: 45px;
            }

        </style>
    </head>
    <body>
        <div id="header">
        	<div id="logo">
                <a href="#(网址)">
                    <!-- 图片就在当前路径的话，用 ./图片名字.后缀 -->
                	<img src="logo路径"> 
                </a>
            </div>
        	<div id="nav">
            	<ul class="navActive">
                    <!-- 需要7个菜单 -->
                    <!-- 给某个菜单设置突出高光的时候，可以给他一个class，对给定的class进行设置即可。-->
                    <li><a href="#">菜单1</a></li>
                    <li><a href="#">菜单2</a></li>
                    <li><a href="#">菜单3</a></li>
                    <li><a href="#">菜单4</a></li>
                    <li><a href="#">菜单5</a></li>
                    <li><a href="#">菜单6</a></li>
                    <li><a href="#">菜单7</a></li>
                </ul>
            </div>
        </div>
        <div id="banner">
            <a href="#"><img src="图片路径"/></a>
        </div>
        <div id="content">
        	<div id="leftArticle">
                <a id="artidA" href="#"><img src="./img/article.jpg" alt="" /></a>
                <h1 align="center"><a href="#">文章标题</a></h1>
                <p>DEFAEFASDVSDVAWE</p>
                <p>FDFAWWAEFDVVVVAS</p>
                <p>ADVCXVZXCVADFAWE</p>
            </div>
            <div id="rightInfo">
                <dl>
                    <div>
                    <dt>标题1：XXXX</dt>
                    <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                    <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                    <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                    <div>
                    <dt>标题1：XXXX</dt>
                    <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                    <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                    <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                    <div>
                        <dt>标题1：XXXX</dt>
                        <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                        <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                        <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                    </div>
                    <div>
                        <dt>标题1：XXXX</dt>
                        <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                        <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                        <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                     </div>
                    <div>
                        <dt>标题1：XXXX</dt>
                        <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                        <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                        <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                    </div>
                    <div>
                        <dt>标题1：XXXX</dt>
                        <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                        <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                        <dd><a href="#">XXXXXXXXXXXXXXX</a></dd>
                    </div>
                </dl>
            </div>
        </div>
        <div id="footer">
        	<p>
                <a href="#">关于某某 |</a>
                <a href="#">广告服务 |</a>
                <a href="#">联系我们 |</a>
                <a href="#">版权声明 |</a>
                <a href="#">合作对象</a>
            </p>
            <p>
                <a>京ICP备 123132123号</a>
                All rights(C) 2020-2030 Reserved.
            </p>
        </div>
    </body>
</html>
```



## 一、Header部分

<img>：是一个内联元素，但是他会把里面的图片变成块元素。

​		在对 **`img`** 元素进行设置的时候，为了能为图片设定宽高，直接把他设置为 display: block。如果他还在一个 **`<a>`** 标签里面，那么把这个 **`<a>`** 标签也设置为 **`display: block`** 。（这是一个约定俗成的rule。）

```css
			img {
				border: none;  /*去掉图片的边沿装饰。*/
            }
            
            #logo {
                width: 222px;
                height: 84px;
                float: left;
                background: #111111;
            }
            
            #logo a{
                display: block;
                width: 222px;
                height: 84px;
            }
            
            #logo a img{
                display: block;
            }
            
            #nav {
                width: 954px;
                height: 84px;
                float: left;
                background: #111111;
            }
            
            #mav li {
                float: left; /*左浮动 -- 也就平过来了*/
                list-style: none;
            }
            
            #nav li a {
                display: block;
                padding: 0 20px; /*上下0，左右20*/
				/*下面三行居中*/
                height: 84px;
                line-height: 84px;
                text-align:center;
				/*IE上面之后真变成块了，一个一行，这里浮动让他变成一行*/
                float: left;
                /*对字体设置*/
                font-size; 23px;
                color: #EEEEEE;
                text-decoration: none;
            }
            
            #nav li a:hover {
                color: #111111;
                font-size: 24px;
                background: #EEEEEE;
            }
            
            #nav ul .navActive {
                /*从上到下 渐变色 从#EEEEEE到#555555 这个渐变色在IE上没显示*/
                background: linear-gradient(to bottom, #EEEEEE, #555555); 
                *background: #888888; 
                /*
                对IE6而言 第一行 linear-xxx不支持，所以不显示。
                		  第二行，认识*，所以background的设置效果显示出来。
                		  第二行覆盖第一行。
                对Chrome而言  第一行，支持
                			 第二行，不认识*
                			 第一行生效。
                */
            }

			/*这里测试header的高度*/
            /*#header {
				width: 1500px;
                background: #00FF00;
            }*/
            /*它会告诉你现在的header高度是0*/
            
            /*#header {
            	由于里面的子元素都已经浮动，浮动就是本来是一个图层的东西，变成了多个图层，导致高度塌陷，所以前面的高度是0。
                overflow: hidden;
            	overflow是把子元素所有的浮动都去掉，然后用hidden自适应设置高度。
            }*/
```



### 浮动问题 —— hidden：

1.   **`浮动`** 会让子元素脱离原来的图层（文档流），当所有元素都脱离时，而与此同时父元素没有设定高度，造成父元素高度变为0。
2.  **`overflow: hidden;`** 会消除所有子元素的浮动，然后进行自适应高度计算，因为父元素没有设定高度，所以就不会进行裁剪。



## 二、Banner部分



```css
#banner {
	margin: 10px auto;
	height: 580px;
}

#banner a, #banner a img {
   	/*block 变成块元素*/
	display: block;
	width: 1176px;
	height: 580px;
}
```



## 三、Content部分



```css
/*都float后，高度会塌陷。*/
#content {
    /*overflow解决高度塌陷*/
    overflow: hidden;
    background: #EAEAEA;
    font-size: 12px;
    line-height: 24px;
}

#leftArticle {
    float: left;
    margin: 10px;
    /*IE6 出现 double margin left 的bug*/
    /*处理成 inline 解决bug*/
    display: inline;
    /*把右边距设置为0*/
    /*margin-right: 0;*/
    /*上下左右设置外边距宽度*/
    /*margin: 10px 0 10px 10px;*/
    
    width: 765px;
    margin-right: 0;
    font-size: 24px;
}

#leftArticle #artidA,#leftArticle a img {
    display: block;
    width: 765px;
    height: 467px;
}

#leftArticle h1 {
    /*上下20px，左右0*/
    margin: 20px 0;
    /*此处使用margin不用padding
    因为如果使用padding，需要重新设定line-height，做垂直居中用*/
}

h1 {
    /*这里100%，就会顶格*/
    font-size: 100%;
}

/*这里设置leftArticle里的文本格式*/
#leftArticle p {
    color: #333;
    /*text-indent: 2em; 用于缩进，2个字*/
    text-indent: 2em;
    /*这里设置字体大小，相当于间接的设置了行间距*/
    /*这里的行间距 = 文本高度 - 字体大小高度*/
    font-size: 14px;
    /*段间距 10px*/
    margin-bottom: 10px;
}

#rightInfo {
    float: left;
    margin: 10px;
    background: #FF0000; /*给个颜色，用于测试，看得出范围。*/
}

#leftArticle h1 a {
    color: #900;
    text-decoration: none;
}

#leftArticle h1 a:hover {
    text-decoration: underline;
}

#rightInfo dl {
    margin-bottom: 3 0px;
}

#rightInfo dl dt {
    font-size: 15px;
    /*字加重 bold*/
    font-weight: bold;
    /*缩进20px长度*/
    text-indent: 20px;
    /*文本背景色*/
    background: #900;
    /*高度*/
    height: 32px;
    /*上下居中*/
    line-height: 32px;
    /*文本色*/
    color: #FFF;
}

#rightInfo dl dd {
    height: 24px;
    line-height: 24px;
    color: #333;
    background: #FFF;
    /*缩进16px长度*/
    text-indent: 16px;
    /*字体大小*/
    font-size: 13px;
}

#rightInfo dl dd:last-child {
	margin-bottom: 20px;
}

#rightInfo dl dd a {
    color: #333;
    text-decoration: none;
}

#rightInfo dl dd a:hover {
	color: #999;
    text-decoraion: underline;
}
```



## 四、Footer部分



```css
#footer {
	background: #393838;
    margin-top: 10px;
    padding-top: 18px;
    height: 52px;
    /*对字起作用*/
    line-height: 18px;
    color: #CCC;
    text-align: center;
    font-size: 12px;
    /*离底部的距离 40px*/
    margin-bottom: 40px;
}

#footer a {
    color: #CCC;
    text-decoration: none;
}

#footer a:hover {
    text-decoration: underline;
}
```



### CSS hack



**利用同一种关于发，在不同的浏览器上的效果不一样，来打到适配性。**

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <style type="text/css">
            #div1 {
				width: 200px;
                height: 200px;
                background: #000; /*黑色*/
            }
            
            #div1 { /*对其他的浏览器*/
                /*红色*/
				background: #F00!important;
                /*蓝色*/
                background: #00F;/*for IE6 Only*/
            }
            /*
            1. 对于其他浏览器，加了important，优先级最高，所以显示为红色(#F00)，忽略important后面的；
            2. 对于IE6而言，IE6不认识important，所以忽略important这一句，读后面，则背景为蓝色(#00F)；
            */
            
            #div2 {
                /*红色*/
				background: #F00;
                /*蓝色*/
                *background: #00F;/*for IE6 Only*/
            }
            /*
            1. 对于其他浏览器，由于不认识*background，所以只认识没有 * 的，所以显示为红色。
            2. 对于IE6，后面的*background也认识，所以后面覆盖前面，所以显示为蓝色。
            */
        </style>
    </head>
    <body>
        <div id="div1"></div>
        <div id="div2"></div>
    </body>
</html>
```



# 第三章



## 一、HTML

### （一）HTML的结构和语法

-  **`<html>,<head>,<body>,<meta>,<title>,注释`** 。

- 所有元素（或者称标签），都包含在  `<`  和  `>`  之间。

- 大部分元素都有起始标签和结束标签，中间包含的是网页内容主体。

- 少部分元素只有起始标签，称为空标签，典型的有：

  ​	**`input,img,area,br,hr,meta,plaintext等`** 

- 起始标签包含元素名称，以及可选的属性。

- 属性可以包含 属性名="属性值" 的形式，也可以只有属性名。属性值应当用引号包含，虽然没有浏览器也认识。
  ​	如：`<meta charset="UTF-8">` ，charset就是属性，UTF-8是属性值。







```html
<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>
        
    </body>
</html>

对于HTML5以上几个标签是必有的。
对于HTML4，除了以上几个，还有<title></title>标签也是必须的。
```



### （二）HTML的特性和标签

- 对于HTML，如果要在网页换行，用 `<br> `标签；如果你手动回车换行的话，它只会当做一个空格。

- 文档结构标签：

  - html，head，body

- 文本格式标签：

  - title ：网页标题
  - h1~h6：文本级别，从级别1到级别6
  - p：段落标签。如果文本内部有回车或者多个空格，只会显示为一个空格。
  - pre：和p类似，但是如果回车或者多个空格，会显示。
  - blockquote：变成名人引用的文本。

- 字符格式标签：

  - b，i，blink，big，small，sup，sub，cite

- 列表标签：

  - 有序列表和无序列表：ul，ol，li
  - 定义列表：dl，dt，dd

- 链接标签：

  - a

- 多媒体标签：

  - img，embed，object

- 表格标签：

  - table，caption，th，tr(行)，td(列)

    ```html
    <table>
        <th> 行
        	<td></td> 列
        	<td></td>
        </th>
        <th>
        	<td></td>
        	<td></td>
    	</th>
        <th>
        	<td></td>
        	<td></td>
    	</th>
    </table>
    
    上面这是一个3*2列的表格。
    一般做表格不用table。
    ```

    

- 表单标签：

  - form，input，textarea，select，option

- 属性：

  - id
  - class
  - style



## 二、XHTML

### （一）XHTML的结构和语法

- 在文档开头必须定义文档类型
- 根元素必须声明命名空间，设置xmlns属性
- 所有标签必须闭合，不支持独立标签
- 所有元素和属性必须小写
- 所有数值型必须使用引号包含
- 没有属性值的属性，属性属于自己
  - `<td nowrap> => <td nowrap="nowrap">`
- 所有标签都需要合理嵌套



## 三、HTML5

### （一）HTML5和HTML4的区别

- 文档类型声明

- 字符集编码

- 元素的重新语法定义：

  - 不允许写结束标记的元素：area，base，br，embed，hr，img，input，keygen，link，meta，param，source，track，wbr
  - 可以省略结束标记的元素：li，dt，dd，p，rt，optgroup，option，thead，tbody，tfoot，tr，td，th
  - 可以省略全部标记的元素：html，head，body，tbody

- 具有布尔值的属性：

  - 只写属性，不写属性值，属性为true
  - 不写属性，属性值为false
  - 属性值等于属性名，属性值为true
  - 属性值等于空字符串，属性值为true

  即：除了不写属性外，其他都为true。

  ```html
  整个是关于类型为checkbox的属性进行讨论。
  
  1.没有属性，代表属性值默认为false
  <input type="checkbox">false<br>
  
  2.有属性没有属性值，代表属性值默认为true
  <input type="checkbox" checked>true<br>
  
  3.属性值等于空字符串，代表属性值默认为true
  <input type="checkbox" checked="">1<br>
  
  4. 属性值等于属性名，代表属性值默认为true
  <input type="checkbox" checked="checked">1<br>
  
  5.给定属性值为啥，则最终属性值就为啥
  <input type="checkbox" checked="true">true<br>
  ```

  

### （二）HTML5新增的元素

- 新增的结构元素：
  - header，footer，section，article，aside，nav
- 新增的功能元素：
  - hgroup，figure，video，audio，embed，mark，time
- 废除的元素：
  - big，center，font，u
  - HTML5中主张用CSS3来呈现文本效果



### （三）HTML5的文档结构

- header + nav + section + footer
- section（aside + article）
- 这些结构都可以嵌套



#### 1.header

```html
<header>HTML5的头部区域</header>
```

#### 2.nav

```html
<nav>HTML5的导航区</nav>
```

#### 3.section

```html
<section>内容区域
	<aside>左侧导航或者菜单栏</aside>
    <article>主页内容
    	<section>可以嵌套
        	<aside></aside>
            <article>
            	<header></header>
                <footer></footer>
            </article>
        </section>
    </article>
</section>

如果里面的小内容是分支的，则是article，如果不分支，则是section。
```

#### 4.footer

```html
<footer>HTML5的底部区域</footer>
```





### （四）IE

在注释文档中写：

```html
<!--[if IE]><meta name="ie" content="IE=6; IE=7; IE=8; IE=9"/><![endif] -->

这里在IE6中打开，会显示h2级别的IE这俩字，但是在其他浏览器会被当做注释忽略掉。
<!--[if IE]><h2>IE<\h2><![endif] -->
```

```html
<meta name="description" content="关于网页的描述" />
<meta name="author" content="作者姓名" />
<meta name="copyright" content="版权问题" />
<meta name="viewport" content="width=device-width,user-scalable=no" />

<!-- 这里是对网页的标题进行设置
	第一个shortcut icon可以在网页前面加一个图片，href是图片的地址 
	第二个是apple系列才有的。
-->
<link rel="shortcut icon" href="https://imags.wanmen.org/favi.png" />
<link rel="apple-touch-icon" href="#" />

<!-- 在JS中配置了src，则alert(2)提示就出不来，没有配置，则会按照书写顺序出来。-->
<script type="text/javascript" src="xxx">alert(2);</script>
<script type="text/javascript">alert(1);</script>
```



### （五）元素分类

#### 1. 结构性元素

- section：在web的应用中，可以用于区域章节的表达，section之间是不相互独立的，如看完第一段文字，第二段也能看到。
- header：head相当于body那里的东西，是不可见的；header里面放的是可见的东西。
- footer：可以放一些法律声明、邮件入口等等相关信息在结尾。
- nav：是navigator的缩写，是导航栏。
- article：在web的应用中，可以用于文章的表达，article之间是相互独立的，如看完第一篇文章，可以不看第二篇。



#### 2. 级块性元素

- aside：放在边上的，比如侧边栏或者摘要，是对内容的补充或者说明。
- figure：
- code：对于代码的显示比较方便。
- dialog：表达人与人之间的对话。常在一问一答中使用。



#### 3. 行内语义性元素

- meter：可以用于百分比、工资等显示，用于数字。
- time：时间的现实。
- progress：
- video：视频
- audio：音频



#### 4. 交互性元素

- details：表达一些具体的内容，但是这个内容是默认不可见的，可以和nav交互。
- datagrid：数据显示和脚本的及时更新。
- menu：菜单的交互。
- command：用来处理命令的按钮。



### （六）HTML5构建主题内容

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <!--导航栏 -->
        <nav>
       	 	<!--菜单 -->
        	<ul>
                <li><a href="#">111</a></li>
                <li><a href="#">222</a></li>
                <li><a href="#">333</a></li>
            </ul>
        </nav>
        
        <!--内容 -->
        <article>
            
            <!--标题 -->
        	<header>
            	<hgroup>
                	<h1>文章标题</h1>
                    <h2>文章副标题</h2>
                </hgroup>
                <!--<time pubdate></time>  发布时间-->
                <time pubdate="pubdate">2020-06-08</time>
            </header>
            <!--正文 -->
            <p>
                XXXXXXXXXXXXXXXXXXX
            </p>
            <!--作者个人信息，放在最下面 -->
            <footer>
                <address><p>来自哪里。</p></address>
            </footer>
            
            <section>
            	<h2>评论</h2>
                
                <article>评论1
                	<header>
                    	<h3>名字</h3>
                        <p>评论的内容。</p>
                        <time pubdate datetime="2020-08-02 11:22:33">一小时前</time>
                    </header>
                    <p>OK</p>
                </article>
                
                <article>评论2
                	<header></header>
                    <p>OK</p>
                    <h3>名字</h3>
                        <p>评论的内容。</p>
                        <time pubdate datetime="2020-08-02 10:22:33">二小时前</time>
                </article>
                
            </section>
        </article>
        
        <!--最下面 -->
        <footer>
        	<ul>
                <li>关于某某 |</li>
                <li>版权申明 |</li>
                <li>详细地址 |</li>
            </ul>
        </footer>
    </body>
</html>
```

​		`section` 就是有条件的 `div`，能用 `div` 就不用`section` ，能清楚导航条等等，就不用 `section`，因为 `section` 的概念是比较模糊的，容易判断失误。



### （七）HTML5添加语义模块

- header —— 添加标题块。
- hgroup —— 给标题分组。
- footer —— 添加脚注。
- address —— 添加联系信息。



### （八）HTML5改造页面

- 用作网页头的或者文本头等，是开头这个含义的，可以用header代替div，或者外面包一层header。
- 导航栏的div用nav代替。
- 文本的div用article代替。
- article内部的文本的div用section代替。
- 如果文本是在侧栏，用aside代替div。



## 四、HTML动手实验

### （一）表单：input的新增输入类型

#### 1. HTML4.01支持的input输入类型

- text：用于文本输入（可以增加属性值value="内容"，这个内容会在网页打开后，就已经在里面了。）
- radio：用于选中与否
- checkbox：用于选择，多选
- password：用于输入密码，输入的时候全是*，看不见
- submit：用于按钮点击，可以增加属性值value="内容"，按钮上就会显示"内容"。
- image：给一个图片图片，和button类似可以点击；也可以不给图片，然后绑定事件进行使用。
- hidden：以隐性的方式对form里面提交出去的数据做步骤记录。（到哪一步了）
- reset：当改一个东西，想放弃的时候，会把这个全部清空。（重置）
- file：用于选择文件，和系统文件对接。

```html
<!DOCTYPE html>
<html>
    <head>
        <title></title>
    </head>
    <body>
        text    : <input type="text"                /><br/>
        radio   : <input type="radio"               /><br/>
        checkbox: <input type="checkbox"            /><br/>
        password: <input type="password"            /><br/>
        submit  : <form action="#" method="get">
        			<input type="text"   /><br/>
                  	<input type="submit" /><br/>
        			<input type="reset"  /><br/>
        		  </form>
        button  : <input type="button" value="123"  /><br/>
        image   : <input type="image" src="图片路径" /><br/>
        hidden  : <input type="hidden"              /><br/>
        reset   : <input type="reset"               /><br/>
        file    : <input type="file"                /><br/>
    </body>
</html>
```



#### 2.HMTL5支持的input类型

- email：和text类似，不过是给一个文本框，然后在文本框输入一个邮件类型的文本，否则会报错。（用于检查是否是合理email）
- url：检查输入的是否是一个合理的网址。（https://www.baidu.com 、www.baidu.com）
- number：用于检查输入的是否是数字，数字的范围是否合理。（除了type="number"，后面的不是必须的。）
- date：用于进行日期的输入和选择。（这个或者这一类时间型控件，都可以设置：min=""  max=""  step=""  value=""）



```html
<form action="#" method="get">
    email: <input type="email"  /><br/>
    	   <input type="submit" /><br/>
</form>

<form action="#" method="get">
    url:   <input type="url"    /><br/>
    	   <input type="submit" /><br/>
</form>

<form action="#" method="get">
    number: <input type="number" min="最小值" max="最大值" step="步长" value="初始值"/><br/>
    	    <input type="submit"   /><br/>
</form>

<form action="#" method="get">
    date : <input type="date"   /><br/>
    <!--这里选了month控件后，出现的选择就是：年/月 -->
    month: <input type="month"   /><br/>
    <!--这里选了week控件后，出现的选择就是：年/周-->
    weed : <input type="week"    /><br/>
    <!--这里选了time控件后，出现的选择就是：时/分-->
    time : <input type="time" min="最早时间" max="最晚时间" step="时间跳跃步长" value="初始时间"/><br/>
    <!--用于手动输入一个时间字符串，里面有性能对它进行控制。 -->
    datetime: <input type="datetime" /><br/>
    <!--可以进行选择具体的：年月日 时秒分 -->
    datetime-local: <input type="datetime-local" /><br/>
    <!--可以用于搜索的时候，输入文本，然后输入错误，可以点×重新输入，如淘宝的搜索宝贝。 -->
    search:<input type="search"  /><br/>
    <!--用于电话的输入和差错。 -->
    tel:   <input type="tel"     /><br/>
    <!--用于颜色的选择，出来一个颜色的选择器。 -->
    color: <input type="color"   /><br/>
    	   <input type="submit"  /><br/>
</form>

<form action="#" method="get">
    month: <input type="date"   /><br/>
    	  <input type="submit"  /><br/>
</form>
```



#### 3. input的新增属性

- autocomplete="on|off"：用于对以前输入的信息，进行自动备份，在二次输入的时候，会将之前输入过的信息显示出来，便于二次快捷输入。
- autofocus（原来是用JS实现的）：getElement.id。（一般这么做？？？）
- form：把表单内部一大块信息一起提交出去。如果要把form外部的东西一起提交出去，可以在外面的input里面，添加一个form属性，属性值是你自己的那个form的名字。
- formaction：在input中假如这个属性，然后属性值给定一个form的action值，然后就会提交到这个action，而不是包着它的那个form。
- placeholder：对于输入框给一个虚的字的提示。
- required：用于防止用户没有填写内容，如果什么都不写就提交，就会提示填写内容。



#### 4. form的新增属性

- autocomplete = "on|off"
- novalidate = "true"：如果设定了这个后，所有试图检查你的输入是否正确的都会关闭。（如：email、tel、url、number）



# 第四章

## 一、音频编码器

- mp3

- AAC

- ogg

  

## 二、检查浏览器关于音频编解码器的支持情况

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <script type="text/javascript">
            // 这个函数用来检查浏览器是否支持mp3，ogg，AAC
        	function checkAudio(){
				let myAudio = document.createElement('audio');
                // 如果支持，浏览器的console会显示log后面的内容
                if(myAudio.canPlayType){
                    if('' != myAudio.canPlayType('audio/mpeg')){
                        console.log('support mp3');
                    }
                    if('' != myAudio.canPlayType('audio/ogg;codecs="vorbis"')){
                        console.log('support ogg');
                    }
                    if('' != myAudio.canPlayType('audio/mp4;codecs="mp4a.40.5"')){
                        console.log('support AAC');
                    }
                // 如果不支持，则console显示log后面的内容。
                }else{
                    console.log('not support audio check!');
                }
            }
            
            window.onload = function(){
                // 调用函数
                checkAudio();
            }
        </script>
    </head>
    <body>
        
    </body>
</html>
```



## 三、用HTML5播放音频

```html
<body>
    <audio controls="">
        <!--源文件目录地址或网页链接地址src -->
        <!--type写支持的音频格式 -->
    	<source src="audio/1.mp3" type="audio/mpeg" />
        <source src="audio/1.ogg" type="audio/ogg"  />
        你的浏览器不支持audio!
    </audio>
</body>
```



## 四、用JS控制音乐

### （一）、JS源码

```js
// 展示myA的一些状态
function showInfo(){
    let myA = document.getElementById('audioControl');
    // 输出当前播放音乐的源文件路径或网页链接
    console.log('currentSrc',myA.currentSrc);
    // 输出音乐已经播放的时间
    console.log('currentTime',myA.currentTime);
    console.log('duration',myAduration);
    // 判断是否结束 true/false
    console.log('ended',myA.ended);
    // 判断是否在播放，返回的一个数组
    // 能取到开始时间，结束时间等
    console.log('played',myA.played);
    // 判断是否停止 true/false
    console.log('paused',myA.paused);
    console.log('volume',myA.volume);
    console.log('seeking',myA.seeking);
}

function playOrPause(){
    let myA = document.getElementById('audioId');
    let myI = document.getElementById('btnId');
    if(myA.paused){
        myA.play();
        myI.value = 'pause';
    }else{
		myA.pause();
        myI.value = 'play';
    }
}
```



### （二）HTML源码1

```html
<body>
    <audio id="audioId">
    	<source src="audio/1.mp3" type="audio/mpeg" />
        <source src="audio/1.ogg" type="audio/ogg"  />
        你的浏览器不支持audio!
    </audio>
    <audio id="btnId">
    	<source src="audio/1.mp3" type="audio/mpeg" />
        <source src="audio/1.ogg" type="audio/ogg"  />
        你的浏览器不支持audio!
    </audio>
    <input type="button" onclick="playOrPause()" value="control" />
</body>
```



###  （三）HTML源码2

```html
<body>
    <audio id="audioId" controls>
    	<source src="audio/1.mp3" type="audio/mpeg" />
        <source src="audio/1.ogg" type="audio/ogg"  />
        你的浏览器不支持audio!
    </audio>
    <input type="button" onclink="showInfo()" value="show Info"/>
</body>
```



## 五、视频编解码

- 编码和解码
- 常用编解码器
  - H.264
  - VP8（Google的WebM项目 VP8+Vorbis）
  - Ogg Theora



## 六、浏览器支持情况

- IE：9.0及以上支持，支持H.264编解码器-MPEG4容器
- FireFox：3.5



## 七、检查浏览器关于视频编解码器支持情况

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <script type="text/javascript">
            function checkVideo(){
                    let myVideo = document.createElement('video');
                    if(myVideo.canPlayType){
                        if('' != myVideo.canPlayType('video/mp4;codecs="avc1.64001E"')){
                            console.log('support H.264');
                        }
                        if('' != myVideo.canPlayType('video/ogg;codecs="vp8"')){
                            console.log('support vp8');
                        }
                        if('' != myVideo.canPlayType('video/ogg;codecs="theora"')){
                            console.log('support theora');
                        }
                    }else{
                        console.log('not support video check!');
                    }
                }
        	window.onload = function(){
        		checkVideo();
        	}
        </script>
    </head>
    <body>
        <videp style="width:800px;height:" controls>
        	<source src="文件网页链接或者文件路径.mp4" />
            你的浏览器不支持video标签。
        </videp>
    </body>
</html>
```



## 八、用JS控制视频

### （一）案例1

```html
<body>
    <!--onmouseover:鼠标在视频内
		onmouseout:鼠标不在视频内
		play():播放
		pause():停止
		注：Chrome66及以上，禁止视频自动播放，所以上面这俩方法做不了。
	-->
	<video style="width:800px;height:450px" onmouseover="this.play()" onmouseout="this.pause">
    <source src="文件网页链接或者文件路径.mp4" />
            你的浏览器不支持video标签。
    </video>
</body>
```



### （二）案例2

```html
<body>
    <videp style="width:800px;height:" controls>
        <source src="文件网页链接或者文件路径.mp4" />
        你的浏览器不支持video标签。
    </videp>
    <input type="buttom" onclink="showInfo()" value="show Info" />
</body>
```



### （三）JS源码

```js
// 展示myA的一些状态
function showInfo(){
    let myA = document.getElementById('videoControl');
    // 输出当前播放的视频的源文件路径或者网页链接
    console.log('currentSrc',myA.currentSrc);
    // 输出视频已经播放的时间
    console.log('currentTime',myA.currentTime);
    console.log('duration',myAduration);
    // 判断是否结束 true/false
    console.log('ended',myA.ended);
    // 判断是否在播放，返回的一个数组
    // 能取到开始时间，结束时间等
    console.log('played',myA.played);
    // 判断是否停止 true/false
    console.log('paused',myA.paused);
    console.log('volume',myA.volume);
    console.log('seeking',myA.seeking);
}
```



## 九、Canvas

- Canvas：跨平台动画和游戏的标准解决方案。
- 简单认识Canvas。.



### （一）简介案例

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
        <script type="text/javascript">
            function load(){
                let c = document.gettElementById('myC');
                // 画2D动画，存放在context变量中
                let context = c.getContext('2d');

                // fillStyle:这个是颜色。
                context.fillStyle='#FF00FF';
                // fillRect:开始画的起始坐标(50,25)，宽度100，高度50。
                context.fillRect(50,25,100,50);
            }
            
            window.onload = function(){
                if(checkSupport()){
                	load();
                }
            }
            
            function checkSupport(){
                let c = document.getElementById('myC');
                if(c.getContext){
                    console.log('support canvas!');
                    return true;
                }else{
                    console.log('not support canvas!');
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <canvas id="myC" style="border: 1px #000 solid" width="800" height="450">
            <!--下面这句话放在canvas里面，可以用来判断canvas后面的属性是否用显示，并给出提示 -->
        	你的浏览器不支持canvas元素！
        </canvas>
    </body>
</html>
```



### （二）绘制图片

moveTo(坐标)：从坐标位置开始画。

lineTo(坐标)：画到坐标位置，画线。

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
        <script type="text/javascript">
            function load(){
                let c = document.getElementById('myC');
                let context = c.getContext('2d');
                
                // 1. 画线   --  line
                // 从(100，100)开始画
                context.moveTo(100,100);
                // 画线到(300,200)结束
                context.lineTo(300,200);
                context.stroke();
                
                // 2. 画矩形（空心）  --  stroke
                // 颜色
                context.strokeStyle = '#FF0000';
                //起始点(100,100)，宽200，高100
                context.strokeRect(100,100,200,100);
                // stroke()：让画的图显示出来的意思。
                context.stroke();
                
                // 3. 画矩形（实心）  --  fill
                context.fillStyle = '#00FF00';
                context.filleRect(300,200,100,100);
                
                // 4. 圆弧  --  Path
                context.beginPath();
                // 从起始点开始画：起始点(100,75)
                // 半径50
                // 画的弧度：(0,π/2)
                // 是否是逆时针：true
                context.arc(100,75,50,0,Math.PI/2,true);
                context.stroke();
                context.closePath();
                //这里画圆是本身有一个圆，然后逆时针画了1/4的圆，就相当于抹去了1/4，剩下了3/4的圆。
                
                // 5.实心圆  --  Path
                context.beginPath();
                context.arc(100,70,25,0,Math.PI/2,true);
                context.closePath();
                
                // 6.画三角形  --  用各种画图来拼
                context.beginPath();
                context.moveTo(400,100);
                context.lineTo(400,100);
                context.lineTo(400,200);
                context.closePath();
                // stroke()是画线，空心
                // context.stroke();
                // fill()是填充，实心
                context.fill();
            }
            window.onload = function(){
                load();
            }
            
            function clearCanvas(){
                // 用 c 取到 id=myC 的标签。
                let c = document.getElementById('myC');
                let context = getContext('2d');
                // 从(0,0)到(800,450)这个矩形范围进行清空。
                context.claerRect(0,0,800,450);
            }
        </script>
    </head>
    <body>
        <canvas id="myC" style="border: 1px #000 solid" width="800" height="450">
            <!--下面这句话放在canvas里面，可以用来判断canvas后面的属性是否用显示，并给出提示 -->
        	你的浏览器不支持canvas元素！
        </canvas>
        <input  type="button" value="clear" onclink="clearCanvas()" />
    </body>
</html>
```



### （三）图形变换

##### 0. 贝塞尔曲线

- 线性公式：B(t) = P0 + (P1-P0)t = (1-t)P0+tP1 , t  [0,1]
- 二次方公式：B(t) = 
- 三次方公式：B(t) = 

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
        <script type="text/javascript">
            function load2(){
                let c = document.gettElementById('myC');
                let context = c.getContext('2d');
				
                context.strokkeStyle = "#000";
                context.beginPath();
 				//后面的图覆盖前面的图              
                context.globalCompositeOperation="source-over";
                context.moveTo(0,200);
                // 贝塞尔二次方公式：三个参数——P0、P1、P2
                context.quadraticCurveTo(75,50,300,200);
                context.stroke();
                context.closePath();
                
                context.beginPath();
                context.moveTo(75,50);
                context.lineTo(0,200);
                context.moveTo(75,50);
                context.lineTo(300,200);
                context.moveTo(0,200);
                context.lineTo(300,200);
                context.stroke();
                context.closePath();
            }
            
            function load3(){
                let c = document.gettElementById('myC');
                let context = c.getContext('2d');
				
                context.strokkeStyle = "#000";
                context.beginPath();
 				//后面的图覆盖前面的图              
                context.globalCompositeOperation="source-over";
                context.moveTo(0,200);
                // 贝塞尔三次方公式：三个参数——P1、P2、P3
                context.bezierCurveTo(25,50,75,50,300,200);
                context.stroke();
                context.closePath();
                
                context.beginPath();
                context.moveTo(25,50);
                context.lineTo(0,200);
                context.moveTo(75,50);
                context.lineTo(300,200);
                context.moveTo(0,200);
                context.lineTo(300,200);
                context.stroke();
                context.closePath();
            }
            
            window.onload = function(){
				load2();
                load3();
            }
        </script>
    </head>
    <body>
        <canvas id="myC" style="border: 1px #000 solid" width="800" height="450">
            <!--下面这句话放在canvas里面，可以用来判断canvas后面的属性是否用显示，并给出提示 -->
        	你的浏览器不支持canvas元素！
        </canvas>
    </body>
</html>
```





##### 1. 小案例

- Canvas：图形变换
  - 平移、旋转、缩放、矩阵变换 。

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
        <script type="text/javascript">
            function load(){
                let c = document.gettElementById('myC');
                // 画2D动画，存放在context变量中
                let context = c.getContext('2d');
                
                //图1
                context.fillStyle = "#FF00FF";
                context.strokeStyle = "#0000FF";
                context.fillRect(20,20,100,100);
                context.strokeRect(20,20,100,100);
                // 填充
                context.fill();
                // 画线
                context.stroke();
                
                // 对上面保存一下。
                context.save();
                
                // 图2
                context.fillStyle = "#FF0000";
                context.strokeStyle = "#00FF00";
                context.fillRect(140,20,100,100);
                context.strokeRect(140,20,100,100);
                context.fill();
                context.stroke();
                
                // 图3
                // context.restore();
                // restore():是把前面save()存的东西再拿出来，最开始save()的是紫色，然后这里拿出来后，就是紫色，如果这里不拿出来，他就会跟着与他最近的颜色相同(红色)。
                context.fillRect(20,140,50,50);
                context.stokeRect(80,140,50,50);
                context.fill();
                context.stroke();
            }
            window.onload = function(){
                load();
            }
        </script>
    </head>
    <body>
        <canvas id="myC" style="border: 1px #000 solid" width="800" height="450">
            <!--下面这句话放在canvas里面，可以用来判断canvas后面的属性是否用显示，并给出提示 -->
        	你的浏览器不支持canvas元素！
        </canvas>
    </body>
</html>
```



##### 2. 平移

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
        <script type="text/javascript">
            function move(){
                let c = document.gettElementById('myC');
                let ctx = c.getContext('2d');
                // 坐标原点平移到(80,80)，原来的(0,0)变成了(-80,-80)。
                ctx.translate(80,80);
                for (let i=1; i<10; i++){
                    // 存下第一次没有改变的时候的坐标轴
                    ctx.save();
                    // 原点坐标随着for循环不断变化
                    // 这里往x轴正方形错开60*i个单位
                    ctx.translate(60*i,0);
                    // 设置变化颜色
                    ctx.fillStyle = "rgb("+(30*i)+","+(255-30*i)+",255)";
                    ctx.fillRect(0,0,60,60);
                    // 回到最开始的位置。
                    ctx.restore();
                }
            }
            window.onload = function(){
                move();
            }
        </script>
    </head>
    <body>
        <canvas id="myC" style="border: 1px #000 solid" width="800" height="450">
            <!--下面这句话放在canvas里面，可以用来判断canvas后面的属性是否用显示，并给出提示 -->
        	你的浏览器不支持canvas元素！
        </canvas>
    </body>
</html>
```



##### 3. 旋转、缩放

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
        <script type="text/javascript">
            function myRotate(){
                let c = document.gettElementById('myC');
                let ctx = c.getContext('2d');
                
                ctx.translate(250,250);
                for (let i=1; i<9; i++){
                    ctx.save();
                    // rotate(角度):坐标轴顺时针旋转一个角度。
                    ctx.rotate(Math.PI*(1/2+i/4));
                    //scale(值1，值2):缩放到(值1*值2)的比例大小。
   	                ctx.scale((1-0.08*i),(1-0.08*i));
                    ctx.translate(0,-150);
                    ctx.fillStyle = "rgb("+(30*i)+","+(255-30*i)+",255)";
                    ctx.fillRect(0,0,60,60);
                    ctx.restore();
                }
            }
            window.onload = function(){
                myRotate();
            }
        </script>
    </head>
    <body>
        <canvas id="myC" style="border: 1px #000 solid" width="800" height="450">
            <!--下面这句话放在canvas里面，可以用来判断canvas后面的属性是否用显示，并给出提示 -->
        	你的浏览器不支持canvas元素！
        </canvas>
    </body>
</html>
```



##### 4. "综合"小案例

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
        <script type="text/javascript">
            function myTest(){
                let c = document.gettElementById('myC');
                let ctx = c.getContext('2d');
                
                ctx.translate(200,20);
                for (let i=1; i<80; i++){
                	ctx.tarnslate(30,30);
                    ctx.scale(0.95,0.95);
                    ctx.rotate(Math.PI/12);
                    
                    ctx.beginPath();
                    ctx.fillStyle = "#F00";
                    // 透明度 0.4
                    ctx.globalAlpha = "0.4";
                    ctx.arc(0,0,50,)
                    ctx.clothPath();
                    ctx.fill();
                }
            }
            window.onload = function(){
                myTest();
            }
        </script>
    </head>
    <body>
        <canvas id="myC" style="border: 1px #000 solid" width="800" height="450">
            <!--下面这句话放在canvas里面，可以用来判断canvas后面的属性是否用显示，并给出提示 -->
        	你的浏览器不支持canvas元素！
        </canvas>
    </body>
</html>
```



##### 5. 矩阵变换

transform(m11,m12,m21,m22,dx,dy)：6个参数。



- 平移的时候，相当于：transform(1,0,0,1,dx,dy)。
- 缩放的时候，相当于：transform(0.95,0,0,0.95,0,0)。缩放比例（0.95*0.95）。
- 旋转也可以用矩阵变换表示出来。

<img src="F:\桌面\HTML5+CSS3\矩阵变换.png" alt="矩阵变换" style="zoom:100%;" />

总之，矩阵旋转就相当于前面几种特殊情况的总和，可以表示图像的各种变换。



### （四）、图形的组合和裁切

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
        <script type="text/javascript">
            function myTest(){
                let c = document.gettElementById('myC');
                let ctx = c.getContext('2d');
                
                // 先画的红色的正方形
                ctx.fillStyle = "#F00";
                ctx.fillRect(50,25,100,100);
                
                // 然后画的绿色的圆形
                ctx.fillStyle = "#0F0";
                ctx.beginPath();
 
                /*
                destination:先画的部分
                source:后画的部分
                */     
 				//source-over:越过后画的部分，把被后画的图像覆盖的地方显露出来
                ctx.globalCompositeOperation="source-over";
                ctx.globalCompositeOperation="destination-over";
                // source-atop:
                ctx.globalCompositeOperation="source-atop";
                ctx.globalCompositeOperation="destination-atop";
                // source-in:保留source的交集部分
                ctx.globalCompositeOperation="source-in";
                 // destination-in:保留destination的交集部分
                ctx.globalCompositeOperation="destinaton-in";
                // source-out:保留source的差集部分
                ctx.globalCompositeOperation="source-in";
                // destination-out:保留destination的差集部分
                ctx.globalCompositeOperation="destinaton-out";
                // 保留异或部分，交集去掉。
                ctx.globalCompositeOperation="xor";
                
                ctx.arc(150,125,50,0,Math.PI*2,true);
                ctx.closePath();
                ctx.fill();
                
                
                
            }
            window.onload = function(){
                myTest();
            }
        </script>
    </head>
    <body>
        <canvas id="myC" style="border: 1px #000 solid" width="800" height="450">
            <!--下面这句话放在canvas里面，可以用来判断canvas后面的属性是否用显示，并给出提示 -->
        	你的浏览器不支持canvas元素！
        </canvas>
    </body>
</html>
```



```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
        <script type="text/javascript">
            function myTest(){
                let c = document.gettElementById('myC');
                let ctx = c.getContext('2d');
                
                // 这里画了一个背景
                ctx.fillStyle = "#000";
                ctx.fiilRect(0,0,300,300);
                ctx.fill();
                
                // 裁切——一个圆
                ctx.beginPath();
                ctx.arc(150,150,130,0,Math.PI*2,true);
                ctx.clip();
                
                ctx.translate(200,20);
                for (let i=1; i<80; i++){
                	ctx.tarnslate(30,30);
                    ctx.scale(0.95,0.95);
                    ctx.rotate(Math.PI/12);
                    
                    ctx.beginPath();
                    ctx.fillStyle = "#F00";
                    // 透明度 0.4
                    ctx.globalAlpha = "0.4";
                    ctx.arc(0,0,50,)
                    ctx.clothPath();
                    ctx.fill();
                }
            }
            window.onload = function(){
                myTest();
            }
        </script>
    </head>
    <body>
        <canvas id="myC" style="border: 1px #000 solid" width="800" height="450">
            <!--下面这句话放在canvas里面，可以用来判断canvas后面的属性是否用显示，并给出提示 -->
        	你的浏览器不支持canvas元素！
        </canvas>
    </body>
</html>
```



### （五）、绘制图像

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
        <script type="text/javascript">
            function myTest(){
                let c = document.gettElementById('myC');
                let ctx = c.getContext('2d');
                // 画图的类Image()
				let img = new Image();
                img.onload = function(){
                    // 1. 从(0,0)点画img   ——  正常绘图
                    // ctx.drawImage(img,0,0);
                    // 2. 从(100,100)点画img，按照300*212比例画  ——  放缩图形
                    //ctx.drawImage(img,100,100,300,212);
                    // 3. 只绘制图片的一部分：前四个数字参数是指在原图的什么位置截取，怎么截取的；后四个参数是指在canvas怎么画的。
                    // 前四个数字：从(142,100)这个位置开始裁，截取大小284*200
                    // 后四个数字：从(100,100)开始画，画的大小为300*212
                    ctx.drawImage(img,142,100,284,200,100,100,300,212);
                }
                // 指定img
                img.src = "图片路径/网页链接";
                
            }
            window.onload = function(){
                myTest();
            }
        </script>
    </head>
    <body>
        <canvas id="myC" style="border: 1px #000 solid" width="800" height="450">
            <!--下面这句话放在canvas里面，可以用来判断canvas后面的属性是否用显示，并给出提示 -->
        	你的浏览器不支持canvas元素！
        </canvas>
    </body>
</html>
```



### （六）、绘制文字

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
        <script type="text/javascript">
            function myTest(){
                let c = document.gettElementById('myC');
                let ctx = c.getContext('2d');
                let txt = '嚯嚯嚯嚯嚯';
                
                // 指定字体格式：斜体 35px  黑体
                ctx.font = 'italic 35px 黑体';
                
                // fill:实心字体
                ctx.fillStyle = '#F00';
                // 内容:嚯嚯嚯嚯。从(30,60)这个位置写
                ctx.fillText(txt,30,60);
                
                //居中对齐。也就是下面的(30,110)这个点是整个文本的最中间的点。默认是从左对齐(left)。
                // 可选项：right,center,start,end
                // 如果文本是从左到右：start是左，end是右
                // 如果文本是从右往左：start是右，end是左
                ctx.textAlign = 'center';
                
                // top是指下面的(30,110)这个坐标线放在了文本的顶部。
                // 缺省值：alphabetic
                // 可选项：top,middle,bottom
                ctx.textBaseline = 'top';
                
                // Stroke:空心字体
                ctx.strokeStyle = '#0F0';
                
                // 获取这个文本的宽度的三分之一(px)
                let width = ctx.measureText(txt).width/3;
                console.log(width);
                
                // 这里会挪动 200-width
                // 这里可以通过计算进行任意挪动
                ctx.strokeText(txt, 200 - width, 110);
                
            }
            window.onload = function(){
                myTest();
            }
        </script>
    </head>
    <body>
        <canvas id="myC" style="border: 1px #000 solid" width="800" height="450">
            <!--下面这句话放在canvas里面，可以用来判断canvas后面的属性是否用显示，并给出提示 -->
        	你的浏览器不支持canvas元素！
        </canvas>
    </body>
</html>
```



# 第五章

## 一、Cookie vs Web Storage

### （一）Cookie

#### 1. 什么是Cookie？

用来区别不同的浏览器、客户端的一个logo。





#### 2. Cookie的优点？

-  能够唯一的标定一台机器，去检查一台机器是否有Cookie，如果没有，就加进去一个Cookie。



#### 3. Cookie的缺点？

- 存储空间不足
- 安全性不够
- 等等



# 第六章



# 第七章

## 一、CSS盒模型

### （一）盒子模型小案例

- margin & padding
  - padding：盒边沿内部的延伸（内部）
  - margin：盒边沿外部的延伸（外部）
  - border：盒边
- 非块元素，部分无效

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            body {
                margin: 0;
                padding: 0;
            }
            
            .box {
                display: block;
                width: 150px;
                height: 50px;
                padding: 50px double #00F;
                border: 50px solid #F00;
                margin: 50px double #0F0;
            }
            
            .classicBox {
                width: 50px;
                height: 50px;
                background: #000;
            }
        </style>
    </head>
    <body>
        <!--span是行内元素 -->
        <span class="box">盒子内部的内容</span>
        <div class="classicBox"></div>
    </body>
</html>

```

**盒子模型：**

<img src="F:\桌面\HTML5+CSS3\盒子模型.png" alt="盒子模型" style="zoom:80%;" />



### （二）外边距  margin

- 内联元素的外边距
- 块元素的外边距
- 浮动元素的外边距
- 绝对定位的外边距



#### 1. 外边距小案例

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            body {
                margin: 0;
                padding: 0;
            }
            
            .box {
                width: 200px;
                height: 50px;
                border: 1px solid #000;
                
                /*上右下左*/
                margin: 50px;
                /*上下，左右*/
                margin: 50px 100px;
                /*上，左右，下*/
                margin: 50px 100px 150px;
                /*上，右，下，左*/
                margin: 50px 50px 50px 50px;
                
                margin-top: 50px;/*上*/
                margin-right: 50px; /*右*/
                margin-bottom: 50px;/*下*/
                margin-left: 50px;/*左*/
                
                /*padding，border类似*/
            }
        </style>
    </head>
    <body>
       <div class="box">外边距的定义方法</div>
    </body>
</html>

```



#### 2. 内联元素的外边距

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            body {
                margin: 0;
                padding: 0;
                font-size: 15px;
            }
            
            .boxN {
                width: 400px;
                height: 20px;
                border: 10px solid #F00;
                
            }
            
            .box {
                margin: 50px;
                border: 20px solid #F00;
            }
        </style>
    </head>
    <body>
       <div class="boxN">上边的元素</div>
       <div>左部文本<span class="box">内联元素的文本</span>有部文本</div>
       <div class="boxN">下边的元素</div>
    </body>
</html>

```

​        **对一个行内元素使用 `margin` 的时候，上下不太管用，但是左右管用。（IE6的兼容性问题，与其他浏览器的显示会有出入）**



#### 3. 块元素、浮动元素、绝对元素的外边距

- **块元素**：

  - 在行内元素的代码中，`.box` 里面加一个 `display:block;` 。
  - 这个时候 `margin` 的上下左右都有用，而且因为是块元素，所以与其他的也不在一行了。

- **浮动元素**：

  - 在行内元素的代码中， `.box` 里面加一个 `float:left;` 和 `diplay:block`。
  - 这个时候 `margin` 的上下左右都有用。
  - 当变成浮动后，他就相当于被抽出来，也就不属于文本流里面，然后他会根据代码里面浮动的设置进行浮动，能浮动多远就多远。
  - 浮动元素在IE6中，在浮动的时候会把自己位置上的其他元素挤开，以保证自己浮动到自己需要的那个方向的那个位置。

- **绝对定位元素：**

  - 在行内元素的代码中加如下代码:

    - ```css
      .box {
          /*absolute:绝对*/
          position: absolute;
          top: 50px;
          left: 50px;
      }
      ```

  - 对于绝对定位元素，一般不用 `margin` 来操作，而是用 `top` 和 `left`。



### （三）内边距  padding

- 外边距会产生交叠，内边距不会，没有边框时可以使用内边距来代替外边距
- 内边距的部分可以由背景图像修饰
- 内边距可以影响边框的大小

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
        <style type="text/css">
            div {
                width: 500px;
                height: 50px;
            }
            
            .box1 {
                margin-bottom: 70px;
                /*border: 1px solid #000;*/
                background-color: #F00;
            }
            
            .box2 {
                /*margin-top: 50px;  这里区域会重叠*/
                padding-top: 50px;  /*改用padding就解决了重叠问题*/
                /*border: 1px solid #000;*/
                background-color: #0F0;/*这个颜色作用于盒子内部，也就是padding也会被染色，margin不会*/
            }
        </style>
    </head>
    <body>
        <div class="box1">
            BOX1
        </div>
        <div class="box2">
            BOX2
        </div>
    </body>
</html>
```



### （四）边框

- 样式
- 颜色
- 宽度

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title> 
        <style type="text/css">
            .box {
                border-style: solid;
                border-width: 100px;
                /*上，左右，下*/
                /*border-color: #F00 #00F #0F0;*/
                /*下面四行和上面一行等价。*/
                border-bottom-color: #0F0;
                border-top-color: #F00;
                border-left-color:#00F;
                border-right-color:#00F;
                line-height: 0;
            }
        </style>
    </head>
    <body>
        <div class="box">
            
        </div>
    </body>
</html>
```



#### （五）宽和高

- 元素宽度和高度  ——  width、height
- 元素的实际高度和宽度  ——  本身的width + 2 \* padding + 2 \* border；height类似。
- 总宽度和总高度  ——  本身的width + 2 \* padding + 2 \* border + 2 \* margin；height类似。
- IE5.5以及以下版本中的宽度和高度指的是实际的宽度和高度。



## 二、网页布局的一般问题

### （一）一般问题

- 样式重用  —— 想到抽象类
- 浮动：易引起兼容性问题
- 定位：自适应差
- 过度使用id，尽量使用class，因为id的重用性很差
- 类和id使用 "数字+字母" 方式命名，难以理解
- 合理使用CSS



### （二）布局的三种基本形式

- 自然布局
  - 根据标签排列顺序。
- 浮动布局
  - 根据显示属性和标签顺序排列。
- 定位布局
  - 根据显示属性，使用类似模拟图像的方式排列。



## 三、浮动

- left
- right
- none



### （一）基础小案例

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
        <style type="text/css">
            body, div {
                margin: 0;
                padding: 0;
                font-size: 32px;
                font-weight: bold;
            }
            
            div {
                color: white;
                text-align: center;
                /*line-height:指的是写的那个字的高度，但注意不是字的大小的高度*/
                line-height: 100px;
                /*向左浮动*/
                /*可以让所有的块状元素排一行，排的顺序，按照写的div顺序排*/
                /*float: left;*/
                width: 150px;
                height: 300px;
            }
            
            #box1 {
                /*当给这个浮动后，这个就和其他的脱离了，其他的按照自己的块顺序排列，这个浮动的就按照自己的浮动要求排*/
                float: left;
                background-color: red;
                margin: 20px;
            }
            
            #box2 {
                /*同box1*/
                float: left;
                background-color: green;
            }
            
            #box3 {
                background-color: blue;
            }
        </style>
    </head>
    <body>
        <div id="box1">BOX 1</div>
        <div id="box2">BOX 2</div>
        <div id="box3">BOX 3</div>
    </body>
</html>
```



### （二）实现312——小案例

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title></title>
        <style type="text/css">
            body, div {
                margin: 0;
                padding: 0;
                font-size: 32px;
                font-weight: bold;
            }
            
            div {
                color: white;
                text-align: center;
                /*line-height:指的是写的那个字的高度，但注意不是字的大小的高度*/
                line-height: 100px;
                /*向左浮动*/
                /*可以让所有的块状元素排一行，排的顺序，按照写的div顺序排*/
                /*float: left;*/
                width: 150px;
                height: 300px;
            }
            
            #box1 {
                /*左浮动*/
                float: left;
                /*右移150px*/
                margin-left: 150px;
                /*在左移的上面，做一个inline，解决IE6上排版的问题*/
                display: inline;
                background-color: red;
                margin: 20px;
            }
            
            #box2 {
                /*右浮动*/
                float: right;
                background-color: green;
            }
            
            #box3 {
                /*左浮动*/
                float: left;
                /*左移300px*/
                margin-right:300px;
                background-color: blue;
            }
        </style>
    </head>
    <body>
        <div id="box1">BOX 1</div>
        <div id="box2">BOX 2</div>
        <div id="box3">BOX 3</div>
    </body>
</html>
```



### （三）浮动元素的大小 —— 塌缩

- 一个元素被设定位浮动，会引起元素自身体积的塌缩。
  - 对一个浮动元素设定宽度和高度，会引起塌缩。
  - 一个元素里面有内容，但是没有设置浮动、定位，这时候会引起塌缩，缩到刚好包到内容。
  - 一个元素里面没内容，没有设置浮动、定位，会塌缩到一个点。

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            body,div {
                margin: 0;
                padding: 0;
            }
            
            div {
                /*左浮动*/
                float: left;
                margin: 6px;
                border: 1px solid #F00;
            }
            
            /*1. 设置宽高*/
            #box1 {
                width: 100px;
                height: 100px;
            }
            
            /*2. 设置字体，字体撑起来*/
            # box2 {
                line-height: 30px;
                font-size: 30px;
            }
            
            #box3 {
                line-height: 100px;
                font-size: 30px;
            }
            
            /*box5  box6 没有设置，所以在网页上是两个点（这个点的形式在div的border中设置的那样）*/
        </style>
    </head>
    <body>
        <div id="box1">box1</div>
        <div id="box2">box2</div>
        <div id="box3">box3</div>
        <div id="box4"><img src="xxx.png" /></div>
        <div id="box5">box5</div>
        <div id="box6">box6</div>
    </body>
</html>
```



### （四）浮动元素的位置

- 如果有父元素，他会一直浮动到父元素边界。
- 如果没有父元素，但是有相邻元素，则浮动到相邻元素的边界。
- 如果都没有，则浮动到整个网页界面的边界。

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            body {
                margin: 0;
                padding: 0;
            }
            
            p {
                border: 2px solid #FF33FF;
            }
            
            #s1 {
                float: left;
                background-color: #FFAAFF;
            }
            
            #s2 {
                float: right;
                background-color: #FF33FF;
            }
        </style>
    </head>
    <body>
		<p>
            Who are you?
			Why are you at here?
            what do you do?
            <span id="s2">
            	how do you about it?
            </span>
            when do you go to XXX?
            <span id="s1">
            	when do you go to XXX?
            </span>
            where are you going to go?
            whom you just mentioned?
        </p>
    </body>
</html>
```



### （五）环绕和清除浮动

##### 1. 环绕

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            body {
                margin: 0;
                padding: 0;
            }
            
            p {
                border: 2px solid #FF33FF;
            }
            
            #s1 {
                float: left;
                background-color: #FFAAFF;
            }
            
            #s2 {
                float: right;
                background-color: #FF33FF;
            }
            
            img {
                /*图片周围文本的环绕*/
                display: block;
                margin: 20px;
            }
            
        </style>
    </head>
    <body>
		<p>
            Who are you?
			Why are you at here?
            what do you do?
            <span id="s2">
            	how do you about it?
            </span>
            when do you go to XXX?
            <img src="XXX.png"/>
            <span id="s1">
            	when do you go to XXX?
            </span>
            where are you going to go?
            whom you just mentioned?
        </p>
    </body>
</html>
```



##### 2. 清除浮动

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            body, div {
                margin: 0;
                padding: 0;
            }
            
            /*div {
				border: 1px solid #F00;
                height: 50px;
            }*/
            
            #header {
                width: 100%;
            }
            
            #header, #left, #middle, #right, #footer {
                /*width: 100%;*/
                border: 1px solid #F00;
                height: 50px;
            }
            
            #left, #middle, #right {
                float: left;
                width: 33.%;
            }
            
            #left {
                height: 100px;
            }
            
            #footer {
                border-color: #000;  
            }
            
            .clear {
                clear: both;
            }
            
        </style>
    </head>
    <body>
		<div id="header">Header</div>
		<div id="left">Left</div>
		<div id="middle">Middle</div>
		<div id="right">Right</div>
        <div class="clear"></div>
		<div id="footer">Footer</div>
    </body>
</html>
```



# 第八章

## 一、IE6因为float水平错位问题

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            body, div {
                margin: 0;
                padding: 0;
            }
            
            div {
                margin-left: 50px;
                width: 200px;
                height: 100px;
                border: solid 1px #F00;
            }
            
            #box2 {
                float: left;
                /*为了兼容IE6，在浮动出现水平错位时，用display:inline; 解决水平错位。*/
                display: inline;
            }
        </style>
    </head>
    <body>
		<div id="box1">基准</div>
		<div id="box2">浮动</div>
    </body>
</html>
```



## 二、定位 —— position

- **静态定位**：什么都不写， **`缺省就是静态定位`** ，静态还在文档流里面。
- **绝对定位**： **`从文档流中拿出来。`** 
- **相对定位**：不破坏整个文档流的结构，**`从原来的位置挪出来，但是对于原来的那个div来说，他的位置还给他留着。`**也就是进行文档覆盖的同时，也不影响原来的文档流。
- **固定定位**：从文档流中出来。**`永远相对于body的左上角来定义自己的位置`**，就算滚动滚动条，他还是在那个位置，不管怎么滚动都看得见。



### （一）静态定位、绝对定位

```html
<!DOCTYPE html>
<html>
    <!--绝对定位小案例 -->
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            /*对外边距内边距进行初始化，让所有浏览器在初始化相同，达到简介兼容*/
            body, div, h1, h2 {
                margin: 0;
                padding: 0;
            }
            
            #container {
				border: 1px solid #F00;
            }
            
            #container h2 {
                /*绝对定位*/
                /*脱离文档流后，就脱离了container的框，container的框就变小了，它也就出来了*/
				position: absolute;
                /*下面这个10*px是基于body的左上角为准*/
                left: 100px;
                top: 100px;
                border: solid 1px #000;
            }
        </style>
    </head>
    <body>
		<div id="containter">
        	<h1>
                ABCDE——块元素
            </h1>
            <h2>
                12345——h是块元素
            </h2>
        </div>
    </body>
</html>
```



### （二）相对定位、固定定位

```html
<!DOCTYPE html>
<html>
    <!--相对定位小案例 -->
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            /*对外边距内边距进行初始化，让所有浏览器在初始化相同，达到简介兼容*/
            body, div, h1, h2 {
                margin: 0;
                padding: 0;
            }
            
            #container {
				border: 1px solid #F00;
            }
            
            #container h2 {
                /*相对定位*/
                /*在进行偏移后，他虽然出了container的框，但是container的里面的位置还给他留着，他没有脱离文档流。*/
                /*也就是没有脱离文档流，但是允许暂时的出来。*/
				position: relative;
                /*下面这个10*px是基于body的左上角为准*/
                left: 0px;
                top: 0px;
                border: solid 1px #000;
            }
        </style>
    </head>
    <body>
		<div id="containter">
        	<h1>
                ABCDE——块元素
            </h1>
            <h2>
                12345——h是块元素
            </h2>
        </div>
    </body>
</html>
```

- 固定定位应为场景：在滚动页面的同时，又需要某个控件或者某一部分不能消失，并且还是在那个位置看得见，这时候就用固定定位。



### （三）包含块

**包含块：**

- 父节点，向上回溯，第一个有有定位的。
- 如果都没有，则回溯到body窗口进行定位。
- **一种垂直居中的方法。**



#### 1. 包含块小案例

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            /*对外边距内边距进行初始化，让所有浏览器在初始化相同，达到简介兼容*/
            body, div, h1, h2 {
                margin: 0;
                padding: 0;
            }
            
            /*临时加一个body来判断一下绝对定位是根据什么来定位的*/
            body {
                margin: 25px;
                padding: 25px;
                /*给body加了绝对定位后，就要把外边距和边框都加上后的新零零点定位，内边距不算*/
                position: absolute;
            }
            
            #container {
				border: 1px solid #F00;
                /*在这里加一个相对定位，里面的子元素定位就会再次基于父元素container进行定位，外面的border要加上成为新的零零点。*/
                position:relative;
            }
            
            #container h2 {
				position: absolute;
                left: 100px;
                top: 100px;
                border: solid 1px #000;
            }
        </style>
    </head>
    <body>
		<div id="containter">
        	<h1>
                ABCDE——块元素
            </h1>
            <h2>
                12345——h是块元素
            </h2>
        </div>
    </body>
</html>
```



#### 2. 利用包含块实现垂直居中

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            /*对外边距内边距进行初始化，让所有浏览器在初始化相同，达到简介兼容*/
            body, div {
                margin: 0;
                padding: 0;
            }

            body {
                border: 1px solid #000;
				width: 800px;
                height: 800px;
            }
            
            /*#box {
                position: absolute;
                background-color: #000;
                width: 100px;
                height: 100px;
                left: (800-100)/2 px;
                top: (800-100)/2 px;
            }*/
            
            #wrap {
                border: 1px solid #000;
                /*以绝对定位，和50%，保证wrap在正中*/
                /*和box一样大小*/
                position: absolute;
                width: 100px;
                height: 100px;
                left: 50%;
                top: 50%;
            }
            
            #box {
                background-color: #000;
                width: 100px;
                height: 100px;
                /*在大小和warp一样的情况下，absolute和relative都可以*/
                /*wrap没有设置相同的大小前，这里用relative只有左实现了，上没用*/
                position: relative;
                left: -50%;
                top: -50%;
            }
        </style>
    </head>
    <body>
        <div id="wrap"></div>
        <div id="box"></div>
    </body>
</html>
```



### （四）坐标值

- top
- left
- right
- bottom
- absolute： **`从定位元素外壁`**  到  **`包含块元素顶部内壁`** 的距离。
- relative：从 **`从定位元素外壁`** 到  **`原始位置外壁`**  的距离。

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            /*对外边距内边距进行初始化，让所有浏览器在初始化相同，达到简介兼容*/
            body, div {
                margin: 0;
                padding: 0;
            }
            
            #wrap {
                position: relative;
                border: 20px solid red
                padding: 400x;
                width: 60px;
                height: 60px;
            }
            
            #box {
                /*绝对定位*/
                /*position: absolute;*/
                /*相对定位*/
                position: relative;
                border: solid 10ox black;
                margin: 30px;
                width: 50px;
                height: 50px;
                left: 100px;
                top: 100px;
            }
            
            span {
                position: relative;
                left: 100px;
                top: 90px;
            }
        </style>
    </head>
    <body>
        <div id="wrap">
            awhkjenq,dnsqkhe
            <span>ankwhekqhwe</span>
            anshekjqwndq
        	<div id="box"></div>
        </div>
    </body>
</html>
```



### （五）定位层叠 —— z-index

- 一般来说，定位元素的 z-index 会高于文档流
- 通过将 z-index 设定成负值可以使定位元素位于文档流的下方。

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            /*对外边距内边距进行初始化，让所有浏览器在初始化相同，达到简介兼容*/
            body, div {
                margin: 0;
                padding: 0;
            }
            
            #box1, #box2, #box3 {
                width: 200px;
                height: 100px;
                position: absolute;
                color: #FFF;
            }
            
            #box1 {
                background-color: red;
                left: 100px;
                z-index: 3;
            }
            
            #box2 {
                background-color: green;
                top: 50px;
                left: 50px;
                z-index: 2;
            }
            
            #box3 {
                background-color: blue;
                top: 100px;
                z-index: 1;
            }
            
            /*缺省的z-index*/
            #box 4{
                background-color: pink;
            }
            
            #box 5{
                background-color: gray;
                z-index: -1;
            }
        </style>
    </head>
    <body>
        <div id="box1">BOX 1</div>
        <div id="box2">BOX 2</div>
        <div id="box3">BOX 3</div>
        <div id="box4">BOX 4</div>
        <div id="box5">BOX 5</div>
    </body>
</html>
```

- 对于 z-index ，值越大，越在上面，以文档流为0为分界，如果是负数，就在文档流下面，间接保护起来。



### （六）select控件的bug

- 在其他浏览器中，select的下拉列表会被div盖住。（上面的div控件会盖住下面的select控件）
- IE6盖不住（IE6会自己重新画控件，然后就会盖不住）。

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            /*对外边距内边距进行初始化，让所有浏览器在初始化相同，达到简介兼容*/
            body, div {
                margin: 0;
                padding: 0;
            }
            div {
                height: 100px;
                width: 200px;
                color: #FFF;
                background-color: red;
                position: absolute;
            }
        </style>
    </head>
    <body>
        <div id="red box">Red Box</div>
        <!-- select 是一个下拉列表 -->
        <select>
            <option value="1"></option>
            <option value="2"></option>
            <option value="3"></option>
        </select>
    </body>
</html>
```

**解决方案：**自己重新用div写一个select控件。



### （七）嵌套层叠、层叠包含框和兼容IE和非IE的嵌套层叠问题

**层叠包含框：**

- 层叠包含框必须是定位元素
- z-index不能是auto
- 同一层叠根元素内的所有定位元素，使用z-index比较
- 不同层叠根元素的定位元素，需要寻找到相同的层叠祖先元素，比较层叠祖先元素下的z-index值。

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            /*对外边距内边距进行初始化，让所有浏览器在初始化相同，达到简介兼容*/
            body, div {
                margin: 0;
                padding: 0;
            }
            
            #warp, #header {
                position: relative;
            }
            
            /*这时候warp就是层叠包含框，它是header和logo的根*/
            #wrap {
                z-index: 0;
            }
            
            /*header是logo的祖先元素*/
            /*这时候logo是进行的同一祖先下比较，不会和main比较。*/
            /*IE6的logo就上来了*/
            #header {
                z-index: 2;
            }
            
            #logo {
                display: block;
                position: absolute;
                left: 20px;
                top: 20px;
                z-index: 2;
            }
            
            #main {
                position: absolute;
                width: 100%;
                height: 400px;
                background: #6699FF;
                top: 40px;
                text-align: center;
                z-index: 1;
            }
        </style>
    </head>
    <body>
		<div id="warp">
        	<div id="header">
            	<img id="logo" src="XXX.png" />
            </div>
        	<div id="main">Main</div>
        </div>
    </body>
</html>
```



### （八）禅意花园





# 第九章

## 一、文字

- **字体类型  font-family**：最好找各个浏览器都有的字体，防止出现乱码。可以放一系列会用到的字体。
- **字体大小  font-size**：
  - small， medium，large ...
  - 20px
  - 0.8em （1em = 20px）
  - 0.6in
  - %
  - 原则：固定布局，用px；不固定布局，用%或者em
- **字体颜色  color**：
  - 颜色名：red，green，black，pink，gray ...
  - #XXXXXX 或者 #XXX    （六位比三位的颜色更丰富）
  - rgb(DDD , DDD , DDD)  （D表示十进制）
  - rgb(DD% , DD% , DD%)  （这里最终颜色是255*DD%）
- **字体粗细  font-weight**：
  - normal，bold(700)，bolder(900)，lighter
  - 100~900 （越大越粗）
- **字体倾斜   font-style**：
  - normal，italic(在浏览器里找斜体)，oblique(浏览器推斜)。
- **字体修饰   text-decoration**：
  - none
  - underline 下划线
  - overline 划顶线
  - line-through 删除线
  - 可以同时设置多个decoration
- **字体对齐方式   text-align**：
  - left，right，center
- **字体的字间距(letter-spacing)、词间距(word-spacing)、行间距(line-height)**：
  - em
  - %
  - px
- **字体缩进   text-indent**：
  - em
  - %
  - px
  - 可以是负值

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            /*对外边距内边距进行初始化，让所有浏览器在初始化相同，达到简介兼容*/
            body, div {
                margin: 0;
                padding: 0;
            }
            
            #p1 {
                /*字体类型*/
                font-family: "微软雅黑", arial, sans-serif, serif;
                /*字体大小*/
                font-size: 40px;
                font-size; 1.2em;
                font-size: 120%;
                /*字体颜色*/
                color: red;
                color: #FF7000;
                color: #F03;
                color: rgb(50%,50%,50%);
                color: rgb(230,230,230);
                /*字体粗细*/
                font-weight: 900;
                font-weight: bolder;
                /*字体倾斜*/
                font-style: italic;
                /*字体修饰*/
                text-decoration: line-through underline overline;
                /*字体对齐方式*/
                text-align: center;
                text-align: left;
                text-align: right;
                
            }
            
            #p1 {
                /*字体间距*/
                /*字间距*/
                letter-spacing: 2em;
                /*词间距*/
                word-spacing: 2em;
                /*行间距*/
                line-height: 2em;
                
                /*字体缩进*/
                text-indent: -2em;
                text-indent: 20%;
                text-indent: 30px;
            }
            
            a {
                /*去掉a链接自带的下划线*/
                text-decoration: none;
            }
        </style>
    </head>
    <body>
		<p id="p1">
            1321564
            ABCD
            万门大学
        </p>
        <p id="p2">
            asdqjwledklansldkawjeljqweljqwndqlkwdnsmndqlwejasdqjwledklansldkawjeljqweljqwndqlkwdnsmndqlwejasdqjwledklansldkawjeljqweljqwndqlkwdnsmndqlwejasdqjwledklansldkawjeljqweljqwndqlkwdnsmndqlwejasdqjwledklansldkawjeljqweljqwndqlkwdnsmndqlwejasdqjwledklansldkawjeljqweljqwndqlkwdnsmndqlwejasdqjwledklansldkawjeljqweljqwndqlkwdnsmndqlwejasdqjwledklansldkawjeljqweljqwndqlkwdnsmndqlwej
        </p>
        <a href="#">AAAAA</a>
    </body>
</html>
```



## 二、图片

- **图片边框  border**
  - border-style
    - solid，dotted，dashed
  - border-color
  - border-width
  - 可以为每条边设定。
- **图片大小**
  - width
  - height
  - 一般只设定宽度或者高度，这时候会根据设定的宽度或者高度进行等比例拉伸
  - 同时设定，如果长宽比不一致，会被拉伸
- **图片对齐方式**
  - 横向对齐   text-align：
    - right，left，center
  - 纵向对齐   vertical-align：
    - baseline，sub，super，top，middle，bottom

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            /*对外边距内边距进行初始化，让所有浏览器在初始化相同，达到简介兼容*/
            body, div {
                margin: 0;
                padding: 0;
            }
            
            p {
                border: 2px solid red;
                /*想让一个图片设定对齐方式，需要在父元素中进行设定*/
                /*横向对齐*/
                text-align: center;
            }
            
            img {
                /*图片的边框*/
                border-style: dashed;
                border-width: 2px;
                /*上下红色，左右绿色*/
                /*这个border也遵循上右下左*/
                border-color: red green;
                /*上面三行等价于*/
                border: dashed 2px red green;
                
                /*图片大小*/
                width: 400px;
                width: 30%; /*这个因为父元素是p，所以指的是整个body的30%宽度*/
            }
        </style>
    </head>
    <body>
        <!--对齐方式也可以在这里通过style直接设置 -->
        <p>
	        baseline<img style="vertical-align: baseilne" src="XXX.png" />            
        </p>
        <p>
	        sub<img style="vertical-align: sub" src="XXX.png" />            
        </p>
        <p>
	        super<img style="vertical-align: super" src="XXX.png" />            
        </p>
        <p>
	        top<img style="vertical-align: top" src="XXX.png" />            
        </p>
        <p>
	        middle<img style="vertical-align: middle" src="XXX.png" />            
        </p>
        <p>
	        bottom<img style="vertical-align: bottom" src="XXX.png" />            
        </p>
    </body>
</html>
```



## 三、文字环绕图片

- **环绕  使用浮动**：
  - float:left
- **背景颜色**
  - background-color：
  - body，div
- **背景图片**
  - background-image:
    - url(XXX.png);
  - background-repeat：
    - repeat-x，repeat-y，no-repeat
  - body，div

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            /*对外边距内边距进行初始化，让所有浏览器在初始化相同，达到简介兼容*/
            body, div {
                margin: 0;
                padding: 0;
                /*背景颜色*/
                /*background-color: #0F0;*/
                
                /*背景图片*/
                background-image: url(XXX.png);
                background-repeat: repeat;
            }
            
            p {
				color: red;
                font-size: 20px;
                font-weight: bold;
            }
            
            img {
				float: left;
            }
            
            li {
                /*在*/
                /*list-style-type: disc;*/
                list-style-image: url(XXX.png);
            }
            
        </style>
    </head>
    <body>
        <p>
            asdqjwledklansldkawjeljqweljqwndqlkwdnsmndqlwejasdqjwledklansldkawjeljqweljqwndqlkwdnsmndqlwejasdqjwledklansldkawjeljqwelj
            <img src="XXX.png"/>
qwndqlkwdnsmndqlwejasdqjwledklansldkawjeljqweljqwndqlkwdnsmndqlwejasdqjwledklansldkawjeljqweljqwndqlkwdnsmndqlwejasdqjwledklansldkawjeljqweljqwndqlkwdnsmndqlwejasdqjwledklansldkawjeljqweljqwndqlkwdnsmndqlwejasdqjwledklansldkawjeljqweljqwndqlkwdnsmndqlwej
        </p>
        <ul>
            <li>111</li>
            <li>222</li>
            <li>333</li>
        </ul>
    </body>
</html>
```



## 四、列表项符号和列表项图片符号

- **列表项符号**：
  - list-style-type：
    - decimal，square，disc
- **列表项图片符号**：
  - list-style-type：
    - url(XXX.png)

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            /*对外边距内边距进行初始化，让所有浏览器在初始化相同，达到简介兼容*/
            body, div {
                margin: 0;
                padding: 0;
            }
            
            li {
                /*在每行列表前面放一个小黑圈*/
                /*list-style-type: disc;*/
                
                /*在每行列表前面放一个图片*/
                list-style-image: url(XXX.png);
            }
            
        </style>
    </head>
    <body>
        <ul>
            <li>111</li>
            <li>222</li>
            <li>333</li>
        </ul>
    </body>
</html>
```



## 五、CCS3新加属性

### （一）文字阴影 —— text-shadow

- 简单阴影
- 模糊音影
- 多色阴影



#### 1. 阴影小案例

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            /*对外边距内边距进行初始化，让所有浏览器在初始化相同，达到简介兼容*/
            body, div {
                margin: 0;
                padding: 0;
            }
            
            p {
                text-align: center;
                font: bold 130px "微软雅黑";
                color: #999;
                
                /*1. 简单阴影*/
                /*x方向偏移 y方向偏移 颜色*/
                /*可以给人一种立体感*/
                /*text-shadow: -0.1em 0.1em #333;*/
                /*2. 模糊阴影*/
                /*x方向偏移、y方向偏移、模糊的半径大小、颜色*/
                /*text-shadow: 0.1em 0.1em 0.2em #333*/
                
                /*多色阴影*/
                /*写多行的时候，就相当于有多个阴影*/
                text-shadow: 0.1em 0.1em 0.2em #333,0.1em 0.1em 0.2em #333;
            }
        </style>
    </head>
    <body>
        <p>
            HTML5+CSS3
        </p>
    </body>
</html>
```



#### 2. 火焰字

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            /*对外边距内边距进行初始化，让所有浏览器在初始化相同，达到简介兼容*/
            body, div {
                margin: 0;
                padding: 0;
                background: #000;
            }
            
            p {
                text-align: center;
                font: bold 130px "微软雅黑";
                color: #F00;
                text-shadow: 0 0 4px white,
                    		 0 -5px 4px #FF3,
                    		 2px -10px 6px #FD3,
                     		 -2px -15px 11px #F80,
                    		 2px -25px 18px #F20;
            }
        </style>
    </head>
    <body>
        <p>
            HTML5+CSS3
        </p>
    </body>
</html>
```



### （二）文字溢出 —— text-overflow

- clip：直接截取。
- ellipsis： 只保留给定的长度，后面超出长度的部分会截取，然后用省略号代替。
- ellipsis-word：截取整词。

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            body {
                margin: 0;
                padding: 0;
            }
            
            .ellipsis {
                width: 100px;
                font-size: 20px;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
            }
        </style>
    </head>
    <body>
        <p>
            ABCD
            12345631
        </p>
        <p class="ellipsis">
            阿斯顿红旗街坑我呢期望呢阿斯顿两千万呢
            阿斯顿红旗街坑我呢期望呢阿斯顿两千万呢
            阿斯顿红旗街坑我呢期望呢阿斯顿两千万呢阿斯顿红旗街坑我呢期望呢阿斯顿两千万呢阿斯顿红旗街坑我呢期望呢阿斯顿两千万呢阿斯顿红旗街坑我呢期望呢阿斯顿两千万呢
        </p>
    </body>
</html>
```



### （三）RGBA、HSL、HSLA、opacity属性

- 颜色是UI的工作，不管朕的事。



## 六、形变 —— transform

- 用于内联或者块元素，可以旋转、缩放、移动元素
- -Transform：-transform 本身
- Webkit：-webkit-transform
- Gecko：-moz-transform
- Presto：-o-transform
- IE暂不支持



### （一）transform小案例

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            body {
                margin: 0;
                padding: 0;
            }
            
            div{
                margin: 100px;
                width: 200px;
                height: 100px;
                background-image: url(XXX.png);
                /*给翻转一个过程，不让看着那么突兀*/
                /*2s时间的一个动画过程*/
                /*transform结束后，他会用2s旋转回来*/
                -webkit-transition: -webkit-transform 2s ease-in;
            }
            
            div:hover {
                /*翻转180度*/
                -weibkit-transform: rotate(180deg);
            }
        </style>
    </head>
    <body>
        <div>
            
        </div>
    </body>
</html>
```



### （二）旋转、平移、缩放、倾斜

- rotate()：旋转
- scale()：平移
- translate()： 缩放
- skew()：倾斜

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            body {
                margin: 0;
                padding: 0;
            }
            
            div{
                margin: 100px;
                width: 200px;
                height: 100px;
                background-image: url(XXX.png);
                /*在div:hover写了相应的transform变换后，这里也要设定相应的变化时间等等，让看起来不突兀*/
				-webkit-transition: -webkit-transform 2s ease-in;
                -o-transition: -webkit-transform 2s ease-in;
                -moz-transition: -webkit-transform 2s ease-in;
                -transition: -webkit-transform 2s ease-in;
            }
            
            div:hover {
                /*-webkit-transform: rotate(180deg);  旋转*/
                /*-webkit-transform: scale(2,0.5); 缩放*/
                /*-webkit-transform: tranlate(200px,100px);  平移*/
                /*-webkit-tranform: skew(15deg,15deg);  倾斜*/
                
                /*上面的几个动作还可以放一起运动*/
                -webkit-transform: skew(15deg,15deg) scale(2,0.5);
                
                /*为了支持各个浏览器，需要写下所需的transform*/
                -o-transform: skew(15deg,15deg) scale(2,0.5);
                -moz-transform: skew(15deg,15deg) scale(2,0.5);
                -transform: skew(15deg,15deg) scale(2,0.5);
            }
        </style>
    </head>
    <body>
        <div></div>
    </body>
</html>
```



### （三）定义复杂图形 ——  -transition

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title></title>
        <style type="text/css">
            body {
                margin: 0;
                padding: 0;
            }
            
            div {
                background-color: red;
                width: 30%;
                height: 80px;
                color: #FFF;
                font-size: 60px;
                /*-transition 这里可以定义各种属性空间的变化，变化时长，怎么变*/
                -webkit-transition: background-color 1s linear, color 1s linear, width 1s linear;
                -moz-transition: background-color 1s linear, color 1s linear, width 1s linear;
                -o-transition: background-color 1s linear, color 1s linear, width 1s linear;
                -transition: background-color 1s linear, color 1s linear, width 1s linear;
            }
            
            div:hover {
                background-color: #F00336;
                color: #0F0;
                width: 100%;
            }
        </style>
    </head>
    <body>
        <div>12346</div>
    </body>
</html>
```

