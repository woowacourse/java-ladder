package ladder.domain;

import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;

import java.util.Random;

public class DefaultLineGenerator implements LineGenerator {

    private static final Random random = new Random();

    @Override
    public Direction generate() {
        if (random.nextBoolean()) {
            return RIGHT;
        }
        return NONE;
    }
}
