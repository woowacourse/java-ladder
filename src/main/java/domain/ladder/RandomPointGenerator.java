package domain.ladder;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator {

    private static final Random random = new Random();

    @Override
    public Point generate() {
        return Point.of(random.nextBoolean());
    }
    
}
