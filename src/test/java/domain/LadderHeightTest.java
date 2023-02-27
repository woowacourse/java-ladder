package domain;

import domain.Ladder.LadderHeight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderHeightTest {

    @Test
    @DisplayName("사다리 높이가 1 이상이면 정상적으로 생성된다.")
    void createLadderHeightTest() {
        int height = 1;
        LadderHeight ladderHeight = LadderHeight.from(height);
        assertThat(ladderHeight.getHeight()).isEqualTo(height);
    }

    @Test
    @DisplayName("사다리 높이가 1 미만이면 예외가 발생한다.")
    void createLadderHeightExceptionTest() {
        int height = 0;
        assertThatThrownBy(() -> LadderHeight.from(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 높이는 1 이상이어야 합니다.");
    }
}
