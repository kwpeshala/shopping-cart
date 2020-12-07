package com.assignment.shopping.cart.repository;

import java.util.List;

public interface BankRepository {
    public List<String> getBankList();
    public String getBankIdByName(String bankName);
}
