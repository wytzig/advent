package com.wytzig.lw.nl.advent.twentytwentyone.positioning;

import com.wytzig.lw.nl.advent.Day;

import java.io.File;
import java.util.*;

public class DayTwo implements Day {

    private File day2Input = null;

    PositioningSystem PSR = null;


    @Override
    public boolean getAnswerFromExample() {
        cleanup();
        // initialize test input
        initializeSimpleTest(new File("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentyone\\input_files\\day2_example_input.txt"));

        // execute operations
        PSR.prettyPrint();

        return true;
    }

    private void initializeSimpleTest(File inputFile) {
        System.out.println("clean-up");
        this.day2Input = null;
        System.out.println("Initializing test data..");
        this.day2Input = inputFile;
        try {
            Scanner sc = new Scanner(this.day2Input);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] inputs = line.split("\s"); // with an operation on pos1 and a value on pos2
                PSR.processOperationSimpleOperation(Operations.valueOf(inputs[0]), Integer.parseInt(inputs[1]));
            }

        } catch (Exception e) {
            System.out.println("input file not found! With exception: " + e);
        }
        finally {
            System.out.println("done");
        }
    }

    private void initializeComplexTest(File inputFile) {
        System.out.println("Initializing test data..");
        this.day2Input = inputFile;
        try {
            Scanner sc = new Scanner(this.day2Input);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] inputs = line.split("\s"); // with an operation on pos1 and a value on pos2
                PSR.processComplexOperation(Operations.valueOf(inputs[0]), Integer.parseInt(inputs[1]));
            }

        } catch (Exception e) {
            System.out.println("input file not found! With exception: " + e);
        }
        finally {
            System.out.println("done");
        }
    }

    @Override
    public boolean getAnswerForQuestion() {
        cleanup();
        System.out.println("Initializing data..");
        initializeSimpleTest(new File("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentyone\\input_files\\day2_question_input.txt"));

        this.PSR.prettyPrint();

        return true;
    }

    @Override
    public boolean getAnswersFromExamplePart2() {
        cleanup();
        initializeComplexTest(new File("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentyone\\input_files\\day2_example_input.txt"));

        // execute operations
        PSR.prettyPrint();

        return true;
    }

    private void cleanup() {
        System.out.println("clean-up");
        this.day2Input = null;
        this.PSR = new PositioningSystem(0, 0, 0);
        System.out.println("done");
    }

    @Override
    public boolean getAnswersForQuestionPart2() {
        // initialize test input
        cleanup();
        initializeComplexTest(new File("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentyone\\input_files\\day2_question_input.txt"));

        // execute operations
        PSR.prettyPrint();

        return false;
    }
}
