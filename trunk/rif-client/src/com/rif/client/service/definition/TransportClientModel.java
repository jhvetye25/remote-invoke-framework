/**
 * 
 */
package com.rif.client.service.definition;

import java.io.Serializable;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-28 下午09:32:43
 */
public class TransportClientModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4291837875420765994L;

	private String refId;
	private String type;
	private String serializerType;
	private String url;
	private String security;
	
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSerializerType() {
		return serializerType;
	}
	public void setSerializerType(String serializerType) {
		this.serializerType = serializerType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
}
