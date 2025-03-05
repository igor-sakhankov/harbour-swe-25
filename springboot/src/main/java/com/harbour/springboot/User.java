package com.harbour.springboot;

import lombok.Getter;

public class User {
    @Getter
    private int age;
    @Getter
    private String name;

    /**
     * Sets the age of the user with validation.
     * Age must be between 19 and 64 (inclusive).
     *
     * @param age the age to set
     * @throws IllegalArgumentException if age is not within valid range
     */
    public void setAge(int age) {
        if (age <= 18 || age >= 65) {
            throw new IllegalArgumentException("Age must be between 19 and 64");
        }
        this.age = age;
    }

    /**
     * Sets the user's name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}

