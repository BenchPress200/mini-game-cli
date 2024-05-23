package com.minigame.demo.view.input.game;

import com.minigame.demo.utils.SimpleInputUtils;

import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.ANSI_GREEN;
import static com.minigame.demo.constant.Message.GUESSING_NUMBER_CONDITION_MESSAGE;

public class GuessingNumberInputManager implements GameInputManager{
    @Override
    public String readUserInput() throws IllegalArgumentException, IOException {
        String userInput = SimpleInputUtils.read(GUESSING_NUMBER_CONDITION_MESSAGE, ANSI_GREEN);
        String regex = "^[0-9] [0-9] [0-9]$";

        if(!userInput.matches(regex)) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }
}
