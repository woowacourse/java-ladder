package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineGeneratorTest {
    private final LineGenerator lineGenerator = new LineGenerator();

    @RepeatedTest(100)
    @DisplayName("랜덤으로 생성된 Line이 유효한지 테스트")
    void randomLineValidateTest() {
        int personCount = 4;
        final List<Point> generatedLine = lineGenerator.generate(personCount);
        Assertions.assertDoesNotThrow(() -> validateLine(generatedLine));
    }

    @Test
    @DisplayName("Ladder의 라인이 겸치지 않으면 정상 작동")
    void unContinuousLineTest() {
        final List<Point> line = List.of(Point.LINKED_POINT, Point.EMPTY_POINT, Point.LINKED_POINT);
        Assertions.assertDoesNotThrow(() -> validateLine(line));
    }

    @Test
    @DisplayName("Ladder의 라인이 겸치면 예외 처리")
    void continuousLineTest() {
        final List<Point> line = List.of(Point.LINKED_POINT, Point.LINKED_POINT, Point.LINKED_POINT);
        Assertions.assertThrows(IllegalArgumentException.class, () -> validateLine(line));
    }

    private void validateLine(final List<Point> line) {
        Point state = Point.EMPTY_POINT;
        for (final Point point : line) {
            state = comparePastPointAndPresentPoint(state, point);
        }
    }

    private Point comparePastPointAndPresentPoint(Point pastPoint, final Point point) {
        if (point.isLink() && pastPoint.isLink()) {
            throw new IllegalArgumentException();
        }
        pastPoint = point;
        return pastPoint;
    }
}
