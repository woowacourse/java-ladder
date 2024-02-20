package ladder.domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderStepGeneratorTest {
    @Test
    @DisplayName("연속된 사다리 발판(true)가 생성될 경우 예외가 발생한다.")
    void checkContinuousPathTest() {
        // given
        List<Boolean> path = List.of(true, true, false, true);
        LadderStepGenerator ladderStepGenerator = new TestLadderStepGenerator(path, 4);

        // when & then
        assertThatThrownBy(ladderStepGenerator::generateValidStep)
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("입력된 참가자 수와 사다리 폭이 다를 경우 예외가 발생한다.")
    void checkStepWidthTest() {
        // given
        List<Boolean> path = List.of(true, false, true);
        LadderStepGenerator ladderStepGenerator = new TestLadderStepGenerator(path, 4);

        // when & then
        assertThatThrownBy(ladderStepGenerator::generateValidStep)
                .isInstanceOf(RuntimeException.class);
    }

    private static class TestLadderStepGenerator extends LadderStepGenerator {
        private final List<Boolean> path;

        public TestLadderStepGenerator(final List<Boolean> path, final int stepWidth) {
            super(stepWidth);
            this.path = path;
        }

        @Override
        protected List<Boolean> generate() {
            return path;
        }
    }
}
