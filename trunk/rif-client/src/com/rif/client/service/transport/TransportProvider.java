/**
 * 
 */
package com.rif.client.service.transport;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import com.rif.client.service.definition.TransportClientModel;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-29 下午03:44:51
 */
public class TransportProvider {
	public static TransportProvider INSTANCE = new TransportProvider();
	private static List<ITransportClient> transportList = new ArrayList<ITransportClient>();
	
	static{
		ServiceLoader<ITransportClient> transports = ServiceLoader.load(ITransportClient.class);
		for(ITransportClient transport : transports){
			transportList.add(transport);
		}
	}
	
	
	private TransportProvider(){}
	
	public ITransportClient provider(String transportType){
		for(ITransportClient transport : transportList){
			if(transport.accept(transportType)){
				return transport;
			}
		}
		return null;
	}
	 
	public ITransportClient provider(TransportClientModel model){
		return provider(model.getType());
	}
	
}
