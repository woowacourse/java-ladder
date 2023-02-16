package domain;

import java.util.ArrayList;
import java.util.List;
import utils.LineMaker;

public class Line {

    private final List<Boolean> points;

    public Line(LineMaker lineMaker, int userCount) {
        this.points = new ArrayList<>();
        addPoint(lineMaker.generateLine(userCount));
    }

    public void addPoint(List<Boolean> randomPoints) {
        for (Boolean randomPoint : randomPoints) {
            points.add(convertPoint(randomPoint));
        }
    }

    private boolean convertPoint(Boolean randomPoint) {
        if (checkFront()) {
            return false;
        }
        return randomPoint;
    }

    private boolean checkFront() {
        return !points.isEmpty() && points.get(points.size() - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
