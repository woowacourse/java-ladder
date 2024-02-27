package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private final PointsGenerator pointsGenerator;
    private final List<Point> points;

    public Line(int personCount, PointsGenerator pointsGenerator) {
        this.pointsGenerator = pointsGenerator;
        this.points = createRandomPoints(personCount - 1);
        ensurePoints();
    }

    private List<Point> createRandomPoints(int size) {
        List<Point> points = pointsGenerator.generate(size);
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

    public int ride(int position) {
        if (points.get(position) == Point.ON) {
            return position + 1;
        }
        if (position > 0 && points.get(position - 1) == Point.ON) {
            return position - 1;
        }
        return position;
    }
}
