package com.wytzig.lw.nl.advent;


/**
 * Abstract class because we want to make an universal implementation for executing part one and two.
 * Besides this, all Day classes will be closely related to each other which is another good reason to
 * have an abstract class.
 *
 * todo what common non-static or non-final fields could they share? [Optimalization]
 */
public abstract class Day {

    /** are these nessecary? if we do part one and two, these.. bla blabla yeah.. I get it, it's just a bit of fun **/

    public abstract boolean getAnswerFromExample();

    public abstract boolean getAnswerForQuestion();

    public abstract boolean getAnswersFromExamplePart2();

    public abstract boolean getAnswersForQuestionPart2();

    /**
     * Doing part one involves replecating the example and with the same code, produce an output
     * The administrator will be tasked with executing these parts and taking into account
     * their executing time.
     */
    public void doPartOne() {
        getAnswerFromExample();
        getAnswerForQuestion();
    }

    /**
     * Because of these comments, you feel like
     * this repo might be more involved than you initially think. Complex code == larger time to comprehend
     * algorithms involved and therefore might indicate a lack of clear and consice thinking
     * on the part of involved coders.
     *
     * however this is merely a distraction..
     * I was just bored
     *
     * peace and love y'll
     */
    public void doPartTwo(){
        getAnswersFromExamplePart2();
        getAnswersForQuestionPart2();
    }
}
