package ladder.domain;

public enum Point {
    FILLED(true),
    EMPTY(false);

    private final boolean isExist;

    Point(boolean isExist) {
        this.isExist = isExist;
    }

    public static Point of(boolean value) {
        if (value) {
            return FILLED;
        }
        return EMPTY;
    }

    public boolean isExist() {
        return isExist;
    }
}
