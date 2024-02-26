package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        return points.stream()
                .filter(Point::isMovable)
                .map(points::indexOf)
                .toList();
    }
}
