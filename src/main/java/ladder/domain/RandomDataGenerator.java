package ladder.domain;

import java.util.Random;

public class RandomDataGenerator implements RandomGenerator {

    private final Random random;

    public RandomDataGenerator() {
        this.random = new Random();
    }

    @Override
    public boolean generateBoolean() {
        return random.nextBoolean();
    }

    @Override
    public int generateNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

}
