package ladder.util;

import ladder.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPointsGenerator implements PointsGenerator {

    private final Random random = new Random();

    @Override
    public List<Point> generate(int size) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            addPoint(points, i);
        }
        enforceAtLeastOnePointIsUsed(points);
        return points;
    }

    private void addPoint(List<Point> points, int currentIndex) {
        if (isPreviousPointUsed(points, currentIndex - 1)) {
            points.add(Point.UNUSED);
            return;
        }
        addRandomPoint(points);
    }

    private boolean isPreviousPointUsed(List<Point> points, int previousIndex) {
        return previousIndex >= 0 && points.get(previousIndex).isUsed();
    }

    private void addRandomPoint(List<Point> points) {
        int randomIndex = random.nextInt(Point.values().length);
        Point point = Point.getByIndex(randomIndex);
        points.add(point);
    }

    private void enforceAtLeastOnePointIsUsed(List<Point> points) {
        if (points.stream().noneMatch(Point::isUsed)) {
            int randomIndex = random.nextInt(points.size());
            points.set(randomIndex, Point.USED);
        }
    }
}
