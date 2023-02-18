package ladder.domain;

import static ladder.domain.StepPoint.EXIST;
import static ladder.domain.StepPoint.NONE;
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
    void 주어진_개수만큼_디딤대_좌표값을_생성한다() {
        StepPoints stepPoints = new StepPoints(new RandomStepPointGenerator(), 5);

        assertThat(stepPoints.toUnmodifiableStepPoints()).hasSize(5);
    }

    @Test
    void 디딤대_좌표값은_랜덤하게_생성된다() {
        List<StepPoint> expected = List.of(EXIST, NONE, EXIST, NONE, EXIST);

        Queue<StepPoint> generateValues = new LinkedList<>(expected);
        StepPoints stepPoints = new StepPoints(new MockedPointGenerator(generateValues), 5);

        assertThat(stepPoints.toUnmodifiableStepPoints()).isEqualTo(expected);
    }

    private class MockedPointGenerator implements StepPointGenerator {

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
