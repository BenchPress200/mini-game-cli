package com.minigame.demo.domain;

import com.minigame.demo.utils.SimpleOutputUtils;

import static com.minigame.demo.constant.ANSIColor.ANSI_GREEN;
import static com.minigame.demo.constant.MeaningfulNumber.MIN_COIN;
import static com.minigame.demo.constant.MeaningfulNumber.ZERO;
import static com.minigame.demo.constant.PrintMessage.EXIT_MESSAGE;

public class Coin {
    private static int coin = 500;

    public static void increaseCoin(int reward) {
        if (reward == 0) {
            coin *= 3;
        }

        coin += reward;
    }

    public static void decreaseCoin(int reward) {
        coin -= reward;
    }

    public static int getCoin() {
        return coin;
    }

    public static void checkRemainingCoin() {
        if (coin < MIN_COIN) {
            SimpleOutputUtils.printNotEnoughCoin();
            SimpleOutputUtils.print(EXIT_MESSAGE, ANSI_GREEN);
            System.exit(ZERO);
        }
    }
}
