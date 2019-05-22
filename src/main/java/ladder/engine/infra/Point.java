package ladder.engine.infra;

class Point {
    private final int index;
    private final Direction direction;

    Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    int move() {
        return index + direction.move();
    }

    Point next() {
        return new Point(index + 1, direction.next());
    }

    Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    boolean isLast(int maxPosition) {
        return maxPosition == this.index + 1;
    }

    static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}