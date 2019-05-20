package ladder.domain;

public enum Direction {
    RIGHT(1),
    LEFT(-1),
    SKIP(0);

    private int number;

    private Direction(int number) {
        this.number = number;
    }

    public int number() {
        return this.number;
    }
}
