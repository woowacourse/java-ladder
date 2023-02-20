package utils;

import domain.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineMaker implements LineMaker {
    private static final int BOUND = 1;

    private final Random random;

    public RandomLineMaker() {
        this.random = new Random();
    }

    @Override
    public List<Point> generateLine(int userCount) {
        List<Point> points = new ArrayList<>();
        for (int point = 1; point < userCount; point++) {
            points.add(generatePoint(BOUND + 1));
        }

        return points;
    }

    public Point generatePoint(int bound) {
        boolean isConnected = random.nextInt(bound) == BOUND;

        return new Point(isConnected);
    }
}
