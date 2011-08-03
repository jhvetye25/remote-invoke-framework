/**
 * 
 */
package com.rif.client.service.invoker;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import com.rif.client.service.invoker.impl.ServiceClientInvokerImpl;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-29 上午11:13:34
 */
public class ServiceClientInvokerManager {
	public static ServiceClientInvokerManager INSTANCE = new ServiceClientInvokerManager();
	private List<IServiceClientInvoker> list = new ArrayList<IServiceClientInvoker>();
	private Object lock = new Object();
	
	private ServiceClientInvokerManager(){}
	
	public void regiester(IServiceClientInvoker invoker){
		list.add(invoker);
	}
	
	public IServiceClientInvoker getInvoker(){
		IServiceClientInvoker invoker = null;
		if(list.size() == 0){
			synchronized (lock) {
				if(list.size() == 0){
					list.add(new ServiceClientInvokerImpl());
				}
			}
		}
		invoker = list.get(0);
		return invoker;
	} 
	
	static{
		ServiceLoader<IServiceClientInvoker> serviceClientInvokers = ServiceLoader.load(IServiceClientInvoker.class);
		for(IServiceClientInvoker serviceClientInvoker : serviceClientInvokers){
			ServiceClientInvokerManager.INSTANCE.regiester(serviceClientInvoker);
		}
	}
}
