package factory;

import domain.Line;
import domain.Point;
import domain.RandomBasedStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineFactory {

    private static final int FIRST_INDEX = 0;

    public static Line generate(final int pointSize, final RandomBasedStrategy randomBasedStrategy) {
        List<Point> points = generatePoints(pointSize, randomBasedStrategy);
        return new Line(points);
    }

    private static List<Point> generatePoints(int pointSize, RandomBasedStrategy randomBasedStrategy) {
        List<Point> points = new ArrayList<>();
        for (int pointIndex = 0; pointIndex < pointSize; pointIndex++) {
            Point currentPoint = randomBasedStrategy.generate(getPreviousPoint(points, pointIndex));
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
