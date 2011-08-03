package com.rif.common.request.impl;

import com.rif.common.request.IServiceRequest;

/**
 * 
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 上午10:10:15
 */
public class ServiceRequestImpl implements IServiceRequest {
	private String serviceName;
	private String operationName;
	private String[] signatures;
	private Object[] args;
	private String serializerType;

	/**
	 * 
	 */
	private static final long serialVersionUID = -113385841400839805L;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String[] getSignatures() {
		return signatures;
	}

	public void setSignatures(String[] signatures) {
		this.signatures = signatures;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	public String getSerializerType() {
		return serializerType;
	}

	public void setSerializerType(String serializerType) {
		this.serializerType = serializerType;
	}



}
