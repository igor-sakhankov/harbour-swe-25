package com.harbour.detour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {

    @Test
    void calculatePrice() {
        PriceCalculator priceCalculator = new PriceCalculator(new MockedVatResolver(0.2));
        assertEquals(120, priceCalculator.calculatePrice(100));
    }
}