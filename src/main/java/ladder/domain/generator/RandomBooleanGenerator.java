package ladder.domain.generator;

import java.security.SecureRandom;
import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {
    private static final Random DEFAULT_RANDOM = new SecureRandom();

    @Override
    public boolean generate() {
        return DEFAULT_RANDOM.nextBoolean();
    }
}

