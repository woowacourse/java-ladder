package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import utils.NumberGenerator;

public class Line {
    private final List<Boolean> points;

    public Line(int personCount, NumberGenerator numberGenerator) {
        this.points = createLine(personCount, numberGenerator);
    }

    private List<Boolean> createLine(int personCount, NumberGenerator numberGenerator) {
        List<Boolean> points = new ArrayList<>();
        points.add(false);
        for (int index = 1; index < personCount; index++) {
            points.add(isContinuousPoint(points, index, numberGenerator));
        }
        return points;
    }

    private boolean isContinuousPoint(List<Boolean> points, int index, NumberGenerator numberGenerator) {
        if (points.get(index - 1)) {
            return false;
        }
        return numberGenerator.isPoint(true);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
