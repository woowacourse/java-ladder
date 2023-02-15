package domain.service;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {
    private final Random random = new Random();

    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }
}
