/**
 *
 */
package com.rif.common.impl;

import com.rif.common.IServiceEndpoint;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 上午09:59:07
 */
public class ServiceEndpointImpl implements IServiceEndpoint {
	private String serviceName;
	private String serviceVersion;
	private String serializerType;
	private String description;
	private String transportID;

	/**
	 *
	 */
	private static final long serialVersionUID = 5635542755326321544L;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getSerializerType() {
		return serializerType;
	}

	public void setSerializerType(String serializerType) {
		this.serializerType = serializerType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTransportID() {
		return transportID;
	}

	public void setTransportID(String transportID) {
		this.transportID = transportID;
	}

	public String getServiceVersion() {
		return serviceVersion;
	}

	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

}
