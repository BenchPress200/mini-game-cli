package com.minigame.demo.view.output.game;

import com.minigame.demo.domain.result.GameResult;
import com.minigame.demo.utils.SimpleOutputUtils;

import static com.minigame.demo.constant.MeaningfulNumber.*;
import static com.minigame.demo.constant.Message.*;


public class HorseRacingOutputManager implements GameOutputManager {
    @Override
    public void printWelcomeView() {
        SimpleOutputUtils.print(HORSE_RACING_WELCOME_MESSAGE);
        SimpleOutputUtils.breakLine(ONE);
    }

    @Override
    public void printResult(GameResult gameResult) throws InterruptedException {

    }

    @Override
    public void printReInputMessage() {

    }
}
