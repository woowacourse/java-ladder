package domain;

import java.util.Collections;
import java.util.List;

public class LadderRow {
    private final List<Point> points;

    public LadderRow(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
