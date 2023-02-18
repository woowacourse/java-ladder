package domain.validator;

public class HeightValidator {
    public static final String NOT_POSITIVE_ERROR_MESSAGE = "[ERROR] 양의 정수만 입력해주세요.";
    public static final int  HEIGHT_MIN_SIZE = 0;
    public void checkNegativeNumber(int height) {
        if (height <= HEIGHT_MIN_SIZE) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }
}
