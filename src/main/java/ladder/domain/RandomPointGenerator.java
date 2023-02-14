package ladder.domain;

import java.util.Random;

public class RandomPointGenerator implements RandomGenerator {

    private static final Random random = new Random();

    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }
}
