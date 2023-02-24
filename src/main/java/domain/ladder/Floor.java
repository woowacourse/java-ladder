package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import utils.BooleanGenerator;

public class Floor {
    private static final int DIFFERENCE_NAME_SIZE_AND_FLOOR_SIZE = 1;

    private final List<Boolean> points;

    public Floor(final int namesSize, final BooleanGenerator booleanGenerator) {
        this.points = new ArrayList<>();
        addPoints(calculatePointsSize(namesSize), booleanGenerator);
    }

    private static int calculatePointsSize(final int namesSize) {
        return namesSize - DIFFERENCE_NAME_SIZE_AND_FLOOR_SIZE;
    }

    private void addPoints(final int pointsSize, final BooleanGenerator booleanGenerator) {
        for (int i = 0; i < pointsSize; i++) {
            points.add(generatePoint(i, booleanGenerator));
        }
    }

    private boolean generatePoint(final int index, final BooleanGenerator booleanGenerator) {
        if (isUnableTrue(index)) {
            return false;
        }
        return booleanGenerator.generate();
    }

    private boolean isUnableTrue(final int index) {
        return index > 0 && points.get(index - 1);
    }

    public boolean getPoint(final int index) {
        return points.get(index);
    }

    public List<Boolean> getPoints() {
        return List.copyOf(points);
    }

    public int getPointsSize() {
        return points.size();
    }
}
