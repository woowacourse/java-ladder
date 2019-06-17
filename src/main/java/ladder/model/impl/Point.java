package ladder.model.impl;

class Point {
    private final static int NEXT = 1;

    private final int index;
    private final Direction direction;

    Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    static Point first(boolean right) {
        return new Point(0, Direction.first(right));
    }

    int move() {
        return index + direction.move();
    }

    Point next() {
        return new Point(index + NEXT, direction.next());
    }

    Point next(boolean right) {
        return new Point(index + NEXT, direction.next(right));
    }

    Point last() {
        return new Point(index + 1, direction.last());
    }

    boolean isNotLast(int maxPosition) {
        return maxPosition != (this.index + 2);
    }

    boolean isCurrent() {
        return direction.isCurrent();
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}