package ladder.domain.utils;

import java.util.Random;

public class RandomGenerator {
    private static Random random = new Random();
    public static Boolean get() {
        return random.nextBoolean();
    }
}
