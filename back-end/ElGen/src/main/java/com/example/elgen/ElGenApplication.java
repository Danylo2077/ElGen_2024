package com.example.elgen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElGenApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElGenApplication.class, args);
        System.out.print("Hello, ElGen!");
    }

}
