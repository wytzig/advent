package com.wytzig.lw.nl.advent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdventApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdventApplication.class, args);
        AdventApplication apl = new AdventApplication();
        apl.Administrator();
    }

    public void Administrator() {
        System.out.println(welcomeText());
    }

    private String welcomeText() {
        return ".....  Welcome traveler......" +
                "you are most welcome. . . . . ";
    }

}
