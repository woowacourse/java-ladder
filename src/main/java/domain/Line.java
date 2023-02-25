package domain;

import java.util.Collections;
import java.util.List;

public class Line {

    public static final int POINT_MIN_SIZE = 0;
    public static final int POINT_MAX_SIZE = 19;

    private final List<Point> points;

    public Line(final List<Point> points) {
        validate(points);
        this.points = points;
    }

    private void validate(final List<Point> points) {
        validateSize(points.size());
        validatePointExistContinuous(points);
    }

    public void validateSize(final int pointSize) {
        if (pointSize < POINT_MIN_SIZE || pointSize > POINT_MAX_SIZE) {
            throw new IllegalArgumentException("포인트 범위는 0부터 19까지입니다.");
        }
    }

    private void validatePointExistContinuous(final List<Point> points) {
        Point previousPoint = Point.NOT_EXIST;
        for (Point currentPoint : points) {
            compareWithPreviousPoint(previousPoint, currentPoint);
            previousPoint = currentPoint;
        }
    }

    private void compareWithPreviousPoint(final Point previousPoint, final Point currentPoint) {
        if (previousPoint == Point.EXIST && currentPoint == Point.EXIST) {
            throw new IllegalArgumentException("사다리는 같은 라인에서 연속되는 포인트를 가질 수 없습니다.");
        }
    }

    public Point getPointAt(final int index) {
        return points.get(index);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

}
