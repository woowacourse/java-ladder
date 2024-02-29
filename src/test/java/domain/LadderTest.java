package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @DisplayName("사다리의 높이는 1 이상만 허용한다.")
    @Test
    void checkLadderHeight() {
        int height = 0;
        int playerSize = 2;

        assertThatThrownBy(() -> new Ladder(height, playerSize, filledStickGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 최소 1 이어야 합니다.");
    }

    @DisplayName("사다리는 높이 만큼의 라인을 갖는다.")
    @Test
    void ladderHasLines() {
        int height = 3;
        int playerSize = 9;

        Ladder ladder = new Ladder(height, playerSize, filledStickGenerator());
        int actualHeight = ladder.getHeight();

        assertThat(actualHeight).isEqualTo(height);
    }

    private StickGenerator filledStickGenerator() {
        return () -> Stick.FILLED;
    }
}
