package com.khailiang.cathyunitedbank.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.khailiang.cathyunitedbank.dao.CoinRepo;
import com.khailiang.cathyunitedbank.entity.CoinDeskCoinModel;
import com.khailiang.cathyunitedbank.entity.CoinDeskModel;
import com.khailiang.cathyunitedbank.entity.CoinDeskTimeModel;
import com.khailiang.cathyunitedbank.entity.CoinEntity;
import com.khailiang.cathyunitedbank.entity.ResponseModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


@Service
public class CoinServiceImpl implements CoinService{
 
    @Autowired
    private CoinRepo coinRepo;
    
    private final String coinDeskURL = "https://api.coindesk.com/v1/bpi/currentprice.json";
    private final String SUCCESS = "SUCCESS";

    @Override
    public CoinDeskModel getCoinDeskAPI(){
        return callCoinDeskAPI();
    }

    @Override
    public CoinDeskModel getConvertCoinDeskApi(){
        List<CoinEntity> coinList = new ArrayList<CoinEntity>();
        CoinDeskModel model = new CoinDeskModel();
        coinList = coinRepo.findAll();
        model = callCoinDeskAPI();
        if(model!=null && coinList.isEmpty()==false)
        {
            
            if(model.getTime()!=null){
                CoinDeskTimeModel timeModel = model.getTime();
                try{
                    SimpleDateFormat finalFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
                    Date updateDate =  new SimpleDateFormat("MMM d, yyyy HH:mm:ss z").parse(timeModel.getUpdated());
                    timeModel.setUpdated(finalFormatter.format(updateDate));
                   
                    Date isoDate =  new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").parse(timeModel.getUpdatedISO());
                    timeModel.setUpdatedISO(finalFormatter.format(isoDate));
                    
                    Date ukDate =  new SimpleDateFormat("MMM d, yyyy 'at' HH:mm z") .parse(timeModel.getUpdateduk());
                    timeModel.setUpdateduk(finalFormatter.format(ukDate));
                }catch(Exception e){
                    System.out.println("date parse error");
                }
            }
            if(model.getBpi()!=null){
                for (CoinEntity entity : coinList)
                {
                    if(model.getBpi().get(entity.getCoinCode().toUpperCase())!=null)
                    {
                        CoinDeskCoinModel coinModel = model.getBpi().get(entity.getCoinCode().toUpperCase());
                        coinModel.setChineseName(entity.getCoinName());
                        model.getBpi().put(coinModel.getCode(), coinModel);
                    }
                }
            }
        }
        return model;
    }

    private CoinDeskModel callCoinDeskAPI(){
        CoinDeskModel coin = new CoinDeskModel();
        ObjectMapper mapper = new ObjectMapper();  
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet getURL = new HttpGet(coinDeskURL);
        CloseableHttpResponse  response = null;

        try{
            
            response = httpclient.execute(getURL);
            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println(responseBody);
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == 200){
                coin = mapper.readValue(responseBody, CoinDeskModel.class);
            }
        }catch(Exception e){
            System.out.println("Exception "+e.getStackTrace());
        }finally{
            try{
                response.close();
            }catch(IOException e){
                System.out.println("IOException");
            }
        }
        return coin;
    }
    
    @Override
    @Transactional(readOnly = true)
    public ResponseModel findAllCoin(){
        ResponseModel response = new ResponseModel();
        response.setStatus(SUCCESS);
        response.setModel(coinRepo.findAll());
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseModel findCoin(int id){
        ResponseModel response = new ResponseModel();
        List<CoinEntity> coinList = new ArrayList<CoinEntity>();
        if(checkIsRecordExist(id)){
            response.setStatus(SUCCESS);
            coinList.add(coinRepo.findById(id).get());
            response.setModel(coinList);
        }
        return response;
    }

    @Override
    @Transactional
    public ResponseModel addCoin(CoinEntity model){
        ResponseModel response = new ResponseModel();
        String pattern = "yyyy/MM/dd HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String now = formatter.format(new Date());
        response.setStatus(SUCCESS);
        model.setCoinUpdateTime(new Date(now));
        CoinEntity coin = coinRepo.save(model);
        List<CoinEntity> coinList = new ArrayList<CoinEntity>();
        coinList.add(coin);
        response.setModel(coinList);
        return response;
    }

    @Override
    @Transactional
    public ResponseModel modifyCoin(CoinEntity model){
        ResponseModel response = new ResponseModel();
        if(checkIsRecordExist(model.getCoinId())){
            coinRepo.saveAndFlush(model);
            response = findCoin(model.getCoinId());
        }
        return response;
    }

    @Override
    @Transactional
    public ResponseModel deleteCoin(int id){
        ResponseModel response = new ResponseModel();
        if(checkIsRecordExist(id)){
            response = findCoin(id);
            coinRepo.deleteById(id);
        }
        return response;
    }

    @Override
    public int checkIntegerNull(Integer number){
        int value = 1;
        if(number!=null){
            value = number.intValue();
        }
        return value;
    }

    private boolean checkIsRecordExist(int id){
        boolean result = false;
        if(coinRepo.existsById(id)){
            result = true;
        }
        return result;
    }
}