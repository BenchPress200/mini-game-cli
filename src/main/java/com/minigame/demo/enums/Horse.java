package com.minigame.demo.enums;

import com.minigame.demo.constant.ANSIColor;

public enum Horse {
    ONE(1, ANSIColor.ANSI_RED),
    TWO(2, ANSIColor.ANSI_YELLOW),
    THREE(3, ANSIColor.ANSI_GREEN),
    FOUR(4, ANSIColor.ANSI_BLUE),
    FIVE(5, ANSIColor.ANSI_PURPLE);

    private final int value;
    private final String color;

    Horse(int value, String color) {
        this.value = value;
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }
}
