package util;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {
    @Override
    public boolean generate() {
        return new Random().nextBoolean();
    }
}
