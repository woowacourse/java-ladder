package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Row {

    private static final int FIRST_POINT = 0;
    private final List<Boolean> points = new ArrayList<>();

    public Row(int personCount, LineCreateDecider lineCreateDecider) {
        int pointCount = personCount - 1;

        for (int i = 0; i < pointCount; i++) {
            createLineAt(i, lineCreateDecider.decide());
        }
    }

    private void createLineAt(int point, boolean isCreated) {
        if (isLeftPointHasLine(point)) {
            points.add(false);
            return;
        }
        points.add(isCreated);
    }

    private boolean isLeftPointHasLine(int point) {
        if (point == FIRST_POINT) {
            return false;
        }
        return points.get(point - 1);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

}
