package domain;

import java.util.Random;

public class RandomBasedStrategy implements PointGenerateStrategy {

    private final static Random random = new Random();

    @Override
    public Point generate(final Point previousPoint) {
        if (previousPoint == Point.EXIST) {
            return Point.NOT_EXIST;
        }
        return generate();
    }

    public static Point generate() {
        return Point.of(random.nextBoolean());
    }

}
