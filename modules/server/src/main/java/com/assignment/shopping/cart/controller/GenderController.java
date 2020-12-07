package com.assignment.shopping.cart.controller;

import com.assignment.shopping.cart.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class GenderController {
    private final GenderService genderService;

    @Autowired
    public GenderController(GenderService genderService){
        this.genderService = genderService;
    }

    @GetMapping(value = "/gender")
    public List<String> getGenderList(){
        return genderService.getGender();
    }
}