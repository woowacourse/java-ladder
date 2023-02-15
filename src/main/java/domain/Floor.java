package domain;

import java.util.ArrayList;
import java.util.List;
import utils.booleanGenerator.BooleanGenerator;

public class Floor {
    List<Boolean> points = new ArrayList<>();

    public Floor(int personCount, BooleanGenerator generator) {
        if (personCount < 2 || personCount > 100) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < personCount - 1; i++) {
            if (i > 0 && points.get(i - 1)) {
                points.add(false);
            } else {
                points.add(generator.generate());
            }
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
