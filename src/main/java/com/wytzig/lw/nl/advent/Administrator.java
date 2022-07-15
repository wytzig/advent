package com.wytzig.lw.nl.advent;


import com.wytzig.lw.nl.advent.days.DayOne;
import com.wytzig.lw.nl.advent.days.DayOneTwo;
import com.wytzig.lw.nl.advent.days.DayThree;

public class Administrator {

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
        System.out.println("---- Take a rest sailor, another day has passed -----");

    }


}
