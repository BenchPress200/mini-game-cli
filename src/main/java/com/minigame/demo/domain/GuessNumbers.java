package com.minigame.demo.domain;

import java.util.List;

public class GuessNumbers extends Numbers {
    public GuessNumbers(List<Integer> guessNumbers) {
        super(guessNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
