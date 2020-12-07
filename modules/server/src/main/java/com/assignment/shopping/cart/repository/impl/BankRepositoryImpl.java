package com.assignment.shopping.cart.repository.impl;

import com.assignment.shopping.cart.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class BankRepositoryImpl implements BankRepository {
    private final JdbcTemplate jdbcTemplate;
    private final String SELECT_BANK ="SELECT DISTINCT bank_name FROM bank_info;";
    private final String SELECT_BANK_ID_BY_NAME="SELECT bank_id FROM bank_info WHERE bank_name=?;";

    @Autowired
    public BankRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> getBankList() {
        List<String> bankList = jdbcTemplate.queryForList(SELECT_BANK, String.class);

        if (bankList!=null && (!bankList.isEmpty())) {
            return bankList;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public String getBankIdByName(String bankName) {
        String bankId = jdbcTemplate.queryForObject(SELECT_BANK_ID_BY_NAME, new String[]{bankName}, String.class);

        if (bankId!=null && !bankId.equals("")) {
            return bankId;
        } else {
            return "";
        }
    }
}
