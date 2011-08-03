/**
 * 
 */
package com.rif.server.service.parser;

import java.io.InputStream;

import com.rif.server.service.parser.impl.ServiceModelParserImpl;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-20 下午09:49:09
 */
public class ServiceModelParserFactory {
	public static ServiceModelParserFactory 	INSTANCE = new ServiceModelParserFactory();
	private ServiceModelParserFactory(){}
	
	public IServiceModelParser createParser(){
		return new ServiceModelParserImpl();
	}
	
	public IServiceModelParser createParser(InputStream[] resources){
		return new ServiceModelParserImpl(resources);
	}
}
