package util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    public static boolean generateRandomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
