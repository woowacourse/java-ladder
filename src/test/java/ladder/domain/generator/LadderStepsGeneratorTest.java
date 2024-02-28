package ladder.domain.generator;

import ladder.domain.ladder.LadderStep;
import ladder.domain.ladder.size.LadderSize;
import ladder.testutil.TestPathAvailabilityGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderStepsGeneratorTest {
    @Test
    @DisplayName("올바른 크기의 LadderSteps를 생성한다.")
    void generateTest() {
        // given
        int expectedWidth = 2;
        int expectedHeight = 3;
        LadderSize ladderSize = new LadderSize(expectedWidth, expectedHeight);
        LadderStepsGenerator ladderStepsGenerator = getLadderStepsGenerator();

        // when
        List<LadderStep> ladderSteps = ladderStepsGenerator.generate(ladderSize);

        // then
        assertThat(ladderSteps.size()).isEqualTo(expectedHeight);
        for (LadderStep ladderStep : ladderSteps) {
            int ladderStepWidth = ladderStep.getLadderPaths().size();
            assertThat(ladderStepWidth).isEqualTo(expectedWidth);
        }
    }

    private static LadderStepsGenerator getLadderStepsGenerator() {
        List<Boolean> pathAvailabilities = List.of(true, true, false, false, true, false);
        PathAvailabilityGenerator pathAvailabilityGenerator = new TestPathAvailabilityGenerator(pathAvailabilities);
        return new LadderStepsGenerator(pathAvailabilityGenerator);
    }
}
