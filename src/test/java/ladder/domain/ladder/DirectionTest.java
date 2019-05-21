package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {
    @Test
    void of_직진() {
        assertThat(Direction.of(0)).isEqualTo(Direction.STRAIGHT);
    }

    @Test
    void of_오른쪽() {
        assertThat(Direction.of(1)).isEqualTo(Direction.RIGHT);
    }

    @Test
    void of_왼쪽() {
        assertThat(Direction.of(-1)).isEqualTo(Direction.LEFT);
    }

    @Test
    void isRight() {
        assertThat(Direction.isRight(Direction.RIGHT)).isTrue();
    }

    @Test
    void 오른쪽이_아닌_경우1() {
        assertThat(Direction.isRight(Direction.LEFT)).isFalse();
    }

    @Test
    void 오른쪽이_아닌_경우2() {
        assertThat(Direction.isRight(Direction.STRAIGHT)).isFalse();
    }

    @Test
    void 존재하지_않는_of() {
        assertThatThrownBy(() -> Direction.valueOf(2)).isInstanceOf(IllegalArgumentException.class);
    }
}
