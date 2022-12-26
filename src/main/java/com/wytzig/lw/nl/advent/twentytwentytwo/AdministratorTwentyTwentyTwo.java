package com.wytzig.lw.nl.advent.twentytwentytwo;

import com.wytzig.lw.nl.advent.Administrator;
import com.wytzig.lw.nl.advent.Day;
import com.wytzig.lw.nl.advent.twentytwentytwo.campcleaning.DayFour;
import com.wytzig.lw.nl.advent.twentytwentytwo.communicationdevice.DaySix;
import com.wytzig.lw.nl.advent.twentytwentytwo.elvescalories.DayOne;
import com.wytzig.lw.nl.advent.twentytwentytwo.rockpaperscissors.DayTwo;
import com.wytzig.lw.nl.advent.twentytwentytwo.rucksackCheck.DayThree;
import com.wytzig.lw.nl.advent.twentytwentytwo.stackingsnacks.DayFive;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Stack;

/**
 * possible improvements:
 *  - write to output files instead of console
 *  -
 */
public class AdministratorTwentyTwentyTwo extends Administrator {
    protected void init() {
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
}
