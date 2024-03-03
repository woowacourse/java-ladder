package domain;

import java.util.Random;
import java.util.function.BooleanSupplier;

public class RandomBooleanSupplier implements BooleanSupplier {
    private final Random random = new Random();

    @Override
    public boolean getAsBoolean() {
        return random.nextBoolean();
    }
}
