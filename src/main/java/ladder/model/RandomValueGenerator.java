package ladder.model;

import java.util.Random;

class RandomValueGenerator {
    private static final Random RANDOM = new Random();

    static boolean generate() {
        return RANDOM.nextBoolean();
    }
}
