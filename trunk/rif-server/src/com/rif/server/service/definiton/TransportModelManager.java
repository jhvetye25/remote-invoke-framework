package com.rif.server.service.definiton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransportModelManager {
    public static TransportModelManager INSTANCE = new TransportModelManager();
    private Map<String, TransportModel> models = new HashMap<String, TransportModel>();

    private TransportModelManager(){}

    public void register(TransportModel model){
        models.put(model.getId(), model);
    }

    public void register(List<TransportModel> models){
        for(TransportModel model : models){
            register(model);
        }
    }

    public void unRegister(TransportModel model){
        models.remove(model);
    }

    public Map<String, TransportModel> lookup(){
        return models;
    }

    public TransportModel lookup(String transportId){
        return models.get(transportId);
    }

    public TransportModel lookup(TransportModel model){
        return models.get(model.getId());
    }

    public void destroy(){
        models.clear();
    }
}
