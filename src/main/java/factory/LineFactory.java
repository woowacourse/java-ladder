package factory;

import domain.Line;
import domain.Point;
import domain.PointGenerateStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineFactory {

    private static final int FIRST_INDEX = 0;
    private static final int MIN_POINT_SIZE = 0;
    private static final int MAX_POINT_SIZE = 19;

    public static Line of(final int pointSize, final PointGenerateStrategy pointGenerateStrategy) {
        validate(pointSize);
        List<Point> points = generatePoints(pointSize, pointGenerateStrategy);
        return new Line(points);
    }

    private static void validate(final int pointSize) {
        if (pointSize < MIN_POINT_SIZE || pointSize > MAX_POINT_SIZE) {
            throw new IllegalArgumentException("포인트 범위는 0부터 19까지입니다.");
        }
    }

    private static List<Point> generatePoints(final int pointSize, final PointGenerateStrategy pointGenerateStrategy) {
        List<Point> points = new ArrayList<>();
        for (int pointIndex = 0; pointIndex < pointSize; pointIndex++) {
            Point currentPoint = generatePoint(getPreviousPoint(points, pointIndex), pointGenerateStrategy);
            points.add(currentPoint);
        }
        return Collections.unmodifiableList(points);
    }

    private static Point generatePoint(Point previousPoint, PointGenerateStrategy pointGenerateStrategy) {
        // TODO : 리팩토링 해보기
        Point generatedPoint = pointGenerateStrategy.generate();
        if (previousPoint == Point.EXIST) {
            return Point.NOT_EXIST;
        }
        return generatedPoint;
    }

    private static Point getPreviousPoint(final List<Point> points, final int currentPointIndex) {
        if (currentPointIndex > FIRST_INDEX) {
            return points.get(currentPointIndex - 1);
        }
        return Point.NOT_EXIST;
    }

}
