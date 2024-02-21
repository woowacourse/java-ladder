package ladder.domain.generator;

import ladder.domain.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ladder.domain.Path.EMPTY;
import static ladder.domain.Path.EXIST;

public class RandomLadderStepGenerator extends LadderStepGenerator {
    private final Random random = new Random();

    public RandomLadderStepGenerator(int stepWidth) {
        super(stepWidth);
    }

    @Override
    protected List<Path> generate() {
        List<Path> ladderPaths = new ArrayList<>();
        Path prevPath = EMPTY;
        while (ladderPaths.size() < stepWidth) {
            Path currentPath = generatePath(prevPath);
            ladderPaths.add(currentPath);
            prevPath = currentPath;
        }
        return ladderPaths;
    }

    private Path generatePath(final Path prevPath) {
        if (prevPath.equals(EXIST)) {
            return EMPTY;
        }
        final boolean isAvailable = random.nextBoolean();
        return Path.from(isAvailable);
    }
}
