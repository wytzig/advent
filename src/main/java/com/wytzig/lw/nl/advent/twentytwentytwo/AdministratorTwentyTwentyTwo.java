package com.wytzig.lw.nl.advent.twentytwentytwo;

import com.wytzig.lw.nl.advent.twentytwentytwo.campcleaning.DayFour;
import com.wytzig.lw.nl.advent.twentytwentytwo.communicationdevice.DaySix;
import com.wytzig.lw.nl.advent.twentytwentytwo.elvescalories.DayOne;
import com.wytzig.lw.nl.advent.twentytwentytwo.rockpaperscissors.DayTwo;
import com.wytzig.lw.nl.advent.twentytwentytwo.rucksackCheck.DayThree;
import com.wytzig.lw.nl.advent.twentytwentytwo.stackingsnacks.DayFive;

public class AdministratorTwentyTwentyTwo {


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
