package com.minigame.demo.view.output.game;

import com.minigame.demo.domain.result.GameResult;
import com.minigame.demo.domain.result.HorseRacingResult;
import com.minigame.demo.utils.SimpleOutputUtils;

import static com.minigame.demo.constant.ANSIColor.*;
import static com.minigame.demo.constant.MeaningfulNumber.HORSE_RACING_REWARD;
import static com.minigame.demo.constant.MeaningfulNumber.ONE;
import static com.minigame.demo.constant.Message.*;


public class HorseRacingOutputManager implements GameOutputManager {
    @Override
    public void printWelcomeView() {
        SimpleOutputUtils.print(HORSE_RACING_WELCOME_MESSAGE);
        SimpleOutputUtils.breakLine(ONE);
    }

    @Override
    public void printResult(GameResult gameResult) {
        HorseRacingResult horseRacingResult = (HorseRacingResult) gameResult;
        SimpleOutputUtils.print(horseRacingResult.getWinnerHorseNumber() + "번 말이 우승 하였습니다 !", ANSI_RESET, ONE);

        if (horseRacingResult.isWinner()) {
            SimpleOutputUtils.print(WIN_MESSAGE, ANSI_BLUE);
            SimpleOutputUtils.printIncreaseCoin(HORSE_RACING_REWARD);

            return;
        }

        SimpleOutputUtils.print(NEXT_CHANCE_MESSAGE, ANSI_BLUE);
    }

    @Override
    public void printReInputMessage() {
        SimpleOutputUtils.print(HORSE_RACING_POSSIBLE_STOP_MESSAGE, ANSI_RED);
        SimpleOutputUtils.print(RE_INPUT_MESSAGE, ANSI_RED);
    }
}
