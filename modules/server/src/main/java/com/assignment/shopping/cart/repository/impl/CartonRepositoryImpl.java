package com.assignment.shopping.cart.repository.impl;

import com.assignment.shopping.cart.entity.Carton;
import com.assignment.shopping.cart.repository.CartonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CartonRepositoryImpl implements CartonRepository {
    private final JdbcTemplate jdbcTemplate;
    private final String SELECT_CARON_LIST="SELECT * FROM carton;";
    private final String SELECT_CARON_BY_PRODUCT_ID="SELECT * FROM carton WHERE product_id=?;";

    @Autowired
    public CartonRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Carton> getCartonList() {
        return jdbcTemplate.query(SELECT_CARON_LIST, new RowMapper<Carton>() {
            @Override
            public Carton mapRow(ResultSet resultSet, int i) throws SQLException {
                return new CartonRowMapper().mapRow(resultSet, i);
            }
        });
    }

    @Override
    public Carton getCartonByProductId(int productId) {
        return jdbcTemplate.queryForObject(SELECT_CARON_BY_PRODUCT_ID, new RowMapper<Carton>() {
            @Override
            public Carton mapRow(ResultSet resultSet, int i) throws SQLException {
                Carton carton = new CartonRowMapper().mapRow(resultSet,i);
                return carton;
            }
        }, productId);
    }
}
