package com.assignment.shopping.cart.controller;

import com.assignment.shopping.cart.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {
    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService){
        this.bankService = bankService;
    }

    @GetMapping(value = "/bank")
    public List<String> getBankNames(){
        return bankService.getBankNames();
    }
}
