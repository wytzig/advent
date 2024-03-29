package com.wytzig.lw.nl.advent.twentytwentytwo.rockpaperscissors;

import com.wytzig.lw.nl.advent.Day;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DayTwo extends Day {

    List<String[]> strategyGuide = new ArrayList<>();

    public long processStrategyGuide() {
        long sum = 0;
        for(String[] strategy: strategyGuide) {
            Optional<GameOptions> myHand = getOptionForInput(strategy[1]);
            Optional<GameOptions> theirHand = getOptionForInput(strategy[0]);

            if(myHand.isPresent() && theirHand.isPresent()) {
                Optional<Long> roundScore = getResultForRound(myHand.get(), theirHand.get());
                if(roundScore.isPresent()) {
                    sum += roundScore.get();
                } else {
                    System.out.println("ERROR, problems while playing rounds. Unknown option played");
                }
            } else {
                System.out.println("ERROR, someone's hand was not any of the pre-defined options (rock, paper, scissors)");
            }
        }
        return sum;
    }

    public long processStrategyGuideForUnknownHand() {
        long sum = 0;
        for (String[] strategy: strategyGuide) {
            Optional<GameOptions> theirHand = getOptionForInput(strategy[0]);

            if(theirHand.isPresent()) {
                Optional<Long> result = getWhatYouNeedToThrowToAchieveResult(theirHand.get(), strategy[1]);
                if(result.isPresent()) {
                    sum += result.get();
                } else {
                    System.out.println("ERROR, problems while playing rounds. Unknown option played");
                }
            } else {
                System.out.println("ERROR, their hand was not any of the pre-defined options (rock, paper, scissors)");
            }
        }
        return sum;
    }

    // x means to lose
    // y means to draw
    // z means to win
    private Optional<Long> getWhatYouNeedToThrowToAchieveResult(GameOptions opponent, String outcome) {
        if(opponent == GameOptions.ROCK) {
            switch (outcome) {
                case "X" -> {
                    return Optional.of(3l); // lose to rock, scissors so 3 + 0
                }
                case "Y" -> {
                    return Optional.of(4l); // draw to rock, rock so 1 + 3
                }
                case "Z" -> {
                    return Optional.of(8l); // win to rock, paper so 2 + 6
                }
            }
        } else if (opponent == GameOptions.PAPER) {
            switch (outcome) {
                case "X" -> {
                    return Optional.of(1l); // lose to paper, rock so 1 + 0
                }
                case "Y" -> {
                    return Optional.of(5l); // draw to paper, paper so 2 + 3
                }
                case "Z" -> {
                    return Optional.of(9l); // win to paper, scissors so 3 + 6
                }
            }
        } else if (opponent == GameOptions.SCISSORS) {
            switch (outcome) {
                case "X" -> {
                    return Optional.of(2l); // lose to scissors, paper so 2 + 0
                }
                case "Y" -> {
                    return Optional.of(6l); // draw to scissors, scissors so 3 + 3
                }
                case "Z" -> {
                    return Optional.of(7l); // win to scissors, rock so 1 + 6
                }
            }
        }
        return Optional.empty();
    }

    private Optional<GameOptions> getOptionForInput(String input) {
        if(input.equals("A") || input.equals("X")) {
            return Optional.of(GameOptions.ROCK);
        } else if(input.equals("B") || input.equals("Y")) {
            return Optional.of(GameOptions.PAPER);
        } else if(input.equals("C") || input.equals("Z")) {
            return Optional.of(GameOptions.SCISSORS);
        }
        return Optional.empty();
    }

    // A, X for rock
    // B, Y for paper
    // C, Z for scissors

    private Optional<Long> getResultForRound(GameOptions x, GameOptions y) {
        if(x == GameOptions.ROCK) {
            switch (y) {
                case ROCK -> {
                    return Optional.of(4l); // draw for rock 1 + 3
                }
                case SCISSORS -> {
                    return Optional.of(7l); // win for rock 1 + 6
                }
                case PAPER -> {
                    return Optional.of(1l); // lose for rock 1 + 0
                }
            }
        } else if (x == GameOptions.SCISSORS) {
            switch (y) {
                case ROCK -> {
                    return Optional.of(3l); // lose for scissors 3 + 0
                }
                case SCISSORS -> {
                    return Optional.of(6l); // draw for scissors 3 + 3
                }
                case PAPER -> {
                    return Optional.of(9l); // win for scissors 3 + 6
                }
            }
        } else if (x == GameOptions.PAPER) {
            switch (y) {
                case ROCK -> {
                    return Optional.of(8l); // win for paper 2 + 6
                }
                case SCISSORS -> {
                    return Optional.of(2l); // lose for paper 2 + 0
                }
                case PAPER -> {
                    return Optional.of(5l); // draw for paper 2 + 3
                }
            }
        }
        return Optional.empty();
    }

    public void processInput(String pathToInputFile) {
        File input = new File(pathToInputFile);
        try {
            Scanner sc = new Scanner(input);

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splittedLine = line.split(" ");
                this.strategyGuide.add(splittedLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error processing input file");
            throw new RuntimeException(e);
        } finally {
            System.out.println("Finished processing of file");
        }
    }

    @Override
    public boolean getAnswerFromExample() {
        processInput("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentytwo\\input\\day2_puzzle_example");
        System.out.println("Total score was: " + processStrategyGuide());
        this.strategyGuide = new ArrayList<>(); // flush global vars
        return true;
    }

    @Override
    public boolean getAnswerForQuestion() {
        processInput("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentytwo\\input\\day2_puzzle_question");
        System.out.println("Total score was: " + processStrategyGuide());
        this.strategyGuide = new ArrayList<>();
        return true;
    }

    @Override
    public boolean getAnswersFromExamplePart2() {
        processInput("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentytwo\\input\\day2_puzzle_example");
        System.out.println("Total score was: " + processStrategyGuideForUnknownHand());
        this.strategyGuide = new ArrayList<>();
        return true;
    }

    @Override
    public boolean getAnswersForQuestionPart2() {
        processInput("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentytwo\\input\\day2_puzzle_question");
        System.out.println("Total score was: " + processStrategyGuideForUnknownHand());
        this.strategyGuide = new ArrayList<>();
        return false;
    }
}
