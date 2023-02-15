package domain;

import java.util.ArrayList;
import java.util.List;
import utils.booleanGenerator.BooleanGenerator;
import utils.validator.FloorValidator;

public class Line {
    private final BooleanGenerator generator;
    List<Boolean> points = new ArrayList<>();

    public Line(int personNumber, BooleanGenerator generator) {
        this.generator = generator;
        FloorValidator.validatePersonNumber(personNumber);
        for (int index = 0; index < personNumber - 1; index++) {
            points.add(getPoint(index));
        }
    }

    private boolean getPoint(int index) {
        if (index > 0 && points.get(index - 1)) {
            return false;
        }
        return generator.generate();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
