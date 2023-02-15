package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line fromHeight(Height height) {
        List<Point> points = new ArrayList<>();
        IntStream.range(0, height.getHeight())
                .forEach(i -> points.add(new Point(Direction.STRAIGHT_DOWN)));

        return new Line(points);
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public void changePointDirectionAt(Direction direction, int index) {
        this.points.get(index - 1)
                .changeDirection(direction);
    }

    public boolean isPointDirectionStraight(int index) {
        return this.points.get(index - 1)
                .matchDirection(Direction.STRAIGHT_DOWN);
    }
}
