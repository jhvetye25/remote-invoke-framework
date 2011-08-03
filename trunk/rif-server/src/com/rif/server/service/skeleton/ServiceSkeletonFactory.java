/**
 * 
 */
package com.rif.server.service.skeleton;

import com.rif.common.IServiceEndpoint;
import com.rif.server.service.skeleton.impl.DefaultServiceSkeletonImpl;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 下午10:03:36
 */
public class ServiceSkeletonFactory {
	public static IServiceSkeleton create(){
		return new DefaultServiceSkeletonImpl();
	}
	
	public static IServiceSkeleton create(IServiceEndpoint serviceEndpoint){
		return new DefaultServiceSkeletonImpl(serviceEndpoint);
	}
}
