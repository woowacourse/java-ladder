package ladder.domain.ladder;

import ladder.domain.RandomGenerator;
import ladder.domain.laddergame.Position;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public enum Direction {
    LEFT(true, false, Position::decrease),
    RIGHT(false, true, Position::increase),
    STAY(false, false, position -> position);

    private final boolean left;
    private final boolean right;
    private final UnaryOperator<Position> movingFunction;

    Direction(final boolean left, final boolean right, final UnaryOperator<Position> movingFunction) {
        this.left = left;
        this.right = right;
        this.movingFunction = movingFunction;
    }

    public static Direction from(final boolean left, final boolean right) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.left == left && direction.right == right) //predicate.test(left, right)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("양쪽이 연결되어 있습니다."));
    }

    public Direction next(final RandomGenerator randomBooleanGenerator) {
        if (this == RIGHT) {
            return LEFT;
        }
        return Direction.from(right, randomBooleanGenerator.generate());
    }

    public Direction last() {
        if (this == RIGHT) {
            return LEFT;
        }
        return STAY;
    }

    public Position move(final Position currentPosition) {
        return movingFunction.apply(currentPosition);
    }

    public boolean isRightConnected() {
        return right;
    }

}
