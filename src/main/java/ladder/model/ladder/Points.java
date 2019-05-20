package ladder.model.ladder;

import java.util.List;
import java.util.stream.IntStream;

public class Points {
    private List<Boolean> points;

    public Points(List<Boolean> points) {
        checkPointsValid(points);
        this.points = points;
    }

    private void checkPointsValid(List<Boolean> points) {
        int length = points.size();
        IntStream.range(1, length).forEach(i -> checkContinued(i - 1));
    }

    private void checkContinued(int index) {
        if (isContinuedPoints(index)) {
            throw new IllegalArgumentException("이어지는 가로라인 발생");
        }
    }

    private boolean isContinuedPoints(int index) {
        return isTrue(index) && isTrue(index + 1);
    }

    public boolean isTrue(int index) {
        return points.get(index);
    }

    public boolean isUnderLast(int index) {
        return index < points.size();
    }

    public int size() {
        return points.size();
    }
}
