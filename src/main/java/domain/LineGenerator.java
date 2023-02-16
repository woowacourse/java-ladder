package domain;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    private final SecureRandom secureRandom = new SecureRandom();
    private List<Point> points;

    public Line generate(int personCount) {
        personCount--;
        points = new ArrayList<>();
        Point pastPoint = Point.EMPTY_POINT;
        while (personCount-- > 0) {
            boolean randomPoint = secureRandom.nextBoolean();
            generateValidatePoint(randomPoint, pastPoint);
            pastPoint = Point.from(randomPoint);
        }
        return new Line(points);
    }

    private void generateValidatePoint(final Boolean isLink, final Point pastPoint) {
        if (pastPoint == Point.LINKED_POINT) {
            points.add(Point.EMPTY_POINT);
            return;
        }
        points.add(Point.from(isLink));
    }
}
