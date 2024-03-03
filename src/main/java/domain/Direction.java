package domain;

import java.util.function.Function;

enum Direction {

    RIGHT(index -> index + 1), LEFT(index -> index - 1), STRAIGHT(index -> index);
    private final Function<Integer, Integer> nextIndexFunction;

    Direction(Function<Integer, Integer> nextIndexFunction) {
        this.nextIndexFunction = nextIndexFunction;
    }

    Point nextPoint(int nowIndex) {
        Integer nextIndex = nextIndexFunction.apply(nowIndex);
        if (this == LEFT) {
            return new Point(RIGHT, nextIndex);
        }
        if (this == RIGHT) {
            return new Point(LEFT, nextIndex);
        }
        return new Point(STRAIGHT, nextIndex);
    }
}
