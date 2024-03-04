package ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import ladder.domain.ladder.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    static int position;

    @BeforeEach
    void initPosition() {
        position = 1;
    }

    @Test
    @DisplayName("Direction.LEFT의 direction 을 더하면 위치가 1 감소한다.")
    void moveDirectionLeft() {
        position += Direction.LEFT.getDirection();
        assertEquals(0, position);
    }

    @Test
    @DisplayName("Direction.INPLACE direction 을 더하면 위치가 제자리이다")
    void moveDirectionInplace() {
        position += Direction.INPLACE.getDirection();
        assertEquals(1, position);
    }

    @Test
    @DisplayName("Direction.RIGHT의 direction 을 더하면 위치가 1 증가한다.")
    void moveDirectionRight() {
        position += Direction.RIGHT.getDirection();
        assertEquals(2, position);
    }
}