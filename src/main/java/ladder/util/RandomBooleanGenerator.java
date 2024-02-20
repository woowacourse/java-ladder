package ladder.util;

import java.util.Random;
import java.util.function.Supplier;

public class RandomBooleanGenerator implements Supplier<Boolean> {
    private static final Random RANDOM = new Random();

    @Override
    public Boolean get() {
        return RANDOM.nextBoolean();
    }
}
