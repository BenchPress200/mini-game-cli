package com.minigame.demo.service;

import com.minigame.demo.domain.Horse;
import com.minigame.demo.domain.Race;
import com.minigame.demo.domain.result.GameResult;
import com.minigame.demo.domain.result.HorseRacingResult;
import com.minigame.demo.enums.HorseColor;
import com.minigame.demo.utils.SimpleOutputUtils;

import java.util.ArrayList;
import java.util.List;

import static com.minigame.demo.constant.ANSIColor.*;
import static com.minigame.demo.constant.MeaningfulNumber.*;

public class HorseRacingGame implements GameService {
    private GameResult gameResult;
    private List<Horse> horses;
    private Horse[] track;

    @Override
    public void start(String userInput) throws InterruptedException {
        horses = new ArrayList<>();
        track = new Horse[51];

        for (int i = 1; i <= 5; i++) {
            Horse horse = new Horse(i, HorseColor.findByValue(i), track);
            horses.add(horse);
        }

        SimpleOutputUtils.breakLine(ONE);
        SimpleOutputUtils.print("5초 후 시작합니다 !");

        for (int i = FIVE; i > ZERO; i--) {
            if (i % 2 == 0) {
                SimpleOutputUtils.printNoLineBreak(String.valueOf(i), ANSI_RED);
            } else {
                SimpleOutputUtils.printNoLineBreak(String.valueOf(i), ANSI_CYAN);
            }
            Thread.sleep(ONE_SECOND);
            SimpleOutputUtils.removeCharacter();
        }

        SimpleOutputUtils.print("start !!!", ANSI_GREEN);


        for (Horse horse : horses) {
            horse.start();
        }

        for (Horse horse : horses) {
            horse.join();
        }


        boolean isWinner = isWinner(userInput);
        this.gameResult = new HorseRacingResult(isWinner, Race.getWinner(track));
    }

    @Override
    public GameResult getResult() {
        return gameResult;
    }

    private boolean isWinner(String userInput) {
        if (userInput.equals(String.valueOf(Race.getWinner(track)))) {
            return true;
        }

        return false;
    }
}
