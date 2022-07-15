package com.wytzig.lw.nl.advent.days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *
 *
 *  1. The most common bit of the first bit is(2x (0) & 5x (1)) :: gamma=[1].
 *  2. The definition of a second most common bit is as the second bit is more comman i.e. ( (2x (0) & 5x (1)) :: gamma=[1, 1]).
 *  3. The definition of a 3rd, 4th and 5th common bit is the same as 1 & 2. This is adding to gamma[]
 *  4. gamma[5] is complete, for example should be:
 *
 */
public class DayThree implements Day {

    private List<String> exampleDiagnosticInput = List.of("00100", "11110", "10110", "10111", "101001",
    "01111", "00111", "11100","10000","11001", "00010","01010");

    private File inputFile = new File("C:\\PersonalProjects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\days\\IO\\day3_input.txt");

    String bitGammaRate = "";
    String exampleAnswerBitGammaRate = "10110";
    long gammaDecimal;
    String exampleAnswerGammaDecimal = "22";

    String bitEpsilonRate = "";
    String exampleAnswerBitEpsilonRate = "01001";
    long epsilonDecimal;
    String exampleAnswerEpsilonDecimal = "9";

    long powerConsumption = 0;
    long powerConsumptionAnswer = 198;

    private Scanner initInput() throws FileNotFoundException {
        return new Scanner(inputFile);
    }

    @Override
    public boolean getAnswerForQuestion() {
        // get scanner for processing file
        try {
            Scanner s = initInput();
            System.out.println("Scanner boot :: successful");

            List<String> fileInput = new LinkedList<>();
            while (s.hasNextLine()) {
                fileInput.add(s.next());
            }
            System.out.println("fileInput was: " + fileInput);
            getAnswer(fileInput);

            System.out.println("the gamma is: " + bitGammaRate);
            System.out.println("the gamma-decimal is: " + this.gammaDecimal);
            System.out.println("the epsilon is: " + bitEpsilonRate);
            System.out.println("the epsilon-decimal is: " + this.epsilonDecimal );
            System.out.println("the power consumption is: " + this.powerConsumption );

        } catch (FileNotFoundException e) {
            System.out.println("[error] Something went wrong Matey! See error message:" + e.getMessage());
        }
        return false;
    }

    public void getAnswer(List<String> usageOfInput) {
        int individualItemLength = usageOfInput.get(0).length();
        System.out.println("length of individual item is: " + individualItemLength);
        for (int i = 0; i <= individualItemLength - 1; i++) { // size of raw digits, based on the first item
            String mostOccurringBit = computeMostOccurringBitForBitArray(getBitstringColumnForPosition(usageOfInput, i));
            String leastOccurringBit = computeLeastOccurringBitForBitArray(getBitstringColumnForPosition(usageOfInput, i));
            this.bitGammaRate += mostOccurringBit;
            this.bitEpsilonRate += leastOccurringBit;
        }
        this.gammaDecimal = Long.parseLong(bitGammaRate, 2);
        this.epsilonDecimal = Long.parseLong(bitEpsilonRate, 2);

        this.powerConsumption = Math.multiplyExact(this.gammaDecimal, this.epsilonDecimal);
    }

    @Override
    public boolean getAnswerFromExample() {
        getAnswer(exampleDiagnosticInput);

        System.out.println("the gamma is: " + bitGammaRate + ".  The answer should have been: " + exampleAnswerBitGammaRate);
        System.out.println("the gamma-decimal is: " + this.gammaDecimal + ".  The answer should have been: " + exampleAnswerGammaDecimal);
        System.out.println("the epsilon is: " + bitEpsilonRate + ".  The answer should have been: " + exampleAnswerBitEpsilonRate);
        System.out.println("the epsilon-decimal is: " + this.epsilonDecimal + ". The answer should have been:" + exampleAnswerEpsilonDecimal);
        System.out.println("the power consumption is: " + this.powerConsumption + ". And should have been: "+ powerConsumptionAnswer);

        return true;
    }

    private List<Integer> getIntBitValuesFromString(String input) {
        List<Integer> listOfBitValues = new LinkedList<>();
        for (char bit: input.toCharArray()) {
            int bitValue = Integer.valueOf(bit);
            listOfBitValues.add(bitValue);
        }
        return listOfBitValues;
    }

    private AtomicInteger getAmountForSpecifiedChar(List<Integer> listOfBitValues, int charIndex) {
        AtomicInteger x = new AtomicInteger();
        for(int bit : listOfBitValues) {
            // char(48) = 0, char(49) = 1
            if(bit == charIndex) {
                x.addAndGet(1); // add one if the char was counted
            }
        }
        return x;
    }

    private String getMostOccurring(int zero, int one) {
        if(zero > one) {
            return "0";
        } else {
            return "1";
        }
    }
    private String getLeastOccurring(int zero, int one) {
        if(zero < one) {
            return "0";
        } else {
            return "1";
        }
    }

    private String computeMostOccurringBitForBitArray(String input) {
        List<Integer> listOfBitValues = getIntBitValuesFromString(input);

        return getMostOccurring(getAmountForSpecifiedChar(listOfBitValues, 48).get(),
                getAmountForSpecifiedChar(listOfBitValues, 49).get());
    }

    private String computeLeastOccurringBitForBitArray(String input) {
        List<Integer> listOfBitValues = getIntBitValuesFromString(input);

        return getLeastOccurring(getAmountForSpecifiedChar(listOfBitValues, 48).get(),
                getAmountForSpecifiedChar(listOfBitValues, 49).get());
    }


    private String getBitstringColumnForPosition(List<String> inputList, int bitPosition) {
        String bitString = "";

        for (String bitArray: inputList) {
            //get first bit
            char firstBit = bitArray.charAt(bitPosition);
            bitString = bitString + firstBit;
        }
        return bitString;
    }

    @Override
    public String getClassName() {
        return this.getClassName();
    }
}
