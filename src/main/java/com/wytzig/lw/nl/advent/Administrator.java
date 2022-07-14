package com.wytzig.lw.nl.advent;


import com.wytzig.lw.nl.advent.days.DayOne;
import com.wytzig.lw.nl.advent.days.DayOneTwo;

public class Administrator {

    public void day1(){

        System.out.println("------ Good morning sailor! Starting up the workday! ------");
        DayOne executable = new DayOne();
        executable.getAnswerFromExample();
        executable.getAnswerForQuestion();

        System.out.println("---- Taking lunch for day 1.1, switching to 1.2 ------");

        DayOneTwo executable2 = new DayOneTwo();
        executable2.getAnswerFromExample();
//        executable2.getAnswerForQuestion();
//        executable2.getAnswerForQuestion();
    }


}
