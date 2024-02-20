package laddergame.util;

import java.util.Random;

public class RandomBooleanGenerator implements NumberGenerator {
    private static final RandomBooleanGenerator generator = new RandomBooleanGenerator();
    private final Random random;

    public RandomBooleanGenerator() {
        this.random = new Random();
    }

    @Override
    public Integer generate() {
        return random.nextInt(2);
    }

    public static RandomBooleanGenerator getGenerator() {
        return generator;
    }
}
