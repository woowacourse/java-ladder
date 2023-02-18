package domain;

import java.util.ArrayList;
import java.util.List;
import utils.booleanGenerator.BooleanGenerator;

public class Line {
    private final BooleanGenerator generator;
    List<Boolean> points = new ArrayList<>();

    public Line(int lineNumber, BooleanGenerator generator) {
        this.generator = generator;
        for (int index = 0; index < lineNumber; index++) {
            points.add(getPoint(index));
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private boolean getPoint(int index) {
        if (index > 0 && points.get(index - 1)) {
            return false;
        }
        return generator.generate();
    }
}
