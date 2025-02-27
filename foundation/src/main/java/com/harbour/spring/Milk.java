package com.harbour.spring;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;


public class Milk {
    @Getter
    @Autowired
    private String fatContent;

    public Milk() {
        System.out.println("Milk constructor");
    }
}
