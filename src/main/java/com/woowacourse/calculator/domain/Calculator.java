package com.woowacourse.calculator.domain;

public class Calculator {
    public static int sum(CalculatorDto calculatorDto) {
        return calculatorDto.getNumbers()
                .stream()
                .reduce(0, Integer::sum)
                ;
    }
}