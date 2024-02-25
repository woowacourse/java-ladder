package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private final RandomPointsGenerator randomPointsGenerator;
    private final List<Point> points;

    public Line(int personCount, RandomPointsGenerator randomPointsGenerator) {
        this.randomPointsGenerator = randomPointsGenerator;
        this.points = createRandomPoints(personCount - 1);
        ensurePoints();
    }

    private List<Point> createRandomPoints(int size) {
        List<Point> points = randomPointsGenerator.generate(size);
        if (!points.contains(Point.ON)) {
            return createRandomPoints(size);
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
