package com.wytzig.lw.nl.advent.twentytwentytwo.stackingsnacks;

import com.wytzig.lw.nl.advent.Day;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Using Deque which is supposed to be a more complete LIFO implementation than a util.Stack
 */
public class DayFive extends Day {


    private Deque<Character> stack1 = new ArrayDeque<>();
    private Deque<Character> stack2 = new ArrayDeque<>();
    private Deque<Character> stack3 = new ArrayDeque<>();
    private Deque<Character> stack4 = new ArrayDeque<>();
    private Deque<Character> stack5 = new ArrayDeque<>();
    private Deque<Character> stack6 = new ArrayDeque<>();
    private Deque<Character> stack7 = new ArrayDeque<>();
    private Deque<Character> stack8 = new ArrayDeque<>();
    private Deque<Character> stack9 = new ArrayDeque<>();

    private void prettyPrintFirst() {
        System.out.println("on top of every stack: " + stack1.peekLast() + stack2.peekLast() + stack3.peekLast() +
                stack4.peekLast() + stack5.peekLast() + stack6.peekLast() + stack7.peekLast() + stack8.peekLast() +
                stack9.peekLast());
    }
    public void setupExample() {
        stack1.add('Z');
        stack1.add('N');
        stack2.add('M');
        stack2.add('C');
        stack2.add('D');
        stack3.add('P');
    }

    public void setupQuestion() {
        stack1.add('W');
        stack1.add('D');
        stack1.add('G');
        stack1.add('B');
        stack1.add('H');
        stack1.add('R');
        stack1.add('V');

        stack2.add('J');
        stack2.add('N');
        stack2.add('G');
        stack2.add('C');
        stack2.add('R');
        stack2.add('F');

        stack3.add('L');
        stack3.add('S');
        stack3.add('F');
        stack3.add('H');
        stack3.add('D');
        stack3.add('N');
        stack3.add('J');

        stack4.add('J');
        stack4.add('D');
        stack4.add('S');
        stack4.add('V');

        stack5.add('S');
        stack5.add('H');
        stack5.add('D');
        stack5.add('R');
        stack5.add('Q');
        stack5.add('W');
        stack5.add('N');
        stack5.add('V');

        stack6.add('P');
        stack6.add('G');
        stack6.add('H');
        stack6.add('C');
        stack6.add('M');

        stack7.add('F');
        stack7.add('J');
        stack7.add('B');
        stack7.add('G');
        stack7.add('L');
        stack7.add('Z');
        stack7.add('H');
        stack7.add('C');

        stack8.add('S');
        stack8.add('J');
        stack8.add('R');

        stack9.add('L');
        stack9.add('G');
        stack9.add('S');
        stack9.add('R');
        stack9.add('B');
        stack9.add('N');
        stack9.add('V');
        stack9.add('M');
    }

    private void cleanGlobals() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
        stack3 = new ArrayDeque<>();
        stack4 = new ArrayDeque<>();
        stack5 = new ArrayDeque<>();
        stack6 = new ArrayDeque<>();
        stack7 = new ArrayDeque<>();
        stack8 = new ArrayDeque<>();
        stack9 = new ArrayDeque<>();
    }

    private List<List<Integer>> processInputAndGetMoveSetList(String pathToFile) {
        File file = new File(pathToFile);
        List<List<Integer>> result = new ArrayList<>();

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                Scanner sc2 = new Scanner(line);
                sc2.useDelimiter("[^\\d]+"); // removes all the non digits

                List<Integer> moves = new ArrayList<>();
                while(sc2.hasNextInt()) {
                    moves.add(sc2.nextInt());
                }
                assert moves.size() == 3;
                result.add(moves);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR, file not found exception: " + e);
        }
        return result;
    }

    private void executeAllMoveSets(List<List<Integer>> allMoveSets, boolean isPartTwo) {
        for(List<Integer> moveset: allMoveSets) {
            executeMoveSet(moveset, isPartTwo);
        }
    }

    private void executeMoveSet(List<Integer> moveSet, boolean moveWithMoveCrane9001) {
        assert moveSet.size() == 3;
        Optional<Deque<Character>> optionalStackToMoveFrom = getStackForNumericValue(moveSet.get(1));
        Optional<Deque<Character>> optionalStackToMoveTo = getStackForNumericValue(moveSet.get(2));

        if(optionalStackToMoveTo.isPresent() && optionalStackToMoveFrom.isPresent()) {
            if(moveWithMoveCrane9001) {
                moveMultipleItemsToStack(moveSet.get(0), optionalStackToMoveFrom.get(), optionalStackToMoveTo.get()); // part 2
            } else {
                moveItemToStack(moveSet.get(0), optionalStackToMoveFrom.get(), optionalStackToMoveTo.get()); // part 1
            }
        }
    }

    private void moveItemToStack(int amountOfItemsToPop, Deque<Character> stackToMoveFrom, Deque<Character> stackToMoveTo) {
        for(int i = 0; i < amountOfItemsToPop; i++) {
            stackToMoveTo.addLast(stackToMoveFrom.removeLast());
        }
    }

    private void moveMultipleItemsToStack(int amountOfItemsToPop, Deque<Character> stackToMoveFrom, Deque<Character> stackToMoveto) {
        Deque<Character> movingItemsOnTheCreateMover9001 = new ArrayDeque<>();
        for(int i = 0; i < amountOfItemsToPop; i++) {
            movingItemsOnTheCreateMover9001.add(stackToMoveFrom.removeLast());
        }
        for(int i = 0; i < amountOfItemsToPop; i++) {
            stackToMoveto.add(movingItemsOnTheCreateMover9001.removeLast());
        }
    }

    private Optional<Deque<Character>> getStackForNumericValue(int stackNumber) {
        assert stackNumber <= 9;
        switch (stackNumber) {
            case 1: return Optional.ofNullable(this.stack1);
            case 2: return Optional.ofNullable(this.stack2);
            case 3: return Optional.ofNullable(this.stack3);
            case 4: return Optional.ofNullable(this.stack4);
            case 5: return Optional.ofNullable(this.stack5);
            case 6: return Optional.ofNullable(this.stack6);
            case 7: return Optional.ofNullable(this.stack7);
            case 8: return Optional.ofNullable(this.stack8);
            case 9: return Optional.ofNullable(this.stack9);
            default: Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public boolean getAnswerFromExample() {
        setupExample();
        List<List<Integer>> moveSets = processInputAndGetMoveSetList("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentytwo\\input\\day5_example");
        executeAllMoveSets(moveSets, false);
        prettyPrintFirst();
        cleanGlobals();
        return true;
    }

    @Override
    public boolean getAnswerForQuestion() {
        setupQuestion();
        List<List<Integer>> moveSets = processInputAndGetMoveSetList("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentytwo\\input\\day5_question");
        executeAllMoveSets(moveSets, false);
        prettyPrintFirst();
        cleanGlobals();
        return true;
    }

    @Override
    public boolean getAnswersFromExamplePart2() {
        setupExample();
        List<List<Integer>> moveSets = processInputAndGetMoveSetList("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentytwo\\input\\day5_example");
        executeAllMoveSets(moveSets, true);
        prettyPrintFirst();
        cleanGlobals();
        return true;
    }

    @Override
    public boolean getAnswersForQuestionPart2() {
        setupQuestion();
        List<List<Integer>> moveSets = processInputAndGetMoveSetList("C:\\Users\\Admin\\projects\\advent\\src\\main\\java\\com\\wytzig\\lw\\nl\\advent\\twentytwentytwo\\input\\day5_question");
        executeAllMoveSets(moveSets, true);
        prettyPrintFirst();
        cleanGlobals();
        return false;
    }
}
