package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    List<Boolean> points = new ArrayList<>();

    public Line(final int personCount) {
        for (int i = 0; i < personCount; i++) {
            points.add(false);
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public boolean hasPoint(int position) {
        return points.get(position);
    }

    public void putPoint(final int position) {
        points.set(position, true);
    }
}
