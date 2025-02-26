package com.harbour.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Capuccino2 {
    private final Coffee coffee;
    @Autowired
    private Milk milk;

    public Capuccino2(Coffee coffee) {
        this.coffee = coffee;
    }

    public void getInformation() {
        System.out.println("This is a capuccino 2 made from " + coffee + " and " + milk);
    }
}
