/**
 * 
 */
package com.rif.client.service.proxy.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import com.rif.client.service.invoker.IServiceClientInvoker;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-29 上午10:21:19
 */
public class JdkInvocationHandler implements InvocationHandler {
	private String refId;
	private IServiceClientInvoker invoker;
	
	public JdkInvocationHandler(String refId,IServiceClientInvoker invoker){
		this.refId = refId;
		this.invoker = invoker;
	}

	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object invoke(Object target, Method method, Object[] args)
			throws Throwable {
		if(Modifier.isPublic(method.getModifiers())){
			String methodName= method.getName();
			Class[] paramTypes = method.getParameterTypes();
			String[] signatures = prepareSignature(paramTypes);
			return this.invoker.invoke(refId, methodName, signatures, args);
		}else{
			throw new RuntimeException("invoke not public method." + method.getName());
		}
	}
	
	@SuppressWarnings("rawtypes")
	private String[] prepareSignature(Class[] paramTypes){
		List<String> list = new ArrayList<String>();
		for(Class clazz:paramTypes){
			list.add(clazz.getName());
		}
		String[] signatures = new String[paramTypes.length];
		return list.toArray(signatures);
	}
}
