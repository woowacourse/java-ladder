package domain;

import utils.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private static final int MIN_NUMBER_RETURN_TRUE = 4;

    private final List<Point> points;

    private Line() {
        this.points = new ArrayList<>();
    }

    public static Line create(int height, NumberGenerator numberGenerator) {
        Line line = new Line();
        for (int i = 0; i < height; i++) {
            line.addPoint(numberGenerator);
        }
        return line;
    }

    private void addPoint(NumberGenerator numberGenerator) {
        if (numberGenerator.generate() >= MIN_NUMBER_RETURN_TRUE) {
            points.add(Point.PASSABLE);
            return;
        }
        points.add(Point.BLOCKED);
    }

    public int getPointSize() {
        return this.points.size();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
