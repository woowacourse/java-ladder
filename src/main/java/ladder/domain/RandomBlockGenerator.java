package ladder.domain;

import java.util.Random;

public class RandomBlockGenerator implements BlockGenerator {

    private final Random random;

    public RandomBlockGenerator() {
        this.random = new Random();
    }

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
