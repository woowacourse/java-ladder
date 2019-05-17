package com.woowacourse.ladder.domain;

import java.util.List;


public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String BANNED_NAME = "all";

    public static boolean isValidNamesInput(List<String> asList) {
        return asList.stream().map(String::trim)
                .filter(InputValidator::isNotEmptyString)
                .filter(InputValidator::checkLength)
                .filter(InputValidator::isNotAll)
                .count() == asList.size();
    }

    public static boolean isNotAll(String s) {
        return !s.toLowerCase().equals(BANNED_NAME);
    }

    public static boolean isNotEmptyString(final String name) {
        return !name.isEmpty();
    }

    private static boolean checkLength(final String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }

    public static boolean isValidDestinationsInput(List<String> expectedResults) {
        return expectedResults.stream()
                .map(String::trim)
                .filter(InputValidator::checkLength)
                .filter(InputValidator::isNotEmptyString)
                .count() == expectedResults.size();
    }
}
