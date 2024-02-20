package laddergame.util;

import java.util.Random;

public class RandomBooleanGenerator {
    private static final RandomBooleanGenerator generator = new RandomBooleanGenerator();
    private final Random random;

    public RandomBooleanGenerator() {
        this.random = new Random();
    }

    public Integer generate() {
        return random.nextInt(2);
    }

    public static RandomBooleanGenerator getGenerator() {
        return generator;
    }
}
