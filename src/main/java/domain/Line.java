package domain;

import domain.validator.LineValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Point> points;

    public Line(final int pointSize) {
        LineValidator.validate(pointSize);
        this.points = generatePoints(pointSize);
    }

    private List<Point> generatePoints(final int pointSize) {
        // TODO: Random 객체 외부에서 주입받아서 사용하도록 수정
        Random random = new Random();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < pointSize; i++) {
            Point currentPoint = Point.generate(random);
            if (i - 1 >= 0) {
                currentPoint = Point.generate(points.get(i - 1), random);
            }
            points.add(currentPoint);
        }
        return points;
    }

    public Point getPointAt(final int index) {
        return points.get(index);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
