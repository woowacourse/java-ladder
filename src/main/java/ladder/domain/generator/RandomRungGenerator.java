package ladder.domain.generator;

import java.security.SecureRandom;
import java.util.Random;
import ladder.domain.ladder.Rung;

public class RandomRungGenerator implements RungGenerator {
    private static final Random DEFAULT_RANDOM = new SecureRandom();

    @Override
    public Rung generate() {
        boolean exist = DEFAULT_RANDOM.nextBoolean();
        if (exist) {
            return Rung.EXIST;
        }
        return Rung.EMPTY;
    }
}

