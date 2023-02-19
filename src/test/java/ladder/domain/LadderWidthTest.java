package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderWidthTest {
    @Test
    @DisplayName("너비는 0이하이면 예외던지기")
    public void 생성_fail() {
        assertThatThrownBy(() -> new LadderWidth(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("너비가 1 이상이어야 한다.");
    }

    @Test
    @DisplayName("너비가 1이상이면 정상 생성한다")
    public void 생성_success() {
        assertThatNoException()
                .isThrownBy(() -> new LadderWidth(1));
    }
}
