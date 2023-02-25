package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import laddergame.utils.LineMaker;

public class LineImpl implements Line{

    private final List<PointImpl> points;

    public LineImpl(LineMaker lineMaker, int userCount) {
        this.points = new ArrayList<>();
        addPoint(lineMaker.generateLine(userCount));
    }

    private void addPoint(List<PointImpl> randomPoints) {
        for (PointImpl randomPoint : randomPoints) {
            points.add(convertPoint(randomPoint));
        }
    }

    private PointImpl convertPoint(PointImpl randomPoint) {
        if (checkFront()) {
            return new PointImpl(false);
        }
        return randomPoint;
    }

    private boolean checkFront() {
        if (points.isEmpty()) {
            return false;
        }

        int lastIndex = points.size() - 1;

        return points.get(lastIndex).isConnected();
    }

    public List<PointImpl> getPoints() {
        return points;
    }

}
