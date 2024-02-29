package ladder.domain.resource.direction;

import java.util.Random;

public enum Direction {

    RIGHT,
    LEFT,
    NEUTRAL;

    private static final Random RANDOM = new Random();
    private static final Direction[] RIGHT_OR_NEUTRAL = {RIGHT, NEUTRAL};
    private static final int SIZE = RIGHT_OR_NEUTRAL.length;

    public static Direction getRightOrNeutral() {
        return RIGHT_OR_NEUTRAL[RANDOM.nextInt(SIZE)];
    }
}
