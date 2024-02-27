package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @Test
    @DisplayName("Direction의 direction 을 더하면 위치가 변경된다")
    void test() {
        int position = 0;

        position += Direction.RIGHT.getDirection();
        assertEquals(1, position);

        position += Direction.LEFT.getDirection();
        assertEquals(0, position);

        position += Direction.INPLACE.getDirection();
        assertEquals(0, position);
    }
}