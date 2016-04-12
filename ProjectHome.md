RIF(Remote Invoke Framework)是一个Java实现的服务调用框架。<br />
支持将POJO、Spring快速发布为远程服务，而无需修改原有系统的任何代码。<br />
允许用户通过扩展的方式实现协议、服务实现、序列化的扩展开发能力。<br />
```
一：RIF(Remote Invoke Framework)
        RIF是一个Java实现的远程服务调用框架。
        支持将POJO、Spring快速发布为远程服务，而无需修改原有系统的任何代码。
        允许用户通过扩展的方式实现协议、服务实现、序列化的扩展开发能力。

二：运行环境
        jdk1.6
        第三方jar包：
        Server端：
                xstream-1.2.2.jar
        Client端：
                xstream-1.2.2.jar
                asm-1.5.3.jar
                asm-attrs-1.5.3.jar
                cglib-2.1.3.jar

三：功能List
1、服务实现支持POJO;
2、支持xml、json两种序列化方式;
3、通讯协议支持http;
4、扩展性
        为了保证框架的稳定性，目前版本支持如下的扩展开发。
        a)支持服务实现的扩展开发
        b)支持扩展方式添加序列化方式
        c)支持其它类型协议的扩展开发

```
