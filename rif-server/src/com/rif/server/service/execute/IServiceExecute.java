/**
 * 
 */
package com.rif.server.service.execute;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-14 下午11:41:56
 */
public interface IServiceExecute {
	@SuppressWarnings("rawtypes")
	Object execute(Class clazz, Object target, String method, String[] signatures, Object[] args) throws Throwable;
}
