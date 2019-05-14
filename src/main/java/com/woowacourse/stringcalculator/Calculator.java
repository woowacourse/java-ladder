package com.woowacourse.stringcalculator;

import java.util.List;

public class Calculator {
    public static int add(final List<Integer> numbers) {
        numbers.stream().forEach(Calculator::isValidNumber);
        return numbers.stream().mapToInt(Integer::new).sum();
    }

    private static void isValidNumber(final int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("음수가 포함되어 있으면 안됩니다.");
        }
    }
}
