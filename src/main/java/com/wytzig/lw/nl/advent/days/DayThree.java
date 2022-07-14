package com.wytzig.lw.nl.advent.days;

import java.io.File;
import java.util.List;

/**
 *
 *
 *
 *  1. The most common bit of the first bit is(2x (0) & 5x (1)) :: gamma=[1].
 *  2. The definition of a second most common bit is as the second bit is more comman i.e. ( (2x (0) & 5x (1)) :: gamma=[1, 1]).
 *  3. The definition of a 3rd, 4th and 5th common bit is the same as 1 & 2. This is adding to gamma[]
 *  4. gamma[5] is complete, for example should be:
 *
 *  //todo epsilon
 *
 */
public class DayThree implements Day {

    private List<String> ExampleDiagnosticInput = List.of("00100", "11110", "10110", "10111", "101001",
    "01111", "00111", "11100","10000","11001", "00010","01010");


    String bitGammaRate;
    String bitEpsilonRate;

    @Override
    public boolean getAnswerFromExample() {
        return false;
    }

    @Override
    public boolean getAnswerForQuestion() {
        return false;
    }

    @Override
    public List<String> computeFromText(File input) {
        return null;
    }
}
