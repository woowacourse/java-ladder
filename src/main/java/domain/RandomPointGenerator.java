package domain;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    private final Random random = new Random();

    @Override
    public Point generate() {
        boolean left = random.nextBoolean();
        boolean right = random.nextBoolean();

        if (left) {
            right = false;
        }
        return Point.of(left, right);
    }

    @Override
    public Point generateFirstPoint() {
        return Point.of(false, random.nextBoolean());
    }

    @Override
    public Point generateLastPoint() {
        return Point.of(random.nextBoolean(), false);
    }
}
