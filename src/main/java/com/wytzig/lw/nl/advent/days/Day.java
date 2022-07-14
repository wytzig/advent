package com.wytzig.lw.nl.advent.days;

import java.io.File;
import java.util.List;

public interface Day {

    public boolean getAnswerFromExample();

    public boolean getAnswerForQuestion();

    public List<String> computeFromText(File input);
}
