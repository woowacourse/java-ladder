package ladder.domain;

public class Path {
    private final LineNumber startLineNumber;
    private final LineNumber endLineNumber;

    private Path(final LineNumber startLineNumber, final LineNumber endLineNumber) {
        this.startLineNumber = startLineNumber;
        this.endLineNumber = endLineNumber;
    }

    public static Path of(int startLineNumber, int endLineNumber) {
        return new Path(new LineNumber(startLineNumber), new LineNumber(endLineNumber));
    }

    public boolean hasPath(LineNumber lineNumber) {
        return startLineNumber.value() == lineNumber.value() || endLineNumber.value() == lineNumber.value();
    }

    public int getOtherPathDistance(LineNumber lineNumber) {
        if (startLineNumber.value() == lineNumber.value()) {
            return 1;
        }
        return -1;
    }
}
