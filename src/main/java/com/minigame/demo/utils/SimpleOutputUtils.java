package com.minigame.demo.utils;

import static com.minigame.demo.constant.ANSIColor.ANSI_RESET;

public class SimpleOutputUtils {
    public static void breakLine(int numberOfLine) {
        for (int i = 0; i < numberOfLine; i++) {
            System.out.println();
        }
    }

    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void simplePrintNoLineBreak(String printValue) {
        System.out.print(printValue);
    }
    public static void simplePrint(String printValue) {
        System.out.println(printValue);
    }

    public static void simplePrint(String printValue, String color) {
        System.out.println(color + printValue + ANSI_RESET);
    }

}
