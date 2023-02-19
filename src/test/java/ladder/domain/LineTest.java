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

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LineTest {

    @Test
    void 라인은_주어진_폭_만큼의_디딤대_좌표값_개수를_가진다() {
        Line line = Line.of(new RandomStepPointGenerator(), new LineWidth(5));

        assertThat(line.toUnmodifiableStepPoints())
                .hasSize(5);
    }

    @Test
    void 디딤대_좌표값은_주어진_생성방식에_따라_생성된다() {
        List<StepPoint> expected = List.of(EXIST, NONE, EXIST, NONE, EXIST);

        Queue<StepPoint> generateValues = new LinkedList<>(expected);
        Line line = Line.of(new MockedPointGenerator(generateValues), new LineWidth(expected.size()));

        assertThat(line.toUnmodifiableStepPoints()).isEqualTo(expected);
    }

    @Test
    void 디딤대는_연속될_수_없다() {
        List<StepPoint> expected = List.of(EXIST, EXIST);

        Queue<StepPoint> generateValues = new LinkedList<>(expected);

        assertThatThrownBy(() -> Line.of(new MockedPointGenerator(generateValues), new LineWidth(expected.size())))
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
