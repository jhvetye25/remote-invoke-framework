/**
 * 
 */
package com.rif.server.service.skeleton;

import com.rif.common.request.IServiceRequest;
import com.rif.common.response.IServiceResponse;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-14 下午11:29:40
 */
public interface IServiceSkeleton {
	/**
	  * 执行服务
	 * @param request
	 * @param response
	 */
	void execute(IServiceRequest request, IServiceResponse response);
}
