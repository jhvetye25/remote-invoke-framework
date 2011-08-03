/**
 * 
 */
package com.rif.client.service.invoker.impl;

import com.rif.client.service.definition.ClientModelManager;
import com.rif.client.service.definition.ServiceClientModel;
import com.rif.client.service.definition.TransportClientModel;
import com.rif.client.service.invoker.IServiceClientInvoker;
import com.rif.client.service.stub.ServiceStubManager;
import com.rif.common.request.IServiceRequest;
import com.rif.common.request.ServiceRequestFactory;
import com.rif.common.response.IServiceResponse;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-29 上午11:13:22
 */
public class ServiceClientInvokerImpl implements IServiceClientInvoker {

	/* (non-Javadoc)
	 * @see com.rif.client.service.invoker.IServiceClientInvoker#invoke(java.lang.String, java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	@Override
	public Object invoke(String refId, String methodName, String[] signatures, Object[] args) {
		ServiceClientModel serviceClientModel = ClientModelManager.INSTANCE.getServiceClientModel(refId);
		if(null == serviceClientModel){
			throw new RuntimeException("Not find the reference definition of " + refId);
		}
		TransportClientModel transportClientModel = ClientModelManager.INSTANCE.getTransportClientModel(serviceClientModel.getTransportId());
		if(null == transportClientModel){
			throw new RuntimeException("Not find the reference transport definition of " + serviceClientModel.getTransportId());
		}
		IServiceRequest request = ServiceRequestFactory.INSTANCE.create();
		request.setServiceName(serviceClientModel.getServieName());
		request.setOperationName(methodName);
		request.setSignatures(signatures);
		request.setArgs(args);
		if(null != serviceClientModel.getSerializerType() &&  !"".equals(transportClientModel.getSerializerType())){
			request.setSerializerType(transportClientModel.getSerializerType());
		}else{
			request.setSerializerType(transportClientModel.getSerializerType());
		}
		
		IServiceResponse response = ServiceStubManager.INSTANCE.lookup(refId).execute(request);
		if(null != response){
			if(response.isSucess()){
				return response.getResult();
			}else{
				throw new RuntimeException("service execute make error.", response.getException());
			}
		}
		return null;
	}
	

}
