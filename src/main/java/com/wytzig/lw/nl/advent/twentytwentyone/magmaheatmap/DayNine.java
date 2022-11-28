package com.wytzig.lw.nl.advent.twentytwentyone.magmaheatmap;

import com.wytzig.lw.nl.advent.Day;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayNine implements Day {

    private List<String> heatmapRows = new ArrayList<>();
    private long[][] heatmap;

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


    @Override
    public boolean getAnswerFromExample() {
        initInputForInputFile("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentyone\\input_files\\day9_example_input.txt");
        processHeatMapRows();
        return false;
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
