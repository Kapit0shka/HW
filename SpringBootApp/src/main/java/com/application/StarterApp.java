package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class StarterApp {

    public static void main(String[] args) {
        SpringApplication.run(StarterApp.class);
    }
}
