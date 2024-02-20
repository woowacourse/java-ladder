package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderHeightTest {
    @Test
    @DisplayName("사다리 높이가 자연수가 아니면 예외가 발생한다.")
    void ladderHeightRangeTest() {
        int height = 0;
        assertThatThrownBy(() -> new LadderHeight(height))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
