package domain;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    public Line generate(int personCount) {
        final SecureRandom secureRandom = new SecureRandom();
        final List<Point> points = new ArrayList<>();
        Point pastPoint = Point.EMPTY_POINT;
        for (int count = 1; count < personCount; count++) {
            boolean randomPoint = secureRandom.nextBoolean();
            points.add(generateValidatePoint(randomPoint, pastPoint));
            pastPoint = Point.from(randomPoint);
        }
        return new Line(points);
    }

    private Point generateValidatePoint(final boolean isLink, final Point pastPoint) {
        if (pastPoint == Point.LINKED_POINT) {
            return Point.EMPTY_POINT;
        }
        return Point.from(isLink);
    }
}
