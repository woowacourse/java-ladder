package domain;

public class Position {

    private final int value;

    public Position(final int value) {
        this.value = value;
    }

    public Position moveLeft() {
        return new Position(value - 1);
    }

    public Position moveRight() {
        return new Position(value + 1);
    }

    public int getValue() {
        return value;
    }
}
