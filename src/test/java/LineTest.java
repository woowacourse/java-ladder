import domain.Line;
import domain.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineTest {
    @RepeatedTest(100)
    @DisplayName("랜덤으로 생성된 Line이 유효한지 테스트")
    void randomLineValidateTest() {
        final Line line = new Line(4);
        Assertions.assertDoesNotThrow(() -> validateLine(line));
    }

    @Test
    @DisplayName("Ladder의 라인이 겸치지 않으면 정상 작동")
    void unContinuousLineTest() {
        final Line line = new Line(List.of(Point.LINKED_POINT, Point.EMPTY_POINT, Point.LINKED_POINT));
        Assertions.assertDoesNotThrow(() -> validateLine(line));
    }

    @Test
    @DisplayName("Ladder의 라인이 겸치면 예외 처리")
    void continuousLineTest() {
        final Line line = new Line(List.of(Point.LINKED_POINT, Point.LINKED_POINT, Point.LINKED_POINT));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validateLine(line));
    }

    private void validateLine(Line points) {
        Point state = Point.EMPTY_POINT;
        for (Point line : points.getPoints()) {
            state = comparePastPointAndPresentPoint(state, line);
        }
    }

    private Point comparePastPointAndPresentPoint(Point pastPoint, Point point) {
        if (point.isLink() && pastPoint.isLink()) {
            throw new IllegalArgumentException();
        }
        pastPoint = point;
        return pastPoint;
    }
}
