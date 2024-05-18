package com.minigame.demo.service;

import com.minigame.demo.domain.result.GameResult;
import com.minigame.demo.domain.GuessNumbers;
import com.minigame.demo.domain.result.GuessingNumberGameResult;
import com.minigame.demo.domain.ResultNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class GuessNumberGame implements GameService{
    private ResultNumbers resultNumbers;
    private GameResult gameResult;

    @Override
    public void start(String userInput) throws IllegalArgumentException {
        GuessNumbers guessNumbers = createGuessNumbers(userInput);
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            randomNumbers.add(random.nextInt(10));
        }

        resultNumbers = new ResultNumbers(randomNumbers);

        boolean isWinner = compareNumbers(guessNumbers);
        gameResult = new GuessingNumberGameResult(isWinner, resultNumbers);
    }

    @Override
    public GameResult getResult() {
        return gameResult;
    }


    private GuessNumbers createGuessNumbers(String input) {
        String regex = "^[0-9] [0-9] [0-9]$";

        if(input.matches(regex)) {
            StringTokenizer st = new StringTokenizer(input);
            List<Integer> numbers = new ArrayList<>();

            while(st.hasMoreTokens()) {
                numbers.add(Integer.parseInt(st.nextToken()));
            }

            return new GuessNumbers(numbers);
        }

        throw new IllegalArgumentException();
    }

    public boolean compareNumbers(GuessNumbers guessNumbers) {
        List<Integer> computerNumbers = resultNumbers.getNumbers();
        List<Integer> userNumbers = guessNumbers.getNumbers();

        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i) != userNumbers.get(i)) {
                return false;
            }
        }

        return true;
    }
}
