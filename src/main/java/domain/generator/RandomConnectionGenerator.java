package domain.generator;

import java.util.Random;

public class RandomConnectionGenerator implements ConnectionGenerator {

    private final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
