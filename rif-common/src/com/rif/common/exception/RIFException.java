/**
 * 
 */
package com.rif.common.exception;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 上午09:50:07
 */
public class RIFException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7641320403086494116L;

	public RIFException(){
		super();
	}
	
	public RIFException(String message){
		super(message);
	}
	
	public RIFException(Throwable t){
		super(t);
	}
	
	public RIFException(String message, Throwable t){
		super(message, t);
	}
}
