package domain;

public enum Direction {
    LEFT, RIGHT, STRAIGHT;

    public boolean isLeft() {
        return this == LEFT;
    }

    public boolean isRight() {
        return this == RIGHT;
    }
}
