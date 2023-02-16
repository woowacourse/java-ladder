package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WidthTest {
    @Test
    public void width_생성_예외던지기() {
        assertThatThrownBy(() -> new Width(1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}