package com.khailiang.cathyunitedbank.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CoinDeskTimeModel {
    
    private String updated;
    private String updatedISO;
    private String updateduk;

    public String getUpdated() {
        return this.updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getUpdatedISO() {
        return this.updatedISO;
    }

    public void setUpdatedISO(String updatedISO) {
        this.updatedISO = updatedISO;
    }

    public String getUpdateduk() {
        return this.updateduk;
    }

    public void setUpdateduk(String updateduk) {
        this.updateduk = updateduk;
    }

}
