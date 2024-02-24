package ladder.exception.generator;

public class ContinuousPathException extends RuntimeException {
    private static final String MESSAGE = "연속된 사다리 발판이 존재합니다.";

    public ContinuousPathException() {
        super(MESSAGE);
    }
}
