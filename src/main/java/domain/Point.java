package domain;

public enum Point {
    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private final int moveValue;

    Point(int moveValue) {
        this.moveValue = moveValue;
    }

    public static Point from(boolean status) {
        if(status) {
            return RIGHT;
        }
        return NONE;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

    public int getMoveValue() {
        return moveValue;
    }
}
