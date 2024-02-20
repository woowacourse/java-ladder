package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderPathGeneratorTest {
    @Test
    @DisplayName("연속된 사다리 발판(true)가 생성될 경우 예외가 발생한다.")
    void checkContinuousPathTest() {
        // given
        List<Boolean> path = List.of(true, true, false, true);
        LadderPathGenerator ladderPathGenerator = new TestLadderPathGenerator(path);

        // when & then
        assertThatThrownBy(() -> ladderPathGenerator.generate(4))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("입력된 참가자 수와 사다리 폭이 다를 경우 예외가 발생한다.")
    void checkPathWidthTest() {
        // given
        List<Boolean> path = List.of(true, false, true);
        LadderPathGenerator ladderPathGenerator = new TestLadderPathGenerator(path);

        // when & then
        assertThatThrownBy(() -> ladderPathGenerator.generate(4))
                .isInstanceOf(RuntimeException.class);
    }

    private static class TestLadderPathGenerator extends LadderPathGenerator {
        private final List<Boolean> path;

        public TestLadderPathGenerator(final List<Boolean> path) {
            this.path = path;
        }

        @Override
        protected List<Boolean> generate(int participantCount) {
            return path;
        }
    }
}
