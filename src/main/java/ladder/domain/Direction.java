package ladder.domain;

public enum Direction {
    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private int moveValue;

    Direction(int moveValue) {
        this.moveValue = moveValue;
    }

    public int getMoveValue() {
        return this.moveValue;
    }
}
