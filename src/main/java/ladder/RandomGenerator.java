package ladder;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static boolean generateBoolean() {
        return random.nextBoolean();
    }
}
