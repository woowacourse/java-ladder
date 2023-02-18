package domain.validator;

public class HeightValidator {
    public static final String NOT_POSITIVE_ERROR_MESSAGE = "양의 정수만 입력해주세요.";
    public void checkNegativeNumber(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }
}
