package com.assignment.shopping.cart.controller;

import com.assignment.shopping.cart.entity.User;
import com.assignment.shopping.cart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRegistrationController {
    private final UserService userService;

    @Autowired
    public UserRegistrationController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<User> findUsers(){
        return userService.getUsers();
    }

    @GetMapping(value = "/")
    public String getString(){
        return "hello world";
    }

    @PostMapping(path = "/add/user", consumes = "application/json", produces = "application/json")
    public void addMember(@RequestBody User user) {
        userService.addNewUser(user);
    }
}
