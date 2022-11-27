package com.wytzig.lw.nl.advent.twentytwentyone.lanternfish;

import com.wytzig.lw.nl.advent.Day;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DaySix implements Day {

    List<Integer> inputListExample = new ArrayList<>(List.of(3,4,3,1,2));
    List<Integer> inputListQuestion = new ArrayList<>(List.of(5,1,1,5,4,2,1,2,1,2,2,1,1,1,4,2,2,4,1,1,1,1,1,4,1,1,1,1,1,5,3,1,4,1,1,1,1,1,4,1,5,1,1,1,4,1,2,2,3,1,5,1,1,5,1,1,5,4,1,1,1,4,3,1,1,1,3,1,5,5,1,1,1,1,5,3,2,1,2,3,1,5,1,1,4,1,1,2,1,5,1,1,1,1,5,4,5,1,3,1,3,3,5,5,1,3,1,5,3,1,1,4,2,3,3,1,2,4,1,1,1,1,1,1,1,2,1,1,4,1,3,2,5,2,1,1,1,4,2,1,1,1,4,2,4,1,1,1,1,4,1,3,5,5,1,2,1,3,1,1,4,1,1,1,1,2,1,1,4,2,3,1,1,1,1,1,1,1,4,5,1,1,3,1,1,2,1,1,1,5,1,1,1,1,1,3,2,1,2,4,5,1,5,4,1,1,3,1,1,5,5,1,3,1,1,1,1,4,4,2,1,2,1,1,5,1,1,4,5,1,1,1,1,1,1,1,1,1,1,3,1,1,1,1,1,4,2,1,1,1,2,5,1,4,1,1,1,4,1,1,5,4,4,3,1,1,4,5,1,1,3,5,3,1,2,5,3,4,1,3,5,4,1,3,1,5,1,4,1,1,4,2,1,1,1,3,2,1,1,4));

    long[] fishAges = new long[5];

    /**
     * Instead of running an ever exspanding list of fishes, count their zeroes
     * @param numberOfDays
     * @return
     */
    private void calculateAmountOfZeroes(int numberOfDays, List<Integer> inputList) {
        int totalAmountOfFishes = inputList.size();
        long[] tempCalclist = new long[9]; // keep track of the amount of every age
        int numberOfDaysCopy = numberOfDays;
        System.out.println("The starting amount of fishes is: " + totalAmountOfFishes);

        // convert input-list to tempcalc list based on ages
        for(Integer fishAge: inputList) {
            switch (fishAge) {
                case 0: tempCalclist[0] += 1; break;
                case 1: tempCalclist[1] += 1; break;
                case 2: tempCalclist[2] += 1; break;
                case 3: tempCalclist[3] += 1; break;
                case 4: tempCalclist[4] += 1; break;
                case 5: tempCalclist[5] += 1; break;
                case 6: tempCalclist[6] += 1; break;
                case 7: tempCalclist[7] += 1; break;
                case 8: tempCalclist[8] += 1; break;
            }
        }

        long zeroes;

        while(numberOfDays > 0) {
            zeroes = tempCalclist[0];
            for(int i = 0; i < tempCalclist.length - 1; ++i) {
                tempCalclist[i] = tempCalclist[i + 1]; // move all items one back in the list
            }
            tempCalclist[8] = zeroes;
            tempCalclist[6] += zeroes;
            numberOfDays--;
        }

        long sum = 0;
        for(long number: tempCalclist) {
            sum += number;
        }
        System.out.println("The amount of fishes in the pool after "+ numberOfDaysCopy + " days is: " + sum);
    }

    @Override
    public boolean getAnswerFromExample() {
        // create initial fishes list
        calculateAmountOfZeroes(18, inputListExample);
        calculateAmountOfZeroes(80, inputListExample);
        return true;
    }


    @Override
    public boolean getAnswerForQuestion() {
        calculateAmountOfZeroes(80, inputListQuestion);
        return true;
    }

    @Override
    public boolean getAnswersFromExamplePart2() {
        calculateAmountOfZeroes(256, inputListExample);
        return false;
    }

    @Override
    public boolean getAnswersForQuestionPart2() {
        calculateAmountOfZeroes(256, inputListQuestion);
        return false;
    }
}
