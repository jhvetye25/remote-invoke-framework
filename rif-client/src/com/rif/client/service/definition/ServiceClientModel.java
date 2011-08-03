/**
 * 
 */
package com.rif.client.service.definition;

import java.io.Serializable;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-28 下午09:32:20
 */
public class ServiceClientModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3045581091413769182L;
	
	private String refId;
	private String servieName;
	private String serviceVersion;
	private String description;
	private String transportId;
	private String serializerType;
	
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public String getServieName() {
		return servieName;
	}
	public void setServieName(String servieName) {
		this.servieName = servieName;
	}
	public String getServiceVersion() {
		return serviceVersion;
	}
	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTransportId() {
		return transportId;
	}
	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}
	public String getSerializerType() {
		return serializerType;
	}
	public void setSerializerType(String serializerType) {
		this.serializerType = serializerType;
	}
}
