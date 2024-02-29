package ladderGame.model;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {

    private final Random random;

    public RandomBooleanGenerator() {
        this.random = new Random();
    }

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
