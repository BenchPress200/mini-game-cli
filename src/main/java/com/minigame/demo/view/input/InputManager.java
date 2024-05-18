package com.minigame.demo.view.input;

import com.minigame.demo.enums.GameType;
import com.minigame.demo.utils.SimpleInputUtils;
import com.minigame.demo.utils.SimpleOutputUtils;

import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.ANSI_GREEN;
import static com.minigame.demo.constant.MeaningfulNumber.ONE;
import static com.minigame.demo.constant.PrintMessage.USER_CHOICE_MESSAGE;

public class InputManager {
    public InputManager() {}

    public GameType readUserChoice() throws IOException, NumberFormatException {
        SimpleOutputUtils.breakLine(ONE);
        String userInput = SimpleInputUtils.read(USER_CHOICE_MESSAGE, ANSI_GREEN);
        int input = Integer.parseInt(userInput);

        if (input < 0 || 3 < input) {
            throw new NumberFormatException();
        }

        return GameType.findByValue(input);
    }
}
