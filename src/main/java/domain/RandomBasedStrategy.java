package domain;

import java.util.Random;

public class RandomBasedStrategy implements PointGenerateStrategy {

    private final static Random random = new Random();

    @Override
    public Point generate(final Point previousPoint) {
        if (previousPoint == Point.EXIST) {
            return Point.NOT_EXIST;
        }
        return Point.generate(random);
        // TODO : generate메서드가 필요한가?
    }

}
