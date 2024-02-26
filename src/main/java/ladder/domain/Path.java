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

    @Override
    public String toString() {
        return "start : " + startLineNumber.toString() + "  end : " + endLineNumber.toString();
    }
}
