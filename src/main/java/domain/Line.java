package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line fromHeight(Height height) {
        List<Point> points = new ArrayList<>();
        int lineHeight = height.getHeight();

        for (int index = 0; index < lineHeight; index++) {
            points.add(new Point(Direction.STRAIGHT_DOWN));
        }

        return new Line(points);
    }

    public List<Point> getPoints() {
        return this.points;
    }

}
