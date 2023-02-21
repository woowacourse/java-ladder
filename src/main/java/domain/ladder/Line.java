package domain.ladder;

import domain.Point;
import util.TrueOrFalseGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    public static Line generate(int personCount,TrueOrFalseGenerator trueOrFalseGenerator) {
        List<Point> points = new ArrayList<>();
        for (int count = 0; count < personCount-1; count++) {
            points.add(correctOverLapPoints(points, new Point(trueOrFalseGenerator.generate()), count));
        }
        return new Line(points);
    }

    private static Point correctOverLapPoints(List<Point> points, Point current, int count) {
        if (points.size() == 0||points.get(count - 1).equals(current)) {
            return current;
        }
        return current.nonPass();
    }
}
