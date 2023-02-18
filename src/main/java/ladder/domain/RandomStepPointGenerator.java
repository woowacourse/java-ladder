package ladder.domain;

import java.util.Random;

public class RandomStepPointGenerator implements StepPointGenerator {

    private static final Random random = new Random();

    @Override
    public StepPoint generate(StepPoint previousValue) {
        if (previousValue == StepPoint.EXIST) {
            return StepPoint.NONE;
        }
        return StepPoint.convert(random.nextBoolean());
    }
}
