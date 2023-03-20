package com.wytzig.lw.nl.advent.twentytwentytwo.rucksackCheck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Executer {

    public Executer(String inputLocation) {
        processInput(inputLocation);
    }

    List<String> rucksack = new ArrayList<>();

    public int findBadgesScore() {
        List<String> elfGroup = new ArrayList<>();
        int priorityScore = 0;
        for(int i = 0; i <= rucksack.size() - 1; i++) {
            elfGroup.add(rucksack.get(i));
            if((i + 1) % 3 == 0) {
                Optional<Character> overLappingChar = getOverLappingCharacter(elfGroup.get(0), elfGroup.get(1), elfGroup.get(2));
                if(overLappingChar.isPresent()) {
//                    System.out.println("Overlapping char is: '" + overLappingChar.get() + "'");
                    Optional<Integer> score = getPriorityForCharByConvertingASCII(overLappingChar.get());
                    if(score.isPresent()) {
                        priorityScore += score.get();
                    } else {
                        System.out.println("ERROR, char was no upper or lower case letter but was: '" + overLappingChar + "'");
                    }
                } else {
                    System.out.println("ERROR, No overlapping chars found!");
                }
                elfGroup = new ArrayList<>(); // refactor to use String[3] for optimization
            }
        }
        this.rucksack = new ArrayList<>();
        return priorityScore;
    }

    public int processRuckSack() {
        int prioritizationRearangementScore = 0;
        for (String line: rucksack) {
            String compartmentOne = line.substring(0, (line.length()/ 2));
            String compartmentTwo = line.substring(line.length() / 2);

            Optional<Character> overlappingChar = getOverLappingCharacter(compartmentOne, compartmentTwo);
            if(overlappingChar.isPresent()) {
                Optional<Integer> charPrioScore = getPriorityForCharByConvertingASCII(overlappingChar.get());
                if(charPrioScore.isPresent()) {
                    prioritizationRearangementScore += charPrioScore.get();
                } else {
                    System.out.println("ERROR, char was no upper or lower case letter but was: '" + overlappingChar + "'");
                }
            } else {
                System.out.println("ERROR, no overlapping char found!");
            }
        }
        this.rucksack = new ArrayList<>();
        return prioritizationRearangementScore;
    }

    private void processInput(String inputFileLocation) {
        File inputFile = new File(inputFileLocation);
        try {
            Scanner sc = new Scanner(inputFile);
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                this.rucksack.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error while processing file!");
            throw new RuntimeException(e);
        }
    }

    /**We have to do this check 3 times because of the flexible string lengths */
    private Optional<Character> getOverLappingCharacter(String elfOne, String elfTwo, String elfThree) {
        Optional<Character> testStringOne = processSequence(elfOne, elfTwo, elfThree);
        Optional<Character> testStringTwo = processSequence(elfTwo, elfOne, elfThree);
        Optional<Character> testStringThree = processSequence(elfThree, elfTwo, elfOne);

        if(testStringOne.isPresent()) {
            return Optional.of(testStringOne.get());
        } else if (testStringTwo.isPresent()) {
            return Optional.of(testStringTwo.get());
        } else if (testStringThree.isPresent()) {
            return Optional.of(testStringThree.get());
        }

        assert !(testStringOne.isPresent() && testStringTwo.isPresent());
        assert !(testStringOne.isPresent() && testStringThree.isPresent());
        assert !(testStringThree.isPresent() && testStringTwo.isPresent());

        return Optional.empty();
    }

    private Optional<Character> processSequence(String stringWalkOver, String compareToOne, String compareToTwo) {
        for(Character c: stringWalkOver.toCharArray()) {
            if(compareToOne.contains(Character.toString(c)) && compareToTwo.contains(Character.toString(c))) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    private Optional<Character> getOverLappingCharacter(String compartmentOne, String compartmentTwo) {
        for(int i = 0; i < compartmentOne.length(); i++) {
            char currentCharToCompare = compartmentOne.charAt(i);

            if(compartmentTwo.contains(Character.toString(currentCharToCompare))) {
//                System.out.println("Overlapping char was: '" + currentCharToCompare + "'");
                return Optional.of(currentCharToCompare);
            }
        }
        return Optional.empty();
    }

    private Optional<Integer> getPriorityForCharByConvertingASCII(char c) {
        if(Character.isUpperCase(c)){
            return Optional.of(c - 38);
        } else if(Character.isLowerCase(c)) {
            return Optional.of(c - 96);
        }
        return Optional.empty();
    }
}
