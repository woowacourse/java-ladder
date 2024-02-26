package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPointsGenerator implements PointsGenerator {

    public RandomPointsGenerator() {
    }

    @Override
    public List<Point> generate(int size) {
        List<Point> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            Point point = Point.match(random.nextBoolean());
            list.add(point);
        }
        return list;
    }
}
