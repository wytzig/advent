package com.wytzig.lw.nl.advent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AdventApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdventApplication.class, args);
        AdventApplication apl = new AdventApplication();
        apl.run();
    }

    public void run() {
        Administrator administrator = new Administrator();
        administrator.init();
    }
}
