package ladder.domain;

import static ladder.domain.ladder.Direction.NONE;
import static ladder.domain.ladder.Direction.RIGHT;

import java.util.Random;
import ladder.domain.ladder.Direction;

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
