package ladder.domain.ladder;

import ladder.domain.generator.RandomLadderStepGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class LadderTest {
    @Test
    @DisplayName("주어진 높이만큼 사다리를 생성한다.")
    void createLadderTest() {
        // given
        final int stepWidth = 3;
        final Height height = new Height(4);

        // when & then
        assertThatCode(() -> new Ladder(height, stepWidth, new RandomLadderStepGenerator()))
                .doesNotThrowAnyException();
    }
}
