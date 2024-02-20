package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int personCount) {
        createLine(personCount);
    }

    private void createLine(int personCount) {
        Random random = new Random();
        for (int i = 0; i < personCount -1; i++) {
            boolean nextBoolean = random.nextBoolean();
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

    private Boolean isLastPointTrue() {
        return points.get(points.size() - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
