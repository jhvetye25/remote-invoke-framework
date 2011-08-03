/**
 * 
 */
package com.rif.client.service.http.dataexchange;

import com.rif.client.service.dataexchange.IClientDataExchange;
import com.rif.common.request.IServiceRequest;
import com.rif.common.serializer.DataSerializerManager;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-29 下午11:56:27
 */
public class HttpDataClientExchangeImpl implements IClientDataExchange {

	/* (non-Javadoc)
	 * @see com.rif.client.service.dataexchange.IClientDataExchange#exchangeSend(byte[])
	 */
	@Override
	public byte[] exchangeSend(byte[] message, IServiceRequest request) {
		byte[] sendMessage = new byte[message.length + 1];
		sendMessage[0] = new Integer(DataSerializerManager.INSTANCE.mappingTypeToIndex.get(request.getSerializerType())).byteValue();
		for(int i=0;i<message.length;i++){
			sendMessage[i+1] = message[i];
		}
		return sendMessage;
	}

	/* (non-Javadoc)
	 * @see com.rif.client.service.dataexchange.IClientDataExchange#exchangeReceive(byte[])
	 */
	@Override
	public byte[] exchangeReceive(byte[] message) {
		return message;
	}

}
