package ladder.model.generator;

import java.util.Random;

public class RandomValueGenerator {
    private static final Random RANDOM = new Random();

    public static boolean generateRandomValue() {
        return RANDOM.nextBoolean();
    }
}
