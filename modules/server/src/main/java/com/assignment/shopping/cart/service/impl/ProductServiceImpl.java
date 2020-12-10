package com.assignment.shopping.cart.service.impl;

import com.assignment.shopping.cart.repository.ProductRepository;
import com.assignment.shopping.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<String> getProductList() {
        return productRepository.getProductList();
    }
}
