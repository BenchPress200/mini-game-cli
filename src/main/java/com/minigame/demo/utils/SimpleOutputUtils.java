package com.minigame.demo.utils;

import static com.minigame.demo.constant.ANSIColor.ANSI_RESET;

public class SimpleOutputUtils {
    public static void breakLine(int numberOfLine) {
        for (int i = 0; i < numberOfLine; i++) {
            System.out.println();
        }
    }

    public static void removeCharacter() {
        System.out.print("\b");
    }

    public static void clearConsole() { // 컨트롤러에서만 사용
        breakLine(100);
    }

    public static void printNoLineBreak(String printValue) {
        System.out.print(printValue);
    }
    public static void print(String printValue) {
        System.out.println(printValue);
    }

    public static void print(String printValue, String color) {
        System.out.println(color + printValue + ANSI_RESET);
    }

}
