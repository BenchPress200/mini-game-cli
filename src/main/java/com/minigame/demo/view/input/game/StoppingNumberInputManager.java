package com.minigame.demo.view.input.game;

import com.minigame.demo.utils.SimpleInputUtils;
import com.minigame.demo.utils.SimpleOutputUtils;

import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.*;
import static com.minigame.demo.constant.MeaningfulNumber.*;
import static com.minigame.demo.constant.Message.*;

public class StoppingNumberInputManager implements GameInputManager {
    public StoppingNumberInputManager() {}

    @Override
    public String readUserInput() throws IOException {
        SimpleOutputUtils.print(STOPPING_NUMBER_WAIT_MESSAGE);
        SimpleOutputUtils.breakLine(ONE);
        String userInput = SimpleInputUtils.read(STOPPING_NUMBER_CONDITION_MESSAGE, ANSI_GREEN);

        if (!userInput.equals("stop")) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }
}
