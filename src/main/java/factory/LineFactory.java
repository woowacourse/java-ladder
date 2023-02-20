package factory;

import domain.Line;
import domain.Point;
import domain.PointGenerateStrategy;

import java.util.ArrayList;
import java.util.List;

public class LineFactory {

    private static final int FIRST_INDEX = 0;
    public static final int MIN_POINT_SIZE = 0;
    public static final int MAX_POINT_SIZE = 19;

    public static Line generate(final int pointSize, final PointGenerateStrategy pointGenerateStrategy) {
        validate(pointSize);
        List<Point> points = generatePoints(pointSize, pointGenerateStrategy);
        return new Line(points);
    }

    private static void validate(int pointSize) {
        if (pointSize < MIN_POINT_SIZE || pointSize > MAX_POINT_SIZE) {
            throw new IllegalArgumentException("포인트 범위는 0부터 19까지입니다.");
        }
    }

    private static List<Point> generatePoints(int pointSize, PointGenerateStrategy pointGenerateStrategy) {
        List<Point> points = new ArrayList<>();
        for (int pointIndex = 0; pointIndex < pointSize; pointIndex++) {
            Point currentPoint = pointGenerateStrategy.generate(getPreviousPoint(points, pointIndex));
            points.add(currentPoint);
        }
        return points;
    }

    private static Point getPreviousPoint(List<Point> points, int currentPointIndex) {
        if (currentPointIndex > FIRST_INDEX) {
            return points.get(currentPointIndex - 1);
        }
        return Point.NOT_EXIST;
    }

}
