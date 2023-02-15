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

    public static Line create(int height, NumberGenerator numberGenerator) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            points.add(generatePoint(numberGenerator.generate()));
        }
        return new Line(points);
    }

    private static Point generatePoint(int number) {
        if (number >= MIN_NUMBER_RETURN_TRUE) {
            return Point.PASSABLE;
        }
        return Point.BLOCKED;
    }

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
