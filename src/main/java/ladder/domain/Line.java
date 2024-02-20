package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int personCount) {
        for (int i = 0; i < personCount - 1; i++) {
            this.points.add(false);
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
