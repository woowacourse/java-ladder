package ladder.exception.outcome;

public class MismatchedOutcomesCountException extends IllegalArgumentException {
    private static final String MESSAGE = "실행 결과의 수는 참가자 수와 동일해야 합니다.";

    public MismatchedOutcomesCountException() {
        super(MESSAGE);
    }
}
