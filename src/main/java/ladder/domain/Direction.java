package ladder.domain;

public enum Direction {
    LEFT(-1),
    STRAIGHT(0),
    RIGHT(1);

    private int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public static Direction determine(PointsTuple tuple) {
        if (tuple.canMoveRight())
            return Direction.RIGHT;
        if (tuple.canMoveLeft())
            return Direction.LEFT;
        return Direction.STRAIGHT;
    }

    int move(int position) {
        return position + this.direction;
    }
}