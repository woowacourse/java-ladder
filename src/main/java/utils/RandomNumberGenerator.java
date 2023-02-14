package utils;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{

    private final Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    @Override
    public int generate() {
        return random.nextInt(10);
    }
}
