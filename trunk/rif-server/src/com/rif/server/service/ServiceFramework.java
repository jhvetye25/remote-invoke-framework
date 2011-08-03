/**
 * 
 */
package com.rif.server.service;

import com.rif.common.IServiceEndpoint;
import com.rif.common.exception.RIFRuntimeException;
import com.rif.common.request.IServiceRequest;
import com.rif.common.response.IServiceResponse;
import com.rif.common.response.ServiceResponseFactory;
import com.rif.common.response.impl.ServiceResponseImpl;
import com.rif.common.serializer.DataSerializerProvider;
import com.rif.server.service.manager.ServiceEndpointManagerFactory;
import com.rif.server.service.skeleton.ServiceSkeletonManager;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 上午10:49:24
 */
public class ServiceFramework {
	
	public static byte[] call(IServerDataExchange dataExchange){
		byte[] response;
		dataExchange.exchange();
		String serializType = dataExchange.getSerializeType();
		byte[] message = dataExchange.getMessage();
		
		// 1.deserialize request data
		IServiceRequest serviceRequest = (IServiceRequest)DataSerializerProvider.INSTANCE.provider(serializType).unmarshall(message);
		
		// 2.service execute
		IServiceResponse serviceResponse = ServiceFramework.call(serviceRequest);
		
		// 3.serialize response data
		response = DataSerializerProvider.INSTANCE.provider(serializType).marshall(serviceResponse);
		
		return response;
	}
	
	public static IServiceResponse call(IServiceRequest serviceRequest){
		IServiceResponse serviceResponse = ServiceResponseFactory.INSTANCE.create();
		//  1.lookup service
		IServiceEndpoint endpoint = ServiceEndpointManagerFactory.INSTANCE.getServiceManager().lookup(serviceRequest.getServiceName());
		if(null ==  endpoint){
			((ServiceResponseImpl)serviceResponse).setException(new RIFRuntimeException("Not found service definition:" + serviceRequest.getServiceName() + "."));
			((ServiceResponseImpl)serviceResponse).setFail(true);
			return serviceResponse;
		}
		
		//  2.find skeleton and execute
		ServiceSkeletonManager.INSTANCE.getServiceSkeleton(endpoint).execute(serviceRequest, serviceResponse);
		
		return serviceResponse;
	}
}
