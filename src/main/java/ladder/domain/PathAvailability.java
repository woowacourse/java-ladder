package ladder.domain;

public enum PathAvailability {
    EMPTY("     "),
    EXIST("-----");

    private final String shape;

    PathAvailability(final String shape) {
        this.shape = shape;
    }

    public static PathAvailability from(Boolean isAvailable) {
        if (isAvailable) {
            return EXIST;
        }
        return EMPTY;
    }

    public String getShape() {
        return shape;
    }
}
