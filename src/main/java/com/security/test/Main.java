package com.security.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by asandoval on 22/09/2017.
 */

@SpringBootApplication
@ComponentScan(
        basePackages = {
                "com.security.test.services",
                "com.security.test.controllers",
                "com.security.test.security"
        }
)
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
