package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StepPointsTest {

    @Test
    void 주어진_개수만큼_좌표값을_생성한다() {
        StepPoints stepPoints = new StepPoints(new RandomStepPointGenerator(), 5);

        assertThat(stepPoints.toUnmodifiableStepPoints()).hasSize(5);
    }

    @Test
    void 좌표값은_랜덤하게_생성된다() {

        List<Boolean> expected = List.of(true, false, true, false, true);

        Queue<Boolean> queue = new LinkedList<>(expected);

        StepPoints stepPoints = new StepPoints(new MockedPointGenerator(queue), 5);

        assertThat(stepPoints.toUnmodifiableStepPoints()).containsExactly(true, false, true, false, true);

    }

    private class MockedPointGenerator implements RandomGenerator {

        private final Queue<Boolean> queue;

        MockedPointGenerator(Queue<Boolean> queue) {
            this.queue = queue;
        }

        @Override
        public Boolean generate(boolean before) {
            return queue.poll();
        }
    }


}
