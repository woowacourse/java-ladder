package domain;

import java.util.List;

public class CompleteBasedStrategy implements PointGenerateStrategy {

    private final List<List<Point>> points;
    private int currentPointIndex = 0;
    private int currentLineIndex = 0;

    CompleteBasedStrategy(List<List<Point>> points) {
        this.points = points;
    }

    @Override
    public Point generate() {
        if (currentPointIndex == points.get(0).size()) {
            currentLineIndex++;
            currentPointIndex = 0;
        }
        return points.get(currentLineIndex).get(currentPointIndex++);
    }
}
