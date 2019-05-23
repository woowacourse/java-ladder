package com.woowacourse.ladder;

import java.util.List;


public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String BANNED_NAME = "all";

    public static boolean isNotValidNamesInput(List<String> asList) {
        return asList.stream().map(String::trim)
                .filter(InputValidator::isNotEmptyString)
                .filter(InputValidator::checkLength)
                .filter(InputValidator::isNotAll)
                .count() != asList.size();
    }

    public static boolean isNotAll(String s) {
        return !s.toLowerCase().equals(BANNED_NAME);
    }

    public static boolean isNotEmptyString(final String name) {
        return !name.isEmpty();
    }

    public static boolean isEmptyString(final String name) {
        return name.isEmpty();
    }

    private static boolean checkLength(final String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }

    public static boolean isNotValidDestinationsInput(List<String> expectedResults) {
        return expectedResults.stream()
                .map(String::trim)
                .filter(InputValidator::checkLength)
                .filter(InputValidator::isNotEmptyString)
                .count() != expectedResults.size();
    }

    public static boolean isNotValidHeight(String height) {
        if (isNumber(height)) {
            return Integer.parseInt(height) < 1;
        }
        return false;
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
