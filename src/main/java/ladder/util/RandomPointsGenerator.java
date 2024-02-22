package ladder.util;

import ladder.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPointsGenerator {
    private final Random random;

    public RandomPointsGenerator(Random random) {
        this.random = random;
    }

    public List<Point> generate(int size) {
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            boolean randomBoolean = generateRandomBoolean();
            Point point = Point.match(randomBoolean);
            list.add(point);
        }
        return list;
    }

    private boolean generateRandomBoolean() {
        return random.nextBoolean();
    }
}
