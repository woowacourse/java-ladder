package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public enum Point {
    EXIST(true),
    NOT_EXIST(false);

    private final boolean isExist;

    Point(boolean isExist) {
        this.isExist = isExist;
    }

    private static final Random random = new Random();

    public static Point generate(final Point previousPoint) {
        if (previousPoint == EXIST) {
            return NOT_EXIST;
        }
        return generate();
    }

    public static Point generate() {
        return of(random.nextBoolean());
    }

    private static Point of(final boolean isExist) {
        if (isExist) {
            return EXIST;
        }
        return NOT_EXIST;
    }

    public boolean isExist() {
        return this.isExist;
    }

    public static List<Boolean> convertPointsToValues(List<Point> points) {
        return points.stream()
                .map(Point::isExist)
                .collect(Collectors.toUnmodifiableList());
    }

}
