package com.minigame.demo.view.output.game;

import com.minigame.demo.domain.result.GameResult;
import com.minigame.demo.domain.result.StoppingNumberGameResult;
import com.minigame.demo.utils.SimpleOutputUtils;

import static com.minigame.demo.constant.ANSIColor.*;
import static com.minigame.demo.constant.MeaningfulNumber.*;
import static com.minigame.demo.constant.Message.*;

public class StoppingNumberOutputManager implements GameOutputManager {
    public StoppingNumberOutputManager() {}

    @Override
    public void printWelcomeView() {
        SimpleOutputUtils.print(STOPPING_NUMBER_WELCOME_MESSAGE);
        SimpleOutputUtils.breakLine(ONE);
    }

    @Override
    public void printResult(GameResult gameResult) {
        StoppingNumberGameResult stoppingNumberGameResult = (StoppingNumberGameResult) gameResult;

        SimpleOutputUtils.print("▓ 타이머: " + String.valueOf(stoppingNumberGameResult.getStopTime()), ANSI_RESET, ONE);

        if (gameResult.isWinner()) {
            SimpleOutputUtils.print(WIN_MESSAGE, ANSI_BLUE);
            SimpleOutputUtils.printIncreaseCoin(500);

            return;
        }

        SimpleOutputUtils.print(NEXT_CHANCE_MESSAGE, ANSI_BLUE);
    }

    @Override
    public void printReInputMessage() {
        SimpleOutputUtils.print(STOPPING_NUMBER_POSSIBLE_STOP_MESSAGE, ANSI_RED);
        SimpleOutputUtils.print(RE_INPUT_MESSAGE, ANSI_RED);
    }
}
