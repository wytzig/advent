package com.wytzig.lw.nl.advent.twentytwentyone.bingo;

import com.wytzig.lw.nl.advent.Day;

import java.io.File;
import java.util.*;

/**
 * Let's play bingo with the kraken, yarrr
 *
 * "Captian's diary" : "Win or lose, that thing shall not break the game!
 * yarrr"
 */
public class Day4 extends Day {

    public ArrayList<Integer> pulledBingoBallsFromExample = new ArrayList<>(
            Arrays.asList(7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1)
    );

    public ArrayList<Integer> pulledBingoBallsFromQuestion = new ArrayList<>(
            Arrays.asList(76,69,38,62,33,48,81,2,64,21,80,90,29,99,37,15,93,46,75,0,89,56,58,40,92,47,8,6,54,96,12,66,83,4,70,19,17,5,50,52,45,51,18,27,49,71,28,86,74,77,11,20,84,72,23,31,16,78,91,65,87,79,73,94,24,68,63,9,88,82,30,42,60,13,67,85,44,59,7,53,22,1,26,41,61,55,43,39,3,35,25,34,57,10,14,32,97,95,36,98)
    );

    private BingoCard card1;
    private BingoCard card2;
    private BingoCard card3;

    private File day4Input = null;

    public List<Integer> tempList = new ArrayList<>();
    public BingoCard tempCard = new BingoCard("default_name");

    public List<BingoCard> question_bingoCards = new ArrayList<>();

    public List<BingoCard> filled_bingo_cards = new ArrayList<>();

    @Override
    public boolean getAnswerFromExample() {
        initBingoCardsFromExample();
        for(int number: pulledBingoBallsFromExample) {
            if(card1.callNumberCheckBingoAndReturnScore(number) ||
                    card2.callNumberCheckBingoAndReturnScore(number) ||
                    card3.callNumberCheckBingoAndReturnScore(number)) {
                // we have bingo so exit
                return true;
            }
        }
        System.out.println("\n\n there was no bingo :(");
        return false; // no bingo :(
    }

    @Override
    public boolean getAnswerForQuestion() {
        setDay4InputFromRemote();
        initBingoCardsFromInputList();
        for(int number: pulledBingoBallsFromQuestion) {
            for(BingoCard card: question_bingoCards) {
                if(card.callNumberCheckBingoAndReturnScore(number)) return true;
            }
        }
        System.out.println("\n\n there was no bingo :(");
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

    public boolean getAnswerPartTwoExample() {
        filled_bingo_cards = new ArrayList<>(); // flush just in case
        initBingoCardsFromExample();
        List<BingoCard> listOfBingoCards = new ArrayList<>(List.of(card1, card2, card3));
        ArrayList<BingoCard> cardsToSkip = new ArrayList<>();

        System.out.println("The amount of input numbers are: " + pulledBingoBallsFromExample.size());
        System.out.println("The amount of bingo cards are: " + listOfBingoCards.size());
        for(int number: pulledBingoBallsFromExample) { // process all numbers
            for(BingoCard card: listOfBingoCards) { // for all known bingo cards
                if(listOfBingoCards.size() != cardsToSkip.size()) { // only process new numbers as not every card has a bingo
                    if(card.callNumberCheckBingoAndReturnScore(number) && !cardsToSkip.contains(card)) {
                        filled_bingo_cards.add(card);
                        cardsToSkip.add(card);
                    }
                } // else we skil processing the numbers, although the loop continues
            }
        }

        BingoCard lastCard = filled_bingo_cards.get(filled_bingo_cards.size() - 1);
        System.out.println("The amount of bingos were: " + filled_bingo_cards.size());
        System.out.println("The last bingo was: " + lastCard.name);
        System.out.println("And it's score would be: " + lastCard.finalScore);

        return false; // no bingo :(
    }

    public boolean getAnswerPartTwo() {
        question_bingoCards = new ArrayList<>(); // flush just in case
        setDay4InputFromRemote();
        initBingoCardsFromInputList();
        List<BingoCard> listOfBingoCards = new ArrayList<>(question_bingoCards);
        ArrayList<BingoCard> cardsToSkip = new ArrayList<>();
        for(int number: pulledBingoBallsFromQuestion) {
            for(BingoCard card: listOfBingoCards) {
                if(listOfBingoCards.size() != cardsToSkip.size()) { // only process new numbers as not every card has a bingo
                    if(card.callNumberCheckBingoAndReturnScore(number) && !cardsToSkip.contains(card)) {
                        filled_bingo_cards.add(card);
                        cardsToSkip.add(card);
                    }
                }
            }
        }
        BingoCard lastCard = filled_bingo_cards.get(filled_bingo_cards.size() - 1);
        System.out.println("The amount of inputCards were: " + question_bingoCards.size());
        System.out.println("The amount of bingos were: " + filled_bingo_cards.size());
        System.out.println("The last bingo was: " + lastCard.name);
        System.out.println("And it's score would be: " + lastCard.finalScore);

        return false; // no bingo :(
    }

    public void initBingoCardsFromInputList() {
        int linesProcessed = 0;
        try {
            Scanner scanner = new Scanner(this.day4Input);

            int cardsProcessed = 0;
            while (scanner.hasNextLine()) { // for every line in the file
                String line = scanner.nextLine();
                if(line.isEmpty() || line.isBlank()) { // on every empty line create a new card

                    // create new card
                    String name = "card"+cardsProcessed; // make name

                    if(cardsProcessed != 0) {
                        Integer[] inputList = tempList.toArray(new Integer[5]); // create inputListForBingoCard
                        tempCard.initInitialBingoCard(inputList); // set tempCard
                        question_bingoCards.add(this.tempCard); // add tempcard as new BingoCard
//                        System.out.println("initialized card " + this.tempCard.name + ", with data: ");
//                        tempCard.prettyPrintInitialCard();
                    }

                    this.tempCard = new BingoCard(name); // create new tempcard & flush tempCard
                    tempList = new ArrayList<>(); // flush tempList

                    cardsProcessed++;

                } else {
                    createListFromInputString(line); // construct tempList
                }
                linesProcessed++;
            }
        } catch (Exception e) {
            System.out.println("Exception while decoding input file with ex: " + e.getMessage());
            System.out.println("Lines processed: " + linesProcessed);
        }
    }

    /**
     * A strict parser for the given input file where a line will be processed into
     * a list of numbers. i.e.: 0 3 43 0 11 1, will be converted and set to a variable
     * List(0,3,43,0,11,1)
     * @param input
     */
    private void createListFromInputString(String input) {
        String[] lineItems = input.split("\s");
        for(String item: lineItems) {
            if(item != "") {
                int number = Integer.parseInt(item);
                this.tempList.add(number);
            }
        }
    }

    private void setDay4InputFromRemote() {
        // create java.File based on input from remote
        day4Input = null;
        day4Input = new File("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentyone\\input_files\\day4_input.txt");
    }

    public void initBingoCardsFromExample() {
        System.out.println("---- Initializing bingo cards for example ----");
        card1 = new BingoCard("card1");
        card1.initInitialBingoCard(
                22, 13, 17, 11, 0,
                8, 2, 23,  4, 24,
                21, 9, 14, 16,  7,
                6, 10, 3, 18, 5, 1,
                12, 20, 15, 19);
        System.out.println("printing card 1: ");
//        card1.prettyPrintInitialCard();

        card2 = new BingoCard("card2");
        card2.initInitialBingoCard(
                3, 15,  0,  2, 22,
                9, 18, 13, 17,  5,
                19,  8,  7, 25, 23,
                20, 11, 10, 24,  4,
                14, 21, 16, 12,  6);
//        card2.prettyPrintInitialCard();

        card3 = new BingoCard("card3");
        card3.initInitialBingoCard(
                14, 21, 17, 24,  4,
                10, 16, 15, 9, 19,
                18,  8, 23, 26, 20,
                22, 11, 13, 6, 5,
                2 , 0, 12, 3, 7);
//        card3.prettyPrintInitialCard();
        System.out.println("---- Finished initializing ----");
    }
}
