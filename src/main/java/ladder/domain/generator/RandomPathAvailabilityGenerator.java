package ladder.domain.generator;

import java.util.Random;

public class RandomPathAvailabilityGenerator implements PathAvailabilityGenerator {
    public static final RandomPathAvailabilityGenerator INSTANCE = new RandomPathAvailabilityGenerator();
    private static final Random RANDOM = new Random();

    private RandomPathAvailabilityGenerator() {
    }

    public static RandomPathAvailabilityGenerator getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean generate() {
        return RANDOM.nextBoolean();
    }
}
