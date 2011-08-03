/**
 * 
 */
package com.rif.client.service.transport;

import com.rif.client.service.definition.TransportClientModel;
import com.rif.common.request.IServiceRequest;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-29 下午03:37:12
 */
public interface ITransportClient {
	boolean accept(String type);
	byte[] transport(TransportClientModel model, final IServiceRequest request, byte[] message) throws Throwable;
}
