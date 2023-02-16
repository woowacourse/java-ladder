package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(final List<Point> points) {
        this.points = points;
    }

    public Line(final int personCount) {
        LineGenerator lineGenerator = new LineGenerator();
        points = lineGenerator.generate(personCount);
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }
}
