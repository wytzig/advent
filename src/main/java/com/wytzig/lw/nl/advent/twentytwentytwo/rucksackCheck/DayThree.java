package com.wytzig.lw.nl.advent.twentytwentytwo.rucksackCheck;

import com.wytzig.lw.nl.advent.Day;

public class DayThree extends Day {

    @Override
    public boolean getAnswerFromExample() {
        Executer executer = new Executer("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentytwo\\input\\day3_puzzle_example");
        System.out.println("Sum of priorities of item types: " + executer.processRuckSack());
        return true;
    }

    @Override
    public boolean getAnswerForQuestion() {
        Executer executer = new Executer("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentytwo\\input\\day3_puzzle_question");
        System.out.println("Sum of priorities of item types: " + executer.processRuckSack());
        return false;
    }

    @Override
    public boolean getAnswersFromExamplePart2() {
        Executer executer = new Executer("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentytwo\\input\\day3_puzzle_example");
        System.out.println("Sum of priorities of item types: " + executer.findBadgesScore());
        return false;
    }

    @Override
    public boolean getAnswersForQuestionPart2() {
        Executer executer = new Executer("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentytwo\\input\\day3_puzzle_question");
        System.out.println("Sum of priorities of item types: " + executer.findBadgesScore());
        return false;
    }
}
