package com.assignment.shopping.cart.repository;

import java.util.List;

public interface GenderRepository {
    public List<String> getGenderList();
    public String getGenderIdByName(String gender);
}
