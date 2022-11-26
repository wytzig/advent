package com.wytzig.lw.nl.advent.twentytwentyone.bingo;

import com.wytzig.lw.nl.advent.Day;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Let's play bingo with the kraken, yarrr
 *
 * "Captian's diary" : "Win or lose, that thing shall not break the game!
 * yarrr"
 */
public class Day4 implements Day {

    public ArrayList<Integer> pulledBingoBallsInOrder= new ArrayList<>(
            Arrays.asList(7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1)
    );

    public void initBingoCardsFromExample() {
        System.out.println("---- Initializing bingo cards for example ----");
        BingoCard card1 = new BingoCard("card1");
        card1.initInitialBingoCard(22, 13, 17, 11,  0, 8, 2, 23,  4, 24, 21, 9, 14, 16,  7, 6, 10, 3, 18, 5, 1, 12, 20, 15, 19);
        System.out.println("printing card 1: ");
        card1.prettyPrintCard();
        BingoCard card2 = new BingoCard("card2");
        card2.initInitialBingoCard(3, 15,  0,  2, 22,
                9, 18, 13, 17,  5,
                19,  8,  7, 25, 23,
                20, 11, 10, 24,  4,
                14, 21, 16, 12,  6);
        card2.prettyPrintCard();
        BingoCard card3 = new BingoCard("card3");
        card3.initInitialBingoCard(14, 21, 17, 24,  4,
                10, 16, 15, 9, 19,
                18,  8, 23, 26, 20,
                22, 11, 13, 6, 5,
                2 , 0, 12, 3, 7);
        card3.prettyPrintCard();
        System.out.println("---- Finished initializing ----");
    }

    @Override
    public boolean getAnswerFromExample() {
        initBingoCardsFromExample();
        return false;
    }

    @Override
    public boolean getAnswerForQuestion() {
        return false;
    }

}
