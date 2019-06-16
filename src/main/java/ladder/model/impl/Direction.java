package ladder.model.impl;

import ladder.utils.RandomValueGenerator;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

class Direction {
    private final static int NEXT = 1;
    private final static int BACK = -1;
    private final static int DIRECT = 0;

    private final boolean left;
    private final boolean current;

    private Direction(final boolean left, final boolean current) {
        if (left && current) {
            throw new IllegalArgumentException();
        }

        this.left = left;
        this.current = current;
    }

    static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    static Direction first(boolean current) {
        return of(FALSE, current);
    }

    int move() {
        if (this.left) {
            return BACK;
        }
        if (this.current) {
            return NEXT;
        }
        return DIRECT;
    }

    Direction next(boolean nextCurrent) {
        return of(this.current, nextCurrent);
    }

    Direction next() {
        if (this.current) {
            return next(FALSE);
        }
        return next(RandomValueGenerator.generate());
    }

    Direction last() {
        return of(this.current, FALSE);
    }

    boolean isCurrent() {
        return current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return left == pair.left &&
                current == pair.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", current=" + current +
                '}';
    }
}