package model.ladder;

import java.util.Random;

public class RandomStatusGenerator implements StepStatusGenerator {
    private static final Random random = new Random();

    @Override
    public StepStatus generate(final Step previous) {
        if (isNotOverlapped(previous)) {
            return StepStatus.from(random.nextBoolean());
        }
        return StepStatus.DISCONNECTED;
    }

    private boolean isNotOverlapped(final Step previous) {
        return previous.isEmpty() || previous.isDisconnected();
    }
}
