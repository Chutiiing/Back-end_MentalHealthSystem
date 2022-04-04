package com.chutiiing.backendsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BackEndSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndSystemApplication.class, args);
    }

}
