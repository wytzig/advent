package com.wytzig.lw.nl.advent.twentytwentytwo.campcleaning;

import com.wytzig.lw.nl.advent.Day;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayFour extends Day {

    private Integer[] convertToIntegerList(String[] rangeList) {
        assert rangeList.length == 2; // we only expect 2 values to be given
        Integer[] result = new Integer[2];

        for(int i = 0; i < rangeList.length; i++) {
            result[i] = Integer.parseInt(rangeList[i]);
        }
        return result;
    }

    public void processInput(String pathToFileName){
        File file = new File(pathToFileName);
        long amountOfContainingRanges = 0;
        long amountOfOverlappingRanges = 0;

        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String line = sc.nextLine(); // line-format: 1-92,2-11
                String[] ranges = line.split(",");
                assert (ranges.length == 2);

                Integer[] rangeListOne = convertToIntegerList(ranges[0].split("-"));
                Integer[] rangeListTwo = convertToIntegerList(ranges[1].split("-"));

                if(checkIfRangesContainEachOther(rangeListOne, rangeListTwo)) {
                    amountOfContainingRanges++;
                }
                if(checkIfRangeOverlap(rangeListOne, rangeListTwo)) {
                    amountOfOverlappingRanges++;
                }
//                System.out.println("Ranges: " + Arrays.toString(ranges) + "; did they contain themselves?: " + checkIfRangesContainEachOther(rangeListOne, rangeListTwo));
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR while processing the file: " + e);
        } finally {
//            System.out.println("The amount of containing ranges was: " + amountOfContainingRanges);
//            System.out.println("The amount of overlapping ranges was: " + amountOfOverlappingRanges);
        }
    }

    private boolean checkIfRangeOverlap(Integer[] jobList1, Integer[] jobList2) {
        if(jobList1[0] <= jobList2[0] && jobList2[0] <= jobList1[1]) {
            return true;
        }
        if(jobList2[0] <= jobList1[0] && jobList1[0] <= jobList2[1]) {
            return true;
        }
         return false;
    }

    private boolean checkIfRangesContainEachOther(Integer[] jobList1, Integer[] jobList2) {
        if(jobList1[0] <= jobList2[0] && jobList1[1] >= jobList2[1]) { // if the first list starts before and ends after the second, it contains it
            return true;
        }
        if(jobList2[0] <= jobList1[0] && jobList2[1] >= jobList1[1]) {
             return true;
        }
        return false;
    }

    @Override
    public boolean getAnswerFromExample() {
        processInput("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentytwo\\input\\day4_example");
        return true;
    }

    @Override
    public boolean getAnswerForQuestion() {
        processInput("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentytwo\\input\\day4_question");
        return true;
    }

    @Override
    public boolean getAnswersFromExamplePart2() {
        return false;
    }

    @Override
    public boolean getAnswersForQuestionPart2() {
        return false;
    }
}
