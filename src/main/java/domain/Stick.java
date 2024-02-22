package domain;

public enum Stick {

    FILLED("-"), EMPTY(" ");

    private final String shape;

    Stick(String shape) {
        this.shape = shape;
    }

    public static Stick getOpposite(Stick stick) {
        if (stick == FILLED) {
            return EMPTY;
        }

        return FILLED;
    }

    public String getShape() {
        return shape;
    }
}
