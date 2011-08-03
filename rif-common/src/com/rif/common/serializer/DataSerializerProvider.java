/**
 * 
 */
package com.rif.common.serializer;

import com.rif.common.IServiceEndpoint;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 *
 */
public class DataSerializerProvider {
	public static DataSerializerProvider INSTANCE = new DataSerializerProvider();
	
	private DataSerializerProvider(){}
	
	public IDataSerializer provider(int index){
		return provider(DataSerializerManager.INSTANCE.mappingIndexToType.get(new Integer(index)));
	}
	
	public IDataSerializer provider(String type){
		IDataSerializer serializer = DataSerializerManager.INSTANCE.get(type);
		return serializer;
	}
	
	public IDataSerializer provider(IServiceEndpoint serviceEndpoint){
		return provider(serviceEndpoint.getSerializerType());
	}
}
