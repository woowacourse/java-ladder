package com.woowacourse.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;
    public static boolean isValidInput(List<String> asList) {
        return asList.stream().map(s -> s.trim())
            .filter(InputValidator::checkIfEmptyString)
            .filter(InputValidator::checkLength)
            .collect(Collectors.toList()).size() == asList.size();
    }

    private static boolean checkIfEmptyString(final String name) {
        return !name.isEmpty();
    }

    private static boolean checkLength(final String name) {
        return name.length() > MAX_NAME_LENGTH;
    }


}
