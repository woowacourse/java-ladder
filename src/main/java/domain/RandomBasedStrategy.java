package domain;

import java.util.Random;

public class RandomBasedStrategy implements PointGenerateStrategy {

    private final static Random random = new Random();

    @Override
    public Point generate() {
        return Point.of(random.nextBoolean());
    }

}
