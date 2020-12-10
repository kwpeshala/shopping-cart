package com.assignment.shopping.cart.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PriceCalculatorImplTest {

    @Autowired
    PriceCalculatorImpl priceCalculator;

    @Test
    public void priceCalculatorTest(){
        double totalPrice = priceCalculator.getTotalPrice("Penguin-ears", "carton", "5");
        assertThat(totalPrice).isEqualTo(787.50);

        double totalPriceWithUnits = priceCalculator.getTotalPrice("Penguin-ears", "unit", "5");
        assertThat(totalPriceWithUnits).isEqualTo(56.88);

        double totalPriceUnitsMoreThanCartonSize = priceCalculator.getTotalPrice("Penguin-ears", "unit", "25");
        assertThat(totalPriceUnitsMoreThanCartonSize).isEqualTo(231.88);

        double totalPriceUnitsMoreThanThreeCartons = priceCalculator.getTotalPrice("Penguin-ears", "unit", "65");
        assertThat(totalPriceUnitsMoreThanThreeCartons).isEqualTo(523.69);

        double totalPriceUnitsThreeCartons = priceCalculator.getTotalPrice("Penguin-ears", "unit", "60");
        assertThat(totalPriceUnitsThreeCartons).isEqualTo(472.50);

        double totalPriceThreeCartons = priceCalculator.getTotalPrice("Penguin-ears", "carton", "3");
        assertThat(totalPriceThreeCartons).isEqualTo(472.50);

        double totalPriceLesserThanThreeCartons = priceCalculator.getTotalPrice("Penguin-ears", "carton", "2");
        assertThat(totalPriceLesserThanThreeCartons).isEqualTo(350.00);
    }


}
