/**
 * 
 */
package com.rif.server.service;


/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-26 下午10:34:20
 */
public interface IServerDataExchange {
	void exchange();
	String getSerializeType();
	byte[] getMessage();
}
