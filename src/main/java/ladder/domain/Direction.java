package ladder.domain;

public enum Direction {
    LEFT(-1),
    STRAIGHT(0),
    RIGHT(1);

    private int direction;

    Direction(int direction) {
        this.direction = direction;
    }

}
