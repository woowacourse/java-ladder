package ladder.domain;

public class LineNumber {

    private final int lineNumber;

    public LineNumber(final int lineNumber) {
        if (lineNumber < 1) {
            throw new IllegalArgumentException("유효하지 않은 라인 번호입니다.");
        }
        this.lineNumber = lineNumber;
    }
}
