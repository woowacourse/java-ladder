package ladder.domain;

public class LineNumber {
    private static final int MINIMUM_LINE_NUMBER = 1;

    private final int lineNumber;

    public LineNumber(final int lineNumber) {
        validateLineNumber(lineNumber);
        this.lineNumber = lineNumber;
    }

    private void validateLineNumber(final int lineNumber) {
        if (lineNumber < MINIMUM_LINE_NUMBER) {
            throw new IllegalArgumentException("유효하지 않은 라인 번호입니다.");
        }
    }
}
