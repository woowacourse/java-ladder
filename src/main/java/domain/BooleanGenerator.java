package domain;

import java.util.Random;

public class BooleanGenerator implements RandomGenerator {
    private static Random RANDOM = new Random();

    @Override
    public boolean next() {
        return RANDOM.nextBoolean();
    }
}
