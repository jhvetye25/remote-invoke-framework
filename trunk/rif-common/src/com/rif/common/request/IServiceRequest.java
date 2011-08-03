/**
 * 
 */
package com.rif.common.request;

import java.io.Serializable;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 *		2011-7-14 下午10:56:26
 */
public interface IServiceRequest extends Serializable{
//	IServiceEndpoint getServiceEndpoint();
	String getServiceName();
	void setServiceName(String serviceName);
	String getOperationName();
	void setOperationName(String operationName);
	String[] getSignatures();
	void setSignatures(String[] signatures);
	Object[] getArgs();
	void setArgs(Object[] args);
	String getSerializerType();
	void setSerializerType(String serializerType);
}
