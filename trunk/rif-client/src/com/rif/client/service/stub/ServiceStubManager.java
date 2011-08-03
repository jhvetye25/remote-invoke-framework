/**
 * 
 */
package com.rif.client.service.stub;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-29 下午03:06:22
 */
public class ServiceStubManager {
	public static ServiceStubManager INSTANCE = new ServiceStubManager();
	private Map<String, IServiceStub> serviceStubMap = new HashMap<String, IServiceStub>();
	private Object lock = new Object();
	
	private ServiceStubManager(){}
	
	public void regiester(IServiceStub stub){
		if(null != stub){
			serviceStubMap.put(stub.getRefId(), stub);
		}
	}
	
	public IServiceStub lookup(String refId){
		IServiceStub stub = serviceStubMap.get(refId);
		if(null == stub){
			synchronized (lock) {
				if(null == stub){
					stub = ServiceStubFactory.INSTANCE.create(refId);
					serviceStubMap.put(stub.getRefId(), stub);
				}
			}
		}
		return stub;
	}
}
