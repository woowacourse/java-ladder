package ladder.domain;

import java.util.Random;

public class RandomStepPointGenerator implements RandomGenerator {

    private static final Random random = new Random();

    @Override
    public Boolean generate(boolean previousValue) {
        if (previousValue) {
            return false;
        }
        return random.nextBoolean();
    }
}
