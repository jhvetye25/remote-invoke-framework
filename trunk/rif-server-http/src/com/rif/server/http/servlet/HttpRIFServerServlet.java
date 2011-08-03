/**
 * 
 */
package com.rif.server.http.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.rif.common.util.ByteUtil;
import com.rif.server.service.IServerDataExchange;
import com.rif.server.service.ServiceFramework;

/**
 * Http接入远程调用请求servlet.<br>
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 *
 */
public class HttpRIFServerServlet implements Servlet{
	
	private static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
	private ServletConfig config;

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public String getServletInfo() {
		return "RIF Service Servlet.";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 */
	@Override
	public void service(final ServletRequest request, final ServletResponse response)
			throws IOException {
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = request.getInputStream();
			byte[] bytes = ByteUtil.getBytes(in);
			
			IServerDataExchange dataExchange = new HttpServerDataExchange(bytes);
			byte[] buffer = ServiceFramework.call(dataExchange);
			
			response.setContentType(APPLICATION_OCTET_STREAM);
			response.setContentLength(buffer.length);
			out = response.getOutputStream();
			out.write(buffer);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally{
			if(null != in){
				try{
					in.close();
				}catch(Throwable t){}
			}
		}
	}

}
