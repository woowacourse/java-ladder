package ladder.util;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {
    private static final Random random = new Random();

    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }
}
