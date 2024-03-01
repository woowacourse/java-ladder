package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(Boolean... canGoRights) {
        this.points = new ArrayList<>();
    }
}
