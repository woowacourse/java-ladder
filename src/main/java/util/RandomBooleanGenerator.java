package util;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {

    private final Random random = new Random();

    public boolean generate() {
        return random.nextBoolean();
    }
}
