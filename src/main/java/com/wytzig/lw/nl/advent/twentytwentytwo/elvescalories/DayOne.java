package com.wytzig.lw.nl.advent.twentytwentytwo.elvescalories;

import com.wytzig.lw.nl.advent.Day;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DayOne extends Day {

    List<List<Long>> caloriesPerElf = new ArrayList<>();
    List<Long> sums = new ArrayList<>();

    private void deepclean() {
        caloriesPerElf = new ArrayList<>();
        sums = new ArrayList<>();
    }

    private long getHighest() {
        long highest = -1;
        for (int i = 0; i < sums.size(); i++) {
            long current = sums.get(i);
            if (current > highest) highest = current;
        }
        return highest;
    }

    private void sortList() {
        Collections.sort(sums);
        Collections.reverse(sums);

        System.out.println("finished sorting");
    }


    private void getSums() {
        for (List<Long> caloriesCarried : caloriesPerElf) {
            long sum = 0;
            for (long fruhstuck : caloriesCarried) {
                sum += fruhstuck;
            }
            sums.add(sum);
        }
    }

    private void parseInput(String inputFileLocation) {
        File inputfile = new File(inputFileLocation);
        try {
            Scanner sc = new Scanner(inputfile);
            List<Long> caloriesCarried = null;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                if(line.isEmpty()) {
                    if(caloriesCarried != null) {
                        this.caloriesPerElf.add(caloriesCarried);
                        caloriesCarried = null;
                    }
                    if(caloriesCarried == null) caloriesCarried = new ArrayList<>();
                } else {
                    caloriesCarried.add(Long.parseLong(line));
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("NO file could be found! e: " + e.getMessage());
        }
    }

    private long sumTopThree() {
        long result = sums.get(0) + sums.get(1) + sums.get(2);

        return result;
    }


    @Override
    public boolean getAnswerFromExample() {
        deepclean();
        parseInput("src/main/java/com/wytzig/lw/nl/advent/twentytwentytwo/input/day1_example_input");
        getSums();
        System.out.println("The highest sum was: " + getHighest());
        return false;
    }

    @Override
    public boolean getAnswerForQuestion() {
        deepclean();
        parseInput("src/main/java/com/wytzig/lw/nl/advent/twentytwentytwo/input/day1_puzzle_input");
        getSums();
        System.out.println("The highest sum was: " + getHighest());
        return false;
    }

    @Override
    public boolean getAnswersFromExamplePart2() {
        deepclean();
        parseInput("src/main/java/com/wytzig/lw/nl/advent/twentytwentytwo/input/day1_example_input");
        getSums();
        sortList();
        System.out.println("Top three calorie sacks combined equals: " + sumTopThree());
        return false;
    }

    @Override
    public boolean getAnswersForQuestionPart2() {
        deepclean();
        parseInput("src/main/java/com/wytzig/lw/nl/advent/twentytwentytwo/input/day1_puzzle_input");
        getSums();
        sortList();
        System.out.println("Top three calorie sacks combined equals: " + sumTopThree());
        return false;
    }

    @Override
    public void doPartOne() {
        this.getAnswerFromExample();
        this.getAnswerForQuestion();
    }

    public void hargosInput() {
        deepclean();
        parseInput("src/main/java/com/wytzig/lw/nl/advent/twentytwentytwo/input/day1_puzzle_input_hargo");
        getSums();
        System.out.println("The highest sum was: " + getHighest());

        deepclean();
        parseInput("src/main/java/com/wytzig/lw/nl/advent/twentytwentytwo/input/day1_puzzle_input_hargo");
        getSums();
        sortList();
        System.out.println("Top three calorie sacks combined equals: " + sumTopThree());
    }
}
