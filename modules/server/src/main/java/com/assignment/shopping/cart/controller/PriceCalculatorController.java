package com.assignment.shopping.cart.controller;

import com.assignment.shopping.cart.service.PriceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceCalculatorController {
    private final PriceCalculator priceCalculator;

    @Autowired
    public PriceCalculatorController(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }

    @GetMapping(value = "/api/calculator")
    @ResponseBody
    public double totalPrice(@RequestParam String productName, @RequestParam String purchaseType, @RequestParam String numberOfItems) {
        return priceCalculator.getTotalPrice(productName, purchaseType, numberOfItems);
    }
}
