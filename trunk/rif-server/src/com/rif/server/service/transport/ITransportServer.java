package com.rif.server.service.transport;

import com.rif.common.naming.INamingObject;

/**
 * 
 * @author bruce.liu (mailto:jxta.liu@gmail.com)
 * 2011-8-3 下午08:57:53
 */
public interface ITransportServer extends INamingObject{
    String getType();
    void start();
    void stop();
}
