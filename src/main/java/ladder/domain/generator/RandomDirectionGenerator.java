package ladder.domain.generator;

import java.util.Random;
import ladder.domain.Direction;

public class RandomDirectionGenerator implements DirectionGenerator {

    private static final Random RANDOM = new Random();
    private static final int UPPER_BOUND = 2;

    @Override
    public Direction generate() {
        final int random = RANDOM.nextInt(UPPER_BOUND);
        return Direction.from(random);
    }
}
