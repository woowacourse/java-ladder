package ladder.domain.ladder;

import ladder.domain.generator.RandomLadderStepGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    @Test
    @DisplayName("주어진 높이만큼 사다리를 생성한다.")
    void createLadderTest() {
        // given
        final int stepWidth = 3;
        final Height height = new Height(4);
        final RandomLadderStepGenerator ladderStepGenerator = new RandomLadderStepGenerator(stepWidth);

        // when
        Ladder ladder = new Ladder(ladderStepGenerator, height);
        int ladderHeight = ladder.getLadderSteps().size();

        // then
        assertThat(ladderHeight).isEqualTo(4);
    }
}
