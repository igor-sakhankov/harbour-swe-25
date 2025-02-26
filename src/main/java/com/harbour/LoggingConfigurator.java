package com.harbour;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoggingConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object object) {
        System.out.println("LoggingConfigurator for object: " + object.getClass().getName());
    }
}
