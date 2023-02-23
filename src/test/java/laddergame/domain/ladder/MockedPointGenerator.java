package laddergame.domain.ladder;

import java.util.Queue;
import laddergame.domain.generator.StepPointGenerator;
import laddergame.domain.ladder.line.StepPoint;

public class MockedPointGenerator implements StepPointGenerator {

    private final Queue<StepPoint> queue;

    public MockedPointGenerator(Queue<StepPoint> generateValues) {
        this.queue = generateValues;
    }

    @Override
    public StepPoint generate(StepPoint previousValue) {
        return queue.poll();
    }
}
