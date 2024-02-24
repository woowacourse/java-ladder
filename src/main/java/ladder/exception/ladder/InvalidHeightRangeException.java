package ladder.exception.ladder;

public class InvalidHeightRangeException extends IllegalArgumentException {
    private static final String MESSAGE = "사다리 높이는 1 이상의 정수입니다.";

    public InvalidHeightRangeException() {
        super(MESSAGE);
    }
}
