package ladder.domain.generator;

import ladder.domain.ladder.LadderStep;
import ladder.domain.ladder.Path;
import ladder.domain.ladder.size.LadderSize;

import java.util.ArrayList;
import java.util.List;

public class LadderStepsGenerator {
    private final PathAvailabilityGenerator pathAvailabilityGenerator;

    public LadderStepsGenerator(final PathAvailabilityGenerator pathAvailabilityGenerator) {
        this.pathAvailabilityGenerator = pathAvailabilityGenerator;
    }

    public List<LadderStep> generate(final LadderSize ladderSize) {
        final List<LadderStep> ladderSteps = new ArrayList<>();
        final int ladderWidth = ladderSize.getWidth();
        while (ladderSteps.size() < ladderSize.getHeight()) {
            final LadderStep currentLadderStep = generateLadderStep(ladderWidth);
            ladderSteps.add(currentLadderStep);
        }
        return ladderSteps;
    }

    private LadderStep generateLadderStep(final int ladderWidth) {
        final List<Path> ladderPaths = new ArrayList<>();
        while (ladderPaths.size() < ladderWidth) {
            final boolean pathAvailability = pathAvailabilityGenerator.generate();
            final Path currentPath = Path.from(pathAvailability);
            ladderPaths.add(currentPath);
        }
        return new LadderStep(ladderPaths);
    }
}
