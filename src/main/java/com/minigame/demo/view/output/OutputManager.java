package com.minigame.demo.view.output;

import com.minigame.demo.utils.SimpleOutputUtils;

import static com.minigame.demo.constant.MeaningfulNumber.*;
import static com.minigame.demo.constant.PrintMessage.*;

public class OutputManager {
    public OutputManager() {}

    public void printWelcomeView() {
        printHorizontalLine();

        SimpleOutputUtils.breakLine(TWO);
        SimpleOutputUtils.simplePrint(WELCOME_MESSAGE);
        SimpleOutputUtils.breakLine(TWO);

        printHorizontalLine();
        SimpleOutputUtils.breakLine(THREE);
    }

    public void printGameList() {
        SimpleOutputUtils.simplePrint(GAME_LIST_MASSAGE);
    }

    private void printHorizontalLine() {
        for (int i = ZERO; i < CONSOLE_END_INDEX; i++) {
            SimpleOutputUtils.simplePrintNoLineBreak(BLOCK_MESSAGE);
        }
    }
}
