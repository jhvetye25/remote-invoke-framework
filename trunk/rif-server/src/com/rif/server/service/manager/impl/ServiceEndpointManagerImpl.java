/**
 *
 */
package com.rif.server.service.manager.impl;

import java.util.HashMap;
import java.util.Map;

import com.rif.common.IServiceEndpoint;
import com.rif.common.naming.AbstractNamingObject;
import com.rif.server.service.manager.IServiceEndpointManager;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 上午09:48:37
 */
public class ServiceEndpointManagerImpl extends AbstractNamingObject implements IServiceEndpointManager {
	private Map<String, IServiceEndpoint> serviceEndpoints = new HashMap<String, IServiceEndpoint>();

	/* (non-Javadoc)
	 * @see com.rif.server.service.manager.IServiceManager#regiest(com.rif.common.IServiceEndpoint)
	 */
	@Override
	public boolean register(IServiceEndpoint endpoint) {
		serviceEndpoints.put(endpoint.getServiceName(), endpoint);
		return true;
	}

	/* (non-Javadoc)
	 * @see com.rif.server.service.manager.IServiceManager#unregiest(java.lang.String)
	 */
	@Override
	public boolean unRegister(String qName) {
		serviceEndpoints.remove(qName);
		return true;
	}

	/* (non-Javadoc)
	 * @see com.rif.server.service.manager.IServiceManager#unregiest()
	 */
	@Override
	public boolean unRegister() {
		serviceEndpoints.clear();
		return true;
	}

	/* (non-Javadoc)
	 * @see com.rif.server.service.manager.IServiceManager#lookup(java.lang.String)
	 */
	@Override
	public IServiceEndpoint lookup(String qName) {
		return serviceEndpoints.get(qName);
	}

	/* (non-Javadoc)
	 * @see com.rif.server.service.manager.IServiceManager#lookup()
	 */
	@Override
	public IServiceEndpoint[] lookup() {
		IServiceEndpoint[] results = new IServiceEndpoint[serviceEndpoints.size()];
		return serviceEndpoints.values().toArray(results);
	}

    @Override
    public void destroy() {
        serviceEndpoints.clear();
    }

}
