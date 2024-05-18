package com.minigame.demo.domain;

import java.util.List;

public class ResultNumbers extends Numbers {
    public ResultNumbers(List<Integer> resultNumbers) {
        super(resultNumbers);

    }

    public List<Integer> getNumbers() {
        return super.numbers;
    }

    public boolean compareNumbers(GuessNumbers guessNumbers) {
        List<Integer> userNumbers = guessNumbers.getNumbers();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) != userNumbers.get(i)) {
                return false;
            }
        }

        return true;
    }
}
