package domain;

import java.util.Random;
import java.util.function.Supplier;

public class RandomGenerator implements Supplier<Boolean> {
    @Override
    public Boolean get() {
        return new Random().nextBoolean();
    }
}
