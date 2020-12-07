package com.assignment.shopping.cart.repository;

import com.assignment.shopping.cart.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> getUserList();
    public void createUser(User user);
}
