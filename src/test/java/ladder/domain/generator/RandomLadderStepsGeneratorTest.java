package ladder.domain.generator;

import ladder.domain.ladder.LadderStep;
import ladder.domain.ladder.size.LadderSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomLadderStepsGeneratorTest {
    @Test
    @DisplayName("올바른 크기의 LadderSteps를 생성한다.")
    void generateTest() {
        // given
        int expectedWidth = 7;
        int expectedHeight = 5;
        LadderSize ladderSize = new LadderSize(expectedWidth, expectedHeight);
        RandomLadderStepsGenerator generator = new RandomLadderStepsGenerator(ladderSize);

        // when
        List<LadderStep> ladderSteps = generator.generate();

        // then
        assertThat(ladderSteps.size())
                .isEqualTo(expectedHeight);
        for (LadderStep ladderStep : ladderSteps) {
            int ladderStepWidth = ladderStep.getLadderPaths().size();
            assertThat(ladderStepWidth).isEqualTo(expectedWidth);
        }
    }
}
