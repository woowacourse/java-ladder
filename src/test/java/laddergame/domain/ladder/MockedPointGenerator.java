package laddergame.domain.ladder;

import java.util.Queue;
import laddergame.domain.generator.StepPointGenerator;
import laddergame.domain.ladder.line.StepPoint;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
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
