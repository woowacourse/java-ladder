package domain;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    private final static RandomPointGenerator instance = new RandomPointGenerator();

    private RandomPointGenerator(){}

    public static RandomPointGenerator getInstance() {
        return instance;
    }

    @Override
    public boolean generate() {
        final Random random = new Random();
        return random.nextBoolean();
    }
}
