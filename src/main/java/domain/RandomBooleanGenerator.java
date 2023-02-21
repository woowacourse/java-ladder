package domain;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {
    @Override
    public boolean get() {
        return new Random().nextBoolean();
    }
}
