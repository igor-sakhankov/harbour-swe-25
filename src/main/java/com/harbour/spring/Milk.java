package com.harbour.spring;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Milk {
    @Getter
    @Autowired
    private String fatContent;

    public Milk() {
        System.out.println("Milk constructor");
    }
}
