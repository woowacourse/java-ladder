package domain;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class LineGenerator {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public Line generate(int personCount) {
        final List<Point> points = new ArrayList<>();
        Point pastPoint = Point.EMPTY_POINT;
        for (int count = 1; count < personCount; count++) {
            boolean randomPoint = SECURE_RANDOM.nextBoolean();
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
