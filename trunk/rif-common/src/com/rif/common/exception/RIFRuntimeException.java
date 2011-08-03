/**
 * 
 */
package com.rif.common.exception;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 上午09:50:30
 */
public class RIFRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8922785418306337565L;

	public RIFRuntimeException(){
		super();
	}
	
	public RIFRuntimeException(String message){
		super(message);
	}
	
	public RIFRuntimeException(Throwable t){
		super(t);
	}
	
	public RIFRuntimeException(String message, Throwable t){
		super(message, t);
	}
	
}
