package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int POINTS_MIN_SIZE = 1;
    private static final int POINTS_MAX_SIZE = 49;

    private List<Boolean> points = new ArrayList<>();

    public Line(int personCount, BooleanGenerator booleanGenerator) {
        validate(personCount);
        createPoints(personCount, booleanGenerator);
    }

    private void validate(int personCount) {
        int pointSize = personCount - 1;
        if (pointSize < POINTS_MIN_SIZE || pointSize > POINTS_MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void createPoints(int personCount, BooleanGenerator booleanGenerator) {
        int pointsSize = personCount - 1;
        for (int index = 0; index < pointsSize; index++) {
            boolean flag = booleanGenerator.generate();
            addPoint(index, flag);
        }
    }

    private void addPoint(int index, boolean flag) {
        if (PointJudge.canMake(points, flag, index)) {
            points.add(true);
            return;
        }
        points.add(false);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
