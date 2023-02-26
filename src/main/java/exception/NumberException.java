package exception;

public class NumberException extends IllegalArgumentException {
    private static final String ONLY_NUMBER_INPUT_MESSAGE = "숫자만 입력 가능 합니다.";

    public NumberException() {
        super(ONLY_NUMBER_INPUT_MESSAGE);
    }
}
