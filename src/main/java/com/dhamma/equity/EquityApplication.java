package com.dhamma.equity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EquityApplication {

    public static void main(String[] args) {
        SpringApplication.run(EquityApplication.class, args);
    }
}
