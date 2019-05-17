package laddergame.domain.ladder;

import java.util.Objects;

public class Direction {

    public static final int LEFT_MOVE = -1;
    public static final int RIGHT_MOVE = 1;
    public static final int KEEP_DIRECTION = 0;

    private final int direction;

    private Direction(int direction) {
        if (!((direction == LEFT_MOVE) || (direction == RIGHT_MOVE)
                || (direction == KEEP_DIRECTION))) {
            throw new IllegalArgumentException("");
        }
        this.direction = direction;
    }

    public static Direction left() {
        return new Direction(LEFT_MOVE);
    }

    public static Direction right() {
        return new Direction(RIGHT_MOVE);
    }

    public static Direction keep() {
        return new Direction(KEEP_DIRECTION);
    }

    public int move() {
        return this.direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        Direction direction1 = (Direction) o;
        return direction == direction1.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
