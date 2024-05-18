package com.minigame.demo.utils;

import static com.minigame.demo.constant.ANSIColor.ANSI_RED;
import static com.minigame.demo.constant.ANSIColor.ANSI_RESET;
import static com.minigame.demo.constant.MeaningfulNumber.CONSOLE_END_INDEX;
import static com.minigame.demo.constant.MeaningfulNumber.ZERO;
import static com.minigame.demo.constant.PrintMessage.*;

public class SimpleOutputUtils {
    public static void breakLine(int numberOfLine) {
        for (int i = 0; i < numberOfLine; i++) {
            System.out.println();
        }
    }

    public static void removeCharacter() {
        System.out.print("\b");
    }

    public static void printHorizontalLine() {
        for (int i = ZERO; i < CONSOLE_END_INDEX; i++) {
            SimpleOutputUtils.printNoLineBreak(BLOCK_MESSAGE);
        }
    }


    public static void printNoLineBreak(String printValue) {
        System.out.print(printValue);
    }

    public static void printNoLineBreak(String printValue, String color) {
        System.out.print(color + printValue + ANSI_RESET);
    }

    public static void print(String printValue) {
        System.out.println(printValue);
    }

    public static void print(String printValue, String color) {
        System.out.println(color + printValue + ANSI_RESET);
    }

    public static void printYesOrNo() { // 컨트롤러에서만 사용
        print(YES_OR_NO_INPUT_MESSAGE , ANSI_RED);
        print(RE_INPUT_MESSAGE , ANSI_RED);
    }

    public static void clearConsole() { // 컨트롤러에서만 사용
        breakLine(100);
    }
}
