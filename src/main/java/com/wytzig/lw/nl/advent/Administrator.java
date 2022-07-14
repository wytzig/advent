package com.wytzig.lw.nl.advent;


import com.wytzig.lw.nl.advent.days.DayOne;
import com.wytzig.lw.nl.advent.days.DayOneTwo;
import com.wytzig.lw.nl.advent.days.DayThree;

public class Administrator {

    public void day1(){

        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("------ Good morning sailor! Starting up the workday! ------");
        DayOne executable = new DayOne();
        executable.getAnswerFromExample();
        executable.getAnswerForQuestion();

        System.out.println("---- Taking lunch for day 1.1, switching to 1.2 ------");

        DayOneTwo executable2 = new DayOneTwo();
        executable2.getAnswerFromExample();

        System.out.println("---- whoah! what a sunset. Take a rest sailor, you did well! -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- ...........  -----");
        System.out.println("---- whoah! what a sunset. Take a rest sailor, you did well! -----");
        System.out.println("---- whoah! what a sunset. Take a rest sailor, you did well! -----");
    }

    public void day2() {
        System.out.println("------ Good morning sailor! Starting up the workday! ------");
        DayThree executable = new DayThree();
    }


}
