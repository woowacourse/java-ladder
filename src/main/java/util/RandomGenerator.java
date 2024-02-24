package util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    public static boolean generateBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
