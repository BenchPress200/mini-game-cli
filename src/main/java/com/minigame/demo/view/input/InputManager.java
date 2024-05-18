package com.minigame.demo.view.input;

import com.minigame.demo.enums.GameType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.*;

public class InputManager {
    private static final String USER_CHOICE_MESSAGE = "원하는 게임의 번호를 입력해주세요: ";

    private final BufferedReader bufferedReader;
    private final BufferedWriter bufferedWriter;

    public InputManager(BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        this.bufferedReader = bufferedReader;
        this.bufferedWriter = bufferedWriter;
    }

    public GameType readUserChoice() throws IOException {
        bufferedWriter.write(ANSI_GREEN + USER_CHOICE_MESSAGE + ANSI_RESET);
        bufferedWriter.flush();

        int input = Integer.parseInt(bufferedReader.readLine());

        if (input < 0 || 3 < input) {
            throw new NumberFormatException();
        }

        return GameType.findByValue(input);
    }

    public static void clearScreen() {
        for (int i = 0; i < 80; i++) {
            System.out.println();
        }
    }
}
