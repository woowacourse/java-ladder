package domain.ladder;

import java.util.Random;

public class RandomStickGenerator implements StickGenerator {

    private static final int RANDOM_BOUND = 2;

    private final Random randomGenerator = new Random();

    @Override
    public Stick generateOne() {
        int random = this.randomGenerator.nextInt(RANDOM_BOUND);

        if (random == 0) {
            return Stick.NOT_FILLED;
        }

        return Stick.FILLED;
    }
}
