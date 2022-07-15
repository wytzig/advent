package com.wytzig.lw.nl.advent.days.utills;

import com.wytzig.lw.nl.advent.days.Day;
import com.wytzig.lw.nl.advent.days.DayThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GenericUtils {

    public List<String> computeFromText(File input, Day reference) {
        try {
            Scanner scanner = new Scanner(input);
            System.out.println("scanner successfully started..");
            return callback(scanner, reference); //todo fix implementation

        } catch (FileNotFoundException e) {
            System.out.println("could not init scanner: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public List<String> callback(Scanner scanner, Day reference) {

        //get specific class
        String className = reference.getClassName();

        // call original caller back
        return Collections.emptyList();

    }
}
