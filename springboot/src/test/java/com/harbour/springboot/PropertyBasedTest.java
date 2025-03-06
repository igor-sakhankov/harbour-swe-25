package com.harbour.springboot;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

class PropertyBasedTest {

    @Property
    boolean sumOfTwoNumbersIsCommutative(@ForAll int a, @ForAll int b) {
	return (a + b) == (b + a);
    }
}