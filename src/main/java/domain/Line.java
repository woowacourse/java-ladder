package domain;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public Line(int personCount) {
        SecureRandom random = new SecureRandom();
        points = new ArrayList<>();
        Point pastPoint = Point.EMPTY_POINT;
        while (personCount-- > 0) {
            boolean randomPoint = random.nextBoolean();
            generateValidatePoint(randomPoint, pastPoint);
            pastPoint = Point.from(randomPoint);
        }
    }

    private void generateValidatePoint(Boolean isLink, Point pastPoint) {
        if (pastPoint == Point.LINKED_POINT) {
            points.add(Point.EMPTY_POINT);
            return;
        }
        points.add(Point.from(isLink));
    }

    //TODO : Line이 validate한지
    public void validateLine() {
        Point state = Point.EMPTY_POINT;
        for (Point line : points) {
            state = comparePastPointAndPresentPoint(state, line);
        }
    }

    private Point comparePastPointAndPresentPoint(Point pastPoint, Point point) {
        if (point.isLink() && pastPoint.isLink()) {
            throw new IllegalArgumentException();
        }
        pastPoint = point;
        return pastPoint;
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }
}
