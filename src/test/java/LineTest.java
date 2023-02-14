import domain.Line;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineTest {
    @Test
    @DisplayName("Ladder의 라인이 겸치지 않으면 정상 작동")
    //TODO : 메서드명 고민하기
    void unContinuousLineTest() {
        Line line = new Line(List.of(true, false, true));
        Assertions.assertDoesNotThrow(line::method);
    }

    @Test
    @DisplayName("Ladder의 라인이 겸치면 예외 처리")
    void continuousLineTest() {
        Line line = new Line(List.of(true, true, true));
        Assertions.assertThrows(IllegalArgumentException.class, line::method);
    }
}
