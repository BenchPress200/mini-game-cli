package com.minigame.demo.view.input.game;

import com.minigame.demo.utils.SimpleInputUtils;

import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.ANSI_GREEN;
import static com.minigame.demo.constant.PrintMessage.GUESSING_NUMBER_CONDITION_MESSAGE;

public class GuessingNumberInputManager implements GameInputManager{
    public GuessingNumberInputManager() {}

    @Override
    public String readUserInput() throws IllegalArgumentException, IOException {
        return SimpleInputUtils.read(GUESSING_NUMBER_CONDITION_MESSAGE, ANSI_GREEN);
    }
}
