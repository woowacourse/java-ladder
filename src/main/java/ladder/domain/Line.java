package ladder.domain;

import ladder.util.BooleanListGenerator;

import java.util.Collections;
import java.util.List;

public class Line {

    private final BooleanListGenerator booleanListGenerator;
    private final List<Point> points;

    public Line(int personCount, BooleanListGenerator booleanListGenerator) {
        this.booleanListGenerator = booleanListGenerator;
        this.points = createPoints(personCount - 1);
        ensurePoints();
    }

    private List<Point> createPoints(int size) {
        List<Point> points = booleanListGenerator.generate(size);
        if (!points.contains(Point.ON)) {
            return createPoints(size);
        }
        return points;
    }

    private void ensurePoints() {
        for (int i = 1; i < points.size(); i++) {
            makePointEnsure(i);
        }
    }

    private void makePointEnsure(int currentIndex) {
        Point previous = points.get(currentIndex - 1);
        if (previous == Point.ON) {
            points.set(currentIndex, Point.OFF);
        }
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
