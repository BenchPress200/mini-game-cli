package com.minigame.demo.domain;

import java.util.List;

public class GuessNumbers {
    private final List<Integer> numbers;

    public GuessNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
