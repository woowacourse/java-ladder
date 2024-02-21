package domain;

import java.util.Random;

class RandomStickGenerator implements StickGenerator {

    private static final int RANDOM_BOUND = 2;

    private final Random randomGenerator = new Random();

    @Override
    public Stick generateOne() {
        int random = randomGenerator.nextInt(RANDOM_BOUND);

        if (random == 0) {
            return Stick.EMPTY;
        }

        return Stick.FILLED;
    }
}
