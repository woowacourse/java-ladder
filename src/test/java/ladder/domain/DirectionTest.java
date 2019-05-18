package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {
    @Test
    void valueOf() {
        assertThat(Direction.valueOf(0)).isEqualTo(Direction.STRAIGHT);
    }

    @Test
    void 존재하지_않는_value() {
        assertThatThrownBy(() -> Direction.valueOf(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}
