package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.NumberGenerator;

public class Line {

    private static final int MIN_NUMBER_RETURN_TRUE = 4;

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public static Line create(int numberOfPeople, NumberGenerator numberGenerator) {
        List<Point> points = new ArrayList<>();
        int numberOfPointsToGenerate = numberOfPeople - 1;
        for (int i = 0; i < numberOfPointsToGenerate; i++) {
            addPoint(points, numberGenerator);
        }
        return new Line(points);
    }

    private static void addPoint(List<Point> points, NumberGenerator numberGenerator) {
        if (points.isEmpty()) {
            points.add(generatePoint(numberGenerator.generate()));
            return;
        }

        if (isPreviousPointPassable(points)) {
            points.add(Point.BLOCKED);
            return;
        }
        points.add(generatePoint(numberGenerator.generate()));
    }

    private static Point generatePoint(int number) {
        if (number >= MIN_NUMBER_RETURN_TRUE) {
            return Point.PASSABLE;
        }
        return Point.BLOCKED;
    }

    private static boolean isPreviousPointPassable(List<Point> points) {
        return points.get(points.size() - 1).isPassable();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
