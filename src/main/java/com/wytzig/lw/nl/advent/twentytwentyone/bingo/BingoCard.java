package com.wytzig.lw.nl.advent.twentytwentyone.bingo;

import lombok.AllArgsConstructor;

public class BingoCard {

    public int[][] initalBingoCard = new int[5][5];

    public int getNumberForRowAndColumn(int row, int column) {
        return initalBingoCard[row][column];
    }

    void initInitialBingoCard(int... numbers) {
        int processed = 0;
        int rowPos = 0;
        int columnNumber = 0;
        for(int number: numbers) {
            initalBingoCard[columnNumber][rowPos] = number;
            processed++;
            rowPos++;
            if(processed % 5 == 0) { // if we've had 5 numbers, we've processed a column
                rowPos = 0;
                columnNumber++;
            }
        }
    }

    public void prettyPrintCard() {
        for(int i = 0; i < 5; i++) { //every 5 items
            for (int j = 0; j < 5; j++) { //column
                System.out.print(initalBingoCard[i][j] + " "); // print for column
            }
            System.out.print("\n");
        }
    }

}
