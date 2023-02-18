package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {
    @Test
    @DisplayName("플레이어의 시작 위치는 0 미만이면 예외를 던진다.")
    void player_startPointShouldOverThanZero() {
        // expected
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalStateException.class);
    }
}
