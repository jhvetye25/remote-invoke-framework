/**
 * 
 */
package com.rif.server.service.helper;

import java.lang.reflect.Method;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com) 2011-7-18 下午10:12:14
 */
public class ClassHelper {
	/**
	 * 
	 * @param className
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Class loadClass(String className) {
		Class result = null;
		try {
			result = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	public static Class[] getparameterTypes(String[] signatures, Object[] args) {
		Class[] parameterTypes = null;
		if (signatures == null
				|| (signatures.length == 0 && args != null && args.length != 0)) {
			if (args == null || args.length == 0) {
				return new Class[0];
			}
			parameterTypes = new Class[args.length];
			for (int i = 0; i < args.length; i++) {
				Object object = args[i];
				if (null == object) {
					continue;
				} else {
					parameterTypes[i] = object.getClass();
				}
			}
		} else {
			parameterTypes = new Class[signatures.length];
			for (int i = 0; i < signatures.length; i++) {
				parameterTypes[i] = ClassHelper.loadClass(signatures[i]);
			}
		}

		return parameterTypes;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Method getMethod(Class clazz, String methodName,
			Class[] parameterTypes) throws NoSuchMethodException {
		if (parameterTypes == null) {
			parameterTypes = new Class[0];
		}
		Method targetMethod = null;
		try {
			targetMethod = clazz.getMethod(methodName, parameterTypes);
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return targetMethod;
	}

}
