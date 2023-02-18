package ladder.domain;

public enum Step {
    EXIST("-----"),
    EMPTY("     ");

    private final String shape;

    Step(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}
