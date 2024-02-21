package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(int playerCount) {
        points = new ArrayList<>();
    }


    public int getPointCount() {
        return points.size();
    }

    public int generateHorizon(int index) {
        points.add(new Point(Direction.RIGHT));
        points.add(new Point(Direction.LEFT));
        return index + 1;
    }

    public int generateVertical(int index) {
        points.add(new Point(Direction.DOWN));
        return index;
    }

    public List<Point> getPoints() {
        return this.points;
    }
}
