/**
 * 
 */
package com.rif.client.service.stub;

import com.rif.common.request.IServiceRequest;
import com.rif.common.response.IServiceResponse;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-29 上午10:24:56
 */
public interface IServiceStub {
	String getRefId();
	IServiceResponse execute(IServiceRequest request);
}
