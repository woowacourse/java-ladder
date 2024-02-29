package ladder.domain;

public class Point {

    private final Direction direction;

    Point(Direction direction) {
        this.direction = direction;
    }

    public Index move(Index index) {
        return direction.move(index);
    }
}
