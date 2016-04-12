
```
V0.1版本说明(2011.08)
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
3、通讯 协议支持http;
4、扩展性
	为了保证框架的稳定性，目前版本支持如下的扩展开发。
	a)支持服务实现的扩展开发
	b)支持扩展方式添加序列化方式
	c)支持其它类型协议的扩展开发

四：工程源码
	/rif-client		:客户端框架项目
	/rif-client-http	:客户端http协议的实现
	/rif-client-lib	:客户端依赖的第三方jar包
	/rif-server		:服务端框架项目
	/rif-server-http	:服务端http协议实现
	/rif-lib		:服务端依赖的第三方jar包
	/rif-common	:客户端、服务端统一依赖的基础项目
	/rif-test-client	:测试-客户端示例项目
	/rif-test-server	:测试-服务端示例项目

----------------------------------------------------------

V0.2版本计划(计划发布时间：2011.09)

一：计划实现的功能List
1、支持服务实现类型为Spring
2、增加支持java序列化
3、增加支持TCP通讯协议
4、增加拦截器机制
5、优化异常处理
6、服务添加版本控制
```