package ladder.domain;

import ladder.util.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class RandomLadderGenerator {
    public static Ladder generate(int numOfPlayers, int height) {
        validateNumOfPlayersBiggerThanZero(numOfPlayers);
        validateHeightBiggerThanZero(height);
        return new Ladder(generateLines(numOfPlayers, height), height);
    }

    private static void validateNumOfPlayersBiggerThanZero(int numOfPlayers) {
        if (numOfPlayers <= 0) {
            throw new IllegalArgumentException("플레이어 수는 두 명 이상이어야 합니다.");
        }
    }

    private static void validateHeightBiggerThanZero(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("사다리 높이는 0보다 커야합니다.");
        }
    }

    private static List<Line> generateLines(int numOfPlayers, int height) {
        List<Line> lines = new ArrayList<>();
        while (lines.size() < height) {
            lines.add(generateLine(numOfPlayers));
        }
        return lines;
    }

    private static Line generateLine(int numOfPlayers) {
        Point currentPoint = generateFirstPoint();
        List<Point> points = new ArrayList<>();

        points.add(currentPoint);
        while (points.size() < numOfPlayers - 1) {
            currentPoint = generateNextPoint(currentPoint);
            points.add(currentPoint);
        }
        points.add(currentPoint.last());

        return new Line(points);
    }

    private static Point generateNextPoint(Point currentPoint) {
        if (currentPoint.getCurrent()) {
            return currentPoint.next(false);
        }
        return currentPoint.next(RandomBooleanGenerator.generateRandomBoolean());
    }

    private static Point generateFirstPoint() {
        return Point.first(RandomBooleanGenerator.generateRandomBoolean());
    }
}
