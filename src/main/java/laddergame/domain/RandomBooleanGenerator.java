package laddergame.domain;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {
    private static final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
