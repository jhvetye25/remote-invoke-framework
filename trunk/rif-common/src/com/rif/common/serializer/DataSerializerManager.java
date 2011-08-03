/**
 *
 */
package com.rif.common.serializer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 *
 */
public class DataSerializerManager {
	private static Map<String, IDataSerializer> serializers = new ConcurrentHashMap<String, IDataSerializer>();
	public static DataSerializerManager INSTANCE = new DataSerializerManager();

	public Map<Integer, String> mappingIndexToType = new HashMap<Integer, String>();
	public Map<String, Integer> mappingTypeToIndex = new HashMap<String, Integer>();

	//RIFServer init service loader
	private DataSerializerManager(){}

	public boolean regiest(IDataSerializer serializer){
		return regiest(serializer.getName(), serializer);
	}

	public boolean regiest(String name, IDataSerializer serializer){
		boolean result = false;
		serializers.put(name, serializer);
		mappingIndexToType.put(new Integer(serializer.getIndex()), serializer.getName());
		mappingTypeToIndex.put(serializer.getName(), new Integer(serializer.getIndex()));
		return result;
	}

	public IDataSerializer get(String name){
		return serializers.get(name);
	}

}