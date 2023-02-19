package ladder.domain;

import static ladder.domain.StepPoint.EXIST;
import static ladder.domain.StepPoint.NONE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LineTest {

    @Test
    @DisplayName("라인은 주어진 폭 만큼의 디딤대 좌표값 개수를 가진다.")
    void should_HasStepPoints_Of_GivenWidth() {
        Line line = Line.of(new RandomStepPointGenerator(), new LineWidth(5));

        assertThat(line.toUnmodifiableStepPoints())
                .hasSize(5);
    }

    @Test
    @DisplayName("디딤대 좌표값은 주어진 생성방식에 따라 생성된다.")
    void should_GenerateStepPoint_By_GivenGenerator() {
        List<StepPoint> expected = List.of(EXIST, NONE, EXIST, NONE, EXIST);

        Queue<StepPoint> generateValues = new LinkedList<>(expected);
        Line line = Line.of(new MockedPointGenerator(generateValues), new LineWidth(expected.size()));

        assertThat(line.toUnmodifiableStepPoints()).isEqualTo(expected);
    }

    @Test
    @DisplayName("라인 생성 시 연속된 디딤대 제공하면 예외를 던진다.")
    void should_ThrowException_When_GenerateContinuousStepPoints() {
        List<StepPoint> expected = List.of(EXIST, EXIST);

        Queue<StepPoint> generateValues = new LinkedList<>(expected);

        assertThatThrownBy(() -> Line.of(new MockedPointGenerator(generateValues), new LineWidth(expected.size())))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("디딤대는 연속적으로 존재할 수 없습니다.");
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
