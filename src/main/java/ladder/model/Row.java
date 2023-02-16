package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Row {

    private final List<Boolean> points = new ArrayList<>();

    public Row(int personCount) {
        for (int i = 0; i < personCount - 1; i++) {
            points.add(false);
        }
    }

    public void createLineAt(int point, boolean isCreated) {
        points.set(point, isCreated);
    }

    public boolean isPointHasLine(int point) {
        return points.get(point);
    }

    public boolean isLeftPointHasLine(int point) {
        return points.get(point - 1);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

}
