package com.minigame.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessNumberGame {
    private ResultNumbers resultNumbers;

    public ResultNumbers createRandomNumbers() {
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            randomNumbers.add(random.nextInt(10));
        }

        resultNumbers = new ResultNumbers(randomNumbers);

        return resultNumbers;
    }

    public boolean getResult(GuessNumbers guessNumbers) {
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
