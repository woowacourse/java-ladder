package laddergame.domain;

import laddergame.util.PointGenerator;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {

    private final PointGenerator pointGenerator;

    public LadderMaker(PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
    }

    public Ladder make(int playerCount, LadderHeight ladderHeight) {
        return new Ladder(generateLines(playerCount, ladderHeight));
    }

    private List<Line> generateLines(int playerCount, LadderHeight ladderHeight) {
        final int pointCount = playerCount - 1;
        List<Line> lines = new ArrayList<>();
        while (!ladderHeight.isEqualTo(lines.size())) {
            lines.add(new Line(createLine(pointCount)));
        }
        return lines;
    }

    private List<Point> createLine(int pointCount) {
        boolean isPreviousConnected = false;
        List<Point> points = new ArrayList<>();
        while (points.size() < pointCount) {
            boolean isCurrentConnected = selectCurrentPoint(isPreviousConnected, pointGenerator.generate());
            points.add(Point.findByConnectedCondition(isCurrentConnected));
            isPreviousConnected = isCurrentConnected;
        }
        return points;
    }

    private boolean selectCurrentPoint(boolean isPreviousConnected, boolean isCurrentConnected) {
        if (isPreviousConnected && isCurrentConnected) {
            return false;
        }
        return isCurrentConnected;
    }
}
