package com.wytzig.lw.nl.advent.days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/***
 * Day 1 was the start of the journey..
 *
 * We gave eachother one last clap on the shoulders before we'd lock ourselves up. On the pier the sun low in the sky.
 * We stepped into the submarine. It was small, but it had all the capabilities.
 *
 * But once we've mustured 'deck, some hacker had deleted all our software!!
 * We liked our own software anyway, as long as we can put enough time in.
 *
 * Whatever the costs..
 * It would be a long journey.
 *
 * Matey's ahoy!
 * ~ Your Captain - 2022
 */
public class DayOne implements Day{

    private static final List<Integer> day1_data_input_depth_measurement = List.
            of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);

    private File day1Input = null;
    private List<Integer> depth_measurement = null;

    // is asked by advent calender
    private void setDay1InputFromRemote() {
        // create java.File based on input from remote
        day1Input = null;
        day1Input = new File("C:\\PersonalProjects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\days\\IO\\day_1_input.txt");
    }

    private int computeFromList(Scanner scanner) {
        int counter = 0;
        int prevLine  = 0;

        int totalCounter = 0;

        while (scanner.hasNextLine()) {
            totalCounter++;
            int line = scanner.nextInt();
//            System.out.println("line is: " + line);

            if(prevLine != 0) {
                if(isIncrease(prevLine, line)) {
                    counter++;
                }
            }
            prevLine = line;
        }
//        System.out.println("end-counter is: " + counter);
        System.out.println("total-counter is: " + totalCounter);
        return counter;
    }

    /**
     *
     * @return
     * @throws FileNotFoundException if file for scanner could not be found. (i.e. is null)
     */
    private boolean processIOFile() {
        try {
            Scanner scanner = new Scanner(this.day1Input);
            System.out.println("scanner successfully started..");

            System.out.println("the answer is: " + computeFromList(scanner));

        } catch (FileNotFoundException e) {
            System.out.println("could not init scanner: " + e.getMessage());
            e.printStackTrace();
        }
        return true;
    }

    // used to verify if example result can be validated
    private void setDay1InputDataFromExample() {
        depth_measurement = null;
        depth_measurement = day1_data_input_depth_measurement;
    }

    public boolean getAnswerForQuestion() {
        setDay1InputFromRemote();

        return processIOFile();
    }

    public boolean getAnswerFromExample() {
        setDay1InputDataFromExample();

        int counter = 0;
        int answer = 7;

        for (int i = 0; i < day1_data_input_depth_measurement.size(); i++) {
            if(i != 0) {
                if(isIncrease(day1_data_input_depth_measurement.get(i - 1), day1_data_input_depth_measurement.get(i))) {
                    counter++;
                }
            }
        }
        System.out.println("the answer of the example is: " + counter);
        return counter == answer;
    }

    /**
     * Checks if y is an increase tenopzichtevan x
     * ex: (1,2) : y>x? : True
     *     (4,3) : : False
     *     (2,2) : : False
     *     (-1, -10) : : False
     */
    protected static boolean isIncrease(int x, int y) {
        System.out.println("returning ??");
        if (y > x) return true;
        System.out.println("x: " + x + " is greater than y: " + y + " so should return false");
        return false;
    }

}
