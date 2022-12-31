package com.wytzig.lw.nl.advent.twentytwentyone.bingo;

public class BingoCard {
    public final String name;

    int[][] initalBingoCard = new int[5][5];

    boolean[][] markedCard = new boolean[5][5];

    int finalScore = -1; // multiplication of all positive numbers can never be negative

    public BingoCard(String name) {
        this.name = name;
    }

    public int getNumberForRowAndColumn(int row, int column) {
        return initalBingoCard[row][column];
    }

    // returns true if there is a bingo and sets the final score variable
    public boolean callNumberCheckBingoAndReturnScore(int calledNumber) {
        if(this.finalScore == -1) { // no bingo yet
            boolean result = callNumberAndCheckForBingo(calledNumber);
            if(result) {
                this.finalScore = calculateScore(calledNumber);
//                System.out.println("We have bingo for card: " + name);
//                System.out.println("Score is: " + finalScore);
//                System.out.print("last pulled number was: " + calledNumber);
            }
            return result;
        } else { // there already was a bingo for this card
            return true;
        }
    }

    //call with a given next number
    //if the number is on the card, the number will be 'marked'.
    //if a full column or a full row is marked, then we have bingo
    private boolean callNumberAndCheckForBingo(int calledNumber) {
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

    /**@return true if we have bingo, false otherwise   */
    private boolean checkForBingo() {
        int rowSucces = 0;
        int columnSucces = 0;
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j <5; j++) {
                // check every position
                if(markedCard[i][j] == true) {
                    rowSucces++;
                }
                if(rowSucces == 5) {
                    return true;
                }
            }
            // next column so reset row succes
            rowSucces = 0;
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j<5; j++) {
                if(markedCard[j][i] == true) {
                    columnSucces++;
                }
                if(columnSucces == 5) {
                    return true;
                }
            }
            columnSucces = 0;
        }
        // assert that row and column successes cannot be >5
        assert columnSucces <= 5;
        return false;
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
                    markedCard[i][j] = true;
                    return true;
                }
            }
        }
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
