package ladder.domain.ladder.generator;

import java.security.SecureRandom;
import java.util.Random;
import ladder.domain.ladder.Rung;

public class RandomRungGenerator implements RungGenerator {
    private static final Random DEFAULT_RANDOM = new SecureRandom();

    @Override
    public Rung generate() {
        return Rung.of(DEFAULT_RANDOM.nextBoolean());
    }
}

