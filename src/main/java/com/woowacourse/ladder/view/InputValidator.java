package com.woowacourse.ladder.view;

import java.util.List;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;
    public static boolean isValidNamesInput(List<String> asList) {
        return asList.stream().map(String::trim)
            .filter(InputValidator::checkIfEmptyString)
            .filter(InputValidator::checkLength)
            .filter(InputValidator::checkIfPreservedName)
            .count() == asList.size();
    }

    private static boolean checkIfPreservedName(String s) {
        return !s.toLowerCase().equals("all");
    }

    private static boolean checkIfEmptyString(final String name) {
        return !name.isEmpty();
    }

    private static boolean checkLength(final String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }

    public static boolean isValidExpectedResults(List<String> expectedResults) {
        return expectedResults.stream()
            .map(String::trim)
            .filter(InputValidator::checkLength)
            .filter(InputValidator::checkIfEmptyString)
            .count() == expectedResults.size();
    }

    public static boolean isValidResultQuery(List<String> queryTokens) {
        return queryTokens
            .stream()
            .map(String::trim)
            .filter(InputValidator::checkIfEmptyString)
            .filter(InputValidator::checkLength)
            .count() == queryTokens.size();
    }
}
