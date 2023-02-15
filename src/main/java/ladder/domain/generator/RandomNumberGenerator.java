package ladder.domain.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int UPPER_BOUND = 2;
    private static final Random RANDOM = new Random();

    @Override
    public int generate() {
        return RANDOM.nextInt(UPPER_BOUND);
    }
}
