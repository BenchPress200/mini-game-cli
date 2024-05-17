package com.minigame.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessNumberGame {

    public GuessNumbers createRandomNumbers() {
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            randomNumbers.add(random.nextInt(10));
        }

        GuessNumbers resultNumbers = new GuessNumbers(randomNumbers);

        return resultNumbers;
    }
}
