5分钟快速入门文档，将POJO快速发布为HTTP的远程服务。

# 一：服务端开发(POJO发布为http类型的服务) #

将POJO发布为远程服务。
本文提供快速入门的Hello服务。
## 1、定义接口 ##
```
package com.rif.helloservice;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-20 下午11:06:50
 */
public interface IHelloService {
	String sayHello(String name);
}
```
## 2、定义实现 ##
```
package com.rif.helloservice.impl;

import com.rif.helloservice.IHelloService;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-20 下午11:07:28
 */
public class HelloServiceImpl implements IHelloService {

	/* (non-Javadoc)
	 * @see com.rif.helloservice.IHelloService#sayHello(java.lang.String)
	 */
	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "Hello,"+name;
	}

}
```
## 3、发布为服务 ##
将上面定义的POJO类直接发布为远程服务，增加配置文件：rif-server.xml
```
<rif-server>
	<services>
			<service name="com.rif.helloservice.HelloServiceImpl" version="1.0.0" serializer="xml">
				<description>hello service</description>
				<transport-id>transportHello</transport-id>
				<implement.pojo class="com.rif.helloservice.impl.HelloServiceImpl" />
				<!--
				<implement.spring bean-id="helloserviceBean" />
				<implement.bpel process="MoneyTransferProcess" />
				-->
			</service>
	</services>	
</rif-server>
```

## 4、配置web.xml ##
http协议目前支持与web容器集成，需要配置web.xml文件。
```
<?xml version="1.0" encoding="ISO-8859-1"?>

<web-app xmlns="http://java.sun.com/xml/ns/javaee"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
   version="2.5"> 

    <description>
      demo.
    </description>
    <display-name>Servlet and JSP Examples</display-name>

			<context-param>
        <param-name>serviceLocation</param-name>
        <param-value>/WEB-INF/rif-server.xml</param-value>
			</context-param>
			<listener>
        <listener-class>com.rif.server.http.servlet.ServiceLoaderServletContextListener</listener-class>
			</listener>
			<servlet>
        <servlet-name>HttpServlet</servlet-name>
        <servlet-class>com.rif.server.http.servlet.HttpRIFServerServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>
			<servlet-mapping>
        <servlet-name>HttpServlet</servlet-name>
        <url-pattern>*.rif</url-pattern>
    	</servlet-mapping>

</web-app>
```

# 二：客户端开发 #

## 1、配置客户端文件rif-client.xml文件 ##
```
<rif-client>
	<transport-refs>
		<transport-ref id="transport1" type="http" serializer="xml">
			<url>http://127.0.0.1:8080/rif</url>
			<security></security>
		</transport-ref>
	</transport-refs>
	<service-refs>
			<service-ref id="helloserviceRef">
				<service-name>com.rif.helloservice.HelloServiceImpl</service-name>
				<service-version>1.0.0</service-version>
				<description>hello service</description>
				<transport-id>transport1</transport-id>
				<serializer>xml</serializer>
			</service-ref>
	</service-refs>	
</rif-client>
```

## 2、客户端代码 ##

```
package com.rif.test.client.http;

import com.rif.client.service.IServiceClient;
import com.rif.client.service.ServiceClientFactory;
import com.rif.helloservice.IHelloService;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-8-1 下午10:09:43
 */
public class HelloServiceClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServiceClientFactory factory = new ServiceClientFactory();

		factory.setConfigPaths(new String[]{HelloServiceClient.class.getResource("rif-client.xml").toString()});
		factory.init();
		IServiceClient client = factory.getServiceClient();
		IHelloService helloService = client.getService("helloserviceRef", IHelloService.class);
		String result = helloService.sayHello("rif");
		System.out.println(result);
	}

}

```

## 3、运行结果 ##

```
Hello,rif
```


so easy.开始使用RIF框架吧。