/**
 * 
 */
package com.rif.server.service.definiton;

import java.io.Serializable;

import com.rif.common.IServiceEndpoint;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 下午10:49:42
 */
public class ServiceModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7587939284645369739L;
	private String serviceName;
	private IServiceEndpoint serviceEndpoint;
	private ServiceImplementModel serviceImplementModel;
	
	public ServiceModel(){}
	
	public ServiceModel(IServiceEndpoint serviceEndpoint,ServiceImplementModel serviceImplementModel){
		this.serviceEndpoint = serviceEndpoint;
		this.serviceImplementModel = serviceImplementModel;
		this.serviceName = serviceEndpoint.getServiceName();
	}
	
	public ServiceModel(String serviceName, IServiceEndpoint serviceEndpoint,ServiceImplementModel serviceImplementModel){
		this.serviceEndpoint = serviceEndpoint;
		this.serviceImplementModel = serviceImplementModel;
		this.serviceName = serviceName;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public IServiceEndpoint getServiceEndpoint() {
		return serviceEndpoint;
	}
	public void setServiceEndpoint(IServiceEndpoint serviceEndpoint) {
		this.serviceEndpoint = serviceEndpoint;
		this.serviceName = this.serviceEndpoint.getServiceName();
	}
	public ServiceImplementModel getServiceImplementModel() {
		return serviceImplementModel;
	}
	public void setServiceImplementModel(ServiceImplementModel serviceImplementModel) {
		this.serviceImplementModel = serviceImplementModel;
	}
}
