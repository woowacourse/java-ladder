package ladder.exception;

public class InvalidNameLengthException extends IllegalArgumentException {
    private static final String MESSAGE = "이름은 1에서 5자 사이로 입력해 주세요";

    public InvalidNameLengthException() {
        super(MESSAGE);
    }
}
