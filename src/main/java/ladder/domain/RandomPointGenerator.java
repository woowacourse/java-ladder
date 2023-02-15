package ladder.domain;

import java.util.Random;

public class RandomPointGenerator implements RandomGenerator {

    private static final Random random = new Random();

    @Override
    public Boolean generate(boolean before) {
        if (before) {
            return false;
        }
        return random.nextBoolean();
    }
}
