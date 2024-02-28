package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points = new ArrayList<>();

    public Line(final int personCount, final PointGenerator generator) {
        createLine(personCount, generator);
    }

    private void createLine(final int personCount, final PointGenerator generator) {
        for (int i = 0; i < personCount - 1; i++) {
            Point nextPoint = selectNextPoint(generator.generate());
            points.add(nextPoint);
        }
    }

    private Point selectNextPoint(Point nextPoint) {
        if (points.isEmpty()) {
            return nextPoint;
        }

        if (isLastPointMovable()) {
            return Point.UNMOVABLE;
        }

        return nextPoint;
    }

    private boolean isLastPointMovable() {
        if (points.isEmpty()) {
            return false;
        }
        Point lastPoint = points.get(points.size() - 1);
        return Point.isMovable(lastPoint);
    }

    public List<Boolean> getMovableLinePoints() {
        return points.stream()
                .map(Point::valueOf)
                .toList();
    }

    public List<Integer> getMovablePointIndexes() {
        List<Point> movablePoints = findMovablePointsOnLine();
        return IntStream.range(0, points.size())
                .filter(index -> movablePoints.contains(points.get(index)))
                .boxed()
                .toList();
    }

    private List<Point> findMovablePointsOnLine() {
        return points.stream()
                .filter(Point::isMovable)
                .toList();
    }
}
