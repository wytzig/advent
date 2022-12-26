package com.wytzig.lw.nl.advent;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Stack;

/**
 * Administrator abstract class which provides a universal execution of initialized Day objects;
 *  1. Initialize your year days in your administrator implementation.
 *  2. Call the execution function from your application.
 *
 * possible improvements:
 *  - write to output files instead of console
 */
public abstract class Administrator {

    /* NOTE: Don't forget to add the default constructor of your class and initialize the init method! */

    protected List<Day> days = new Stack<>();

    protected abstract void init();

    public void execute() {
        for(Day day: this.days) {
            Instant start = Instant.now();
            day.doPartOne();
            day.doPartTwo();
            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();

            System.out.println("::" + timeElapsed + " [ms]");
        }
    }
}
