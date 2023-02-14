package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private List<Boolean> points;

    public Line(int playerCount) {
        points = new ArrayList<>();
        initializePoints(playerCount);
    }

    private void initializePoints(int count) {
        for (int i = 0; i < count - 1; i++) {
            points.add(true);
        }
    }

    public List<Boolean> toUnmodifiablePoints() {
        return Collections.unmodifiableList(points);
    }
}
