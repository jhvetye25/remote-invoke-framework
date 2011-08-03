/**
 * 
 */
package com.rif.server.service.manager;

import com.rif.server.service.manager.impl.ServiceEndpointManagerImpl;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 上午09:53:11
 */
public class ServiceEndpointManagerFactory {
	public static ServiceEndpointManagerFactory INSTANCE = new ServiceEndpointManagerFactory();
	private static IServiceEndpointManager _serviceManager = new ServiceEndpointManagerImpl();
	private ServiceEndpointManagerFactory(){}
	
	public IServiceEndpointManager getServiceManager(){
		return _serviceManager;
	}
	
}
