package domain;

import java.util.Random;

public class RandomDigitsGenerator implements RandomGenerator {
    private static final int DIGIT_SIZE = 2;
    private static final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(DIGIT_SIZE);
    }

}
