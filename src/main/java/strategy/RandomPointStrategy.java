package strategy;

import domain.Point;
import java.util.Random;

public class RandomPointStrategy implements PointStrategy {

    @Override
    public Point generatePoint() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return Point.CONNECTED;
        }
        return Point.DISCONNECTED;
    }
}
