package domain;

import util.TrueOrFalseGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(int personCount, TrueOrFalseGenerator trueOrFalseGenerator) {
        this.points = makeLine(personCount,trueOrFalseGenerator);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private List<Boolean> makeLine(int personCount,TrueOrFalseGenerator trueOrFalseGenerator) {
        List<Boolean> points = new ArrayList<>();
        for (int count = 0; count < personCount-1; count++) {
            points.add(correctOverLapPoints(points, trueOrFalseGenerator.generate(), count));
        }
        return points;
    }

    private Boolean correctOverLapPoints(List<Boolean> points, boolean current,int count) {
        if (points.size() == 0) {
            return current;
        }
        if (!points.get(count-1) || !current) {
            return current;
        }
        return false;
    }
}
