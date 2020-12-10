package com.assignment.shopping.cart.repository;

import java.util.List;

public interface ProductRepository {
    public List<String> getProductList();

    public String getProductNameById(int productId);

    public int getProductIdByName(String productName);
}
