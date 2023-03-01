package laddergame.domain.ladder.line;

public enum Point {
    FILLED(true),
    EMPTY(false);

    private final boolean isFilled;

    Point(boolean isFilled) {
        this.isFilled = isFilled;
    }

    public static Point of(boolean isFilled) {
        if (isFilled) {
            return FILLED;
        }
        return EMPTY;
    }

    public boolean isFilled() {
        return isFilled;
    }
}
