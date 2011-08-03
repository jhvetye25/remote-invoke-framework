/**
 * 
 */
package com.rif.server.service.definiton;

import java.io.Serializable;
import java.util.Properties;

import com.rif.server.service.Constant;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 下午11:02:04
 */
public class ServiceImplementModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5256708433085557486L;
	private String type;
	private Properties attributes = new Properties();
	
	public ServiceImplementModel(){}
	
	public ServiceImplementModel(String type){
		this.type = type;
	} 
	
	public ServiceImplementModel(String type, Properties attributes){
		this.type = type;
		this.attributes = attributes;
	}
	
	public boolean isPojoImpl(){
		return (this.type != null) && Constant.IMPLEMENT_TYPE_POJO.equals(this.type);
	}
	public boolean isSpringImpl(){
		return (this.type != null) && Constant.IMPLEMENT_TYPE_SPRING.equals(this.type);
	}
	
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Properties getAttributes() {
		return this.attributes;
	}
	public void setAttributes(Properties attributes) {
		this.attributes = attributes;
	}
	
	public void addAttribute(String key, String value){
		this.attributes.put(key, value);
	}
	
}
