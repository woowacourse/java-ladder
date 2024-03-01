package domain;

import java.util.Random;

public class BooleanGenerator implements RandomGenerator {

    @Override
    public boolean next() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
