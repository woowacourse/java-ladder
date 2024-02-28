package domain.ladder;

public enum Stick {

    FILLED("-"), NOT_FILLED(" ");

    private final String shape;

    Stick(String shape) {
        this.shape = shape;
    }

    public boolean isFilled() {
        return this == FILLED;
    }

    public boolean isSameType(Stick target) {
        return this == target;
    }

    public String getShape() {
        return shape;
    }
}
