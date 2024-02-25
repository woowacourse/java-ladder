package ladder.domain.generator;

import ladder.domain.ladder.LadderStep;
import ladder.domain.ladder.Path;
import ladder.domain.ladder.size.LadderSize;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderStepsGenerator implements LadderStepsGenerator{
    private static final Random RANDOM = new Random();

    private final LadderSize ladderSize;

    public RandomLadderStepsGenerator(LadderSize ladderSize) {
        this.ladderSize = ladderSize;
    }

    @Override
    public List<LadderStep> generate() {
        final List<LadderStep> ladderSteps = new ArrayList<>();
        while (ladderSteps.size() < ladderSize.getHeight()) {
            final LadderStep currentLadderStep = generateLadderStep();
            ladderSteps.add(currentLadderStep);
        }
        return ladderSteps;
    }

    private LadderStep generateLadderStep() {
        final List<Path> ladderPaths = new ArrayList<>();
        while (ladderPaths.size() < ladderSize.getWidth()) {
            final Path currentPath = Path.from(pickRandomBoolean());
            ladderPaths.add(currentPath);
        }
        return new LadderStep(ladderPaths);
    }

    private boolean pickRandomBoolean() {
        return RANDOM.nextBoolean();
    }
}
