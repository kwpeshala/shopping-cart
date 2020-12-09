package com.assignment.shopping.cart.controller;

import com.assignment.shopping.cart.entity.Product;
import com.assignment.shopping.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "/api/product")
    public List<String> getListOfProducts(){
        return productService.getProductList();
    }
}
