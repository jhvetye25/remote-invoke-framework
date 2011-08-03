/**
 * 
 */
package com.rif.common.naming;


/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 *
 */
public abstract class AbstractNamingObject {
	private String name;
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
}
