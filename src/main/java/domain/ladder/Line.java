package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<LinePoint> points;

    public Line(List<LinePoint> points) {
        this.points = new ArrayList<>(points);
    }

    public List<LinePoint> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int getLastPosition() {
        return points.size() + 1;
    }

    public boolean isLeftPointPassableBySpecificPosition(int position) {
        return points.get(position - 2).isPassable();
    }

    public boolean isRightPointPassableBySpecificPosition(int position) {
        return points.get(position - 1).isPassable();
    }
}
