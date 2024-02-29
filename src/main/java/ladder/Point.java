package ladder;

public class Point {

    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public int move(int index) {
        if (direction == Direction.LEFT) {
            return index - 1;
        }
        if (direction == Direction.RIGHT) {
            return index + 1;
        }
        return index;
    }
}
