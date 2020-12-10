package com.assignment.shopping.cart.service;

import com.assignment.shopping.cart.entity.PriceListApi;

import java.util.List;

public interface PriceCalculator {
    public List<PriceListApi> getPriceList();

    public PriceListApi getPriceByProductIdAndUnits();

    public double getTotalPrice(String productName, String purchaseType, String numberOfItems);

}
