package domain;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(final List<Point> points) {
        this.points = points;
    }

    public Line(int personCount) {
        personCount -= 1;
        SecureRandom random = new SecureRandom();
        points = new ArrayList<>();
        Point pastPoint = Point.EMPTY_POINT;
        while (personCount-- > 0) {
            boolean randomPoint = random.nextBoolean();
            generateValidatePoint(randomPoint, pastPoint);
            pastPoint = Point.from(randomPoint);
        }
    }

    private void generateValidatePoint(final Boolean isLink, final Point pastPoint) {
        if (pastPoint == Point.LINKED_POINT) {
            points.add(Point.EMPTY_POINT);
            return;
        }
        points.add(Point.from(isLink));
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }
}
