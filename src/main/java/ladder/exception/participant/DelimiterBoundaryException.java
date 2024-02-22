package ladder.exception.participant;

public class DelimiterBoundaryException extends IllegalArgumentException {
    private static final String MESSAGE = "구분자는 양 끝에 입력할 수 없습니다.";

    public DelimiterBoundaryException() {
        super(MESSAGE);
    }
}
