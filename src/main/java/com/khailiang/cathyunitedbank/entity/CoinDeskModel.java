package com.khailiang.cathyunitedbank.entity;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) 
public class CoinDeskModel {

    
    private CoinDeskTimeModel time;
    private String disclaimer;
    private String chartName;
    private HashMap<String, CoinDeskCoinModel> bpi;

    public HashMap<String,CoinDeskCoinModel> getBpi()
    {
		return this.bpi;
	}

    public void setBpi(HashMap<String,CoinDeskCoinModel> map)
    {
		this.bpi = map;
	}

    public CoinDeskTimeModel getTime() {
        return this.time;
    }

    public void setTime(CoinDeskTimeModel time) {
        this.time = time;
    }

    public String getDisclaimer() {
        return this.disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getChartName() {
        return this.chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }
}
