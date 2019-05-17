package laddergame.domain;

import org.apache.commons.lang3.StringUtils;

public class inputValidator {

    public static void validateInput(String input) {
        checkNull(input, "치명적인 오류 발생");
        checkLastIndexOfInput(input);
    }

    private static void checkLastIndexOfInput(String input) {
        if (input.lastIndexOf(Constant.COMMA) == input.length() - 1) {
            throw new IllegalArgumentException("콤마로 끝나면 안됩니다");
        }
    }

    private static void checkNull(String input, String errorMessage) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
