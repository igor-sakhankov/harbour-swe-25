package com.harbour.selfwrittendi;

import lombok.SneakyThrows;

public class LoggingConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object object) {
        System.out.println("LoggingConfigurator for object: " + object.getClass().getName());
    }
}
