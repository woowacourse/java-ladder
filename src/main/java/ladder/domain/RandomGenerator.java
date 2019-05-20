package ladder.domain;

import java.util.Random;

public class RandomGenerator {
    private static final int RANDOM_RANGE = 2;

    public static int number() {
        return new Random().nextInt(RANDOM_RANGE);
    }
}
