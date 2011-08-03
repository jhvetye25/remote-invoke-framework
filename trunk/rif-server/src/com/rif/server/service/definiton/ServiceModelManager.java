/**
 * 
 */
package com.rif.server.service.definiton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rif.common.IServiceEndpoint;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 下午11:29:11
 */
public class ServiceModelManager {
	public static ServiceModelManager INSTANCE = new ServiceModelManager();
	private Map<String, ServiceModel> models= new HashMap<String, ServiceModel>();
	
	private ServiceModelManager(){}
	
	public void register(ServiceModel model){
		models.put(model.getServiceName(), model);
	}
	
	public void register(List<ServiceModel> models){
		for(ServiceModel model : models){
			register(model);
		}
	}
	
	public void unRegister(ServiceModel model){
		models.remove(model);
	}
	public Map<String, ServiceModel> lookup(){
		return models;
	}
	public ServiceModel lookup(String serviceName){
		return models.get(serviceName);
	}
	public ServiceModel lookup(IServiceEndpoint serviceEndpoint){
		return models.get(serviceEndpoint.getServiceName());
	}
	
	public void destroy(){
		models.clear();
	}
}
