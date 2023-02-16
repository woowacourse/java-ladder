package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineTest {
    @Test
    @DisplayName("Line 생성 시 Point가 연속해서 존재하지 않으면 정상적으로 생성")
    void unContinuousLineTest() {
        final List<Point> points = List.of(Point.LINKED_POINT, Point.EMPTY_POINT, Point.LINKED_POINT);
        Assertions.assertDoesNotThrow(() -> new Line(points));
    }

    @Test
    @DisplayName("Line 생성 시 Point가 연속해서 존재하면 예외 처리")
    void continuousLineTest() {
        final List<Point> points = List.of(Point.LINKED_POINT, Point.LINKED_POINT, Point.LINKED_POINT);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Line(points));
    }
}
