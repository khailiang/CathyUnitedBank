package com.khailiang.cathyunitedbank.service;

import java.util.List;

import com.khailiang.cathyunitedbank.dao.CoinRepo;
import com.khailiang.cathyunitedbank.entity.CoinDeskModel;
import com.khailiang.cathyunitedbank.entity.CoinEntity;
import com.khailiang.cathyunitedbank.entity.ResponseModel;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

public interface CoinService{
    public CoinDeskModel getCoinDeskAPI();
    public CoinDeskModel getConvertCoinDeskApi();
    public ResponseModel findAllCoin();
    public ResponseModel findCoin(int id);
    public ResponseModel addCoin(CoinEntity model);
    public ResponseModel modifyCoin(CoinEntity model);
    public ResponseModel deleteCoin(int id);
    public int checkIntegerNull(Integer number);
}
