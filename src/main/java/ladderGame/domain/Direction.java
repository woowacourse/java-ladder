package ladderGame.domain;

public enum  Direction {
    RIGHT(1),
    LEFT(-1),
    STOP(0);

    private int distance;

    private Direction(int distance) {
        this.distance = distance;
    }

    public static Direction makeDirection(Direction direction, boolean nextRight) {
        if (direction == RIGHT) {
            return LEFT;
        }
        if (nextRight) {
            return RIGHT;
        }
        return STOP;
    }

    public int getDistance() {
        return distance;
    }
}
