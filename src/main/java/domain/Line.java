package domain;

import util.TrueOrFalseGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final TrueOrFalseGenerator trueOrFalseGenerator;
    private final List<Boolean> points;

    public Line(int personCount, TrueOrFalseGenerator trueOrFalseGenerator) {
        this.trueOrFalseGenerator = trueOrFalseGenerator;
        this.points = makeLine(personCount);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private List<Boolean> makeLine(int personCount) {
        List<Boolean> points = new ArrayList<>();
        points.add(false);
        for (int count = 1; count < personCount; count++) {
            points.add(correctOverLapPoints(points.get(count - 1), trueOrFalseGenerator.generate()));
        }
        points.remove(0);
        return points;
    }

    private Boolean correctOverLapPoints(boolean previous, boolean current) {
        if (!previous || !current) {
            return current;
        }
        return false;
    }
}
