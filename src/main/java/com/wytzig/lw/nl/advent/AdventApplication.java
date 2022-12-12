package com.wytzig.lw.nl.advent;

import com.wytzig.lw.nl.advent.twentytwentyone.AdministratorTwentyTwentyOne;
import com.wytzig.lw.nl.advent.twentytwentytwo.AdministratorTwentyTwentyTwo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdventApplication {

    AdministratorTwentyTwentyOne administratorTwentyTwentyOne;
    AdministratorTwentyTwentyTwo administratorTwentyTwentyTwo;

    public static void main(String[] args) {
        SpringApplication.run(AdventApplication.class, args);
        AdventApplication apl = new AdventApplication();
        apl.run();
    }

    public void run() {
//        TheYear2021();
        TheYear2022();
    }

    public void TheYear2022() {
        this.administratorTwentyTwentyTwo = new AdministratorTwentyTwentyTwo();
//        administratorTwentyTwentyTwo.day1();
        administratorTwentyTwentyTwo.day2();
    }

    public void TheYear2021() {
//        administratorTwentyTwentyOne = new AdministratorTwentyTwentyOne();
//        administratorTwentyTwentyOne.day1();
//        administratorTwentyTwentyOne.day2();
//        administratorTwentyTwentyOne.day3();
//        administratorTwentyTwentyOne.day4();
//
//        administratorTwentyTwentyOne.day6();
//        administratorTwentyTwentyOne.day7();
//        administratorTwentyTwentyOne.day9();
    }
}
