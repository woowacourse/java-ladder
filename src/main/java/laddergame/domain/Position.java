package laddergame.domain;

public class Position {
    private final int value;

    public Position(final int value) {
        this.value = value;
    }

    public Position move(final int value) {
        return new Position(this.value + value);
    }

    public int getValue() {
        return this.value;
    }
}
