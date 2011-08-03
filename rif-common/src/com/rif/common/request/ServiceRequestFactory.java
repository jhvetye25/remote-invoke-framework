/**
 * 
 */
package com.rif.common.request;

import com.rif.common.request.impl.ServiceRequestImpl;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 上午10:27:48
 */
public class ServiceRequestFactory {
	public static ServiceRequestFactory INSTANCE = new ServiceRequestFactory();
	private ServiceRequestFactory(){}
	
	public IServiceRequest create(){
		return new ServiceRequestImpl();
	}
} 
