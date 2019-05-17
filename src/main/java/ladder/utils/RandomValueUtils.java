package ladder.utils;

import java.util.Random;

public class RandomValueUtils {
    private static Random random = new Random();

    public static boolean generate() {
        return random.nextBoolean();
    }
}
