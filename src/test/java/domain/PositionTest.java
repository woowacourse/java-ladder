package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    @DisplayName("순서는 0부터 시작한다.")
    void testInitializePosition() {
        int testPosition = -1;

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Position(testPosition));
    }

    @Test
    @DisplayName("주어진 위치에 따라 위치를 이동한다.")
    void testMove() {
        int testPosition = 1;
        Position position = new Position(testPosition);
        Direction direction = Direction.LEFT;
        position.move(direction);

        Assertions.assertEquals(0, position.getPosition());
    }
}
