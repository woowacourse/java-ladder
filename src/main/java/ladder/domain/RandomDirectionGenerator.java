package ladder.domain;

import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;

import java.util.Random;

public class RandomDirectionGenerator implements DirectionGenerator {
    private static final Random RANDOM = new Random();

    @Override
    public Direction generate() {
        if (RANDOM.nextBoolean()) {
            return RIGHT;
        }
        return NONE;
    }
}
