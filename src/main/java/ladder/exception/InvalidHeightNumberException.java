package ladder.exception;

public class InvalidHeightNumberException extends IllegalArgumentException {
    private static final String MESSAGE = "사다리 높이는 숫자로 입력해주세요.";

    public InvalidHeightNumberException() {
        super(MESSAGE);
    }
}
