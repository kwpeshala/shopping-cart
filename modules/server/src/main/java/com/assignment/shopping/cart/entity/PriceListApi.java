package com.assignment.shopping.cart.entity;

public class PriceListApi {
    private String productName;
    private int numberOfUnits;
    private double price;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOdUnits) {
        this.numberOfUnits = numberOdUnits;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
