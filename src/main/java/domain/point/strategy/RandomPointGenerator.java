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
            boolean point = random.nextBoolean();
            if(i == 0) {
                points.add(point);
                continue;
            }
            points.add(generatePoint(point, points.get(i-1)));
        }
        return points;
    }

    private boolean generatePoint(boolean now, boolean before) {
        while(now == true && before == true) {
            now = random.nextBoolean();
        }

        return now;
    }


}
