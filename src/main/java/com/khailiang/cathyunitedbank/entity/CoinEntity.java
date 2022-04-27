package com.khailiang.cathyunitedbank.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "COIN")
public class CoinEntity {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COIN_ID")
    private Integer coinId;

    public Integer getCoinId() {
        return this.coinId;
    }

    public void setCoinId(Integer coinId) {
        this.coinId = coinId;
    }

	@Column(name = "COIN_NAME")
    private String coinName;

    public String getCoinName() {
        return this.coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }
   
    @Column(name = "COIN_CODE")
    private String coinCode;

    public String getCoinCode() {
        return this.coinCode;
    }

    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }

    @Column(name = "COIN_UPDATE_TIME")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
    private Date coinUpdateTime;

    public Date getCoinUpdateTime() {
        return this.coinUpdateTime;
    }

    public void setCoinUpdateTime(Date coinUpdateTime) {
        this.coinUpdateTime = coinUpdateTime;
    }

    @Column(name = "COIN_RATE")
    private BigDecimal coinRate;

    public BigDecimal getCoinRate() {
        return this.coinRate;
    }

    public void setCoinRate(BigDecimal coinRate) {
        this.coinRate = coinRate;
    }

    @Column(name = "COIN_DESCRIPTION")
    private String coinDescription;

    public String getCoinDescription() {
        return this.coinDescription;
    }

    public void setCoinDescription(String coinDescription) {
        this.coinDescription = coinDescription;
    }

}
