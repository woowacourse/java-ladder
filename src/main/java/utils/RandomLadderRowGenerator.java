package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.LadderRow;
import domain.Point;

public class RandomLadderRowGenerator implements LadderRowGenerator {

    private static final Random RANDOM = new Random();

    public LadderRow generate(int userCount) {
        List<Point> points = createPoints(userCount);
        return new LadderRow(points);
    }

    private List<Point> createPoints(int userCount) {
        List<Point> points = new ArrayList<>();
        Point previousPoint = new Point(false, RANDOM.nextBoolean());
        points.add(previousPoint);
        for (int i = 0; i < userCount - 2; i++) {
            Point nextPoint = generateBarByPrevious(previousPoint);
            points.add(nextPoint);
            previousPoint = nextPoint;
        }
        Point lastPoint = createLastPoint(previousPoint);
        points.add(lastPoint);
        return points;
    }

    private Point createLastPoint(Point previous) {
        boolean currentLeft = previous.getRight();
        return new Point(currentLeft, false);
    }

    private Point generateBarByPrevious(Point previous) {
        boolean currentLeft = previous.getRight();
        if (currentLeft) {
            return new Point(currentLeft, false);
        }
        return new Point(currentLeft, RANDOM.nextBoolean());
    }
}
