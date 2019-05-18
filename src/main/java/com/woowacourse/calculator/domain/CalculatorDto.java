package com.woowacourse.calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorDto {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = ":|,";
    private List<Integer> numbers;

    CalculatorDto(String input) {
        numbers = initNumbers(input);
    }

    private List<Integer> initNumbers(String input) {
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }

        Matcher m = CUSTOM_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return parseNumbers(m.group(2).split(customDelimiter));
        }

        return parseNumbers(input.split(DEFAULT_DELIMITER));
    }

    private List<Integer> parseNumbers(String[] expression) {
        return Arrays.stream(expression)
                .map(Integer::parseInt)
                .filter(this::isNegative)
                .collect(Collectors.toList());
    }

    private boolean isNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다");
        }

        return true;
    }

    List<Integer> getNumbers() {
        return numbers;
    }
}
