package com.minigame.demo.view.input.game;

import com.minigame.demo.utils.SimpleInputUtils;

import java.io.IOException;

import static com.minigame.demo.constant.Message.*;

public class SpeedCodingInputManager implements GameInputManager{
    public SpeedCodingInputManager() {}

    @Override
    public String readUserInput() throws IOException {
        StringBuilder sb = new StringBuilder(NULL);
        String input;

        while(!(input = SimpleInputUtils.read()).equals(ZERO_STRING)) {
            sb.append(input);
            sb.append(BREAK_LINE);
        }

        return sb.toString();
    }
}
