package laddergame.domain.point;

import laddergame.domain.point.Point;
import laddergame.domain.point.PointGenerator;

import java.util.Random;


public class RandomPointGenerator implements PointGenerator {

    private static final Random random = new Random();

    @Override
    public Point generate() {
        return Point.from(random.nextBoolean());
    }
}
