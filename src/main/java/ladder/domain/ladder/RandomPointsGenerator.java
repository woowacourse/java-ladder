package ladder.domain.ladder;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomPointsGenerator {
    private final Random random = new Random();

    public RandomPointsGenerator() {
    }

    public List<Point> generate(int size) {
        List<Point> points = Stream.iterate(Point.OFF, this::getPoints)
                .skip(1)
                .limit(size - 1)
                .collect(Collectors.toList());

        if (!points.contains(Point.ON)) {
            return generate(size);
        }
        points.add(Point.OFF);
        return points;
    }

    private Point getPoints(Point previous) {
        if (Point.ON.equals(previous)) {
            return Point.OFF;
        }
        return Point.match(random.nextBoolean());
    }
}
