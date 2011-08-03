/**
 * 
 */
package com.rif.server.service.execute;

import com.rif.server.service.execute.impl.DefaultServiceExecuteImpl;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-18 下午10:16:52
 */
public class ServiceExecuteManager {
	public static ServiceExecuteManager INSTANCE = new ServiceExecuteManager();
	private IServiceExecute serviceExecute = new DefaultServiceExecuteImpl();
	
	private ServiceExecuteManager(){}
	
	public IServiceExecute getServiceExecute(){
		return serviceExecute;
	}
}
