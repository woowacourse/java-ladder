package ladder.domain.ladder;

public enum Path {
    EMPTY("     "),
    EXIST("-----");

    private final String shape;

    Path(final String shape) {
        this.shape = shape;
    }

    public static Path from(final boolean isAvailable) {
        if (isAvailable) {
            return EXIST;
        }
        return EMPTY;
    }

    public boolean isExist() {
        return this.equals(EXIST);
    }

    public String getShape() {
        return shape;
    }
}
