package ladder.domain;

import java.util.Random;

public class RandomMovableGenerator implements RandomGenerator {

    private final Random random;

    public RandomMovableGenerator() {
        this.random = new Random();
    }

    @Override
    public boolean generateBoolean() {
        return random.nextBoolean();
    }

}
