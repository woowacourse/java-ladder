package ladder.domain;

import java.util.Random;

public class RandomBooleanGenerator implements RandomGenerator<Boolean> {

    private static final Random random = new Random();

    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }
}
