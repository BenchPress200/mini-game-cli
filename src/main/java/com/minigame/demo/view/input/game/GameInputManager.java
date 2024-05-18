package com.minigame.demo.view.input.game;

import java.io.IOException;

public interface GameInputManager {
    String readUserInput() throws IOException, InterruptedException;
}
