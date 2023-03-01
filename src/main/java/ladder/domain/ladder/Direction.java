package ladder.domain.ladder;

import ladder.domain.RandomGenerator;
import ladder.domain.ladderGame.Position;

import java.util.Arrays;
import java.util.function.Function;

public enum Direction {
    LEFT(true, false, Position::decrease),
    RIGHT(false, true, Position::increase),
    STAY(false, false, position -> position);

    private final boolean left;
    private final boolean right;
    private final Function<Position, Position> movingFunction;

    Direction(boolean left, boolean right, Function<Position, Position> movingFunction) {
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

    public Direction next(RandomGenerator randomBooleanGenerator) {
        if (this == RIGHT) {
            return LEFT;
        }
        return Direction.from(this.right, randomBooleanGenerator.generate());
    }

    public Direction last() {
        if (this == RIGHT) {
            return LEFT;
        }
        return STAY;
    }

    public Position move(Position currentPosition) {
        return this.movingFunction.apply(currentPosition);
    }

}
