package com.harbour.spring;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Capuccino {
    private final Coffee coffee;
    @Autowired
    @Setter
    private Milk milk;

    public Capuccino(Coffee coffee) {
        this.coffee = coffee;
    }

    public void getInformation() {
        System.out.println("This is a capuccino made from " + coffee + " and " + milk);
    }
}
