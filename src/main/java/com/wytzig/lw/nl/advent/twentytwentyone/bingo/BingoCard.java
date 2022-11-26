package com.wytzig.lw.nl.advent.twentytwentyone.bingo;

public class BingoCard {
    private final String name;

    private int[][] initalBingoCard = new int[5][5];

    public BingoCard(String name) {
        this.name = name;
    }

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
        System.out.println("Pretty print for card: " + name);
        for(int i = 0; i < 5; i++) { //every 5 items
            for (int j = 0; j < 5; j++) { //column
                System.out.print(initalBingoCard[i][j] + " "); // print for column
            }
            System.out.print("\n");
        }
    }

}
