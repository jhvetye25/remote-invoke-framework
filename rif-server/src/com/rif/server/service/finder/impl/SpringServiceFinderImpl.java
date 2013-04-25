/**
 * 
 */
package com.rif.server.service.finder.impl;

import com.rif.common.IServiceEndpoint;
import com.rif.common.naming.AbstractNamingObject;
import com.rif.server.service.definiton.ServiceModel;
import com.rif.server.service.definiton.ServiceModelManager;
import com.rif.server.service.finder.IServiceFinder;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-15 上午12:06:41
 */
public class SpringServiceFinderImpl extends AbstractNamingObject implements
		IServiceFinder {


	public SpringServiceFinderImpl(){
		this.setName(SpringServiceFinderImpl.class.getName());
	}
	
	public SpringServiceFinderImpl(String name){
		this.setName(name);
	}
	
	/* (non-Javadoc)
	 * @see com.rif.server.service.resolver.IServiceResolver#canResolve(com.rif.common.IServiceEndpoint)
	 */
	@Override
	public boolean accept(IServiceEndpoint endpoint) {
		boolean isAccept = false;
		if(null != endpoint){
			ServiceModel serviceModel = ServiceModelManager.INSTANCE.lookup(endpoint);
			if(null != serviceModel){
				if(serviceModel.getServiceImplementModel().isSpringImpl()){
					isAccept = true;
				}
			}
		}
		return isAccept;
	}

	/* (non-Javadoc)
	 * @see com.rif.server.service.resolver.IServiceResolver#resolve(com.rif.common.IServiceEndpoint)
	 */
	@Override
	public Object find(IServiceEndpoint endpoint) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getType(IServiceEndpoint endpoint) {
		// TODO Auto-generated method stub
		return null;
	}

}
