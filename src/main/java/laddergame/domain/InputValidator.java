package laddergame.domain;

import org.apache.commons.lang3.StringUtils;

public class InputValidator {
    private final static String COMMA = ",";

    private InputValidator() {
    }

    public static void validateInput(String input) {
        checkNull(input);
        checkLastIndexOfInput(input);
    }

    private static void checkLastIndexOfInput(String input) {
        if (input.lastIndexOf(COMMA) == input.length() - 1) {
            throw new IllegalArgumentException("콤마로 끝나면 안됩니다");
        }
    }

    private static void checkNull(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        }
    }
}
