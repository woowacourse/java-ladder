package com.woowacourse.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    public static int sum(CalculatorDto calculatorDto) {
        int sum = 0;
        for (int number : calculatorDto.getNumbers()) {
            sum += number;
        }
        return sum;
    }
}