package domain;

import java.util.ArrayList;
import java.util.List;
import utils.NumberGenerator;

public class Line {

    private final List<LinePoint> points;

    private Line(List<LinePoint> points) {
        this.points = new ArrayList<>(points);
    }

    public static Line create(NumberGenerator numberGenerator, int width) {
        List<LinePoint> linePoints = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            addPoint(numberGenerator, linePoints);
        }
        return new Line(linePoints);
    }

    private static void addPoint(NumberGenerator numberGenerator, List<LinePoint> points) {
        if (points.isEmpty()) {
            points.add(LinePoint.from(numberGenerator.generate()));
            return;
        }

        if (isPreviousPointPassable(points)) {
            points.add(LinePoint.BLOCKED);
            return;
        }
        points.add(LinePoint.from(numberGenerator.generate()));
    }

    private static boolean isPreviousPointPassable(List<LinePoint> points) {
        return points.get(points.size() - 1).isPassable();
    }

    public List<LinePoint> getPoints() {
        return points;
    }
}
