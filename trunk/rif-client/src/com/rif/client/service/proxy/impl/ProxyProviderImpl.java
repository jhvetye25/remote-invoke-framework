/**
 * 
 */
package com.rif.client.service.proxy.impl;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.proxy.Enhancer;

import com.rif.client.service.invoker.IServiceClientInvoker;
import com.rif.client.service.invoker.ServiceClientInvokerManager;
import com.rif.client.service.proxy.IProxyProvider;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-29 上午11:11:13
 */
public class ProxyProviderImpl implements IProxyProvider {
	private Map<String, Object> proxyCache = new HashMap<String, Object>();
	private Object lock = new Object();

	/* (non-Javadoc)
	 * @see com.rif.client.service.proxy.IProxyProvider#getProxy(java.lang.String, java.lang.Class)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> T getProxy(String refId, Class serviceClazz) {
		Object proxy = proxyCache.get(refId);
		if(null == proxy){
			synchronized (lock) {
				if(null == proxy){
					IServiceClientInvoker invoker = ServiceClientInvokerManager.INSTANCE.getInvoker();
					if(serviceClazz.isInterface()){
						proxy = Proxy.newProxyInstance(ProxyProviderImpl.class.getClassLoader(), new Class[]{serviceClazz}, new JdkInvocationHandler(refId, invoker));
					}else{
						Enhancer enhancer = new Enhancer();
						enhancer.setSuperclass(serviceClazz);
						enhancer.setClassLoader(ProxyProviderImpl.class.getClassLoader());
						enhancer.setCallback(new CglibMethodInterceptor(refId, invoker));
						proxy = enhancer.create();
					}
					proxyCache.put(refId, proxy);
				}
			}
		}
		return (T)proxy;
	}

}
