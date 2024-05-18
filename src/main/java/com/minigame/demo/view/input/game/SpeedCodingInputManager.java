package com.minigame.demo.view.input.game;

import com.minigame.demo.utils.SimpleInputUtils;

import java.io.IOException;

public class SpeedCodingInputManager implements GameInputManager{
    public SpeedCodingInputManager() {}

    @Override
    public String readUserInput() throws IOException {
        StringBuilder sb = new StringBuilder("");
        String input;

        while(!(input = SimpleInputUtils.read()).equals("0")) {
            sb.append(input);
            sb.append("\n");
        }

        return sb.toString();
    }
}
