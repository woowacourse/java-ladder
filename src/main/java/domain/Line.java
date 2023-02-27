package domain;

import java.util.Collections;
import java.util.List;

public class Line {

    public static final int POINT_MIN_SIZE = 0;
    public static final int POINT_MAX_SIZE = 19;
    public static final int FIRST_INDEX_OF_POINTS = 0;
    private static final boolean NOT_EXIST = false;
    private static final int MOVING_NONE = 0;
    private static final int RIGHT_MOVING_POSITION = 1;
    private static final int LEFT_MOVING_POSITION = -1;

    private final List<Point> points;

    public Line(final List<Point> points) {
        validate(points);
        this.points = points;
    }

    public int getNextX(int currentXIndex) {
        if (isRightPointExist(currentXIndex) || isLeftPointExist(currentXIndex)) {
            return getMovingPosition(currentXIndex);
        }
        return MOVING_NONE;
    }

    public Point getPointAt(final int index) {
        return points.get(index);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    private int getMovingPosition(int currentXIndex) {
        if (currentXIndex < points.size() && points.get(currentXIndex).isExist()) {
            return RIGHT_MOVING_POSITION;
        }
        return LEFT_MOVING_POSITION;
    }

    private boolean isRightPointExist(final int currentXPosition) {
        if (currentXPosition == points.size()) {
            return NOT_EXIST;
        }
        return points.get(currentXPosition).isExist();
    }

    private boolean isLeftPointExist(final int currentXPosition) {
        if (currentXPosition == FIRST_INDEX_OF_POINTS) {
            return NOT_EXIST;
        }
        return points.get(currentXPosition - 1).isExist();
    }

    private void validate(final List<Point> points) {
        validateSize(points.size());
        validatePointExistContinuous(points);
    }

    private void validateSize(final int pointSize) {
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

}
