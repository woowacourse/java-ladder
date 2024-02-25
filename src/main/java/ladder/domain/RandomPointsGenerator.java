package ladder.domain;

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
            Point point = Point.match(generateRandomBoolean());
            list.add(point);
        }
        return list;
    }

    private boolean generateRandomBoolean() {
        return random.nextBoolean();
    }
}
