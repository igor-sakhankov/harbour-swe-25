package com.harbour.spring;

import org.springframework.stereotype.Component;

@Component
public class Coffee {
    public Coffee() {
        System.out.println("Coffee constructor");
    }
}
