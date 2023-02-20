package domain;

import domain.validator.LineValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Point> points;

    public Line(final List<Point> points) {
        LineValidator.validate(points.size());
        this.points = points;
    }

    public Point getPointAt(final int index) {
        return points.get(index);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

}
