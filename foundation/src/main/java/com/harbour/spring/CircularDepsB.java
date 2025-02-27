package com.harbour.spring;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDepsB {
    @Autowired
    @Setter
    private CircularDepsA a;

    public void b() {
        System.out.println("b");
    }
}
