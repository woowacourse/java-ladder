package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int personCount) {
        for (int j = 0; j < personCount-1; j++) {
            points.add(false);
        }
    }

    public int size() {
        return points.size();
    }
}
