package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {
    @Test
    void 생성된다() {
        assertThat(new Point(0, 5)).isEqualTo(new Point(0, 5));
    }

    @Test
    void 생성되지_않는다() {
        assertThatThrownBy(() -> {
            new Point(5, 5);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Point(-1, 5);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
