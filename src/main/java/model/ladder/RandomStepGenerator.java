package model.ladder;

import java.util.Random;

public class RandomStepGenerator implements StepStatusGenerator {
    @Override
    public StepStatus generate(final Step previous) {
        Random random = new Random();
        if (isNotOverlapped(previous)) {
            return StepStatus.from(random.nextBoolean());
        }
        return StepStatus.DISCONNECTED;
    }

    private boolean isNotOverlapped(final Step previous) {
        return previous.isEmpty() || previous.isDisconnected();
    }
}
