package domain;

import java.util.ArrayList;
import java.util.List;
import utils.NumberGenerator;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public static Line create(NumberGenerator numberGenerator, int width) {
        List<Point> linePoints = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            addPoint(numberGenerator, linePoints);
        }
        return new Line(linePoints);
    }

    private static void addPoint(NumberGenerator numberGenerator, List<Point> points) {
        if (points.isEmpty()) {
            points.add(Point.from(numberGenerator.generate()));
            return;
        }

        if (isPreviousPointPassable(points)) {
            points.add(Point.BLOCKED);
            return;
        }
        points.add(Point.from(numberGenerator.generate()));
    }

    private static boolean isPreviousPointPassable(List<Point> points) {
        return points.get(points.size() - 1).isPassable();
    }

    public List<Point> getPoints() {
        return points;
    }
}
