/**
 * 
 */
package com.rif.common.response;

import com.rif.common.response.impl.ServiceResponseImpl;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 上午10:29:49
 */
public class ServiceResponseFactory {
	public static ServiceResponseFactory INSTANCE = new ServiceResponseFactory();
	private ServiceResponseFactory(){}
	
	public IServiceResponse create(){
		return new ServiceResponseImpl();
	}
}
