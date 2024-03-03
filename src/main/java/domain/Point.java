package domain;

record Point(Direction direction, int index) {
    Point(Direction direction) {
        this(direction, 0);
    }

    Point next() {
        return direction.nextPoint(index);
    }
}
