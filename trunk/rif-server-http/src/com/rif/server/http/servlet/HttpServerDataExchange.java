/**
 * 
 */
package com.rif.server.http.servlet;

import com.rif.common.serializer.DataSerializerManager;
import com.rif.server.service.IServerDataExchange;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-26 下午10:37:54
 */
public class HttpServerDataExchange implements IServerDataExchange {
	byte[] orainalMessage = null;
	String serializeType = null;
	byte[] message = null;
	
	public HttpServerDataExchange(byte[] orainalMessage){
		this.orainalMessage = orainalMessage;
	}

	/* (non-Javadoc)
	 * @see com.rif.server.service.IDataExchange#process(java.io.InputStream)
	 */
	@Override
	public void exchange() {
		int serializTypeInt = this.orainalMessage[0];
		this.serializeType = DataSerializerManager.INSTANCE.mappingIndexToType.get(new Integer(serializTypeInt));
		this.message = new byte[this.orainalMessage.length -1];
		System.arraycopy(this.orainalMessage, 1, this.message, 0, this.orainalMessage.length -1);
	}

	/* (non-Javadoc)
	 * @see com.rif.server.service.IDataExchange#getSerializType()
	 */
	@Override
	public String getSerializeType() {
		return this.serializeType;
	}

	/* (non-Javadoc)
	 * @see com.rif.server.service.IDataExchange#getMessage()
	 */
	@Override
	public byte[] getMessage() {
		return this.message;
	}
}
