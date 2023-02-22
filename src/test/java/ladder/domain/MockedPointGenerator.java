package ladder.domain;

import java.util.Queue;

public class MockedPointGenerator implements StepPointGenerator {

    private final Queue<StepPoint> queue;

    MockedPointGenerator(Queue<StepPoint> generateValues) {
        this.queue = generateValues;
    }

    @Override
    public StepPoint generate(StepPoint previousValue) {
        return queue.poll();
    }
}
