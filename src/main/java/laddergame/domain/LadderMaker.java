package laddergame.domain;

import laddergame.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {

    private final BooleanGenerator booleanGenerator;

    public LadderMaker(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
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
        List<Point> points = new ArrayList<>();
        while (points.size() < pointCount) {
            boolean connectedCondition = booleanGenerator.generate();
            points.add(Point.findByConnectedCondition(connectedCondition));
        }
        return points;
    }
}
