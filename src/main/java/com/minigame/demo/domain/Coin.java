package com.minigame.demo.domain;

public class Coin {
    private static int coin = 500;

    public static void addCoin(int reward) {
        coin += reward;
    }

    public static int getCoin() {
        return coin;
    }
}
