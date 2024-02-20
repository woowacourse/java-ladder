package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    List<Boolean> points = new ArrayList<>();

    public Line(final int size) {
        for (int i = 0; i < size; i++) {
            points.add(false);
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public boolean hasPoint() {
        return false;
    }
}
