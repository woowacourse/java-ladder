package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int personCount) {
        addPoints(personCount);
    }

    private void addPoints(int personCount) {
        for (int i = 0; i < personCount - 1; i++) {
            points.add(true);
        }
    }

    public int getPointsSize() {
        return points.size();
    }
}
