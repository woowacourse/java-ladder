package domain.point.strategy;

import domain.point.PointGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPointGenerator implements PointGenerator {
    private static final Random random = new Random();

    @Override
    public List<Boolean> generate(int pointCount) {
        List<Boolean> points = new ArrayList<>(pointCount);
        for (int i = 0; i < pointCount; i++) {
            addPoint(i, points, random.nextBoolean());
        }

        return points;
    }

    private void addPoint(int index, List<Boolean> points, boolean point) {
        if (index == 0) {
            points.add(point);
            return;
        }
        points.add(generatePoint(point, points.get(index - 1)));
    }

    private boolean generatePoint(boolean now, boolean before) {
        while (now == true && before == true) {
            now = random.nextBoolean();
        }

        return now;
    }


}
