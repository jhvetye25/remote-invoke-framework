/**
 * 
 */
package com.rif.client.service.impl;

import com.rif.client.service.IServiceClient;
import com.rif.client.service.invoker.ServiceClientInvokerManager;
import com.rif.client.service.proxy.ProxyProviderManager;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-28 下午11:23:14
 */
public class ServiceClientImpl implements IServiceClient {

	/* (non-Javadoc)
	 * @see com.rif.client.service.IServiceClient#newProxyInstance(java.lang.String, java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public <T> T getService(String refId, Class serviceClass) {
		return ProxyProviderManager.INSTANCE.getProxyProvider().getProxy(refId, serviceClass);
	}

	/* (non-Javadoc)
	 * @see com.rif.client.service.IServiceClient#invoke(java.lang.String, java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object invoke(String refId, String methodName, Object[] args) {
		return ServiceClientInvokerManager.INSTANCE.getInvoker().invoke(refId, methodName, null, args);
	}

}
