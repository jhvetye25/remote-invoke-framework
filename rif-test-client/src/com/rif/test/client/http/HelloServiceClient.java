/**
 *
 */
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
