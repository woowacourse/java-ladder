package ladder.domain;

import static ladder.domain.StepPoint.EXIST;
import static ladder.domain.StepPoint.NONE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LineTest {

    @Test
    void 라인은_주어진_폭_만큼의_디딤대_좌표값_개수를_가진다() {
        Line line = Line.of(new RandomStepPointGenerator(), 5);

        assertThat(line.toUnmodifiableStepPoints())
                .hasSize(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 주어진_폭이_1_미만이면_예외(int width) {
        assertThatThrownBy(() -> Line.of(new RandomStepPointGenerator(), width))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 폭은 1 이상이어야 합니다.");
    }

    @Test
    void 디딤대_좌표값은_주어진_생성방식에_따라_생성된다() {
        List<StepPoint> expected = List.of(EXIST, NONE, EXIST, NONE, EXIST);

        Queue<StepPoint> generateValues = new LinkedList<>(expected);
        Line line = Line.of(new MockedPointGenerator(generateValues), 5);

        assertThat(line.toUnmodifiableStepPoints()).isEqualTo(expected);
    }

    @Test
    void 디딤대는_연속될_수_없다() {
        List<StepPoint> expected = List.of(EXIST, EXIST);

        Queue<StepPoint> generateValues = new LinkedList<>(expected);

        assertThatThrownBy(() -> Line.of(new MockedPointGenerator(generateValues), 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static class MockedPointGenerator implements StepPointGenerator {

        private final Queue<StepPoint> queue;

        MockedPointGenerator(Queue<StepPoint> generateValues) {
            this.queue = generateValues;
        }

        @Override
        public StepPoint generate(StepPoint previousValue) {
            return queue.poll();
        }
    }
}
