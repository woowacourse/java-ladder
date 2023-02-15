package ladder.domain;

import java.util.Random;

public class RandomDataGenerator implements RandomGenerator{
    @Override
    public boolean generateBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    @Override
    public int generateNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
