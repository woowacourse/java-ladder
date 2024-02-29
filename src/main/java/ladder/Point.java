package ladder;

public class Point {

    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public Index move(Index index) {
        if (direction == Direction.LEFT) {
            return index.decrement();
        }
        if (direction == Direction.RIGHT) {
            return index.increment();
        }
        return index;
    }
}
