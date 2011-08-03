/**
 * 
 */
package com.rif.client.service;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-28 下午10:59:34
 */
public interface IServiceClient {
	@SuppressWarnings("rawtypes")
	<T> T getService(String refId, Class serviceClass);
	Object invoke(String refId, String methodName, Object[] args);
}
