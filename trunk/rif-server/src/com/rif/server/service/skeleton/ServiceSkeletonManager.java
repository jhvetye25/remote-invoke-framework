/**
 * 
 */
package com.rif.server.service.skeleton;

import java.util.HashMap;
import java.util.Map;

import com.rif.common.IServiceEndpoint;
import com.rif.server.service.manager.ServiceEndpointManagerFactory;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 上午10:37:46
 */
public class ServiceSkeletonManager {
	public static ServiceSkeletonManager INSTANCE = new ServiceSkeletonManager();
	private static Object lock = new Object();
	private ServiceSkeletonManager(){}
	
	private Map<String, IServiceSkeleton> skeletons = new HashMap<String, IServiceSkeleton>();
	
	public IServiceSkeleton getServiceSkeleton(IServiceEndpoint serviceEndpoint){
		IServiceSkeleton skeleton = null;
		skeleton = skeletons.get(serviceEndpoint.getServiceName());
		if(null == skeleton){
			synchronized (lock) {
				skeleton = ServiceSkeletonFactory.create(serviceEndpoint);
				skeletons.put(serviceEndpoint.getServiceName(), skeleton);
			}
		}
		return skeleton;
	}
	
	public IServiceSkeleton getServiceSkeleton(String serviceName){
		return getServiceSkeleton(ServiceEndpointManagerFactory.INSTANCE.getServiceManager().lookup(serviceName));
	}
}
