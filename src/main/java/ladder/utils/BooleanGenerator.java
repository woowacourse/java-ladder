package ladder.utils;

import java.util.Random;

public class BooleanGenerator implements RandomGenerator<Boolean> {
    private static final Random RANDOM = new Random();

    @Override
    public Boolean generate() {
        return RANDOM.nextBoolean();
    }
}
