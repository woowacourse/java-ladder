package domain.ladder;

public enum Direction {
    LEFT(-1),
    DOWN(0),
    RIGHT(1);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
