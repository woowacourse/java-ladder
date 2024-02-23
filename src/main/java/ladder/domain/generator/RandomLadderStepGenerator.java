package ladder.domain.generator;

import ladder.domain.ladder.LadderStep;
import ladder.domain.ladder.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderStepGenerator {
    private static final Random RANDOM = new Random();

    private final int stepWidth;

    public RandomLadderStepGenerator(final int stepWidth) {
        this.stepWidth = stepWidth;
    }

    public LadderStep generate() {
        final List<Path> ladderPaths = new ArrayList<>();
        while (ladderPaths.size() < stepWidth) {
            final Path currentPath = Path.from(pickRandomBoolean());
            ladderPaths.add(currentPath);
        }
        return new LadderStep(ladderPaths);
    }

    private boolean pickRandomBoolean() {
        return RANDOM.nextBoolean();
    }
}
