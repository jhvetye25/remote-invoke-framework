/**
 * 
 */
package com.rif.server.service.finder;

import com.rif.common.IServiceEndpoint;
import com.rif.common.naming.INamingObject;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-14 下午11:57:03
 */
public interface IServiceFinder extends INamingObject{
	boolean accept(IServiceEndpoint endpoint);
	Object find(IServiceEndpoint endpoint);
	@SuppressWarnings("rawtypes")
	Class getType(IServiceEndpoint endpoint);
}
