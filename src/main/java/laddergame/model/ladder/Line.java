package laddergame.model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random random = new Random();

    private final List<Point> line;

    public Line(int personCount) {
        this(makeLine(personCount));
    }

    public Line(List<Point> line) {
        validateLine(line);
        this.line = line;
    }

    private static List<Point> makeLine(int personCount) {
        List<Point> line = new ArrayList<>();
        line.add(new Point(new Direction(false), new Direction(random.nextBoolean())));
        for (int i = 1; i < personCount - 1; i++) {
            line.add(makePoint(isPreRightPoint(line.get(i - 1))));
        }
        line.add(new Point(new Direction(isPreRightPoint(line.get(personCount - 2))), new Direction(false)));
        return line;
    }

    private static Point makePoint(boolean preRightPoint) {
        Direction left = new Direction(preRightPoint);
        if (preRightPoint) {
            return new Point(left, new Direction(false));
        }
        return new Point(left, new Direction(random.nextBoolean()));
    }

    private static boolean isPreRightPoint(Point prePoint) {
        return prePoint.getRightIsBoolean();
    }

    private static void validateLine(List<Point> line) {
        for (int i = 0; i < line.size() - 1; i++) {
            validatePoint(line.get(i), line.get(i + 1));
        }
    }

    private static void validatePoint(Point point1, Point point2) {
        if (point1.getRightIsBoolean() && point2.getRightIsBoolean()) {
            throw new IllegalArgumentException("사다리가 연속되게 이어질 수 없습니다.");
        }
    }

    public int size() {
        return line.size();
    }

    public List<Point> getLine() {
        return line;
    }
}
