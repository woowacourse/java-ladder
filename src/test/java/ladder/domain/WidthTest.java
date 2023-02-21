package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WidthTest {
    @Test
    @DisplayName("너비는 1이하이면 예외던지기")
    public void 생성_fail() {
        assertThatThrownBy(() -> new Width(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("너비가 2이상이어야 합니다.");
    }

    @Test
    @DisplayName("너비가 2이상이면 정상 생성한다")
    public void 생성_success() {
        assertThatNoException()
                .isThrownBy(() -> new Width(2));
    }
}
