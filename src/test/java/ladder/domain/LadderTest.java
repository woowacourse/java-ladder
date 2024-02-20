package ladder.domain;

import ladder.domain.generator.LadderStepGenerator;
import ladder.domain.generator.RandomLadderStepGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class LadderTest {
    @Test
    @DisplayName("주어진 높이만큼 사다리를 생성한다.")
    void createLadderTest() {
        // given
        int stepWidth = 3;
        int stepHeight = 4;
        LadderStepGenerator ladderStepGenerator = new RandomLadderStepGenerator(stepWidth);

        // when & then
        assertThatCode(() -> new Ladder(ladderStepGenerator, stepHeight))
                .doesNotThrowAnyException();
    }
}
