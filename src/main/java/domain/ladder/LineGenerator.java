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
        List<LineBridge> linePoints = new ArrayList<>();
        int width = countOfPoint - 1;
        while (width-- > 0) {
            addPoint(numberGenerator, linePoints);
        }

        List<LinePoint> points = mapLinePointsToPoints(linePoints);
        addLastPoint(countOfPoint, points);

        return new Line(points);
    }

    private  int addPoint(LineBridge linePoint, List<LinePoint> points, int index) {
        if (linePoint.isPassable()) {
            points.add(new LinePoint(Direction.RIGHT, new Position(index +1)));
            points.add(new LinePoint(Direction.LEFT, new Position(index +2)));
            return ++index;
        }

        points.add(new LinePoint(Direction.DOWN, new Position(index +1)));
        return index;
    }

    private List<LinePoint> mapLinePointsToPoints(List<LineBridge> linePoints) {
        List<LinePoint> points = new ArrayList<>();
        for (int i = 0; i < linePoints.size(); i++) {
            LineBridge linePoint = linePoints.get(i);
            i = addPoint(linePoint, points, i);
        }
        return points;
    }

    private static void addLastPoint(int countOfPoint, List<LinePoint> points) {
        if (points.size() != countOfPoint) {
            points.add(new LinePoint(Direction.DOWN, new Position(countOfPoint)));
        }
    }

    private void addPoint(NumberGenerator numberGenerator, List<LineBridge> points) {
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
}
