package com.wytzig.lw.nl.advent.twentytwentyone;


import com.wytzig.lw.nl.advent.twentytwentyone.bingo.Day4;
import com.wytzig.lw.nl.advent.twentytwentyone.depth_measurement.DayOne;
import com.wytzig.lw.nl.advent.twentytwentyone.depth_measurement.DayOneTwo;
import com.wytzig.lw.nl.advent.twentytwentyone.positioning.DayTwo;
import com.wytzig.lw.nl.advent.twentytwentyone.power_consumption.DayThree;

public class AdministratorTwentyTwentyOne {

    public void day4() {
        System.out.println("---------- DAY 4 ------------------");
        Day4 day4 = new Day4();
        System.out.println("Getting answers from example.. commander: ");
        day4.getAnswerFromExample();

        System.out.println("---");
        System.out.println("---");
        System.out.println("---");
        System.out.println("Getting answers from input-file.. commander: ");
        day4.getAnswerForQuestion();

        System.out.println("---");
        System.out.println("---");
        System.out.println("---");
        day4.getAnswerPartTwoExample();
        day4.getAnswerPartTwo();
        System.out.println("---");
        System.out.println("---");
        System.out.println("---");
        System.out.println("--- end of file");

    }

    public void day3() {
        System.out.println("------ Good morning sailor! Starting up the workday! It's the 3rd ------");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");

        DayThree executable = new DayThree();
        executable.getAnswerFromExample();
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- well done captain, but can you put this on production pls?  -----");
        System.out.println("---- we need it asap!  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        executable.getAnswerForQuestion();
        System.out.println("---- The systems seem to be calibrating..  -----");
        System.out.println("---- It works!  -----");
        System.out.println("---- You mad-lad -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- Taking lunch for day 1.1, switching to 1.2 ------");

        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- Take a rest sailor, another day has passed -----");
    }

    public void day2() {
        System.out.println("------ Good morning sailor! Starting up the second workday! ------");
        System.out.println("---- ...........  -----");
        System.out.println("---- doing tests...  -----");

        DayTwo executable = new DayTwo();
        executable.getAnswerFromExample();

        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- moving on to real data... -----");

        executable.getAnswerForQuestion();

        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- moving on with part 2 -----");
        System.out.println("---- doing tests-----");

        executable.getAnswersFromExamplePart2();

        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- moving on to real data-----");

        executable.getAnswersForQuestionPart2();
    }

    public void day1(){

        System.out.println("------ Good morning sailor! Starting up the first workday! ------");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");

        DayOne executable = new DayOne();
        executable.getAnswerFromExample();
        executable.getAnswerForQuestion();

        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- Taking lunch for day 1.1, switching to 1.2 ------");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");

        DayOneTwo executable2 = new DayOneTwo();
        executable2.getAnswerFromExample();

        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- whoah! what a sunset. Take a rest sailor, you did well! -----");
    }
}
