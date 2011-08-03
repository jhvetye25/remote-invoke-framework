/**
 *
 */
package com.rif.common;

import java.io.Serializable;

/**
 *  服务端点.<br>
 * @author bruce.liu IServiceEndpoint(mailto:jxta.liu@gmail.com)
 *
 */
public interface IServiceEndpoint extends Serializable{
	String getServiceName();
	String getServiceVersion();
	String getSerializerType();
	String getDescription();
	String getTransportID();
//	ITransport getTransport();
}

