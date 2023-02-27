package domain.ladderRowGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.LadderRow;
import domain.Point;
import domain.ladderRowGenerator.LadderRowGenerator;

public class RandomLadderRowGenerator implements LadderRowGenerator {

    private static final Random RANDOM = new Random();

    public LadderRow generate(int userCount) {
        List<Point> points = createPoints(userCount);
        return new LadderRow(points);
    }

    private List<Point> createPoints(int userCount) {
        List<Point> points = new ArrayList<>();
        Point previousPoint = Point.from(RANDOM.nextBoolean());
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

    private Point generateBarByPrevious(Point previous) {
        if (previous.isRight()) {
            return Point.LEFT;
        }
        return Point.from(RANDOM.nextBoolean());
    }

    private Point createLastPoint(Point previous) {
        if(previous.isRight()){
            return Point.LEFT;
        }
        return Point.NONE;
    }
}
