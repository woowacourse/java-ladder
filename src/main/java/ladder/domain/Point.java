package ladder.domain;

public enum Point {
    AVAILABLE(true),
    DISABLE(false);

    private final boolean status;

    Point(final boolean status) {
        this.status = status;
    }

    public boolean isAvailable() {
        return this.status;
    }

    public static Point from(final boolean status) {
        if (status) {
            return AVAILABLE;
        }
        return DISABLE;
    }
}
