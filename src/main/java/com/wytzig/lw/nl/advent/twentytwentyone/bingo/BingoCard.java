package com.wytzig.lw.nl.advent.twentytwentyone.bingo;

import org.bouncycastle.asn1.esf.SPUserNotice;

public class BingoCard {
    public final String name;

    int[][] initalBingoCard = new int[5][5];

    boolean[][] markedCard = new boolean[5][5];

    public BingoCard(String name) {
        this.name = name;
    }

    public int getNumberForRowAndColumn(int row, int column) {
        return initalBingoCard[row][column];
    }

    public boolean callNumberCheckBingoAndReturnScore(int calledNumber) {
        boolean result = callNumberAndCheckForBingo(calledNumber);
        if(result) {
            System.out.println("Score is: " + calculateScore(calledNumber));
            System.out.println("--------------------- ");
        }
        return result;
    }

    //call with a given next number
    //if the number is on the card, the number will be 'marked'.
    //if a full column or a full row is marked, then we have bingo
    private boolean callNumberAndCheckForBingo(int calledNumber) {
//        System.out.println("-------------");
//        System.out.println("-------------");
//        System.out.println("call number: "+ calledNumber);
        // check number and fill the marked card
        isPresentInCard(calledNumber);

        // check row's for bingo
        return checkForBingo();
    }

    // all unmarked numbers from the initial list is aggregated and returned as SUM
    private int calculateScore(int lastCalledNumber) {
        int result = 0;
        for(int i = 0; i <5; i++) {
            for(int j = 0; j<5; j++) {
                if(markedCard[i][j] == false) {
                    result += initalBingoCard[i][j];
                }
            }
        }
        return result * lastCalledNumber;
    }

    private boolean checkForBingo() {
        int rowSucces = 0;
        int columnSucces = 0;
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j <5; j++) {
                // check every row
                if(markedCard[i][j] == true) rowSucces++;
                if(rowSucces == 5) {
                    bingoPrint(rowSucces, columnSucces);
                    return true;
                }
            }
            // next column so reset row succes
            rowSucces = 0;

            if(markedCard[i][0] == true) columnSucces++;
            if(columnSucces == 5) {
                bingoPrint(rowSucces, columnSucces);
                return true;
            }
        }
        // assert that row and column successes cannot be >5
        assert columnSucces <= 5;
        return false;
    }

    private void bingoPrint(int rowSucces, int columnSucces) {
        System.out.println("rowsucces: " + rowSucces + " and columnSucces: " + columnSucces);
        System.out.println("WE HAVE A BINGO!!!");
        System.out.println("Card: " + this.name);

    }


    /**
     * Also sets a true flag in the markedBingoCard list on the pos (x,y) that if found
     * the number
     * @param calledNumber the number drawn by the bingoMeister
     * @return true if the number exists on the bingo card, false otherwise
     */
    private boolean isPresentInCard(int calledNumber) {
        for(int i = 0; i < 5; i++) { // every row
            for (int j = 0; j < 5; j++) { // every column
                if(initalBingoCard[i][j] == calledNumber) {
//                    System.out.println("\ncalled number: " + calledNumber + " was present on" + this.name + " on pos: " + (i + 1) + ", " + (j + 1));
                    markedCard[i][j] = true;
//                    prettyPrintMarkedCard();
                    return true;
                }
            }
        }
        System.out.println("called number: " + calledNumber + " was not present on card " + this.name);
        return false;
    }

    void initInitialBingoCard(Integer... numbers) {
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

    public void prettyPrintInitialCard() {
        System.out.println("---------------------");
        System.out.println("Pretty print initalCard for card: " + name);
        System.out.println("---------------------");
        for(int i = 0; i < 5; i++) { //every 5 items
            for (int j = 0; j < 5; j++) { //column
                System.out.print(initalBingoCard[i][j] + " "); // print for column
            }
            System.out.print("\n");
        }
    }

    public void prettyPrintMarkedCard() {
        System.out.println("---------------------");
        System.out.println("Pretty print markedCard for card: " + name);
        System.out.println("---------------------");
        for(int i = 0; i < 5; i++) { //every 5 items
            for (int j = 0; j < 5; j++) { //column
                System.out.print(markedCard[i][j] + " "); // print for column
            }
            System.out.print("\n");
        }
    }

}
