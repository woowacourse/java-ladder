package domain;

import java.util.ArrayList;
import java.util.List;
import utils.RandomNumberGenerator;

public class Line {
    private final List<Boolean> points;

    public Line(int personCount) {
        this.points = createLine(personCount);
    }

    private List<Boolean> createLine(int personCount) {
        List<Boolean> points = new ArrayList<>();
        points.add(false);
        for (int i = 1; i < personCount; i++) {
            points.add(isContinuousTrue(points, i));
        }
        return points;
    }

    private boolean isContinuousTrue(List<Boolean> points, int index) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        if (points.get(index - 1)) {
            return false;
        }
        return randomNumberGenerator.isPoint();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
