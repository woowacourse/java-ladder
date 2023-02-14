package domain;

public class Ladder {
    private static final int LINE_MIN_SIZE = 1;
    private static final int LINE_MAX_SIZE = 30;

    public Ladder(final int lineSize) {
        validate(lineSize);
    }

    private void validate(final int lineSize) {
        if (lineSize < LINE_MIN_SIZE || lineSize > LINE_MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
