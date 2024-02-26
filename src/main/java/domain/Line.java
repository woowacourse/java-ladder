package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points = new ArrayList<>();
    private final PointGenerator generator;

    public Line(final int personCount, final PointGenerator generator) {
        this.generator = generator;
        createLine(personCount);
    }

    private void createLine(int personCount) {
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

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public List<Integer> getMovablePointIndexes() {
        List<Point> movablePoints = points.stream()
                .filter(Point::isMovable)
                .toList();
        return getMovableIndexes(movablePoints);
    }

    private List<Integer> getMovableIndexes(final List<Point> movablePoints) {
        return IntStream.range(0, points.size())
                .filter(index -> movablePoints.contains(points.get(index)))
                .boxed()
                .toList();
    }
}
