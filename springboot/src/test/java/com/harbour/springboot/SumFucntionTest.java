package com.harbour.springboot;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SumFucntionTest {
    public static int sum(int a, int b) {
	return a + b;
    }

    @ParameterizedTest
    @CsvSource({"0,3, 3", "2, 3, 5"})
    void testSum(int a, int b, int expected) {
	assertThat(sum(a, b)).isEqualTo(expected);
    }

    @Property
    void testSumProperty(@ForAll int a, @ForAll int b) {
	assertThat(sum(a, b)).isEqualTo(a + b);
    }
}
