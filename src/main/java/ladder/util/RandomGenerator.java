package ladder.util;

import java.util.Random;

public class RandomGenerator implements Generator {
    private static final int RANDOM_RANGE = 2;

    @Override
    public int generate() {
        return new Random().nextInt(RANDOM_RANGE);
    }
}
