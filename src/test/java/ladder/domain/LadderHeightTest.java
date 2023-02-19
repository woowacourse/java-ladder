package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderHeightTest {
    @Test
    @DisplayName("높이는 1이하이면 예외던지기")
    public void 생성_fail() {
        assertThatThrownBy(() -> new LadderHeight(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("높이가 2이상이어야 합니다.");
    }

    @Test
    @DisplayName("높이가 2이상이면 정상 생성한다")
    public void 생성_success() {
        assertThatNoException()
                .isThrownBy(() -> new LadderHeight(2));
    }
}
