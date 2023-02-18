package view;

import java.util.regex.Pattern;

public class InputHeightValidator {

    public static final String NOT_NUMBER_ERROR_MESSAGE = "숫자만 입력해주세요.";
    public static final String NOT_POSITIVE_ERROR_MESSAGE = "양의 정수만 입력해주세요.";

    public void checkNumberMissMatch(String height) {
        if (!Pattern.matches("^[0-9]*$", height)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public void checkNegativeNumber(String height) {
        if (Integer.parseInt(height) <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }
}
