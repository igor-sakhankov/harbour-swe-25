package com.harbour.springboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PriceCalculatorTest {

    @ParameterizedTest
    @CsvSource({
	    "100, 0.2, 120",
    })
    void testCalculateTax(double price, double vat, double expected) {
	PriceCalculator priceCalculator = new PriceCalculator();
	var result =  priceCalculator.calculatePiceWithVat(price, vat);

	assertEquals(result, expected);
    }
}
