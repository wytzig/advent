package com.wytzig.lw.nl.advent.twentytwentyone.magmaheatmap;

import com.wytzig.lw.nl.advent.Day;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DayNine implements Day {

    private List<String> heatmapRows = new ArrayList<>();
    private long[][] heatmap;

    private List<Long> listOfLowPoints = new ArrayList<>();

    /**
     * Converts input file to rows in @param heatmapRows
     * @param pathToInputFile
     */
    private void initInputForInputFile(String pathToInputFile) {
        File file = new File(pathToInputFile);
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                heatmapRows.add(line);
            }

        } catch (Exception e) {
            System.out.println("Error while trying to process input with exception: " + e.getMessage());
        }
    }

    private void processHeatMapRows() {
        this.heatmap = new long[heatmapRows.size()][heatmapRows.stream().findFirst().get().length()];
        for(int i = 0; i < heatmapRows.size(); i++) { // iterate over all heatmapRows elements
            String row = heatmapRows.get(i);

            for(int j = 0; j < row.length() ; j++) {
                int rowNumber = Integer.parseInt(row.charAt(j) + "");

                heatmap[i][j] = rowNumber;
            }
        }
    }

    private long getLocation(Positions positions, int i, int j) {
        long result = -1; // ASSUMPTION input will not have any negative numbers || future solve with Optional.EMPTY()
        try {
            switch (positions) {
                case LEFT -> {
                    result = heatmap[i][j - 1];
                }
                case RIGHT -> {
                    result = heatmap[i] [j + 1];
                }
                case UP -> {
                    result = heatmap[i - 1][j];
                }
                case DOWN -> {
                    result = heatmap[i + 1][j];
                }
            }
        } catch (Exception e) {
//            System.out.println("We skip " + positions);
        } finally {
            return result;
        }
    }

    private boolean isLower(long location, long compareTo) {
        if(compareTo != -1) {
            return location < compareTo;
        }
        return true; // no value means out of bounds, safe to assume location will be low
    }

    private void determineLowPoints() {
        for(int i = 0; i < this.heatmap.length; i++) { // for all columns
            assert this.heatmap.length == this.heatmapRows.size();
            assert Arrays.stream(this.heatmap).findAny().get().length == this.heatmapRows.stream().findAny().get().length();
            for(int j = 0; j < Arrays.stream(this.heatmap).findAny().get().length; j++) { // for every element in the row
                long location = this.heatmap[i][j];

                long left = getLocation(Positions.LEFT, i, j);
                long right = getLocation(Positions.RIGHT, i, j);
                long upper = getLocation(Positions.UP, i, j);
                long under = getLocation(Positions.DOWN, i, j);

                if(isLower(location, left) && isLower(location, right) && isLower(location, upper) && isLower(location, under)) {
                    System.out.println("low point detected: " + location);
                    this.listOfLowPoints.add(location);
                }

                System.out.println("the current number is: " + location + ". left: " + left + ". right: " + right + ". up: " + upper + ". under: "+ under);
            }
            System.out.println("\n");
        }
    }

    public long caluculateRiskFromLowPoints() {
        long sum = 0;
        for(long location: listOfLowPoints) {
            sum += (location + 1);
        }
        System.out.println("The sum of all risk points is: " + sum);
        return sum;
    }


    @Override
    public boolean getAnswerFromExample() {
        initInputForInputFile("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentyone\\input_files\\day9_example_input.txt");
        processHeatMapRows();
        determineLowPoints();
        caluculateRiskFromLowPoints();
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
}
