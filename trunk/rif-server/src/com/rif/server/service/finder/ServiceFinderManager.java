/**
 * 
 */
package com.rif.server.service.finder;

import java.util.HashMap;
import java.util.Map;

import com.rif.common.IServiceEndpoint;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 上午11:38:57
 */
public class ServiceFinderManager {
	public static ServiceFinderManager INSTANCE = new ServiceFinderManager();
	private ServiceFinderManager(){}
	
	private Map<String, IServiceFinder> finders = new HashMap<String, IServiceFinder>();
	
	public boolean regiester(IServiceFinder finder){
		boolean result = false;
		if(finders.containsKey(finder.getName())){
			return result;
		}
		finders.put(finder.getName(), finder);
		result = true;
		return result;
	}
	
	public Map<String, IServiceFinder> findAll(){
		return finders;
	}
	
	public IServiceFinder getFind(String name){
		return finders.get(name);
	}
	
	public IServiceFinder getFind(IServiceEndpoint endpoint){
		for(IServiceFinder finder: finders.values()){
			if(finder.accept(endpoint)){
				return finder;
			}
		}
		return null;
	}
}
