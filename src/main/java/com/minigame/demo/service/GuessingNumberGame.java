package com.minigame.demo.service;

import com.minigame.demo.domain.result.GameResult;
import com.minigame.demo.domain.GuessNumbers;
import com.minigame.demo.domain.result.GuessingNumberGameResult;
import com.minigame.demo.domain.ResultNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class GuessingNumberGame implements GameService {
    private GameResult gameResult;

    @Override
    public void start(String userInput) throws IllegalArgumentException {
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();

        GuessNumbers guessNumbers = createGuessNumbers(userInput);

        for (int i = 0; i < 3; i++) {
            randomNumbers.add(random.nextInt(10));
        }

        ResultNumbers resultNumbers = new ResultNumbers(randomNumbers);

        boolean isWinner = resultNumbers.compareNumbers(guessNumbers);
        gameResult = new GuessingNumberGameResult(isWinner, resultNumbers);
    }

    @Override
    public GameResult getResult() {
        return gameResult;
    }


    private GuessNumbers createGuessNumbers(String input) {
        StringTokenizer st = new StringTokenizer(input);
        List<Integer> numbers = new ArrayList<>();

        while(st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        return new GuessNumbers(numbers);
    }
}
