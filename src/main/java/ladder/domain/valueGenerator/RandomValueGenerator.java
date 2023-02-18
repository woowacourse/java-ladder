package ladder.domain.valueGenerator;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator {

    private final Random random;

    public RandomValueGenerator() {
        this.random = new Random();
    }

    @Override
    public boolean generateBoolean() {
        return random.nextBoolean();
    }

    @Override
    public int generateNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

}
