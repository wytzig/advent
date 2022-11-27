package com.wytzig.lw.nl.advent;

import com.wytzig.lw.nl.advent.twentytwentyone.AdministratorTwentyTwentyOne;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdventApplication {

    AdministratorTwentyTwentyOne administratorTwentyTwentyOne;

    public static void main(String[] args) {
        SpringApplication.run(AdventApplication.class, args);
        AdventApplication apl = new AdventApplication();
        apl.run();
    }

    public void run() {
        TheYear2021();
    }

    public void TheYear2021() {
        administratorTwentyTwentyOne = new AdministratorTwentyTwentyOne();
//        administratorTwentyTwentyOne.day1();
//        administratorTwentyTwentyOne.day2();
//        administratorTwentyTwentyOne.day3();
//        administratorTwentyTwentyOne.day4();

        administratorTwentyTwentyOne.day6();
    }
}
