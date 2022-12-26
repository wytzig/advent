package com.wytzig.lw.nl.advent.twentytwentytwo;

import com.wytzig.lw.nl.advent.Day;
import com.wytzig.lw.nl.advent.twentytwentytwo.campcleaning.DayFour;
import com.wytzig.lw.nl.advent.twentytwentytwo.communicationdevice.DaySix;
import com.wytzig.lw.nl.advent.twentytwentytwo.elvescalories.DayOne;
import com.wytzig.lw.nl.advent.twentytwentytwo.rockpaperscissors.DayTwo;
import com.wytzig.lw.nl.advent.twentytwentytwo.rucksackCheck.DayThree;
import com.wytzig.lw.nl.advent.twentytwentytwo.stackingsnacks.DayFive;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class AdministratorTwentyTwentyTwo {

    protected List<Day> days = new Stack<>();

    // setup days
    private void init() {
        this.days.add(new DayOne());
        this.days.add(new DayTwo());
        this.days.add(new DayThree());
        this.days.add(new DayFour());
        this.days.add(new DayFive());
        this.days.add(new DaySix());
    }

    public AdministratorTwentyTwentyTwo() {
        this.init();
    }

    public void execute() {
        for(Day day: this.days) {
            Instant start = Instant.now();
            day.doPartOne();
            day.doPartTwo();
            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();

            System.out.println(":: [" + timeElapsed + "]");
        }
    }

    public void day6() {
        DaySix executable = new DaySix();
        executable.getAnswerFromExample();
        executable.getAnswerForQuestion();
        executable.getAnswersFromExamplePart2();
        executable.getAnswersForQuestionPart2();
    }

    public void day5() {
        DayFive executable = new DayFive();
        executable.getAnswerFromExample();
        executable.getAnswerForQuestion();
        executable.getAnswersFromExamplePart2();
        executable.getAnswersForQuestionPart2();
    }

    public void day4() {
        DayFour executable = new DayFour();
        executable.getAnswerFromExample();
        executable.getAnswerForQuestion();
    }

    public void day3() {
        DayThree executable = new DayThree();
        executable.getAnswerFromExample();
        executable.getAnswerForQuestion();
        executable.getAnswersFromExamplePart2();
        executable.getAnswersForQuestionPart2();
    }

    public void day2() {
        DayTwo executable = new DayTwo();
        executable.getAnswerFromExample();
        executable.getAnswerForQuestion();
        executable.getAnswersFromExamplePart2();
        executable.getAnswersForQuestionPart2();
    }
    public void day1() {
        DayOne executable = new DayOne();
        executable.getAnswerFromExample();
        executable.getAnswerForQuestion();
        executable.getAnswersFromExamplePart2();
        executable.getAnswersForQuestionPart2();
        executable.hargosInput();
    }

}
