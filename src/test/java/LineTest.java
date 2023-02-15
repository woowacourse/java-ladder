import domain.Line;
import domain.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineTest {
    @Test
    @DisplayName("Ladder의 라인이 겸치지 않으면 정상 작동")
    //TODO : 메서드명 고민하기
    void unContinuousLineTest() {
        Line line = new Line(List.of(Point.LINKED_POINT, Point.EMPTY_POINT, Point.LINKED_POINT));
        Assertions.assertDoesNotThrow(line::validateLine);
    }

    @Test
    @DisplayName("Ladder의 라인이 겸치면 예외 처리")
    void continuousLineTest() {
        Line line = new Line(List.of(Point.LINKED_POINT, Point.LINKED_POINT, Point.LINKED_POINT));
        Assertions.assertThrows(IllegalArgumentException.class, line::validateLine);
    }
}
