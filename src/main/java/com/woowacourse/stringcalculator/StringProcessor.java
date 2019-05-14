package com.woowacourse.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringProcessor {
    private static final String DEFAULT_DELIMITERS= ",:";
    public static List<Integer> split(final String input) {
        if (input == null || input.isEmpty()) {
            return Arrays.asList(0);
        }
        String[] str = input.split("\n");
        if (str.length == 1) {
            return splitIntoIntegers(input, DEFAULT_DELIMITERS);
        }

        if (str[0].startsWith("//")) {
            String customDelimiter = str[0].split("//")[1];
            return splitIntoIntegers(str[1], "[" + DEFAULT_DELIMITERS + customDelimiter + "]");
        }

        return splitIntoIntegers(input, DEFAULT_DELIMITERS);
    }

    private static List<Integer> splitIntoIntegers(String input, String pattern) {
        return Arrays.stream(input.split(pattern))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

}
