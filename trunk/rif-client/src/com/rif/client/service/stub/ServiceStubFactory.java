/**
 * 
 */
package com.rif.client.service.stub;

import com.rif.client.service.definition.ServiceClientModel;
import com.rif.client.service.stub.impl.ServiceStubImpl;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-29 下午03:18:18
 */
public class ServiceStubFactory {
	public static ServiceStubFactory INSTANCE = new ServiceStubFactory();
	private ServiceStubFactory(){}
	
	public IServiceStub create(String refId){
		return new ServiceStubImpl(refId);
	}
	public IServiceStub create(ServiceClientModel serviceClientModel){
		return new ServiceStubImpl(serviceClientModel);
	}
}
