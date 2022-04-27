package com.khailiang.cathyunitedbank.restc;

import com.khailiang.cathyunitedbank.entity.CoinDeskModel;
import com.khailiang.cathyunitedbank.service.CoinService;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/normal")
public class CoinRestController {

    @Autowired
    private CoinService coinService;
    
    @RequestMapping(value = "/get-coindesk-api", method = RequestMethod.POST)
    public CoinDeskModel getCoinDeskApi(){
        return coinService.getCoinDeskAPI();
    }

    @RequestMapping(value = "/get-convert-coindesk-api", method = RequestMethod.POST)
    public CoinDeskModel getConvertCoinDeskApi(){
        return coinService.getConvertCoinDeskApi();
    }
}
