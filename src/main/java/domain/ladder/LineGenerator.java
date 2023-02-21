package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import utils.NumberGenerator;

public class LineGenerator {

    private final NumberGenerator numberGenerator;

    public LineGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Line generate(int width) {
        List<LinePoint> linePoints = new ArrayList<>();
        while (width-- > 0) {
            addPoint(numberGenerator, linePoints);
        }
        return new Line(linePoints);
    }

    private void addPoint(NumberGenerator numberGenerator, List<LinePoint> points) {
        if (points.isEmpty()) {
            points.add(LinePoint.from(numberGenerator.generate()));
            return;
        }

        if (isLastPointPassable(points)) {
            points.add(LinePoint.BLOCKED);
            return;
        }

        points.add(LinePoint.from(numberGenerator.generate()));
    }

    private boolean isLastPointPassable(List<LinePoint> points) {
        return points.get(points.size() - 1).isPassable();
    }
}
