package view;


import java.util.regex.Pattern;

public class InputHeightValidator {

    private static final String NOT_POSITIVE_ERROR_MESSAGE = "[ERROR] 양의 정수만 입력해주세요.";
    private static final String BLANK_MESSAGE = "[ERROR] 입력값이 비어있습니다.";
    private static final String NULL_MESSAGE = "[ERROR] 아무것도 입력하지 않았습니다.";
    private static final String MATCH_NUMBER_MESSAGE = "[ERROR] 숫자만 입력해야 합니다.";

    public void checkHeight(String height) {
        checkNegativeNumber(height);
        checkNotEmpty(height);
        checkNull(height);
        checkMissMatchNumber(height);
    }

    private void checkNegativeNumber(String height) {
        if (Integer.parseInt(height) <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }
    private void checkNotEmpty(String height) {
        if (height.isBlank()) {
            throw new IllegalArgumentException(BLANK_MESSAGE);
        }
    }
    private void checkNull(String height) {
        if (height==null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }

    private void checkMissMatchNumber(String height) {
        if (!Pattern.matches("^[0-9]*$", height)) {
            throw new IllegalArgumentException(MATCH_NUMBER_MESSAGE);
        }
    }
}
