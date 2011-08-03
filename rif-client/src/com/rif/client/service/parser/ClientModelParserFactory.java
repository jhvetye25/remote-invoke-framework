/**
 * 
 */
package com.rif.client.service.parser;

import java.io.InputStream;

import com.rif.client.service.parser.impl.ClientModleParserImpl;

/**
 * 
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-28 下午10:36:27
 */
public class ClientModelParserFactory {
	public static ClientModelParserFactory 	INSTANCE = new ClientModelParserFactory();
	private ClientModelParserFactory(){}
	
	public IClientModelParser createParser(){
		return new ClientModleParserImpl();
	}
	
	public IClientModelParser createParser(InputStream[] resources){
		return new ClientModleParserImpl(resources);
	}
}
