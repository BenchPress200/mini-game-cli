package com.minigame.demo.view.output.game;

import com.minigame.demo.model.ResultNumbers;
import com.minigame.demo.utils.SimpleOutputUtils;

import java.util.Random;

import static com.minigame.demo.constant.ANSIColor.*;
import static com.minigame.demo.constant.MeaningfulNumber.*;
import static com.minigame.demo.constant.PrintMessage.*;

public class GuessingNumberOutputManager {
    public GuessingNumberOutputManager() {}

    public void printWelcomeView() {
        SimpleOutputUtils.print(GUESSING_NUMBER_WELCOME_MESSAGE);
        SimpleOutputUtils.breakLine(ONE);
    }

    public void printResult(ResultNumbers resultNumbers, boolean result) throws InterruptedException {
        SimpleOutputUtils.print(BLOCK_MESSAGE);

        Random random = new Random();

        for (Integer number : resultNumbers.getNumbers()) {
            SimpleOutputUtils.printNoLineBreak(SPACE);

            for(int i = ZERO; i < RANDOM_COUNT; i++) {
                SimpleOutputUtils.printNoLineBreak(String.valueOf(random.nextInt(RANDOM_RANGE)));

                Thread.sleep(ZERO_POINT_ONE_SECOND);

                SimpleOutputUtils.removeCharacter();
            }

            SimpleOutputUtils.printNoLineBreak(String.valueOf(number) + SPACE + BLOCK_MESSAGE);
        }

        SimpleOutputUtils.breakLine(TWO);

        if (!result) {
            SimpleOutputUtils.print(NEXT_CHANCE_MESSAGE, ANSI_BLUE);

            return;
        }

        SimpleOutputUtils.print(WIN_MESSAGE, ANSI_BLUE);
        SimpleOutputUtils.print(REWARD_MESSAGE, ANSI_BLUE);
    }
}
