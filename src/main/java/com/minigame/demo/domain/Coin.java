package com.minigame.demo.domain;

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
}
