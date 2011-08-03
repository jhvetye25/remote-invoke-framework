/**
 * 
 */
package com.rif.client.service.parser;

import java.io.InputStream;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-28 下午10:01:42
 */
public interface IClientModelParser {
	void parser();

	InputStream[] getResources();
	
	void setResources(InputStream[] resources);
}
