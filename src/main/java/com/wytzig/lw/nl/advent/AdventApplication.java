package com.wytzig.lw.nl.advent;

import com.wytzig.lw.nl.advent.twentytwentyone.AdministratorTwentyTwentyOne;
import com.wytzig.lw.nl.advent.twentytwentytwo.AdministratorTwentyTwentyTwo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdventApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdventApplication.class, args);
        AdventApplication apl = new AdventApplication();
        apl.run();
    }

    public void run() {
        TheYear2021();
        TheYear2022();
    }

    public void TheYear2022() {
        System.out.println("Starting 2022..");
        AdministratorTwentyTwentyTwo administratorTwentyTwentyTwo = new AdministratorTwentyTwentyTwo();
        administratorTwentyTwentyTwo.execute();
        System.out.println("Ending 2022..");
    }

    public void TheYear2021() {
        System.out.println("Starting 2021..");
        AdministratorTwentyTwentyOne administratorTwentyTwentyOne = new AdministratorTwentyTwentyOne();
        administratorTwentyTwentyOne.execute();
        System.out.println("Ending 2021..");
    }
}
