/**
 *
 */
package com.rif.server.service.manager;

import com.rif.common.IServiceEndpoint;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 *
 */
public interface IServiceEndpointManager {
	boolean register(IServiceEndpoint endpoint);
	boolean unRegister(String qName);
	boolean unRegister();
	void destroy();
	IServiceEndpoint lookup(String qName);
	IServiceEndpoint[] lookup();
}
