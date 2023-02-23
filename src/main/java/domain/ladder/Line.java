package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import utils.RandomNumberGenerator;

public class Line {
    private final List<Boolean> points;

    public Line(int personCount, RandomNumberGenerator randomNumberGenerator) {
        this.points = createLine(personCount, randomNumberGenerator);
    }

    private List<Boolean> createLine(int personCount, RandomNumberGenerator randomNumberGenerator) {
        List<Boolean> points = new ArrayList<>();
        points.add(false);
        for (int index = 1; index < personCount; index++) {
            points.add(isContinuousPoint(points, index, randomNumberGenerator));
        }
        return points;
    }

    private boolean isContinuousPoint(List<Boolean> points, int index, RandomNumberGenerator randomNumberGenerator) {
        if (points.get(index - 1)) {
            return false;
        }
        return randomNumberGenerator.isPoint();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
