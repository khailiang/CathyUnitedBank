package com.khailiang.cathyunitedbank.entity;

import java.util.List;

public class ResponseModel {
    
    private String status = "FAILED";
    private List<CoinEntity> model;

    public List<CoinEntity> getModel() {
        return this.model;
    }

    public void setModel(List<CoinEntity> model) {
        this.model = model;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
