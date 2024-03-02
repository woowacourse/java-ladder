package domain.ladder;

public class Path {
    private final LineNumber startLineNumber;
    private final LineNumber endLineNumber;

    private Path(final LineNumber startLineNumber, final LineNumber endLineNumber) {
        this.startLineNumber = startLineNumber;
        this.endLineNumber = endLineNumber;
    }

    public static Path of(final int startLineNumber, final int endLineNumber) {
        return new Path(new LineNumber(startLineNumber), new LineNumber(endLineNumber));
    }

    public boolean hasPath(final LineNumber lineNumber) {
        return startLineNumber.value() == lineNumber.value() || endLineNumber.value() == lineNumber.value();
    }

    public int getOtherLineDistance(final LineNumber lineNumber) {
        if (startLineNumber.value() == lineNumber.value()) {
            return endLineNumber.value() - lineNumber.value();
        }
        return startLineNumber.value() - lineNumber.value();
    }
}
