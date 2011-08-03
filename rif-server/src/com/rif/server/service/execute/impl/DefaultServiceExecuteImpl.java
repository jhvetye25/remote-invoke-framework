/**
 * 
 */
package com.rif.server.service.execute.impl;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.rif.server.service.execute.IServiceExecute;
import com.rif.server.service.helper.ClassHelper;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-14 下午11:44:48
 */
public class DefaultServiceExecuteImpl implements IServiceExecute {

	@SuppressWarnings("rawtypes")
	@Override
	public Object execute(Class clazz, Object target, String methodName,
			String[] signatures, Object[] args) throws Throwable {
		Object result = null;
		Method targetMethod = ClassHelper.getMethod(clazz, methodName, ClassHelper.getparameterTypes(signatures, args));
		if (Modifier.isStatic(targetMethod.getModifiers())) {
			result = targetMethod.invoke(null, args);
		} else {
			result = targetMethod.invoke(target, args);
		}
		return result;
	}


}
