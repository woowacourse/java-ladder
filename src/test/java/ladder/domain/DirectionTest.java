package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DirectionTest {
    @Test
    void 왼쪽_이동() {
        Direction direction = Direction.of(true, false);
        assertThat(direction.move()).isEqualTo(-1);
    }

    @Test
    void 오른쪽_이동() {
        Direction direction = Direction.of(false, true);
        assertThat(direction.move()).isEqualTo(1);
    }

    @Test
    void 이동_안함() {
        Direction direction = Direction.of(false, false);
        assertThat(direction.move()).isEqualTo(0);
    }

    @Test
    void 첫번째() {
        Direction first = Direction.first(false);
        assertThat(first).isEqualTo(Direction.of(false, false));
    }

    @Test
    void 마지막() {
        Direction last = Direction.last(false);
        assertThat(last).isEqualTo(Direction.of(false, false));
    }

    @Test
    void 다음() {
        Direction next = Direction.of(true, false).next(true);
        assertThat(next).isEqualTo(Direction.of(false,true));
    }

    @Test
    void 연속_TRUE() {
        assertThrows(IllegalArgumentException.class, () -> {
            Direction.of(true, true);
        });
    }
}
