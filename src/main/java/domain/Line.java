package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points = new ArrayList<>();
    private final BooleanGenerator generator;

    public Line(final int personCount, final BooleanGenerator generator) {
        this.generator = generator;
        createLine(personCount);
    }

    private void createLine(int personCount) {
        for (int i = 0; i < personCount - 1; i++) {
            boolean nextBoolean = generator.generate();
            boolean nextPoint = getNextPoint(nextBoolean);
            points.add(nextPoint);
        }
    }

    private boolean getNextPoint(boolean nextBoolean) {
        if (points.isEmpty()) {
            return nextBoolean;
        }

        if (isLastPointTrue()) {
            return false;
        }
        
        return nextBoolean;
    }

    private boolean isLastPointTrue() {
        return points.get(points.size() - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
