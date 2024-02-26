package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @DisplayName("생성 테스트")
    @Test
    void createLadder() {
        assertThatCode(() -> new Ladder(3, 2, filledStickGenerator()))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리의 높이는 1 이상만 허용한다.")
    @Test
    void checkLadderHeight() {
        assertThatThrownBy(() -> new Ladder(0, 2, filledStickGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리는 높이 만큼의 라인을 갖는다.")
    @Test
    void ladderHasLines() {
        int height = 3;
        Ladder ladder = new Ladder(height, 9, filledStickGenerator());
        List<Line> lines = ladder.getLines();

        assertThat(lines).hasSize(height);
    }

    private StickGenerator filledStickGenerator() {
        return () -> Stick.FILLED;
    }
}
