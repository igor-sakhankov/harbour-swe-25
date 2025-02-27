package com.harbour.spring;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDepsA {

    @Setter
    @Autowired
    private CircularDepsB b;


    public void a() {
        System.out.println("a");
    }
}
