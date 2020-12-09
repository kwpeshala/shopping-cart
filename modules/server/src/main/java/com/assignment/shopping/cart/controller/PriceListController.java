package com.assignment.shopping.cart.controller;

import com.assignment.shopping.cart.entity.PriceListApi;
import com.assignment.shopping.cart.service.PriceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PriceListController {

    private final PriceCalculator priceCalculator;

    @Autowired
    public PriceListController(PriceCalculator priceCalculator){
        this.priceCalculator = priceCalculator;
    }

    @GetMapping(value = "/price/list")
    public List<PriceListApi> getPriceList(){
        return priceCalculator.getPriceList();
    }

}
