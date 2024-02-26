package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    @Test
    @DisplayName("사다리 높이가 자연수가 아니면 예외가 발생한다.")
    void ladderHeightRangeTest() {
        int height = 0;
        int width = 5;
        assertThatThrownBy(() -> Ladder.of(height, width))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 너비가 자연수가 아니면 예외가 발생한다.")
    void ladderWidthRangeTest() {
        int height = 5;
        int width = 0;
        assertThatThrownBy(() -> Ladder.of(height, width))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유효한 가로줄을 포함하는 사다리를 생성할 수 있다.")
    void createValidLadderTest() {
        int height = 10;
        int width = 10;
        assertThatCode(() -> Ladder.of(height, width))
                .doesNotThrowAnyException();
    }
}
