package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    @DisplayName("현재 좌표에서 이동할 수 있는지 판단한다.")
    void isPointMovable() {
        assertTrue(Point.isMovable(Point.MOVABLE));
    }
}
