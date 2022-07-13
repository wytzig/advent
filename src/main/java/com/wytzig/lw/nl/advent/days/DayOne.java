package com.wytzig.lw.nl.advent.days;

import java.io.File;
import java.util.List;

public class DayOne implements Day{

    private static final List<Integer> day1_data_input_depth_measurement = List.
            of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);

    private File day1Input = null;
    private List<Integer> depth_measurement = null;

    private void setDay1InputFromRemote() {
        // create java.File based on input from remote
        day1Input = null;
        day1Input = new File("day_1_input.txt");;

        // convert file to List<Integer>
        // todo
    }

    // used to verify
    private void setDay1InputDataFromExample() {
        depth_measurement = null;
        depth_measurement = day1_data_input_depth_measurement;
    }

    public boolean getAnswerFromExample() {
        setDay1InputDataFromExample();
        setDay1InputFromRemote();

        int counter = 0;
        int answer = 7;

        for (int i = 0; i < day1_data_input_depth_measurement.size(); i++) {
            if(i != 0) {
                if(isIncrease(day1_data_input_depth_measurement.get(i - 1), day1_data_input_depth_measurement.get(i))) {
                    counter++;
                }
            }
        }
        System.out.println("counter is: " + counter);
        return counter == answer;
    }

    /**
     * Checks if y is an increase tenopzichtevan x
     * ex: (1,2) : y>x? : True
     *     (4,3) : : False
     *     (2,2) : : False
     *     (-1, -10) : : False
     */
    private boolean isIncrease(int x, int y) {
//        if(x == null) throw new InvalidListOperationException("first element of the list can't be compared to the previous one");
        if (y > x) return true;
        return false;
    }

}
