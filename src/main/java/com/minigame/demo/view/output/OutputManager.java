package com.minigame.demo.view.output;

import com.minigame.demo.utils.SimpleOutputUtils;

import static com.minigame.demo.constant.ANSIColor.ANSI_GREEN;
import static com.minigame.demo.constant.ANSIColor.ANSI_RED;
import static com.minigame.demo.constant.MeaningfulNumber.*;
import static com.minigame.demo.constant.PrintMessage.*;

public class OutputManager {
    public OutputManager() {}

    public void printWelcomeView() {
        SimpleOutputUtils.printHorizontalLine();

        SimpleOutputUtils.breakLine(TWO);
        SimpleOutputUtils.print(WELCOME_MESSAGE);
        SimpleOutputUtils.breakLine(TWO);

        SimpleOutputUtils.printHorizontalLine();
        SimpleOutputUtils.breakLine(THREE);
    }

    public void printExitMessage() {
        SimpleOutputUtils.print(EXIT_MESSAGE, ANSI_GREEN);
    }

    public void printGameList() {
        SimpleOutputUtils.print(GAME_LIST_MASSAGE);
    }

    public void printReInputMessage() {
        SimpleOutputUtils.print(GAME_CHOICE_POSSIBLE_INPUT_MESSAGE, ANSI_RED);
        SimpleOutputUtils.print(RE_INPUT_MESSAGE, ANSI_RED);
    }
}
