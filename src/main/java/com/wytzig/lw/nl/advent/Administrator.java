package com.wytzig.lw.nl.advent;


import java.io.File;
import java.util.List;

public class Administrator {

    private static final List<Integer> day1_data_input_depth_measurement = List.
            of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);

    private File day1Input = null;
    private List<Integer> depth_measurement = null;

    public void setDay1InputFromRemote() {
        // create java.File based on input from remote
        day1Input = null;
        day1Input = new File("day_1_input.txt");;

        // convert file to List<Integer>
    }

    // used to verify
    public void setDay1InputDataFromExample() {
        depth_measurement = null;
        depth_measurement = day1_data_input_depth_measurement;
    }

    public boolean day_1() {
        setDay1InputDataFromExample();
        setDay1InputFromRemote();
        return true;
    }



}
