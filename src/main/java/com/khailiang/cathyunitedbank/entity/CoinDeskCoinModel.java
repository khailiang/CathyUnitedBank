package com.khailiang.cathyunitedbank.entity;

import java.math.BigDecimal;

public class CoinDeskCoinModel {
    private String code;
    private String symbol;
    private String rate;

    public String getRate() {
        return this.rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    private String description;
    private BigDecimal rate_float;
    private String chineseName;

    public String getChineseName() {
        return this.chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public BigDecimal getRate_float() {
        return this.rate_float;
    }

    public void setRate_float(BigDecimal rate_float) {
        this.rate_float = rate_float;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
