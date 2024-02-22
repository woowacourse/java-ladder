package strategy;

import java.util.Random;

public class RandomPointStrategy implements PointStrategy {

    @Override
    public boolean generatePoint() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
