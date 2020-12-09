package com.assignment.shopping.cart.repository;

import com.assignment.shopping.cart.entity.Carton;

import java.util.List;

public interface CartonRepository {
    public List<Carton> getCartonList();
    public Carton getCartonByProductId(int productId);
}
