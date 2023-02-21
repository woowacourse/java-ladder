package domain.model;

import java.util.Random;

public class RandomPassGenerator implements PassGenerator {

    private static final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
