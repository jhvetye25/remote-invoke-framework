package com.rif.server.service.transport;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import com.rif.server.service.definiton.TransportModel;


public class TransportServerFactoryProvider {
    public static TransportServerFactoryProvider INSTANCE = new TransportServerFactoryProvider();
    private static List<ITransportServerFactory> transportServerFactoryList = new ArrayList<ITransportServerFactory>();

    static{
        ServiceLoader<ITransportServerFactory> transportServerFactorys = ServiceLoader.load(ITransportServerFactory.class);
        for(ITransportServerFactory transportServerFactory : transportServerFactorys){
            transportServerFactoryList.add(transportServerFactory);
        }
    }

    private TransportServerFactoryProvider(){}

    public ITransportServerFactory lookup(String transportType){
        for(ITransportServerFactory factory : transportServerFactoryList){
            if(null != factory && factory.accept(transportType)){
                return factory;
            }
        }
        return null;
    }

    public ITransportServerFactory lookup(TransportModel model){
        return lookup(model.getType());
    }
}
