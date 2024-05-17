package com.minigame.demo.enums;

public enum GameType {
    GAME_EXIT(0),
    MINI_LOTTO(1),
    TIMER(2),
    SPEED_CODING(3);

    private final int value;

    GameType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GameType findByValue(int value) {
        for (GameType type : GameType.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }

        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
