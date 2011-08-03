package com.rif.server.service.transport;

import com.rif.common.naming.INamingObject;

public interface ITransportServer extends INamingObject{
    String getType();
    void start();
    void stop();
}
