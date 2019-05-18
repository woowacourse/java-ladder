package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirecionTest {
    @Test
    void valueOf_테스트() {
        assertThat(Direction.valueOf(0)).isEqualTo(Direction.STRAIGHT);
        assertThat(Direction.valueOf(1)).isEqualTo(Direction.RIGHT);
        assertThat(Direction.valueOf(2)).isEqualTo(Direction.LEFT);
    }

    @Test
    void valueOf_존재하지_않는_값의_경우() {
        assertThatThrownBy(() -> Direction.valueOf(3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Direction.valueOf(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}
