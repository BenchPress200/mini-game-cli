package com.minigame.demo.view.input.game;

import com.minigame.demo.utils.SimpleInputUtils;
import com.minigame.demo.utils.SimpleOutputUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static com.minigame.demo.constant.ANSIColor.*;
import static com.minigame.demo.constant.MeaningfulNumber.*;
import static com.minigame.demo.constant.PrintMessage.*;

public class StoppingNumberInputManager implements GameInputManager {
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public StoppingNumberInputManager(BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        this.bufferedReader = bufferedReader;
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public String readUserInput() throws IOException {
        SimpleOutputUtils.breakLine(ONE);
        bufferedWriter.write("시간이 녹아내리는 중...🫠");
        SimpleOutputUtils.breakLine(TWO);
        String userInput = SimpleInputUtils.read(STOPPING_NUMBER_CONDITION_MESSAGE, ANSI_GREEN);

        if (!userInput.equals("stop")) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }




    public boolean readReStart() throws IOException {
        bufferedWriter.write(ANSI_GREEN + "재도전하시겠습니까? [y/n]: " + ANSI_RESET);
        bufferedWriter.flush();

        String answer = bufferedReader.readLine();

        if (answer.equals("y") || answer.equals("Y")) {
            return true;
        }

        if (answer.equals("n") || answer.equals("N")) {
            return false;
        }

        throw new IllegalArgumentException();
    }


}
