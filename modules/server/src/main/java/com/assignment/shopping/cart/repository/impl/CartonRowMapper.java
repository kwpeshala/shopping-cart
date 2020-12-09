package com.assignment.shopping.cart.repository.impl;

import com.assignment.shopping.cart.entity.Carton;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartonRowMapper implements RowMapper<Carton> {
    @Override
    public Carton mapRow(ResultSet resultSet, int i) throws SQLException {
        Carton carton = new Carton();
        carton.setCartonId(resultSet.getInt("carton_id"));
        carton.setCartonPrice(resultSet.getDouble("carton_price"));
        carton.setProductId(resultSet.getInt("product_id"));
        carton.setUnitsPerCarton(resultSet.getInt("units_per_carton"));
        return carton;
    }
}
