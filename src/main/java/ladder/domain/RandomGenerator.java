package ladder.domain;

import java.util.Random;

public class RandomGenerator {
    private static Random random = new Random();

    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public static boolean getRandomBoolean(boolean result) {
        return (result) ? false : random.nextBoolean();
    }
}
