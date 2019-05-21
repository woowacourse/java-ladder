package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DirectionTest {
    @Test
    public void 첫번째방향생성() {
        assertThat(Direction.firstDirection(true))
                .isEqualTo(Direction.of(false, true));
    }

    @Test
    public void 방향생성() {
        Direction direction = Direction.firstDirection(true);
        assertThat(direction.nextDirection(false))
                .isEqualTo(Direction.of(true, false));
    }

    @Test
    public void 마지막방향생성() {
        Direction direction = Direction.firstDirection(true);
        assertThat(direction.lastDirection())
                .isEqualTo(Direction.of(true, false));
    }

    @Test
    public void 방향생성불가능() {
        assertThrows(IllegalArgumentException.class, () -> {
            Direction.of(true, true);
        });
    }

    @Test
    public void 왼쪽방향() {
        assertThat(Direction.of(true, false).move()).isEqualTo(-1);
    }

    @Test
    public void 오른쪽방향() {
        assertThat(Direction.of(false, true).move()).isEqualTo(1);
    }

    @Test
    public void 일자방향() {
        assertThat(Direction.of(false, false).move()).isEqualTo(0);
    }
}