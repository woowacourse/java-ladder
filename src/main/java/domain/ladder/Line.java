package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    public static final int POINT_MIN_SIZE = 0;
    public static final int POINT_MAX_SIZE = 19;

    private final List<Point> points;

    private Line(final List<Point> points) {
        validate(points);
        this.points = new ArrayList<>(points);
    }

    public static Line of(final int pointSize, PointGenerator pointGenerator) {
        validate(pointSize);
        List<Point> points = new ArrayList<>();
        for (int pointIndex = 0; pointIndex < pointSize; pointIndex++) {
            Point currentPoint = choosePoint(points, pointGenerator);
            points.add(currentPoint);
        }
        return new Line(points);
    }

    private static Point choosePoint(final List<Point> points, final PointGenerator pointGenerator) {
        Point currentPoint = Point.choosePoint(pointGenerator);
        int pointIndex = points.size();
        int previousPointIndex = pointIndex - 1;
        if (previousPointIndex >= 0) {
            currentPoint = Point.choosePoint(points.get(pointIndex - 1), pointGenerator);
        }
        return currentPoint;
    }

    private static void validate(final int pointSize) {
        validatePointRange(pointSize);
    }

    private static void validate(final List<Point> points) {
        validatePointRange(points.size());
        validateDiscontinuity(points);
    }

    private static void validatePointRange(final int pointSize) {
        if (pointSize < POINT_MIN_SIZE || pointSize > POINT_MAX_SIZE) {
            throw new IllegalArgumentException("포인트 범위는 0부터 19까지입니다.");
        }
    }

    private static void validateDiscontinuity(final List<Point> points) {
        boolean previousExistence = false;
        for (Point point : points) {
            boolean currentExistence = point.isExist();
            checkContinuity(previousExistence, currentExistence);
            previousExistence = currentExistence;
        }
    }

    private static void checkContinuity(final boolean previousExistence, final boolean currentExistence) {
        if (previousExistence && currentExistence) {
            throw new IllegalArgumentException("라인은 겹칠 수 없습니다.");
        }
    }

    public int decideNextIndex(int index) {
        if ((index != 0) && checkPointOn(Direction.LEFT, index)) {
            return index + Direction.LEFT.distance;
        }
        if ((index != points.size()) && checkPointOn(Direction.RIGHT, index)) {
            return index + Direction.RIGHT.distance;
        }
        return index;
    }

    private boolean checkPointOn(Direction direction, int index) {
        Point point = points.get(index + direction.pointDifference);
        return point.isExist();
    }

    public Point getPointAt(final int index) {
        return points.get(index);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    private enum Direction {
        LEFT(-1, -1),
        RIGHT(1, 0);

        private final int distance;
        private final int pointDifference;

        Direction(int distance, int pointDifference) {
            this.distance = distance;
            this.pointDifference = pointDifference;
        }
    }

}
