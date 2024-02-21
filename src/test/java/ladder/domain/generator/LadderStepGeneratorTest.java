package ladder.domain.generator;

import ladder.domain.ladder.Path;
import ladder.exception.ContinuousPathException;
import ladder.exception.InvalidStepWidthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.ladder.Path.EMPTY;
import static ladder.domain.ladder.Path.EXIST;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderStepGeneratorTest {
    @Test
    @DisplayName("연속된 사다리 발판(true)가 생성될 경우 예외가 발생한다.")
    void checkContinuousPathTest() {
        // given
        List<Path> ladderStep = List.of(EXIST, EXIST, EXIST, EMPTY);
        LadderStepGenerator ladderStepGenerator = new TestLadderStepGenerator(ladderStep, 4);

        // when & then
        assertThatThrownBy(ladderStepGenerator::generateValidStep)
                .isInstanceOf(ContinuousPathException.class);
    }

    @Test
    @DisplayName("입력된 값과 생성된 사다리 너비가 다를 경우 예외가 발생한다.")
    void checkStepWidthTest() {
        // given
        List<Path> ladderStep = List.of(EXIST, EMPTY, EXIST);
        LadderStepGenerator ladderStepGenerator = new TestLadderStepGenerator(ladderStep, 4);

        // when & then
        assertThatThrownBy(ladderStepGenerator::generateValidStep)
                .isInstanceOf(InvalidStepWidthException.class);
    }

    private static class TestLadderStepGenerator extends LadderStepGenerator {
        private final List<Path> ladderStep;

        public TestLadderStepGenerator(final List<Path> ladderStep, final int stepWidth) {
            super(stepWidth);
            this.ladderStep = ladderStep;
        }

        @Override
        protected List<Path> generate() {
            return ladderStep;
        }
    }
}
