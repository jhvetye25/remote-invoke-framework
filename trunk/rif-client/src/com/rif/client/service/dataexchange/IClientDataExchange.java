/**
 * 
 */
package com.rif.client.service.dataexchange;

import com.rif.common.request.IServiceRequest;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-29 下午03:41:39
 */
public interface IClientDataExchange {
	byte[] exchangeSend(byte[] message, IServiceRequest request);
	byte[] exchangeReceive(byte[] message);
}
