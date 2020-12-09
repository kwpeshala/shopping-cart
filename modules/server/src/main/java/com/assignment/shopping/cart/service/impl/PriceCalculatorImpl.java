package com.assignment.shopping.cart.service.impl;

import com.assignment.shopping.cart.entity.Carton;
import com.assignment.shopping.cart.entity.PriceListApi;
import com.assignment.shopping.cart.repository.CartonRepository;
import com.assignment.shopping.cart.repository.ProductRepository;
import com.assignment.shopping.cart.service.PriceCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceCalculatorImpl implements PriceCalculator {
    private final CartonRepository cartonRepository;
    private final ProductRepository productRepository;
    private final Logger logger = LoggerFactory.getLogger(PriceCalculatorImpl.class);
    private double increasePercentage = 30;
    private double discountPercentage = 10;

    @Autowired
    public PriceCalculatorImpl(CartonRepository cartonRepository, ProductRepository productRepository) {
        this.cartonRepository = cartonRepository;
        this.productRepository = productRepository;
    }


    @Override
    public List<PriceListApi> getPriceList() {
        logger.info("requesting for priceList");
        List<Carton> listOfCarton = cartonRepository.getCartonList();
        List<PriceListApi> priceListApis = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            for (Carton carton : listOfCarton) {
                priceListApis.add(getPriceListApi(i, carton.getCartonPrice(), carton.getUnitsPerCarton(), carton.getProductId()));
            }
        }


        return priceListApis;
    }

    @Override
    public PriceListApi getPriceByProductIdAndUnits() {
        return null;
    }

    @Override
    public double getTotalPrice(String productName, String purchaseType, String numberOfItems) {
        logger.info("Request for calculator");
        int noOfItems = Integer.parseInt(numberOfItems);

        if (purchaseType.toLowerCase().equals("carton")){
            return getTotalPriceByCarton(noOfItems, productName);
        } else {
            return getTotalPriceByUnit(noOfItems,productName);
        }
    }

    private PriceListApi getPriceListApi(int numberOfUnits, double cartonPrice, int unitsPerCarton, int productId) {
        String productName = productRepository.getProductNameById(productId);

        double price;

        double pricePerSingleUnit = cartonPrice / unitsPerCarton * (1 + increasePercentage / 100);

        if (numberOfUnits % unitsPerCarton == 0) {
            if (numberOfUnits / unitsPerCarton >= 3) {
                price = (int)(numberOfUnits / unitsPerCarton) * cartonPrice * (1 - discountPercentage / 100);
            } else {
                price = (int)(numberOfUnits / unitsPerCarton) * cartonPrice;
            }
        } else {
            int numberOfSingleUnits = numberOfUnits % unitsPerCarton;
            double totalSingleUnitsPrice = numberOfSingleUnits * pricePerSingleUnit;
            int numberOfCartons = (int) (numberOfUnits / unitsPerCarton);
            double totalCartonPrice = numberOfCartons * cartonPrice;
            price = totalCartonPrice + totalSingleUnitsPrice;

            if (numberOfCartons >= 3) {
                price = price * (1 - discountPercentage / 100);
            }

        }

        PriceListApi priceListApi = new PriceListApi();
        priceListApi.setNumberOfUnits(numberOfUnits);
        priceListApi.setProductName(productName);
        priceListApi.setPrice(price);

        return priceListApi;
    }

    private double getTotalPriceByCarton(int numberOfCartons, String productName){
        int productId = productRepository.getProductIdByName(productName);
        Carton carton = cartonRepository.getCartonByProductId(productId);
        if (numberOfCartons>=3){
            return numberOfCartons* carton.getCartonPrice()*(1-discountPercentage/100);

        }else {
            return  numberOfCartons * carton.getCartonPrice();
        }
    }

    private double getTotalPriceByUnit(int numberOfUnits, String productName){
        int productId = productRepository.getProductIdByName(productName);
        Carton carton = cartonRepository.getCartonByProductId(productId);
        PriceListApi priceListApi = getPriceListApi(numberOfUnits, carton.getCartonPrice(), carton.getUnitsPerCarton(), productId);
        return  priceListApi.getPrice();
    }

}
