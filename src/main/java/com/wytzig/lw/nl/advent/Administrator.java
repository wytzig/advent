package com.wytzig.lw.nl.advent;


import java.io.File;
import java.util.List;

public class Administrator {

    private static final List<Integer> day1_data_input_depth_measurement = List.
            of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);

    private File day1Input = null;

    public void init() {
        day1Input = new File("day_1_input.txt");;
    }

    public boolean day_1() {
        return true;
    }

}
