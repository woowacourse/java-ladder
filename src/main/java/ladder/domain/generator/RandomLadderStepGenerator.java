package ladder.domain.generator;

import ladder.domain.ladder.LadderStep;
import ladder.domain.ladder.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderStepGenerator {
    private static final Random random = new Random();

    static public LadderStep generate(final int stepWidth) {
        final List<Path> ladderPaths = new ArrayList<>();
        while (ladderPaths.size() < stepWidth) {
            final Path currentPath = generatePath();
            ladderPaths.add(currentPath);
        }
        return new LadderStep(ladderPaths);
    }

    static private Path generatePath() {
        final boolean isAvailable = random.nextBoolean();
        return Path.from(isAvailable);
    }
}
