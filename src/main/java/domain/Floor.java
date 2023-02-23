package domain;

import java.util.ArrayList;
import java.util.List;
import utils.BooleanGenerator;

public class Floor {
    private static final int DIFFERENCE_NAME_SIZE_AND_FLOOR_SIZE = 1;

    private final BooleanGenerator generator;
    private final List<Boolean> points;

    public Floor(int namesSize, BooleanGenerator generator) {
        this.generator = generator;
        this.points = new ArrayList<>();
        addPoints(calculatePointsSize(namesSize));
    }

    private int calculatePointsSize(int namesSize) {
        return namesSize - DIFFERENCE_NAME_SIZE_AND_FLOOR_SIZE;
    }

    private void addPoints(int pointsSize) {
        for (int i = 0; i < pointsSize; i++) {
            points.add(generatePoint(i));
        }
    }

    private boolean generatePoint(int index) {
        if (isUnableTrue(index)) {
            return false;
        }
        return generator.generate();
    }

    private boolean isUnableTrue(int index) {
        return index > 0 && points.get(index - 1);
    }

    public boolean getPoint(int index) {
        return points.get(index);
    }

    public List<Boolean> getPoints() {
        return List.copyOf(points);
    }

    public int getPointsSize() {
        return points.size();
    }
}
