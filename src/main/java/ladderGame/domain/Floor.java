package ladderGame.domain;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.util.Random;

public class Floor {
    private final List<Point> points = new ArrayList<>();

    public Floor(int width) {
        makePoints(width);
    }

    private void makePoints(int width) {
        points.add(Point.pointFirst(createState()));
        while (points.size() != width - 1) {
            Point prePoint = points.get(points.size()-1);
            points.add(prePoint.nextPoint(createState()));
        }
        points.add(points.get(points.size()-1).nextPointLast(createState()));
    }

    private boolean createState() {
        Random random = new Random();
        return random.nextBoolean();
    }


    public List<Point> getPoints() {
        return points;
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
