package ladder.model.ladder;

import java.util.List;
import java.util.stream.IntStream;

public class Points {
    private List<Point> points;

    public Points(List<Point> points) {
        checkPointsValid(points);
        this.points = points;
    }

    private void checkPointsValid(List<Point> points) {
        int length = points.size();
        IntStream.range(0, length - 1).forEach(i -> checkContinued(points, i));
    }

    private void checkContinued(List<Point> points, int index) {
        if (isContinuedPoints(points, index)) {
            throw new IllegalArgumentException("이어지는 가로라인 발생");
        }
    }

    private boolean isContinuedPoints(List<Point> points, int index) {
        return points.get(index).isTrue() && points.get(index + 1).isTrue();
    }

    public boolean isTrue(int index) {
        return points.get(index).isTrue();
    }

    public boolean isUnderLast(int index) {
        return index < points.size();
    }

    public int size() {
        return points.size();
    }
}
