package com.harbour;

import com.harbour.spring.Capuccino;
import com.harbour.spring.Coffee;
import com.harbour.spring.Milk;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.harbour")
@Configuration
public class BarristaConfg {

    @Bean
    Capuccino decafCapuccino(Coffee coffee, Milk skimMilk) {
        Capuccino capuccino = new Capuccino(coffee);
        capuccino.setMilk(skimMilk());
        return capuccino;
    }

    @Bean
    String fatContent() {
        return "2%";
    }

    @Bean
    Milk skimMilk() {
        System.out.println("Creating milk");
        return new Milk();
    }
}
