package com.assignment.shopping.cart.service;


import com.assignment.shopping.cart.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public void addNewUser(User user);
}
