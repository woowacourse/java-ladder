package ladder.domain;

public enum PathAvailability {
    EMPTY("     ", false),
    EXIST("-----", true);

    private final String shape;
    private final boolean isAvailable;

    PathAvailability(final String shape, final boolean isAvailable) {
        this.shape = shape;
        this.isAvailable = isAvailable;
    }

    public static PathAvailability from(boolean isAvailable) {
        if (isAvailable) {
            return EXIST;
        }
        return EMPTY;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getShape() {
        return shape;
    }
}
