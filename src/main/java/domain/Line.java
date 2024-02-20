package domain;

import utils.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line(int count, BooleanGenerator booleanGenerator) {
        points.add(booleanGenerator.generate());
        for (int i = 1; i < count; i++) {
            if (!points.get(i - 1)) {
                points.add(booleanGenerator.generate());
                continue;
            }
            points.add(false);

        }
    }

    List<Boolean> getPoints() {
        return points;
    }
}
