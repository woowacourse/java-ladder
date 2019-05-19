package ladder.domain;

import java.util.Random;

public class RandomValue implements RandomValueGenerator {
    @Override
    public boolean generate() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
