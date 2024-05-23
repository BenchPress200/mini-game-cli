package com.minigame.demo.view.input.game;

import com.minigame.demo.utils.SimpleInputUtils;

import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.ANSI_GREEN;
import static com.minigame.demo.constant.Message.*;

public class HorseRacingInputManager implements GameInputManager {
    @Override
    public String readUserInput() throws IOException {
        String userInput = SimpleInputUtils.read(HORSE_RACING_CONDITION_MESSAGE, ANSI_GREEN);
        String regex = "^[1-5]$";

        if(!userInput.matches(regex)) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }
}
