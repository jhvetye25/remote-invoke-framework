/**
 * 
 */
package com.rif.common.response;

import java.io.Serializable;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 	2011-7-14 下午11:12:01
 */
public interface IServiceResponse extends Serializable {
	boolean isSucess();
	boolean isFail();
	Object getResult();
	Throwable getException();
}