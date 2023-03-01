package domain;

import static domain.Position.LEFT_MOST_POSITION;

import java.util.ArrayList;
import java.util.List;
import utils.NumberGenerator;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public static Line create(int numberOfPeople, NumberGenerator numberGenerator) {
        List<Point> points = new ArrayList<>();
        int width = numberOfPeople - 1;
        for (int i = 0; i < width; i++) {
            addPoint(points, numberGenerator);
        }
        return new Line(points);
    }

    private static void addPoint(List<Point> points, NumberGenerator numberGenerator) {
        if (points.isEmpty()) {
            points.add(Point.of(numberGenerator.generate()));
            return;
        }

        if (isPreviousPointPassable(points)) {
            points.add(Point.BLOCKED);
            return;
        }
        points.add(Point.of(numberGenerator.generate()));
    }

    private static boolean isPreviousPointPassable(List<Point> points) {
        return points.get(points.size() - 1).isPassable();
    }

    public void tryMoveAt(Position position) {
        if (isRightPassableAt(position)) {
            position.moveToRight();
            return;
        }
        if (isLeftPassableAt(position)) {
            position.moveToLeft();
        }
    }

    private boolean isRightPassableAt(Position position) {
        if (position.equals(new Position(width()))) {
            return false;
        }
        return points.get(position.value()).isPassable();
    }

    private boolean isLeftPassableAt(Position position) {
        if (position.equals(LEFT_MOST_POSITION)) {
            return false;
        }
        return points.get(position.value() - 1).isPassable();
    }

    public List<Point> points() {
        return List.copyOf(points);
    }

    public int width() {
        return points.size();
    }
}
