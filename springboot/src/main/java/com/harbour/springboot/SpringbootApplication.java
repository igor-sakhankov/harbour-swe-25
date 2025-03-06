package com.harbour.springboot;

import jakarta.servlet.Filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import java.time.Clock;


@Slf4j
@SpringBootApplication
public class SpringbootApplication {

    @Bean
    public Clock clock() {
	return Clock.systemDefaultZone();
    }

    @Bean
    public Filter shallowEtagHeaderFilter() {
	ShallowEtagHeaderFilter shallowEtagHeaderFilter = new ShallowEtagHeaderFilter();
	shallowEtagHeaderFilter.setWriteWeakETag(true);
	return shallowEtagHeaderFilter;
    }

    public static void main(String[] args) {

	log.info("SpringbootApplication started");
	log.info(System.currentTimeMillis() + " ");

	System.currentTimeMillis();
	SpringApplication.run(SpringbootApplication.class, args);

	System.out.println("Hello world!");
    }

}
