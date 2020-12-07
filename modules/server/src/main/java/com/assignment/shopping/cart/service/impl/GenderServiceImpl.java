package com.assignment.shopping.cart.service.impl;

import com.assignment.shopping.cart.repository.GenderRepository;
import com.assignment.shopping.cart.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {
    private final GenderRepository genderRepository;

    @Autowired
    public GenderServiceImpl(GenderRepository genderRepository){
        this.genderRepository = genderRepository;
    }

    public List<String> getGender(){
        return genderRepository.getGenderList();
    }

}
