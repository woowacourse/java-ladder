package domain;

import java.util.Random;

public class RandomBasedStrategy implements PointGenerateStrategy {

    private final static Random random = new Random();

    @Override
    public Point generate(Point previousPoint) {
        if (previousPoint == Point.EXIST) {
            return Point.NOT_EXIST;
        }
        return Point.generate(random);
    }

}
