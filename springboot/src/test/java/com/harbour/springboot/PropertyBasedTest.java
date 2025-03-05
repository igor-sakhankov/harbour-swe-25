package com.harbour.springboot;

import net.jqwik.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class PropertyBasedTest {

    @Property
    boolean sumOfTwoNumbersIsCommutative(@ForAll int a, @ForAll int b) {
        return (a + b) == (b + a);
    }
}