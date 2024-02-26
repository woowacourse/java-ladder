package ladder.domain;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    CENTER(0);

    private final int value;

    Direction(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
