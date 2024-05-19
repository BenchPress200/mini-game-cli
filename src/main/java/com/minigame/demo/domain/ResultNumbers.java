package com.minigame.demo.domain;

import java.util.List;

public class ResultNumbers extends GuessNumbers {
    public ResultNumbers(List<Integer> numbers) {
        super(numbers);
    }

    public boolean compareNumbers(GuessNumbers guessNumbers) {
        List<Integer> userNumbers = guessNumbers.getNumbers();
        List<Integer> computerNumbers = getNumbers();

        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i) != userNumbers.get(i)) {
                return false;
            }
        }

        return true;
    }
}
