package ladder.exception.outcome;

public class InvalidOutcomeLengthException extends IllegalArgumentException {
    private static final String MESSAGE = "실행 결과의 내용은 1에서 4 글자 사이로 입력해 주세요.";

    public InvalidOutcomeLengthException() {
        super(MESSAGE);
    }
}
