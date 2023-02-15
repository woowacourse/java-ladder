package ladder.domain;

import java.util.Random;

public class RandomIntegerGenerator implements RandomGenerator<Integer> {
    private final int max;
    private final int min;

    public RandomIntegerGenerator(int max, int min) {
        this.max = max;
        this.min = min;
    }

    @Override
    public Integer generate() {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
