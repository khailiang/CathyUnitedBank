package com.khailiang.cathyunitedbank.restc;

import java.util.List;

import com.khailiang.cathyunitedbank.entity.CoinEntity;
import com.khailiang.cathyunitedbank.entity.ResponseModel;
import com.khailiang.cathyunitedbank.service.CoinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db")
public class DbBasicController {

    @Autowired
    private CoinService coinService;

    @RequestMapping(value = "/get-all-coin", method = RequestMethod.GET)
    public ResponseModel getAllRecord(){
        return coinService.findAllCoin();
    }

    @RequestMapping(value = "/get-coin", method = RequestMethod.GET)
    public ResponseModel getRecord(@RequestParam Integer id){
        int number = coinService.checkIntegerNull(id);
        return coinService.findCoin(number);
    }

    @RequestMapping(value = "/remove-coin", method = RequestMethod.DELETE)
    public ResponseModel removeRecord(@RequestParam Integer id){
        int number = coinService.checkIntegerNull(id);
        return coinService.deleteCoin(number);
    }

    @RequestMapping(value = "/modify-coin", method = RequestMethod.PUT)
    public ResponseModel modifyRecord(@RequestBody CoinEntity model){
        return coinService.modifyCoin(model);
    }

    @RequestMapping(value = "/add-coin", method = RequestMethod.POST)
    public ResponseModel addRecord(@RequestBody CoinEntity model){
        return coinService.addCoin(model);
    }
}
