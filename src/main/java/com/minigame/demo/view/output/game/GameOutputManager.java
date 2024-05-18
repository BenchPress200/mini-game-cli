package com.minigame.demo.view.output.game;

import com.minigame.demo.domain.result.GameResult;

public interface GameOutputManager {
    void printWelcomeView();
    void printResult(GameResult gameResult) throws InterruptedException;
    void printReInputMessage();
}
