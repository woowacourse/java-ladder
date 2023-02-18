package view;


public class InputHeightValidator {

    public static final String NOT_POSITIVE_ERROR_MESSAGE = "[ERROR] 양의 정수만 입력해주세요.";
    public static final String BLANK_MESSAGE = "[ERROR] 입력값이 비어있습니다.";
    public static final String NULL_MESSAGE = "[ERROR] 아무것도 입력하지 않았습니다.";

    public void checkHeight(String height) {
        checkNegativeNumber(height);
        checkNotEmpty(height);
        checkNull(height);
    }

    private void checkNegativeNumber(String height) {
        if (Integer.parseInt(height) <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }
    private static void checkNotEmpty(String height) {
        if (height.isBlank()) {
            throw new IllegalArgumentException(BLANK_MESSAGE);
        }
    }
    private static void checkNull(String height) {
        if (height==null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }
}
