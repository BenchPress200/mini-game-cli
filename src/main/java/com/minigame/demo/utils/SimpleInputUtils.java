package com.minigame.demo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.minigame.demo.constant.ANSIColor.ANSI_GREEN;
import static com.minigame.demo.constant.MeaningfulNumber.ONE;
import static com.minigame.demo.constant.Message.*;

public class SimpleInputUtils {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static boolean readContinue() throws IOException {
        SimpleOutputUtils.breakLine(ONE);
        SimpleOutputUtils.printNoLineBreak(READY_MESSAGE, ANSI_GREEN);

        String answer = bufferedReader.readLine();
        SimpleOutputUtils.breakLine(ONE);

        if (answer.equals(L_YES) || answer.equals(U_YES)) {
            return true;
        }

        if (answer.equals(L_NO) || answer.equals(U_NO)) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    public static boolean readReStart() throws IOException {
        SimpleOutputUtils.breakLine(ONE);
        String answer = SimpleInputUtils.read(RETRY_MESSAGE, ANSI_GREEN);
        SimpleOutputUtils.clearConsole();

        if (answer.equals(L_YES) || answer.equals(U_YES)) {
            return true;
        }

        if (answer.equals(L_NO) || answer.equals(U_NO)) {
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
