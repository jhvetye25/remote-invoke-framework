/**
 * 
 */
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
