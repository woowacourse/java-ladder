package domain.generator;

import java.util.Random;

public class RandomFootholdGenerator implements FootholdGenerator {

    private final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}
