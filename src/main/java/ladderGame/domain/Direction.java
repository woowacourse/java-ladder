package ladderGame.domain;

public enum  Direction {
    RIGHT(1),
    LEFT(-1),
    STOP(0);

    private int distance;

    private Direction(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
