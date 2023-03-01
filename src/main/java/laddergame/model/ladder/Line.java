package laddergame.model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random random = new Random();

    private final List<Point> points;

    public Line(int personCount) {
        this(makeLine(personCount));
    }

    public Line(List<Point> points) {
        validateLine(points);
        this.points = points;
    }

    private static List<Point> makeLine(int personCount) {
        List<Point> points = new ArrayList<>();
        points.add(makeFirstPoint());
        for (int i = 1; i < personCount - 1; i++) {
            points.add(makePoint(isPreRightConnect(points.get(i - 1))));
        }
        points.add(makeEndPoint(personCount - 2, points));
        return points;
    }

    private static Point makeFirstPoint() {
        Direction left = new Direction(false);
        Direction right = new Direction(random.nextBoolean());
        return new Point(left, right);
    }

    private static Point makePoint(boolean preRightPoint) {
        Direction left = new Direction(preRightPoint);
        if (preRightPoint) {
            return new Point(left, new Direction(false));
        }
        return new Point(left, new Direction(random.nextBoolean()));
    }

    private static Point makeEndPoint(int index, List<Point> points) {
        Direction left = new Direction(isPreRightConnect(points.get(index)));
        Direction right = new Direction(false);
        return new Point(left, right);
    }

    private static boolean isPreRightConnect(Point prePoint) {
        return prePoint.isRightConnect();
    }

    private static void validateLine(List<Point> line) {
        for (int i = 0; i < line.size() - 1; i++) {
            validatePoints(line.get(i), line.get(i + 1));
        }
    }

    private static void validatePoints(Point point1, Point point2) {
        if (point1.isRightConnect() && point2.isRightConnect()) {
            throw new IllegalArgumentException("사다리가 연속되게 이어질 수 없습니다.");
        }
    }

    public int getLength() {
        return points.size();
    }

    public List<Point> getPoints() {
        return points;
    }

    public Point getPoint(int i) {
        return points.get(i);
    }
}
