package utils;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {
    @Override
    public boolean isMovable() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
