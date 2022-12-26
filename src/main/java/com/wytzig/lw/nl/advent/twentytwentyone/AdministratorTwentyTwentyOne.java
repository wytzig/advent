package com.wytzig.lw.nl.advent.twentytwentyone;


import com.wytzig.lw.nl.advent.Administrator;
import com.wytzig.lw.nl.advent.twentytwentyone.bingo.Day4;
import com.wytzig.lw.nl.advent.twentytwentyone.crabfuel.DaySeven;
import com.wytzig.lw.nl.advent.twentytwentyone.depth_measurement.DayOne;
import com.wytzig.lw.nl.advent.twentytwentyone.lanternfish.DaySix;
import com.wytzig.lw.nl.advent.twentytwentyone.magmaheatmap.DayNine;
import com.wytzig.lw.nl.advent.twentytwentyone.positioning.DayTwo;
import com.wytzig.lw.nl.advent.twentytwentyone.power_consumption.DayThree;

public class AdministratorTwentyTwentyOne extends Administrator {

    public AdministratorTwentyTwentyOne() {
        this.init();
    }

    @Override
    protected void init() {
        this.days.add(new DayOne());
        this.days.add(new DayTwo());
        this.days.add(new DayThree());
        this.days.add(new Day4());
        this.days.add(new DaySix());
        this.days.add(new DaySeven());
        this.days.add(new DayNine());
    }
}
