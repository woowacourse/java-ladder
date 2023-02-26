package laddergame.domain.generator;

import java.util.Random;
import laddergame.domain.ladder.line.StepPoint;

public class RandomStepPointGenerator implements StepPointGenerator {

    private static final Random random = new Random();

    @Override
    public StepPoint generate(final StepPoint previousValue) {
        if (previousValue == StepPoint.EXIST) {
            return StepPoint.NONE;
        }
        return StepPoint.convert(random.nextBoolean());
    }
}
