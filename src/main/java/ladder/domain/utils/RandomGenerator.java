package ladder.domain.utils;

import java.util.Random;

import ladder.domain.ladder.Direction;

public class RandomGenerator {
    private static Random random = new Random();

    public static Direction get() {
        return new Direction(random.nextBoolean());
    }
}
