package com.minigame.demo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.minigame.demo.constant.ANSIColor.ANSI_GREEN;
import static com.minigame.demo.constant.MeaningfulNumber.ONE;
import static com.minigame.demo.constant.Message.READY_MESSAGE;
import static com.minigame.demo.constant.Message.RETRY_MESSAGE;

public class SimpleInputUtils {
    // 단일 유저, 빈번한 입력이 발생하는 프로그램이기 때문에 입력 인스턴스는 static이 제일 좋다고 생각
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static boolean readContinue() throws IOException {
        SimpleOutputUtils.breakLine(ONE);
        SimpleOutputUtils.printNoLineBreak(READY_MESSAGE, ANSI_GREEN);

        String answer = bufferedReader.readLine();
        SimpleOutputUtils.breakLine(ONE);

        if (answer.equals("y") || answer.equals("Y")) {
            return true;
        }

        if (answer.equals("n") || answer.equals("N")) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    public static boolean readReStart() throws IOException {
        SimpleOutputUtils.breakLine(ONE);
        String answer = SimpleInputUtils.read(RETRY_MESSAGE, ANSI_GREEN);
        SimpleOutputUtils.clearConsole();

        if (answer.equals("y") || answer.equals("Y")) {
            return true;
        }

        if (answer.equals("n") || answer.equals("N")) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    public static String read(String printValue, String color) throws IOException {
        SimpleOutputUtils.printNoLineBreak(printValue, color);
        String userInput = bufferedReader.readLine();

        return userInput;
    }

    public static String read() throws IOException {
        String userInput = bufferedReader.readLine();

        return userInput;
    }
}
