package domain;

enum Direction {

    LEFT(1),
    RIGHT(1),
    STAY(0);

    Direction(int priority) {
        this.priority = priority;
    }

    private final int priority;

    public Direction getHigherPriority(Direction other) {
        if (priority > other.priority) {
            return this;
        }

        if (priority < other.priority) {
            return other;
        }

        return this;
    }
}
