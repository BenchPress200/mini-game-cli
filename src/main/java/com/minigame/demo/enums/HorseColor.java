package com.minigame.demo.enums;

import com.minigame.demo.constant.ANSIColor;

public enum HorseColor {
    ONE(1, ANSIColor.ANSI_RED),
    TWO(2, ANSIColor.ANSI_YELLOW),
    THREE(3, ANSIColor.ANSI_GREEN),
    FOUR(4, ANSIColor.ANSI_BLUE),
    FIVE(5, ANSIColor.ANSI_PURPLE);

    private final int value;
    private final String color;

    HorseColor(int value, String color) {
        this.value = value;
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public static HorseColor findByValue(int value) {
        for (HorseColor type : HorseColor.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }

        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
