package laddergame.domain;

import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = List.copyOf(points);
    }

    public List<Point> getLine() {
        return points;
    }
}
