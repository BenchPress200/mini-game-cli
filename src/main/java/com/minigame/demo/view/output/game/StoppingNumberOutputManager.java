package com.minigame.demo.view.output.game;

import com.minigame.demo.domain.GameResult;
import com.minigame.demo.utils.SimpleOutputUtils;

import static com.minigame.demo.constant.ANSIColor.*;
import static com.minigame.demo.constant.MeaningfulNumber.*;
import static com.minigame.demo.constant.PrintMessage.*;

public class StoppingNumberOutputManager implements GameOutputManager {
    public StoppingNumberOutputManager() {}

    @Override
    public void printWelcomeView() {
        SimpleOutputUtils.print(STOPPING_NUMBER_WELCOME_MESSAGE);
        SimpleOutputUtils.breakLine(ONE);
    }

    @Override
    public void printResult(GameResult gameResult) {
        SimpleOutputUtils.breakLine(ONE);
        SimpleOutputUtils.print("▓ 타이머: " + String.valueOf(gameResult.getStopTime()));
        SimpleOutputUtils.breakLine(ONE);

        if (gameResult.isWinner()) {
            SimpleOutputUtils.print(WIN_MESSAGE, ANSI_BLUE);
            SimpleOutputUtils.print(WIN_MESSAGE, ANSI_BLUE );
            SimpleOutputUtils.print("보상으로" + ANSI_CYAN + " [300코인]" + ANSI_BLUE + "이 지급되었습니다 !", ANSI_BLUE);

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
