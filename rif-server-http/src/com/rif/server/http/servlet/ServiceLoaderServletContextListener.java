/**
 *
 */
package com.rif.server.http.servlet;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.rif.server.service.server.RIFServer;

/**
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-7-20 下午09:36:13
 */
public class ServiceLoaderServletContextListener implements
		ServletContextListener {
	private static final String SERVICE_LOCATION = "serviceLocation";

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		RIFServer.stop();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		RIFServer.start(initService(event));
	}

	private InputStream[] initService(ServletContextEvent event){
	    List<InputStream> list = new ArrayList<InputStream>();
		ServletContext context = event.getServletContext();
		String serviceLocations = context.getInitParameter(SERVICE_LOCATION);
		if(null != serviceLocations){
			String[] serviceLocation = serviceLocations.split(",");
			InputStream is = null;
			for(String tmp : serviceLocation){
				try {
					is = context.getResourceAsStream(tmp);
					if(null != is){
						list.add(is);
					}
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		}
		InputStream[] result = new InputStream[list.size()];
		return list.toArray(result);
	}

}
