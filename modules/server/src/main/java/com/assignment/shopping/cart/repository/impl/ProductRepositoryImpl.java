package com.assignment.shopping.cart.repository.impl;

import com.assignment.shopping.cart.entity.Product;
import com.assignment.shopping.cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    private final String SELECT_PRODUCTS ="SELECT product_name FROM product;";
    private final String SELECT_PRODUCT_NAME_BY_ID = "SELECT product_name FROM product WHERE product_id=?;";
    private final String SELECT_PRODUCT_ID_BY_NAME = "SELECT product_id FROM product WHERE product_name=?;";


    @Autowired
    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> getProductList() {
       return jdbcTemplate.queryForList(SELECT_PRODUCTS, String.class);
    }

    @Override
    public String getProductNameById(int productId) {
        try {
            String productName = jdbcTemplate.queryForObject(SELECT_PRODUCT_NAME_BY_ID,  String.class, productId);

            if (productName!=null && !productName.equals("")) {
                return productName;
            } else {
                return "";
            }
        } catch (DataAccessException e) {
            return "";
        }
    }

    @Override
    public int getProductIdByName(String productName) {
        try {
            String productId =  jdbcTemplate.queryForObject(SELECT_PRODUCT_ID_BY_NAME,  String.class, productName);
            return Integer.parseInt(productId);
        } catch (DataAccessException e) {
            return 0;
        }
    }
}
