package domain;

import utils.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int count, BooleanGenerator booleanGenerator) {
        points.add(booleanGenerator.generate());
        for (int index = 1; index < count; index++) {
            points.add(makeOnePoint(index, booleanGenerator));
        }
    }

    private boolean makeOnePoint(int index, BooleanGenerator booleanGenerator) {
        if (!points.get(index - 1)) {
            return booleanGenerator.generate();
        }
        return false;
    }

    public boolean isExistPoint(int index) {
        return points.get(index);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
