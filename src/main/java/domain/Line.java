package domain;

import java.util.ArrayList;
import java.util.List;
import utils.booleanGenerator.BooleanGenerator;

public class Line {
    private static final int PERSON_COUNT_POINT_SIZE_DIFFERENCE = 1;

    private final BooleanGenerator generator;

    List<Boolean> points = new ArrayList<>();

    public Line(int personNumber, BooleanGenerator generator) {
        this.generator = generator;
        int pointSize = personNumber - PERSON_COUNT_POINT_SIZE_DIFFERENCE;
        for (int index = 0; index < pointSize; index++) {
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
