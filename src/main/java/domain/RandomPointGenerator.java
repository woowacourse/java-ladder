package domain;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    private final Random random = new Random();

    @Override
    public Point generate() {   // todo
        boolean left = true;
        boolean right = true;
        while (left && right) {
            left = random.nextBoolean();
            right = random.nextBoolean();
        }
        return Point.of(left, right);
    }

    @Override
    public Point generateExceptLeft() {
        return Point.of(false, random.nextBoolean());
    }

    @Override
    public Point generateExceptRight() {
        return Point.of(random.nextBoolean(), false);
    }
}
