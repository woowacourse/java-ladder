package ladder.domain;

public enum Direction {

    LEFT(-1),
    STAY(0),
    RIGHT(1),
    ;

    private final int move;

    Direction(final int move) {
        this.move = move;
    }

    public int getMove() {
        return move;
    }
}
