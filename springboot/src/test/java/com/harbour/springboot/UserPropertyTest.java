package com.harbour.springboot;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import net.jqwik.api.statistics.Statistics;
import net.jqwik.api.statistics.StatisticsReport;
import org.assertj.core.api.Assertions;

class UserPropertyTest {

    @Property(tries = 1000)
    void validAgesShouldBeAccepted(@ForAll @IntRange(min = 19, max = 64) int age) {
        // Arrange
        User user = new User();
        
        // Act
        user.setAge(age);
        
        // Assert
        Assertions.assertThat(user.getAge())
            .as("Age should be between 19 and 64")
            .isEqualTo(age);
            
        // Collect statistics
        Statistics.collect(age);
    }
    
    @Property(tries = 1000)
    void invalidAgesShouldBeRejected(@ForAll("invalidAges") int invalidAge) {
        // Arrange
        User user = new User();
        
        // Act & Assert
        Assertions.assertThatThrownBy(() -> user.setAge(invalidAge))
            .as("Setting invalid age %d should throw IllegalArgumentException", invalidAge)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Age must be between 19 and 64");
    }
    
    @Provide
    Arbitrary<Integer> invalidAges() {
        // Generate ages that are either <= 18 or >= 65
        return Arbitraries.integers()
            .filter(age -> age <= 18 || age >= 65);
    }
    
    @Example
    void boundaryValuesTest() {
        User user = new User();
        
        // Just below lower boundary
        Assertions.assertThatThrownBy(() -> user.setAge(18))
            .isInstanceOf(IllegalArgumentException.class);
            
        // Lower boundary
        user.setAge(19);
        Assertions.assertThat(user.getAge()).isEqualTo(19);
        
        // Upper boundary
        user.setAge(64);
        Assertions.assertThat(user.getAge()).isEqualTo(64);
        
        // Just above upper boundary
        Assertions.assertThatThrownBy(() -> user.setAge(65))
            .isInstanceOf(IllegalArgumentException.class);
    }
}