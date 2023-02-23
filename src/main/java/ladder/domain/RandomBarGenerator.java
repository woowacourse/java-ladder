package ladder.domain;

import java.util.Random;

public class RandomBarGenerator implements RandomGenerator {

    private final Random random;

    public RandomBarGenerator() {
        this.random = new Random();
    }

    @Override
    public Bar generate() {
        boolean connected = random.nextBoolean();

        return Bar.from(connected);
    }

}
