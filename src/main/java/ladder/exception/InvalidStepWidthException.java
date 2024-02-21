package ladder.exception;

public class InvalidStepWidthException extends RuntimeException {
    private static final String MESSAGE = "생성된 사다리 너비가 올바르지 않습니다.";

    public InvalidStepWidthException() {
        super(MESSAGE);
    }
}
