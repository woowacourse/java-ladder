package ladder.domain;

public enum PathAvailability {
    EMPTY("     "),
    EXIST("-----");

    private final String shape;

    PathAvailability(final String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}
