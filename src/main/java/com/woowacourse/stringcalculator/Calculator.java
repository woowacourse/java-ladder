package com.woowacourse.stringcalculator;

import java.util.List;

public class Calculator {
    public void add(List<Integer> numbers) {
        numbers.stream().forEach(Calculator::isValidNumber);
    }

    private static void isValidNumber(int number) throws IllegalArgumentException{
        if(number < 0){
            throw new IllegalArgumentException("음수가 포함되어 있으면 안됩니다.");
        }
    }
}
