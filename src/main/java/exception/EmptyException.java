package exception;

public class EmptyException extends IllegalArgumentException {
    private static final String BLANK_MESSAGE = "[ERROR] 입력값이 비어있습니다.";

    public EmptyException() {
        super(BLANK_MESSAGE);
    }
}
