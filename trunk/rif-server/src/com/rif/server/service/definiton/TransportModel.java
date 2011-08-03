package com.rif.server.service.definiton;

import java.io.Serializable;

public class TransportModel implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 4283261120035298621L;
    private String id;
    private String type;
    private String url;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

}
