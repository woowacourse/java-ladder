package ladder.domain;

public record LineNumber(int value) {
    private static final int MINIMUM_LINE_NUMBER = 1;

    public LineNumber {
        validateLineNumber(value);
    }

    private void validateLineNumber(final int lineNumber) {
        if (lineNumber < MINIMUM_LINE_NUMBER) {
            throw new IllegalArgumentException("유효하지 않은 라인 번호입니다.");
        }
    }
}
