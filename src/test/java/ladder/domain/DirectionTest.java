package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {
    @Test
    void 오른쪽_이동() {
        Direction direction = new Direction(false, true);
        assertThat(direction.move()).isEqualTo(1);
    }

    @Test
    void 왼쪽_이동() {
        Direction direction = new Direction(true, false);
        assertThat(direction.move()).isEqualTo(-1);
    }

    @Test
    void 움직이지않음() {
        Direction direction = new Direction(false, false);
        assertThat(direction.move()).isEqualTo(0);
    }

    @Test
    void 방향_오류() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Direction(true, true);
        });
    }
}