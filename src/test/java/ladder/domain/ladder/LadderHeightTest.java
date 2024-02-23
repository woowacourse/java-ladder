package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderHeightTest {

    @Test
    @DisplayName("사다리는 높이를 가진다.")
    void testConstruct() {
        int height = 5;

        LadderHeight ladderHeight = new LadderHeight(height);

        assertThat(ladderHeight.getHeight()).isEqualTo(height);
    }

    @Test
    @DisplayName("사다리의 높이가 범위를 벗어나면 예외가 발생한다.")
    void testInvalidHeightRange() {
        assertThatThrownBy(() -> new LadderHeight(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
