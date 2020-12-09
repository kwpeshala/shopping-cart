package com.assignment.shopping.cart.entity;

public class Carton {
    private int cartonId;
    private double cartonPrice;
    private int productId;
    private int unitsPerCarton;

    public int getCartonId() {
        return cartonId;
    }

    public void setCartonId(int cartonId) {
        this.cartonId = cartonId;
    }

    public double getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUnitsPerCarton() {
        return unitsPerCarton;
    }

    public void setUnitsPerCarton(int unitsPerCarton) {
        this.unitsPerCarton = unitsPerCarton;
    }
}
