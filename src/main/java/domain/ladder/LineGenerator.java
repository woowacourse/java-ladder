package domain.ladder;

import domain.player.Position;
import java.util.ArrayList;
import java.util.List;
import utils.NumberGenerator;

public class LineGenerator {

    private final NumberGenerator numberGenerator;

    public LineGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Line generate(int countOfPoint) {
        List<LineBridge> lineBridges = new ArrayList<>();
        int width = countOfPoint - 1;
        while (width-- > 0) {
            addLineBridge(numberGenerator, lineBridges);
        }

        List<LinePoint> linePoints = mapBridgeToPoint(lineBridges);
        addLastPoint(countOfPoint, linePoints);

        return new Line(linePoints);
    }

    private void addLineBridge(NumberGenerator numberGenerator, List<LineBridge> points) {
        if (points.isEmpty()) {
            points.add(LineBridge.from(numberGenerator.generate()));
            return;
        }

        if (isLastPointPassable(points)) {
            points.add(LineBridge.BLOCKED);
            return;
        }

        points.add(LineBridge.from(numberGenerator.generate()));
    }

    private boolean isLastPointPassable(List<LineBridge> points) {
        return points.get(points.size() - 1).isPassable();
    }

    private List<LinePoint> mapBridgeToPoint(List<LineBridge> linePoints) {
        List<LinePoint> points = new ArrayList<>();
        for (int index = 0; index < linePoints.size(); index++) {
            LineBridge linePoint = linePoints.get(index);
            index = addLinePoint(linePoint, points, index);
        }
        return points;
    }

    private int addLinePoint(LineBridge linePoint, List<LinePoint> points, int index) {
        if (linePoint.isPassable()) {
            points.add(new LinePoint(Direction.RIGHT, new Position(index + 1)));
            points.add(new LinePoint(Direction.LEFT, new Position(index +2)));
            return ++index;
        }

        points.add(new LinePoint(Direction.DOWN, new Position(index +1)));
        return index;
    }

    private static void addLastPoint(int countOfPoint, List<LinePoint> points) {
        if (points.size() != countOfPoint) {
            points.add(new LinePoint(Direction.DOWN, new Position(countOfPoint)));
        }
    }
}
