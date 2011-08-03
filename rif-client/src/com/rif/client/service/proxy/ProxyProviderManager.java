/**
 * 
 */
package com.rif.client.service.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import com.rif.client.service.proxy.impl.ProxyProviderImpl;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-29 上午11:11:37
 */
public class ProxyProviderManager {
	public static ProxyProviderManager INSTANCE = new ProxyProviderManager();
	private List<IProxyProvider> list = new ArrayList<IProxyProvider>();
	private Object lock = new Object();
	
	private ProxyProviderManager(){}
	
	public void regiester(IProxyProvider proxyProvider){
		list.add(proxyProvider);
	}
	
	public IProxyProvider getProxyProvider(){
		IProxyProvider proxyProvider = null;
		if(list.size() == 0){
			synchronized (lock) {
				if(list.size() == 0){
					list.add(new ProxyProviderImpl());
				}
			}
		}
		proxyProvider = list.get(0);
		return proxyProvider;
	} 
	
	static{
		ServiceLoader<IProxyProvider> proxyProviders = ServiceLoader.load(IProxyProvider.class);
		for(IProxyProvider proxyProvider : proxyProviders){
			ProxyProviderManager.INSTANCE.regiester(proxyProvider);
		}
	}
}
