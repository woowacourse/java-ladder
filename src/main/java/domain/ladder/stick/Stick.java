package domain.ladder.stick;

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

    public Stick getOpposite() {
        if (this.isSameType(Stick.FILLED)) {
            return Stick.NOT_FILLED;
        }
        return Stick.FILLED;
    }

    public String getShape() {
        return shape;
    }
}
