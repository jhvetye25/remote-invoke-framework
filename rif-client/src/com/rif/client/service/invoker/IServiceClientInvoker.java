/**
 * 
 */
package com.rif.client.service.invoker;


/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-29 上午10:33:02
 */
public interface IServiceClientInvoker {
	Object invoke(String refId, String methodName, String[] signatures, Object[] args );
}
