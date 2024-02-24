package strategy;

import domain.Point;
import java.util.Random;

public class RandomPointStrategy implements PointStrategy {

    private final Random random;

    public RandomPointStrategy() {
        this.random = new Random();
    }

    @Override
    public Point generatePoint() {
        if (random.nextBoolean()) {
            return Point.CONNECTED;
        }
        return Point.DISCONNECTED;
    }
}
