/**
 * 
 */
package com.rif.common.response.impl;

import com.rif.common.response.IServiceResponse;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-16 上午10:31:43
 */
public class ServiceResponseImpl implements IServiceResponse {
	private boolean sucess;
	private boolean fail;
	private Object result;
	private Throwable exception;

	/**
	 * 
	 */
	private static final long serialVersionUID = 677012294060209658L;

	public boolean isSucess() {
		return sucess;
	}

	public void setSucess(boolean sucess) {
		this.sucess = sucess;
		this.fail = !sucess;
	}

	public boolean isFail() {
		return fail;
	}

	public void setFail(boolean fail) {
		this.fail = fail;
		this.sucess = !fail;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

}
