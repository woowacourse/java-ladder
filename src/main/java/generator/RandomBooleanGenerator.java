package generator;

import java.util.concurrent.ThreadLocalRandom;

public class RandomBooleanGenerator implements BooleanGenerator {
    @Override
    public boolean generate() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
