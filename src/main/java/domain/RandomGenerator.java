package domain;

import java.util.Random;

public class RandomGenerator implements BooleanGenerator {
    @Override
    public boolean get() {
        return new Random().nextBoolean();
    }
}
