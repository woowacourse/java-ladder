package exception;

public class PositiveException extends IllegalArgumentException {
    private static final String NOT_POSITIVE_ERROR_MESSAGE = "[ERROR] 양의 정수만 입력해주세요.";

    public PositiveException() {
        super(NOT_POSITIVE_ERROR_MESSAGE);
    }
}
