package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderSizeTest {
    @Test
    @DisplayName("사다리 높이가 자연수가 아니면 예외가 발생한다.")
    void ladderHeightRangeTest() {
        int height = 0;
        int width = 5;
        assertThatThrownBy(() -> new LadderSize(height, width))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 자연수여야 합니다.");
    }

    @Test
    @DisplayName("사다리 너비가 자연수가 아니면 예외가 발생한다.")
    void ladderWidthRangeTest() {
        int height = 5;
        int width = 0;
        assertThatThrownBy(() -> new LadderSize(height, width))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리 너비는 자연수여야 합니다.");
    }
}
