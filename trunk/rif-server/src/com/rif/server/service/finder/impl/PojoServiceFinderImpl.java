/**
 * 
 */
package com.rif.server.service.finder.impl;

import com.rif.common.IServiceEndpoint;
import com.rif.common.naming.AbstractNamingObject;
import com.rif.server.service.definiton.ServiceModel;
import com.rif.server.service.definiton.ServiceModelConstant;
import com.rif.server.service.definiton.ServiceModelManager;
import com.rif.server.service.finder.IServiceFinder;
import com.rif.server.service.helper.ClassHelper;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-15 上午12:03:36
 */
public class PojoServiceFinderImpl extends AbstractNamingObject implements IServiceFinder {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9210952451804107976L;

	public PojoServiceFinderImpl(){
		this.setName(PojoServiceFinderImpl.class.getName());
	}
	
	public PojoServiceFinderImpl(String name){
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
				if(serviceModel.getServiceImplementModel().isPojoImpl()){
					isAccept = true;
				}
			}
		}
		return isAccept;
	}

	/* (non-Javadoc)
	 * @see com.rif.server.service.resolver.IServiceResolver#resolve(com.rif.common.IServiceEndpoint)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object find(IServiceEndpoint endpoint) {
		Class clazz = getType(endpoint);
		Object obj = null;
		try {
			obj = clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getType(IServiceEndpoint endpoint) {
		String className = (String) ServiceModelManager.INSTANCE
				.lookup(endpoint)
				.getServiceImplementModel()
				.getAttributes()
				.get(ServiceModelConstant.SERVICE_MODEL_SERVICE_IMPLEMENTS_POJO_CLASS);
		if (null == className) {
			return null;
		}
		Class result = null;
		result = ClassHelper.loadClass(className);
		return result;
	}

}
