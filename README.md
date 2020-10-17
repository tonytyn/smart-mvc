# smart-mvc
一个微型MVC框架,适合初学者了解java web项目的目录结构，运作流程等
作者TonyTyn  
<a href="https://996.icu"><img src="https://img.shields.io/badge/link-996.icu-red.svg" alt="996.icu" /></a>
# web.xml是什么啊
web.xml是web项目的配置文件，一般的web工程都会用到web.xml来配置，方便大型开发。web.xml主要用来配置Filter，Listener，Servlet等。但是web.xml并不是必须的，一个web工程可以没有web.xml文件

# web工程加载web.xml过程
web容器的加载顺序ServletContext -> context-param -> listener -> filter -> servlet。并且这些元素可以配置在文件中的任意位置，不会因为filter在web.xml文件中写在listener前面就先加载filter。

# 加载过程顺序如下

启动一个web项目，web容器会读取它的配置文件web.xml，读取<listener>和<context-param>两个结点。
创建一个ServletContext(Servlet上下文)，这个web项目的所有部分都将共享这个上下文
容器将<context-param>转换为键值对，并交给ServletContext
容器创建<listener>中的类实例，创建监听器
