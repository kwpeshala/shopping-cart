package com.assignment.shopping.cart.repository.impl;

import com.assignment.shopping.cart.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class GenderRepositoryImpl implements GenderRepository {
    private final JdbcTemplate jdbcTemplate;
    private final String SELECT_GENDER ="SELECT gender_name FROM gender;";
    private final String SELECT_GENDE_ID_BY_NAME="SELECT gender_id FROM gender WHERE gender_name=?;";

    @Autowired
    public GenderRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> getGenderList() {
        List<String> genderList = jdbcTemplate.queryForList(SELECT_GENDER, String.class);

        if (genderList!=null && (!genderList.isEmpty())) {
            return genderList;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public String getGenderIdByName(String gender) {
        String genderId = jdbcTemplate.queryForObject(SELECT_GENDE_ID_BY_NAME, new String[]{gender}, String.class);

        if (genderId!=null && !genderId.equals("")) {
            return genderId;
        } else {
            return "";
        }
    }
}
