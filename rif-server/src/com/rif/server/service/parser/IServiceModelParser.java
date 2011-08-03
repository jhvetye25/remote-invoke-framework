/**
 *
 */
package com.rif.server.service.parser;

import java.io.InputStream;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com) 2011-7-19 下午11:47:56
 */
public interface IServiceModelParser {
	void parser();

	InputStream[] getResources();

	void setResources(InputStream[] resources);
}
