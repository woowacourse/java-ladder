package domain;

import java.util.Random;

public class RandomDigitsGenerator implements RandomGenerator {

    private static final int DIGIT_SIZE = 2;

    @Override
    public int generate() {
        Random random = new Random();

        return random.nextInt(DIGIT_SIZE);
    }
}
