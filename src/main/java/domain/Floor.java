package domain;

import java.util.ArrayList;
import java.util.List;
import utils.booleanGenerator.BooleanGenerator;
import utils.validator.FloorValidator;

public class Floor {
    private final BooleanGenerator generator;
    List<Boolean> points = new ArrayList<>();

    public Floor(int personCount, BooleanGenerator generator) {
        this.generator = generator;
        FloorValidator.validatePersonCount(personCount);
        for (int index = 0; index < personCount - 1; index++) {
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
