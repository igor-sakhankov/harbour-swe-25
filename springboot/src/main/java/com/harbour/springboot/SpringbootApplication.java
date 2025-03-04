package com.harbour.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {

	log.info("SpringbootApplication started");
	log.info(System.currentTimeMillis() + " ");

	System.currentTimeMillis();
	SpringApplication.run(SpringbootApplication.class, args);
    }

}
