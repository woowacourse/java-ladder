package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class HeightTest {
    @Test
    public void 높이_예외던지기() {
        assertThatThrownBy(() -> new Height(1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}