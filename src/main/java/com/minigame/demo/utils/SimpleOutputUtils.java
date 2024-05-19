package com.minigame.demo.utils;

import com.minigame.demo.domain.Coin;

import static com.minigame.demo.constant.ANSIColor.*;
import static com.minigame.demo.constant.MeaningfulNumber.*;
import static com.minigame.demo.constant.Message.*;

public class SimpleOutputUtils {
    public static void breakLine(int numberOfLine) {
        for (int i = ZERO; i < numberOfLine; i++) {
            System.out.println();
        }
    }

    public static void removeCharacter() {
        System.out.print("\b");
    }

    public static void printNoLineBreak(String printValue) {
        System.out.print(printValue);
    }

    public static void printNoLineBreak(String printValue, String color) {
        System.out.print(color + printValue + ANSI_RESET);
    }

    public static void print(String printValue, String color, int padding) {
        for (int i = ZERO; i < padding; i++) {
            System.out.println();
        }

        System.out.println(color + printValue + ANSI_RESET);

        for (int i = ZERO; i < padding; i++) {
            System.out.println();
        }
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
        breakLine(ONE_HUNDRED);
    }



    public static void printNotEnoughCoin() {
        SimpleOutputUtils.print("코인이 부족하여 더 이상 게임을 진행할 수 없습니다 😡", ANSI_RED);
    }

    public static void printCurrentCoin() {
        SimpleOutputUtils.print("[현재 COIN: " + String.valueOf(Coin.getCoin()) + "]", ANSI_CYAN);
    }

    public static void printDecreaseCoin() {
        Coin.decreaseCoin(50);
        SimpleOutputUtils.print("50코인이 소모되었습니다 !", ANSI_CYAN);
        SimpleOutputUtils.print("[현재 COIN: " + String.valueOf(Coin.getCoin()) + "]", ANSI_CYAN);
        SimpleOutputUtils.breakLine(ONE);
    }

    public static void printIncreaseCoin(int reward) {
        Coin.increaseCoin(reward);
        SimpleOutputUtils.print(String.valueOf(reward) + "코인이 추가되었습니다 !", ANSI_CYAN);
        SimpleOutputUtils.print("[현재 COIN: " + String.valueOf(Coin.getCoin()) + "]", ANSI_CYAN);
    }
}
