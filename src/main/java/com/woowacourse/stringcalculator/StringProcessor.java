package com.woowacourse.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringProcessor {
    public static List<Integer> split(final String input) {
        if (input == null || input.isEmpty()) {
            return Arrays.asList(0);
        }
        return Arrays.stream(input.split("[,:]"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
