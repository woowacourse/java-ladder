package ladder.domain.generator;

import ladder.domain.PathAvailability;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.PathAvailability.EMPTY;
import static ladder.domain.PathAvailability.EXIST;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderStepGeneratorTest {
    @Test
    @DisplayName("연속된 사다리 발판(true)가 생성될 경우 예외가 발생한다.")
    void checkContinuousPathTest() {
        // given
        List<PathAvailability> ladderStep = List.of(EXIST, EXIST, EXIST, EMPTY);
        LadderStepGenerator ladderStepGenerator = new TestLadderStepGenerator(ladderStep, 4);

        // when & then
        assertThatThrownBy(ladderStepGenerator::generateValidStep)
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("입력된 참가자 수와 사다리 폭이 다를 경우 예외가 발생한다.")
    void checkStepWidthTest() {
        // given
        List<PathAvailability> ladderStep = List.of(EXIST, EMPTY, EXIST);
        LadderStepGenerator ladderStepGenerator = new TestLadderStepGenerator(ladderStep, 4);

        // when & then
        assertThatThrownBy(ladderStepGenerator::generateValidStep)
                .isInstanceOf(RuntimeException.class);
    }

    private static class TestLadderStepGenerator extends LadderStepGenerator {
        private final List<PathAvailability> ladderStep;

        public TestLadderStepGenerator(final List<PathAvailability> ladderStep, final int stepWidth) {
            super(stepWidth);
            this.ladderStep = ladderStep;
        }

        @Override
        protected List<PathAvailability> generate() {
            return ladderStep;
        }
    }
}
