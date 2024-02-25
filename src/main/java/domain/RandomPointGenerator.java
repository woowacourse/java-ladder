package domain;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    private final Random random = new Random();

    @Override
    public Point generate() {
        if (random.nextBoolean()) {
            return Point.MOVABLE;
        }
        return Point.UNMOVABLE;
    }
}
