package ladder.domain;

public class Point {

    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public Index move(Index index) {
        return direction.move(index);
    }

    Direction getDirection() {
        return direction;
    }
}
