package domain;

import utils.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            addPoint(numberGenerator, points);
        }
        return new Line(points);
    }

    private static void addPoint(NumberGenerator numberGenerator, List<Point> points) {
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

    //TODO: Ladder refactoring할 때 메소드 제거
    public static Line createWithoutPassablePoint(int height) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            points.add(generatePoint(MIN_NUMBER_RETURN_TRUE - 1));
        }
        return new Line(points);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
