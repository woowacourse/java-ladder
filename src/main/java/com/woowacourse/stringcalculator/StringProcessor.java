package com.woowacourse.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringProcessor {
    private static final String DEFAULT_DELIMITERS = "[,:]";

    public static List<Integer> split(final String input) {
        if (checkIfStringNullOrEmpty(input)) {
            return Arrays.asList(0);
        }

        return handleInputTokens(input);
    }

    private static boolean checkIfStringNullOrEmpty(final String input) {
        return input == null || input.isEmpty();
    }

    private static List<Integer> handleInputTokens(final String input) {
        String[] inputTokens = input.split("\n");
        if (inputTokens.length == 1) {
            return splitIntoIntegers(input, DEFAULT_DELIMITERS);
        }

        if (inputTokens[0].startsWith("//")) {
            String customDelimiter = inputTokens[0].split("//")[1];
            throwIfNumber(customDelimiter);
            return splitIntoIntegers(inputTokens[1], String.format("(%s|%s)", DEFAULT_DELIMITERS, Pattern.quote(customDelimiter)));
        }
        throw new IllegalArgumentException("올바르지 않은 문자열 형식입니다.");
    }

    private static void throwIfNumber(final String customDelimiter) {
        if (checkIfNumber(customDelimiter)) {
            throw new IllegalArgumentException("커스텀구분자는 숫자가 될 수 없습니다.");
        }
    }

    private static boolean checkIfNumber(final String customDelimiter) {
        try {
            Integer.parseInt(customDelimiter);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static List<Integer> splitIntoIntegers(final String input, final String pattern) {
        return Arrays.stream(input.split(pattern))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
