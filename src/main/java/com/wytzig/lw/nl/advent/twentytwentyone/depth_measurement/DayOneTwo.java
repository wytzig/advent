package com.wytzig.lw.nl.advent.twentytwentyone.depth_measurement;

import com.wytzig.lw.nl.advent.Day;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 * Allright matey's listen up.
 *
 * We've successfully computed our current depth, this is great. However we get a lot of irregularities.
 * At certain moments we are at -5 and others -400. These are minor blips though, but we should account
 * for the half broken machinery our company has set us up.
 *
 * "Burak" diary: machines broken, sky is dark. Soon we will all be dead.
 */
public class DayOneTwo extends Day {

    private File day1Input = null;

    private static final List<Integer> day1_data_input_depth_measurement = List.
            of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);


    @Override
    public boolean getAnswerFromExample() {
        setDay1InputFromRemote();

        boolean result = processIOFile();
        return result ;
    }

    // re-use this one depending on [example] or not
    private List<Integer> computeFilteredThreeMeasureDataFromInputList(List<Integer> inputList) {
        List<Integer> filteredInputListOfDepthMeasurements = new LinkedList<>();
        int amountOfRawDataMinus3 = inputList.size() - 3;

        // calculates the moving average for the next three; todo how to handle the last 2? unfinished thought
        for(int i = 0; i < amountOfRawDataMinus3; i++) {
            // add up this, next and next + 1 to calculate moving average.
            int slidingThreeSum = inputList.get(i) + inputList.get(i+1) + inputList.get(i+2);
            filteredInputListOfDepthMeasurements.add(slidingThreeSum);
        }
        int res = inputList.get(inputList.size() - 3) + inputList.get(inputList.size() - 2) + inputList.get(inputList.size() -1); // resolve our debts captain! We beg you.
        filteredInputListOfDepthMeasurements.add(res);
        return filteredInputListOfDepthMeasurements;
    }

    /**
     * Creates filtered list based on next three sums from an scanner object
     * @param scanner scanner put on the right file
     * @return
     */
    private List<String> computeFromInput(Scanner scanner) {
        int amountOfDepbtMeasurements = 0;

        List<Integer> inputListOfDepthMeasurements = new LinkedList<>();
        List<Integer> filteredInputListOfDepthMeasurementsExample = new LinkedList<>();
        List<Integer> filteredInputListOfDepthMeasurements = new LinkedList<>();

        //calculate moving future [three average]
        while (scanner.hasNextLine()) {
            inputListOfDepthMeasurements.add(scanner.nextInt());
            amountOfDepbtMeasurements++;
        }

        filteredInputListOfDepthMeasurementsExample = computeFilteredThreeMeasureDataFromInputList(day1_data_input_depth_measurement);
        filteredInputListOfDepthMeasurements = computeFilteredThreeMeasureDataFromInputList(inputListOfDepthMeasurements);
        System.out.println("[example] List of calculated sums: " + computeFilteredThreeMeasureDataFromInputList(day1_data_input_depth_measurement));
        System.out.println("List of calculated sums: " + computeFilteredThreeMeasureDataFromInputList(inputListOfDepthMeasurements));

        int amountOfIncreasesExample = amountOfIncreasesForList(filteredInputListOfDepthMeasurementsExample);
        int amountOfIncreases = amountOfIncreasesForList(filteredInputListOfDepthMeasurements);

//        System.out.println("first average [example]:" + filteredInputListOfDepthMeasurementsExample.get(0));
//        System.out.println("first average :" + filteredInputListOfDepthMeasurements.get(0));
        System.out.println("total amount of depth measurements [unfiltered] is: " + amountOfDepbtMeasurements);
        System.out.println("[example] total amount of depth measurements [filtered] is: " + filteredInputListOfDepthMeasurementsExample);
        System.out.println("Amount of increases in three-measure sums[]: " + amountOfIncreasesExample);
        System.out.println("isTrueToExample?: " + (amountOfIncreasesExample == 5));
        System.out.println("answer to question?: " + (amountOfIncreases));
        System.out.println("total amount of depth measurements [filtered] is: " + filteredInputListOfDepthMeasurements);
        System.out.println("total amount of filtered three-measures increased: " + amountOfIncreases);

        return List.of("1","2"); //spoof for future compatibility
    }

    private int amountOfIncreasesForList(List<Integer> inputList) {
        int amountOfIncreases = 0;

        for (int i = 0; i < inputList.size(); i++) {
            if(i != 0) {
                // re-use calculate method from day1
                if(DayOne.isIncrease(inputList.get(i - 1), inputList.get(i))) {
                    amountOfIncreases++;
                }
            }
        }
        return amountOfIncreases;
    }

    // is asked by advent calender
    private void setDay1InputFromRemote() {
        // create java.File based on input from remote
        day1Input = null;
        day1Input = new File("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentyone\\input_files\\day_1_input.txt");
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
            computeFromInput(scanner);

        } catch (FileNotFoundException e) {
            System.out.println("could not init scanner: " + e.getMessage());
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean getAnswerForQuestion() {
        return false;
    }

    @Override
    public boolean getAnswersFromExamplePart2() {
        return false;
    }

    @Override
    public boolean getAnswersForQuestionPart2() {
        return false;
    }

    //    @Override
    public List<String> computeFromText(File input) {
        try {
            Scanner scanner = new Scanner(input);
            System.out.println("scanner successfully started..");
            return computeFromInput(scanner);

        } catch (FileNotFoundException e) {
            System.out.println("could not init scanner: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
