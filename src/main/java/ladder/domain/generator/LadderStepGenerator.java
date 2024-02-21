package ladder.domain.generator;

import ladder.domain.LadderStep;
import ladder.domain.PathAvailability;

import java.util.List;

import static ladder.domain.PathAvailability.EMPTY;

public abstract class LadderStepGenerator {
    protected final int stepWidth;

    public LadderStepGenerator(final int stepWidth) {
        this.stepWidth = stepWidth;
    }

    public LadderStep generateValidStep() {
        List<PathAvailability> path = generate();
        validateStepWidth(path);
        validateContinuousPath(path);
        return new LadderStep(path);
    }

    private void validateStepWidth(final List<PathAvailability> paths) {
        if (paths.size() != stepWidth) {
            throw new RuntimeException();
        }
    }

    private void validateContinuousPath(final List<PathAvailability> paths) {
        paths.stream().reduce(EMPTY, (prevPath, currentPath) -> {
            if (prevPath.isAvailable() && currentPath.isAvailable()) {
                throw new RuntimeException();
            }
            return currentPath;
        });
    }

    protected abstract List<PathAvailability> generate();
}
