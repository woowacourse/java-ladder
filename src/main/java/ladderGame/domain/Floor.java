package ladderGame.domain;

import java.util.*;

public class Floor {
    private final List<Point> points;

    public Floor(PointGenerator pointGenerator, int width) {
        this.points = pointGenerator.makePointList(width);
    }

    public Point getPointByPosition(int position) {
        return points.get(position);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return Objects.equals(points, floor.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
