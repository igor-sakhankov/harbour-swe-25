package com.harbour.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {

        List.of(1,2,4).forEach(System.out::println);
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
