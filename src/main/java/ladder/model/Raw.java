package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Raw {

    private final List<Boolean> points = new ArrayList<>();

    public Raw(int personCount) {
        for (int i = 0; i < personCount; i++) {
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

}
