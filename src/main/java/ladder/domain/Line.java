package ladder.domain;

import ladder.util.BooleanListGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;
    private final BooleanListGenerator booleanListGenerator;

    public Line(int personCount, BooleanListGenerator booleanListGenerator) {
        this.booleanListGenerator = booleanListGenerator;
        this.points = createValidPoints(personCount - 1);
    }

    private List<Point> createValidPoints(int size) {
        List<Point> rawPoints = booleanListGenerator.generate(size);
        if (!rawPoints.contains(Point.ON)) {
            return createValidPoints(size);
        }

        return makePoints(size, rawPoints);
    }

    private List<Point> makePoints(int size, List<Point> rawPoints) {
        List<Point> points = init(rawPoints.get(0));
        for (int i = 1; i < size; i++) {
            Point previous = points.get(i - 1);
            Point current = rawPoints.get(i);
            Point point = replaceValidPoint(previous, current);
            points.add(point);
        }
        return points;
    }

    private List<Point> init(Point point) {
        List<Point> points = new ArrayList<>();
        points.add(point);
        return points;
    }

    private Point replaceValidPoint(Point previous, Point current) {
        if (previous == Point.ON) {
            return Point.OFF;
        }
        return current;
    }

    public List<Point> getPoints() {
        return points;
    }
}
