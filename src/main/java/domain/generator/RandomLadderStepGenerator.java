package domain.generator;

import domain.ladder.LadderStep;
import java.util.Random;

public class RandomLadderStepGenerator implements LadderStepGenerator {

    private final Random random = new Random();

    @Override
    public LadderStep generate() {
        if (random.nextBoolean()) {
            return LadderStep.EXISTS;
        }
        return LadderStep.NONE;
    }
}
