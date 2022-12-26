package com.wytzig.lw.nl.advent;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Stack;

public abstract class Administrator {

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
