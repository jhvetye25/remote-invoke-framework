/**
 * 
 */
package com.rif.client.service.proxy;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-29 上午10:20:16
 */
public interface IProxyProvider {
	@SuppressWarnings("rawtypes")
	<T> T getProxy(String refId, Class serviceClazz);
}
