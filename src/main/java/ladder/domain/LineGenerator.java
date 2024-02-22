package ladder.domain;

import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;

import java.util.Random;

public class LineGenerator {

    private static final Random random = new Random();

    public Direction generate() {
        if (random.nextBoolean()) {
            return RIGHT;
        }
        return NONE;
    }
}
