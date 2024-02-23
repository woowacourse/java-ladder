package laddergame.util;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {
    private static final RandomBooleanGenerator generator = new RandomBooleanGenerator();
    private final Random random;

    public RandomBooleanGenerator() {
        this.random = new Random();
    }

    @Override
    public boolean generate() {
        return random.nextInt(2) == 1;
    }

    public static RandomBooleanGenerator getGenerator() {
        return generator;
    }
}
