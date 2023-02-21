package util;

import java.util.Random;

public class RandomValueGenerator {

    private final Random random = new Random();

    public Boolean getRandomValue() {
        return random.nextBoolean();
    }
}
