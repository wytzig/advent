package com.wytzig.lw.nl.advent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AdventApplication {

    Administrator administrator;

    public static void main(String[] args) {
        SpringApplication.run(AdventApplication.class, args);
        AdventApplication apl = new AdventApplication();
        apl.run();
    }

    public void run() {
        administrator = new Administrator();
        administrator.day1();
    }
}
