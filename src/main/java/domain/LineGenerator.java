package domain;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    private final SecureRandom secureRandom = new SecureRandom();
    private List<Point> line;

    public List<Point> generate(int personCount) {
        personCount--;
        line = new ArrayList<>();
        Point pastPoint = Point.EMPTY_POINT;
        while (personCount-- > 0) {
            boolean randomPoint = secureRandom.nextBoolean();
            generateValidatePoint(randomPoint, pastPoint);
            pastPoint = Point.from(randomPoint);
        }
        return line;
    }

    private void generateValidatePoint(final Boolean isLink, final Point pastPoint) {
        if (pastPoint == Point.LINKED_POINT) {
            line.add(Point.EMPTY_POINT);
            return;
        }
        line.add(Point.from(isLink));
    }
}
