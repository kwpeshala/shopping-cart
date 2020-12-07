package com.assignment.shopping.cart.service.impl;

import com.assignment.shopping.cart.entity.User;
import com.assignment.shopping.cart.repository.BankRepository;
import com.assignment.shopping.cart.repository.GenderRepository;
import com.assignment.shopping.cart.repository.UserRepository;
import com.assignment.shopping.cart.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BankRepository bankRepository;
    private final GenderRepository genderRepository;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BankRepository bankRepository, GenderRepository genderRepository){
        this.userRepository = userRepository;
        this.bankRepository = bankRepository;
        this.genderRepository = genderRepository;
    }

    @Override
    public List<User> getUsers(){

        return userRepository.getUserList();
    }

    @Override
    public void addNewUser(User user){
        String bankId = bankRepository.getBankIdByName(user.getBankName());
        String genderId = genderRepository.getGenderIdByName(user.getGender());

        logger.debug("Searching genderId and bankId for user [{}]", user.getFirstName());
        user.setGenderId(genderId);
        user.setBankId(bankId);
        userRepository.createUser(user);


    }

}
