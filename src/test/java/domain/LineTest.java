package domain;

import domain.line.Line;
import domain.line.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {
    @Test
    @DisplayName("가로 라인은 겹칠 수 없다.")
    void isLineCannotNextToLine() {
        assertThrows(IllegalStateException.class, () -> new Line(List.of(Point.CONNECTED, Point.CONNECTED)));
    }
}
