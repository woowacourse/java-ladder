package ladder.domain.generator;

import ladder.domain.PathAvailability;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ladder.domain.PathAvailability.EMPTY;
import static ladder.domain.PathAvailability.EXIST;

public class RandomLadderStepGenerator extends LadderStepGenerator {
    private final Random random = new Random();

    public RandomLadderStepGenerator(int stepWidth) {
        super(stepWidth);
    }

    @Override
    protected List<PathAvailability> generate() {
        List<PathAvailability> ladderStep = new ArrayList<>();
        PathAvailability isPrevAvailable = EMPTY;
        while (ladderStep.size() < stepWidth) {
            PathAvailability isCurrentAvailable = generatePath(isPrevAvailable);
            ladderStep.add(isCurrentAvailable);
            isPrevAvailable = isCurrentAvailable;
        }
        return ladderStep;
    }

    private PathAvailability generatePath(final PathAvailability isPrevAvailable) {
        if (isPrevAvailable.equals(EXIST)) {
            return EMPTY;
        }
        final boolean isAvailable = random.nextBoolean();
        return PathAvailability.from(isAvailable);
    }
}
